package repository.custom.impl;

import entity.ItemEntity;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import org.hibernate.query.Query;
import repository.custom.ItemDao;
import repository.custom.SupplierDao;
import org.hibernate.Session;
import service.custom.ItemService;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {

    @Override
    public boolean save(SupplierEntity entity) {
        System.out.println(entity);
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(SupplierEntity entity) {
        return false;
    }

    @Override
    public ObservableList<SupplierEntity> findAll() {
        ObservableList<SupplierEntity> observableList = FXCollections.observableArrayList();
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query<SupplierEntity> fromSupplierEntity = session.createQuery("From SupplierEntity", SupplierEntity.class);
        session.getTransaction().commit();
        observableList.addAll(fromSupplierEntity.getResultList());

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
    public ObservableList<SupplierEntity> getAllItems() {
        return null;
    }


}


