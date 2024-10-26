package service.custom;

import model.Employers;
import model.Suppliers;
import javafx.collections.ObservableList;
import service.SuperService;

public interface SupplierService extends SuperService {
    ObservableList<Suppliers> getAllSupplier();

    public boolean addSuppier(Suppliers suppliers);

}
