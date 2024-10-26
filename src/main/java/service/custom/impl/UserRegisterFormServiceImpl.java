package service.custom.impl;

import edu.clothifyStore.util.ServiceType;
import entity.UserEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;
import repository.DaoFactory;
import repository.SuperDao;
import repository.custom.UserDao;
import edu.clothifyStore.util.DaoType;
import org.modelmapper.ModelMapper;
import service.ServiceFactory;
import service.SuperService;
import service.custom.UserRegisterFormService;

public class UserRegisterFormServiceImpl implements UserRegisterFormService {
    ModelMapper mapper=new ModelMapper();
    @Override
    public boolean addUser(User user) {
        System.out.println(user);
        UserEntity userEntity=new ModelMapper().map(user,UserEntity.class);
        UserDao userDao = DaoFactory.getInstance().getDaoType(DaoType.User);

        return userDao.save(userEntity);
    }

    @Override
    public ObservableList<User> getAllUser() {
        ObservableList<User> userList = FXCollections.observableArrayList();
        UserDao userDao = DaoFactory.getInstance().getDaoType(DaoType.User);
        ObservableList<UserEntity> all = userDao.findAll();
        all.forEach(userEntity -> userList.add(mapper.map(userEntity, User.class)));
        return userList;
    }
}
