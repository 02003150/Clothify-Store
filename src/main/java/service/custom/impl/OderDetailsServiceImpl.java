package service.custom.impl;

import edu.clothifyStore.util.DaoType;
import entity.OderDetailsEntity;
import javafx.collections.ObservableList;
import model.OderDetails;
import model.Suppliers;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.impl.OderDetailsDaoImpl;
import service.custom.OderDetailsService;

public class OderDetailsServiceImpl implements OderDetailsService {

ModelMapper mapper=new ModelMapper();
    @Override
    public ObservableList<Suppliers> getAllSupplier() {
        return null;
    }

    @Override
    public boolean addSuppier(Suppliers suppliers) {
        return false;
    }

    @Override
    public boolean addOderDetails(OderDetails oderDetails) {
        System.out.println("oder details :"+oderDetails);
        OderDetailsDaoImpl oderDetailsDao = DaoFactory.getInstance().getDaoType(DaoType.OderDetails);
        return oderDetailsDao.save(mapper.map(oderDetails, OderDetailsEntity.class));
    }
}
