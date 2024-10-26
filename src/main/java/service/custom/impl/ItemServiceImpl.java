package service.custom.impl;

import edu.clothifyStore.util.ServiceType;
import entity.ItemEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Items;
import repository.DaoFactory;
import repository.SuperDao;
import repository.custom.ItemDao;
import edu.clothifyStore.util.DaoType;
import org.modelmapper.ModelMapper;
import service.ServiceFactory;
import service.SuperService;
import service.custom.ItemService;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;


public class ItemServiceImpl implements ItemService {
    ModelMapper mapper=new ModelMapper();
    @Override
    public boolean addItem(Items items) {
        System.out.println(items);
        ItemEntity entity = new ModelMapper().map(items, ItemEntity.class);
        ItemDao repository=DaoFactory.getInstance().getDaoType(DaoType.Item);
        return repository.save(entity);
    }
    @Override
    public ObservableList<Items> getAllItems() {
        ObservableList<Items> items = FXCollections.observableArrayList();
        ItemDao itemDao=DaoFactory.getInstance().getDaoType(DaoType.Item);
        ObservableList<ItemEntity> itemAll = itemDao.findAll();
        itemAll.forEach(itemEntity -> {items.add(mapper.map(itemEntity, Items.class));
        });
        return items;
    }
    @Override
    public ItemEntity updateItem(Items items) {
        System.out.println("sssssss :"+items);
        ItemEntity itm = mapper.map(items, ItemEntity.class);
        ItemDao itemDao=DaoFactory.getInstance().getDaoType(DaoType.Item);

       itemDao.update(itm);

        return itm;
    }
    @Override
    public boolean deleteItem(Integer id) {
        ItemDao itemDao = DaoFactory.getInstance().getDaoType(DaoType.Item);
        itemDao.deleteAll(id);
        return true;
    }

    @Override
    public ObservableList<Items> getAllItemIds() {
        ObservableList<Items> itmList = FXCollections.observableArrayList();
        ItemDao itemDao=DaoFactory.getInstance().getDaoType(DaoType.Item);
        ObservableList<ItemEntity> itemAll = itemDao.getAllItems();
        itemAll.forEach(itemEntity -> {itmList.add(mapper.map(itemEntity, Items.class));
        });
        return itmList;

    }


    @Override
    public Items searchItem(Integer id) {
        ItemDao dao = DaoFactory.getInstance().getDaoType(DaoType.Item);
        ItemEntity itemEntity = dao.searchId(id);
        return mapper.map(itemEntity, Items.class);
    }
}
