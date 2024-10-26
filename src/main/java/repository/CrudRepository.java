package repository;

import entity.ItemEntity;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import repository.custom.ItemDao;
import service.custom.ItemService;

import java.util.List;

public interface CrudRepository<T>extends SuperDao {
    boolean save(T entity);
    boolean update(T entity);
    ObservableList<T> findAll();
    public ItemEntity searchId(Integer id);
    public Boolean deleteAll(Integer id);
     ObservableList<T> getAllItems();
}
