package service.custom.impl;

import entity.EmployerEntity;
import entity.SupplierEntity;
import model.Employers;
import model.Suppliers;
import repository.DaoFactory;
import repository.SuperDao;
import repository.custom.EmployerDao;
import repository.custom.SupplierDao;

import edu.clothifyStore.util.DaoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import service.custom.SupplierService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    ModelMapper mapper = new ModelMapper();
    @Override
    public ObservableList<Suppliers> getAllSupplier() {
        ObservableList<Suppliers> suppliers = FXCollections.observableArrayList();
        SupplierDao supplierDao = DaoFactory.getInstance().getDaoType(DaoType.Supplier);
        ObservableList<SupplierEntity> all = supplierDao.findAll();
        all.forEach(supplierEntity -> {
            suppliers.add(mapper.map(supplierEntity,Suppliers.class));
        });
        return suppliers;
    }
    @Override
    public boolean addSuppier(Suppliers suppliers) {
        System.out.println(suppliers);
        SupplierEntity entity=new ModelMapper().map(suppliers, SupplierEntity.class);
        SupplierDao repository= DaoFactory.getInstance().getDaoType(DaoType.Supplier);
        return repository.save(entity);
    }




}
