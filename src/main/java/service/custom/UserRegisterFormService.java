package service.custom;

import javafx.collections.ObservableList;
import model.User;
import service.SuperService;

public interface UserRegisterFormService extends SuperService {
    boolean addUser(User user);
    ObservableList<User> getAllUser();
}
