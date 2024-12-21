package repository.custom.impl;

import entity.ItemEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.ItemDao;
import util.HibernateUtil;


public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(ItemEntity entity) {
        System.out.println(entity);
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    @Override
    public boolean update(ItemEntity entity) {

        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("UPDATE ItemEntity SET item = :item, qty = :qty, price = :price, catagory = :catagory, description = :description, totalPrice= :totalPrice WHERE itmCode = :id ");

        System.out.println("CCCCC :"+entity);

        query.setParameter("id",entity.getItmCode());
        query.setParameter("item",entity.getItem());
        query.setParameter("qty",entity.getQty());
        query.setParameter("price",entity.getPrice());
        query.setParameter("catagory",entity.getCatagory());
        query.setParameter("description",entity.getDescription());
        query.setParameter("totalPrice",entity.getTotalPrice());

        System.out.println(entity.getQty());
        boolean isupdate = query.executeUpdate() > 0;
        System.out.println(isupdate);
        session.getTransaction().commit();
        session.close();
        return isupdate;

    }

    @Override
    public ObservableList<ItemEntity> findAll() {
        ObservableList<ItemEntity> itemEntities=FXCollections.observableArrayList();
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();
        Query<ItemEntity> fromItemEntity = session.createQuery("From ItemEntity", ItemEntity.class);
        fromItemEntity.getResultList();
        session.getTransaction().commit();
        itemEntities.addAll(fromItemEntity.getResultList());
        session.close();
        return itemEntities;
    }

    @Override
    public ItemEntity searchId(Integer id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query<ItemEntity> id1 = session.createQuery("FROM ItemEntity WHERE itmCode= :id", ItemEntity.class)
                .setParameter("id", id);
        ItemEntity singleResult = id1.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return singleResult;
    }

    @Override
    public Boolean deleteAll(Integer id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query itmId = session.createQuery("DELETE FROM ItemEntity WHERE itmCode=:id")
                .setParameter("id",id);
        boolean isDeleted = itmId.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return isDeleted;
    }

    @Override
    public ObservableList<ItemEntity> getAllItems() {
        ObservableList<ItemEntity> itmList=FXCollections.observableArrayList();
        Session session=HibernateUtil.getSession();
        session.getTransaction().begin();
        Query<ItemEntity> fromItemEntity = session.createQuery("From ItemEntity", ItemEntity.class);
        fromItemEntity.getResultList();
        session.getTransaction().commit();
        itmList.addAll(fromItemEntity.getResultList());
        session.close();
        return itmList;
        }

//    @Override
//    public ObservableList<ItemEntity> getAllItems() {
//        ObservableList<ItemEntity> itmList=FXCollections.observableArrayList();
//        Session session=HibernateUtil.getSession();
//        session.getTransaction().begin();
//        Query<ItemEntity> fromItemEntity = session.createQuery("From ItemEntity", ItemEntity.class);
//        fromItemEntity.getResultList();
//        session.getTransaction().commit();
//        itmList.addAll(fromItemEntity.getResultList());
//        session.close();
//        return itmList;
//    }

}
