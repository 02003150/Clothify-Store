package service.custom;

import entity.ItemEntity;
import javafx.collections.ObservableList;
import model.Items;
import org.hibernate.service.spi.InjectService;
import service.SuperService;

public interface ItemService extends SuperService {
    public boolean addItem(Items items);
    public ObservableList<Items> getAllItems();
   Items searchItem(Integer id);
    public ItemEntity updateItem(Items items);
    public boolean deleteItem(Integer id);
    public ObservableList<Items>getAllItemIds();


}
