package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;
import edu.clothifyStore.util.ServiceType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import service.ServiceFactory;
import service.custom.UserRegisterFormService;

import java.net.URL;
import java.util.ResourceBundle;

public class UserRegisterFormController implements Initializable {


    public TableView tblUserRegisterForm;
    @FXML
    private TableColumn<?, ?> colUserAddressUserRegisterForm;

    @FXML
    private TableColumn<?, ?> colUserIdUserRegisterForm;

    @FXML
    private TableColumn<?, ?> colUserNameUserRegisterForm;

    @FXML
    private TableColumn<?, ?> colUserNicUserRegisterForm;

    @FXML
    private TableColumn<?, ?> colUserPhoneNumberUserRegisterForm;

    @FXML
    private JFXTextField txtAddressUserRegisterForm;

    @FXML
    private JFXTextField txtNameUserRegisterForm;

    @FXML
    private JFXTextField txtNicUserRegisterForm;

    @FXML
    private JFXTextField txtPhoneNumberUserRegisterForm;

    @FXML
    void btnAddUserRegisterForm(ActionEvent event) {
        UserRegisterFormService serviceType = ServiceFactory.getInstance().getServiceType(ServiceType.User);
        User user=new User(
                txtNameUserRegisterForm.getText(),
                txtAddressUserRegisterForm.getText(),
                txtNicUserRegisterForm.getText(),
                txtPhoneNumberUserRegisterForm.getText()
        );

        if (serviceType.addUser(user)){
            new Alert(Alert.AlertType.INFORMATION).show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
        loadTable();
    }

    @FXML
    void btnBackUserRegisterForm(ActionEvent event) {

    }

    public void btnDeleteUserRegisterForm(ActionEvent event) {
    }

    public void btnUpdateUserRegisterForm(ActionEvent event) {
    }

    public void btnReloadUserRegisterForm(ActionEvent event) {
        loadTable();
    }
    public void btnSearchUserRegisterForm(ActionEvent event){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }
    void loadTable(){
        UserRegisterFormService userRegisterFormService = ServiceFactory.getInstance().getServiceType(ServiceType.User);
        ObservableList<User> allUser = userRegisterFormService.getAllUser();
        colUserIdUserRegisterForm.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserNameUserRegisterForm.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUserAddressUserRegisterForm.setCellValueFactory(new PropertyValueFactory<>("address"));
        colUserNicUserRegisterForm.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colUserPhoneNumberUserRegisterForm.setCellValueFactory(new PropertyValueFactory<>("number"));

        tblUserRegisterForm.setItems(allUser);


    }
}
