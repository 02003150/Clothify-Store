package service.custom.impl;

import entity.EmployerEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employers;
import repository.DaoFactory;
import repository.custom.EmployerDao;
import edu.clothifyStore.util.DaoType;
import org.modelmapper.ModelMapper;
import service.custom.EmployerService;

public class EmployerServiceImpl implements EmployerService {
        ModelMapper mapper= new ModelMapper();
    @Override
    public boolean addEmployer(Employers employers) {
        System.out.println(employers);
        EmployerEntity entity=new ModelMapper().map(employers, EmployerEntity.class);
        EmployerDao repository = DaoFactory.getInstance().getDaoType(DaoType.Employer);
        return repository.save(entity);
    }
    @Override
    public ObservableList<Employers> getAllEmployers() {
        ObservableList<Employers> employers = FXCollections.observableArrayList();
        EmployerDao employerDao=DaoFactory.getInstance().getDaoType(DaoType.Employer);
        ObservableList<EmployerEntity> all = employerDao.findAll();
        all.forEach(employerEntity ->employers.add(mapper.map(employerEntity, Employers.class))
        );
        return employers;
    }
}
