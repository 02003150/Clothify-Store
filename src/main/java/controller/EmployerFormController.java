package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employers;
import edu.clothifyStore.util.ServiceType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import service.ServiceFactory;
import service.SuperService;
import service.custom.EmployerService;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployerFormController implements Initializable{

    @FXML
    private TableView<Employers> tblAddEmployerFormId;
    @FXML
    private TableColumn<?, ?> colCompanyAddEmplyerFormTable;

    @FXML
    private TableColumn<?, ?> colEmailAddEmplyerFormTable;

    @FXML
    private TableColumn<?, ?> colIdAddEmplyerFormTable;

    @FXML
    private TableColumn<?, ?> colNameAddEmplyerFormTable;

    @FXML
    private JFXTextField txtCompanyAddEmployerForm;

    @FXML
    private JFXTextField txtEmailAddEmployerForm;

    @FXML
    private JFXTextField txtNameAddEmployerForm;

    @FXML
    void btnAddOnActionAddEmployerForm(ActionEvent event) {

        EmployerService employerService = ServiceFactory.getInstance().getServiceType(ServiceType.Employer);
        Employers employers=new Employers(
                txtNameAddEmployerForm.getText(),
                txtCompanyAddEmployerForm.getText(),
                txtEmailAddEmployerForm.getText()
        );
        if (employerService.addEmployer(employers)){
           new Alert(Alert.AlertType.INFORMATION).show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void btnBackOnActionAddEmployerForm(ActionEvent event) {

    }

    public void btnReloadOnActionAddEmployerForm(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }
    void loadTable(){
        EmployerService employers = ServiceFactory.getInstance().getServiceType(ServiceType.Employer);
        ObservableList<Employers> allEmployers = employers.getAllEmployers();
        colIdAddEmplyerFormTable.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameAddEmplyerFormTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCompanyAddEmplyerFormTable.setCellValueFactory(new PropertyValueFactory<>("company"));
        colEmailAddEmplyerFormTable.setCellValueFactory(new PropertyValueFactory<>("employerEmail"));

        tblAddEmployerFormId.setItems(allEmployers);

    }
}
