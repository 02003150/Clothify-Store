package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.clothifyStore.util.DaoType;
import edu.clothifyStore.util.ServiceType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.RequiredArgsConstructor;
import model.AddToCart;
import model.Items;
import repository.DaoFactory;
import repository.SuperDao;
import service.ServiceFactory;
import service.SuperService;
import service.custom.ItemService;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;




public class PlaceOderFormContrlloer implements Initializable {

    public Label lblNetTotalPlaceOderForm;
    public JFXComboBox<Integer> cmdItemCode;
    public Label lblDatePlaceOderForm;
    public JFXTextField txtOderIdPlaceOderForm;
    public TableView tblPlaceOderForm;
    public Label lblDatePlaceOderForm1;
    public JFXTextField txtTotalPricePlaceOderForm;
    public TableColumn colTotalPricePlaceOderForm1;
    public TableColumn<?, ?>  colTotalPricePlaceOderForm;
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
        txtStockPlaceOderForm.setText(items.getQty().toString());
        txtDescriptionPlaceOderForm1.setText(items.getDescription());
        txtPricePlaceOderForm.setText(items.getPrice().toString());
    }

    ObservableList<AddToCart> itmList=FXCollections.observableArrayList();
    public void btnAddToCartOnActionPlaceOderForm(ActionEvent event) {

        colOderIdPlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("oderId"));
        colCustomerNamePlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colItemCodePlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colPricePlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("item"));
        colItemPlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyPlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colDescriptionPlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("description"));
        colTotalPricePlaceOderForm.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        Integer oderId = Integer.parseInt(txtOderIdPlaceOderForm.getText());
        String customerName = txtNamePlaceOderForm.getText();
        Integer itemCode = cmdItemCode.getValue();
        String item = txtItemPlaceOderForm.getText();
        Double unitPrice = Double.parseDouble(txtPricePlaceOderForm.getText());
        Integer qty = Integer.parseInt(txtQtyPlaceOderForm.getText());
        String description = txtDescriptionPlaceOderForm1.getText();
        Double totalPrice = unitPrice * qty;

        String stock = txtStockPlaceOderForm.getText();
        int stockItm=Integer.parseInt(stock);
        if(stockItm<qty){
            new Alert(Alert.AlertType.WARNING,"Not Available").show();
        }else{
            AddToCart addToCart = new AddToCart(oderId, customerName, itemCode, item, unitPrice, qty, description, totalPrice);
            itmList.addAll(addToCart);
            tblPlaceOderForm.setItems(itmList);
            addToCartTm();
            updateStock();
        }
    }

    public void get(){
        ItemService service = ServiceFactory.getInstance().getServiceType(ServiceType.Item);
        ObservableList<Items> allItems = service.getAllItems();

        System.out.println(allItems);
    }
    public void updateStock(){

//        Integer stock=Integer.parseInt(txtStockPlaceOderForm.getText());
//        Integer qty=Integer.parseInt(txtQtyPlaceOderForm.getText());
//        Integer updatedstock = stock - qty;
//        ArrayList<Items> list=new ArrayList<>();
//
//        Items items=new Items();
//
//
//        ItemService itemService=ServiceFactory.getInstance().getServiceType(ServiceType.Item);
//        ObservableList<Items> allItems = itemService.getAllItems();
//
//        itemService.updateItem();
    }


    public void addToCartTm(){
        Double netTotal = 0.0;
        for(AddToCart addToCart: itmList){
             netTotal += addToCart.getTotalPrice();
            lblNetTotalPlaceOderForm.setText(Double.toString(netTotal));    
        }
    }
}
