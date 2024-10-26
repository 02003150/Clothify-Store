package repository;

import repository.custom.impl.EmployerDaoImpl;
import repository.custom.impl.ItemDaoImpl;
import repository.custom.impl.SupplierDaoImpl;
import repository.custom.impl.UserDaoImpl;
import edu.clothifyStore.util.DaoType;

public class DaoFactory {
    public static DaoFactory instance;
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        if (instance==null){
           instance=new DaoFactory();
        }
        return instance;
    }
    public <T extends SuperDao>T getDaoType(DaoType type){
    switch (type){
        case Item:return (T) new ItemDaoImpl();
        case Supplier:return (T) new SupplierDaoImpl();
        case Employer:return (T) new EmployerDaoImpl();
        case User:return (T) new UserDaoImpl();
    }
        return null;
    }
}
