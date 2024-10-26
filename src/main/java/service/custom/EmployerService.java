package service.custom;

import javafx.collections.ObservableList;
import model.Employers;
import service.SuperService;

public interface EmployerService extends SuperService {
    ObservableList<Employers> getAllEmployers();
    boolean addEmployer(Employers employers);
}
