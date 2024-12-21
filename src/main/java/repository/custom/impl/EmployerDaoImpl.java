package repository.custom.impl;

import entity.EmployerEntity;
import entity.ItemEntity;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employers;
import org.hibernate.query.Query;
import repository.custom.EmployerDao;
import org.hibernate.Session;
import repository.custom.ItemDao;
import service.custom.ItemService;
import util.HibernateUtil;

import java.util.List;

public class EmployerDaoImpl implements EmployerDao {

    @Override
    public boolean save(EmployerEntity entity) {
        System.out.println(entity);
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(EmployerEntity entity) {
        return false;
    }

    @Override
    public ObservableList<EmployerEntity> findAll() {
        ObservableList<EmployerEntity> observableList = FXCollections.observableArrayList();
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query<EmployerEntity> fromEmployerEntity = session.createQuery("From EmployerEntity", EmployerEntity.class);
        session.getTransaction().commit();
        observableList.addAll(fromEmployerEntity.getResultList());
        session.close();
        return observableList;
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
    public ObservableList<EmployerEntity> getAllItems() {
        return null;
    }


}
