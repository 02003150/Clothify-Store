package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.clothifyStore.util.ServiceType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AddToCart;
import model.Items;
import service.ServiceFactory;
import service.custom.ItemService;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class PlaceOderFormContrlloer implements Initializable {

    public Label lblNetTotalPlaceOderForm;
    public JFXComboBox<Integer> cmdItemCode;
    public Label lblDatePlaceOderForm;
    public JFXTextField txtOderIdPlaceOderForm;
    public TableView tblPlaceOderForm;
    @FXML
    private TableColumn<?, ?> colCustomerNamePlaceOderForm;
    @FXML
    private TableColumn<?, ?> colDescriptionPlaceOderForm;

    @FXML
    private TableColumn<?, ?> colItemCodePlaceOderForm;

    @FXML
    private TableColumn<?, ?> colItemPlaceOderForm;

    @FXML
    private TableColumn<?, ?> colOderIdPlaceOderForm;

    @FXML
    private TableColumn<?, ?> colPricePlaceOderForm;

    @FXML
    private TableColumn<?, ?> colQtyPlaceOderForm;

    @FXML
    private TableColumn<?, ?> colStockPlaceOderForm;

    @FXML
    private JFXTextField txtDescriptionPlaceOderForm1;

    @FXML
    private JFXTextField txtItemCodePlaceOderForm;

    @FXML
    private JFXTextField txtItemPlaceOderForm;

    @FXML
    private JFXTextField txtNamePlaceOderForm;

    @FXML
    private JFXTextField txtPricePlaceOderForm;

    @FXML
    private JFXTextField txtQtyPlaceOderForm;

    @FXML
    private JFXTextField txtStockPlaceOderForm;

    @FXML
    void btnAddOnActionPlaceOderForm(ActionEvent event) {

    }
    @FXML
    void btnBackPlaceOderForm(ActionEvent event) {

    }
    @FXML
    void btnDeleteOnActionPlaceOderForm(ActionEvent event) {

    }
    @FXML
    void btnPlaceOderOnActionPlaceOderForm(ActionEvent event) {

    }
    @FXML
    void btnSearchOnActionPlaceOderForm(ActionEvent event) {

    }
    @FXML
    void btnUpdateOnActionPlaceOderForm(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateAndTime();
        loadItemIds();
    }

    public void DateAndTime(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        lblDatePlaceOderForm.setText(simpleDateFormat.format(date));
    }
    private void loadItemIds(){
        ObservableList<Integer> itmList=FXCollections.observableArrayList();
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.Item);
        ObservableList<Items> itemIdsList = itemService.getAllItemIds();
        itemIdsList.forEach(itmIds->{
            itmList.add(itmIds.getItmCode());
        });
       cmdItemCode.setItems(itmList);

       cmdItemCode.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldVal, newVal) ->{
            if (newVal!=null){
                addValueToText(newVal);
            }
            System.out.println(newVal);
        } ));
    }
    private void addValueToText(Integer newVal) {
        ItemService itemService = ServiceFactory.getInstance().getServiceType(ServiceType.Item);
        Items items = itemService.searchItem(newVal);
        System.out.println("items "+items);
        txtItemPlaceOderForm.setText(items.getItem());
    }
    public void btnAddToCartOnActionPlaceOderForm(ActionEvent event) {

        ObservableList<AddToCart> itmList=FXCollections.observableArrayList();

        colOderIdPlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("oderId"));
        colCustomerNamePlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colItemCodePlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colPricePlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("item"));
        colItemPlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyPlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colDescriptionPlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("description"));

        Integer oderId = Integer.parseInt(txtOderIdPlaceOderForm.getText());
        String customerName = txtNamePlaceOderForm.getText();
        Integer itemCode = cmdItemCode.getValue();
        String item = txtItemPlaceOderForm.getText();
        Double unitPrice = Double.parseDouble(txtPricePlaceOderForm.getText());
        Integer qty = Integer.parseInt(txtQtyPlaceOderForm.getText());
        String description = txtDescriptionPlaceOderForm1.getText();
        Double netTotal=unitPrice*qty;
        AddToCart addToCart = new AddToCart(oderId, customerName, itemCode, item, unitPrice, qty, description);
        itmList.addAll(addToCart);

        tblPlaceOderForm.setItems(itmList);
        lblNetTotalPlaceOderForm.setText(netTotal.toString());
    }
}
