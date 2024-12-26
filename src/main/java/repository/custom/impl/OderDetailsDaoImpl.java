package repository.custom.impl;

import entity.ItemEntity;
import entity.OderDetailsEntity;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import repository.custom.OderDetailsDao;
import util.HibernateUtil;

public class OderDetailsDaoImpl implements OderDetailsDao {
    @Override
    public boolean save(OderDetailsEntity entity) {
        System.out.println("entity oder details :"+entity);
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(OderDetailsEntity entity) {
        return false;
    }

    @Override
    public ObservableList<OderDetailsEntity> findAll() {
        return null;
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
    public ObservableList<OderDetailsEntity> getAllItems() {
        return null;
    }
}
