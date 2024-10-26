package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import model.Suppliers;
import edu.clothifyStore.util.ServiceType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.custom.SupplierService;

import java.net.URL;
import java.util.ResourceBundle;

public class AddSuppdierFormController implements Initializable {

    public TableColumn<? , ?> colIdSuppierForm;
    public TableColumn<? , ?> colISupplierNameSuppierForm;
    public TableColumn<? , ?> colItemSuppierForm;
    public TableColumn<? , ?> colCompnaySuppierForm;
    public TableColumn<? , ?> colEmailSuppierForm;
    public TableView<Suppliers> tblSupplierFormId;


    @FXML
    private JFXTextField txtNameAddSupplierForm;

    @FXML
    private JFXTextField txtEmailAddSupplierForm;

    @FXML
    private JFXTextField txtIdAddSupplierForm;

    @FXML
    private JFXTextField txtItemAddSupplierForm;

    @FXML
    private JFXTextField txtCompanyAddSupplierForm;

    @FXML
    void btnAddSupplierForm(ActionEvent event) {

        SupplierService supplierService= ServiceFactory.getInstance().getServiceType(ServiceType.Supplier);
                Suppliers suppliers=new Suppliers(
                        txtNameAddSupplierForm.getText(),
                        txtCompanyAddSupplierForm.getText(),
                        txtEmailAddSupplierForm.getText(),
                        txtItemAddSupplierForm.getText());

        if(supplierService.addSuppier(suppliers)){
            new Alert(Alert.AlertType.INFORMATION).show();
    }else {
            new Alert(Alert.AlertType.ERROR).show();
        }

    }


    @FXML
    void btnBackSupplierForm(ActionEvent event) {

    }

    @FXML
    void btnDeleteSupplierForm(ActionEvent event) {

    }

    @FXML
    void btnSearchSupplierForm(ActionEvent event) {

    }

    @FXML
    void btnUpdateSupplierForm(ActionEvent event) {

    }

    public void btnReloadOnActionSupplierForm(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }
    private void loadTable(){
        SupplierService service = ServiceFactory.getInstance().getServiceType(ServiceType.Supplier);
        ObservableList<Suppliers> allSupplier = service.getAllSupplier();
        System.out.println(allSupplier);
        colIdSuppierForm.setCellValueFactory(new PropertyValueFactory<>("id"));
        colISupplierNameSuppierForm.setCellValueFactory(new PropertyValueFactory<>("name"));
        colItemSuppierForm.setCellValueFactory(new PropertyValueFactory<>("item"));
        colCompnaySuppierForm.setCellValueFactory(new PropertyValueFactory<>("company"));
        colEmailSuppierForm.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblSupplierFormId.setItems(allSupplier);
    }
}
