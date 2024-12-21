package repository.custom.impl;

import entity.ItemEntity;
import entity.UserEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.query.Query;
import repository.custom.ItemDao;
import repository.custom.UserDao;
import org.hibernate.Session;
import service.custom.ItemService;
import util.HibernateUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(UserEntity entity) {
        System.out.println(entity);
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(UserEntity entity) {
        return false;
    }

    @Override
    public ObservableList<UserEntity> findAll() {


        ObservableList<UserEntity> userEntities = FXCollections.observableArrayList();
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query<UserEntity> fromUserEntity = session.createQuery("From UserEntity", UserEntity.class);
        List<UserEntity> resultList = fromUserEntity.getResultList();
        resultList.forEach(userEntity -> {userEntities.add(userEntity);
        });
        session.close();
        return userEntities;
    }

    @Override
    public ItemEntity searchId(Integer id) {

        return null;
    }

    @Override
    public Boolean deleteAll(Integer id) {
        return null;
    }

    @Override
    public ObservableList<UserEntity> getAllItems() {
        return null;
    }


//    @Override
//    public ObservableList<UserEntity> searchAll(Integer id) {
//        ObservableList<UserEntity> userEntities = FXCollections.observableArrayList();
//        Session session = HibernateUtil.getSession();
//        session.getTransaction().begin();
//        Query<UserEntity> fromUserEntity = session.createQuery("From UserEntity", UserEntity.class);
//        List<UserEntity> resultList = fromUserEntity.getResultList();
//        userEntities.addAll(resultList);
//        session.close();
//        return userEntities;
//    }
}
