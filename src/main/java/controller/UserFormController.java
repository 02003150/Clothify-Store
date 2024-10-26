package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserFormController {

    public void btn_homepage_user_OnAction(ActionEvent event) {
        Stage stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user_loging_or_create_form.fxml"))));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }



    public void btn_homepage_admin_OnAction(ActionEvent event) {
        Stage stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/admin_login_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void btn_create_user_acu_form_on_action(ActionEvent event) {
        Stage stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/create_user_account_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void btn_login_user_acu_form_on_action(ActionEvent event) {
        Stage stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user_dash_board.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void btn_back_user_acu_form_on_action(ActionEvent event) {
    }

}
