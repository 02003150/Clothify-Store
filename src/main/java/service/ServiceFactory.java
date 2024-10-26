package service;


import edu.clothifyStore.util.ServiceType;
import service.custom.impl.EmployerServiceImpl;
import service.custom.impl.ItemServiceImpl;
import service.custom.impl.SupplierServiceImpl;
import service.custom.impl.UserRegisterFormServiceImpl;

public class ServiceFactory {
    private static ServiceFactory instance;
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        if (instance==null){
             instance=new ServiceFactory();
        }
        return instance;

    }
    public <T extends service.SuperService>T getServiceType(ServiceType type){
        switch (type){
            case Item:return (T)new ItemServiceImpl();
            case Supplier:return (T)new SupplierServiceImpl();
            case Employer:return (T)new EmployerServiceImpl();
            case User:return (T)new UserRegisterFormServiceImpl();
        }
        return null;
    }

}
