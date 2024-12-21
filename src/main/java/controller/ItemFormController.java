package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Items;
import edu.clothifyStore.util.ServiceType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import service.ServiceFactory;
import service.SuperService;
import service.custom.ItemService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

    @FXML
    public TableView tblAddItemFormTable;

    @FXML
    public JFXTextField txtIdtemAddItemForm;
    public TableColumn<?, ?> colTotalPriceAddItemFormTable1;
    public JFXTextField txtTotalPriceAddItemForm1;

    @FXML
    private JFXComboBox<String> cmbCatogoryAddItemForm;

    @FXML
    private TableColumn<?, ?> colCatagoryAddItemFormTable;

    @FXML
    private TableColumn<?, ?> colIdAddItemFormTable;


    @FXML
    private TableColumn<?, ?> colDiscriptionAddItemFormTable;

    @FXML
    private TableColumn<?, ?> colItemAddItemFormTable;

    @FXML
    private TableColumn<?, ?> colPriceAddItemFormTable;

    @FXML
    private TableColumn<?, ?> colQtyAddItemFormTable;

    @FXML
    private JFXTextField txtDescriptionAddItemForm;

    @FXML
    private JFXTextField txtItemAddItemForm;

    @FXML
    private JFXTextField txtPriceAddItemForm;

    @FXML
    private JFXTextField txtQtyAddItemForm;

    @FXML
    void btnAddOnActionAddItemForm(ActionEvent event) {
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.Item);

        Items items=new Items(
                txtItemAddItemForm.getText(),
                Integer.parseInt(txtQtyAddItemForm.getText()),
                Double.parseDouble(txtPriceAddItemForm.getText()),
                cmbCatogoryAddItemForm.getValue(),
                txtDescriptionAddItemForm.getText()
//                Double.parseDouble(txtPriceAddItemForm*txtQtyAddItemForm)
        );
        System.out.println(items);
        if (itemService.addItem(items)){
           new Alert(Alert.AlertType.INFORMATION).show();
        }
        else{
            new Alert(Alert.AlertType.ERROR).show();
        }
        loadTable();
    }
    @FXML
    void btnBackOnActionAddItemForm(ActionEvent event) {
    }
    @FXML
    void btnDeleteOnActionAddItemForm(ActionEvent event) {
        String id = txtIdtemAddItemForm.getText();
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.Item);
        itemService.deleteItem(Integer.parseInt(id));
        loadTable();
    }
    @FXML
    void btnReloadOnActionAddItemForm(ActionEvent event) {
        loadTable();
    }

    @FXML
    void btnSearchOnActionAddItemForm(ActionEvent event) {
        String id = txtIdtemAddItemForm.getText();
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.Item);
        Items items = itemService.searchItem(Integer.parseInt(id));

        txtItemAddItemForm.setText(items.getItem());
        txtPriceAddItemForm.setText("" + items.getPrice());
        txtQtyAddItemForm.setText(""+items.getQty());
        txtDescriptionAddItemForm.setText(items.getDescription());
        cmbCatogoryAddItemForm.setValue(items.getCatagory());
        txtTotalPriceAddItemForm1.setText(items.getTotalPrice().toString());
    }
    @FXML
    void btnUpdateOnActionAddItemForm(ActionEvent event) {
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.Item);
        Items items=new Items(
                Integer.parseInt(txtIdtemAddItemForm.getText()),
                txtItemAddItemForm.getText(),
                Integer.parseInt(txtQtyAddItemForm.getText()),
                Double.parseDouble(txtPriceAddItemForm.getText()),
                cmbCatogoryAddItemForm.getValue(),
                txtDescriptionAddItemForm.getText()

        );
        itemService.updateItem(items);
        loadTable();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }
    void loadTable(){
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.Item);
        ObservableList<Items> itemServices=itemService.getAllItems();
        colIdAddItemFormTable.setCellValueFactory(new PropertyValueFactory<>("itmCode"));
        colItemAddItemFormTable.setCellValueFactory(new PropertyValueFactory<>("item"));
        colPriceAddItemFormTable.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQtyAddItemFormTable.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colCatagoryAddItemFormTable.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        colDiscriptionAddItemFormTable.setCellValueFactory(new PropertyValueFactory<>("description"));
        colTotalPriceAddItemFormTable1.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        tblAddItemFormTable.setItems(itemServices);

        ObservableList<String> catagoryList= FXCollections.observableArrayList();
        catagoryList.add("Ledies");
        catagoryList.add("Gents");
        catagoryList.add("Kids");
        cmbCatogoryAddItemForm.setItems(catagoryList);

        tblAddItemFormTable.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldVal, newVal) ->{
            if (newVal!=null){
               addValueToText((Items) newVal);
            }
            System.out.println(newVal);
        } ));
        clear();
    }
        void addValueToText(Items newVal){
        txtIdtemAddItemForm.setText(""+newVal.getItmCode());
        txtItemAddItemForm.setText(newVal.getItem());
        txtPriceAddItemForm.setText("" + newVal.getPrice());
        txtQtyAddItemForm.setText(""+newVal.getQty());
        txtDescriptionAddItemForm.setText(newVal.getDescription());
        cmbCatogoryAddItemForm.setValue(newVal.getCatagory());
        }
        public void clear(){
            txtIdtemAddItemForm.clear();
            txtItemAddItemForm.clear();
            txtQtyAddItemForm.clear();
            txtPriceAddItemForm.clear();
            cmbCatogoryAddItemForm.setValue("");
            txtDescriptionAddItemForm.clear();
        }
}

