package com.sprint.food_delivery.RestaurantsModule.MenuItems;

import java.util.List;

public interface MenuItemsInterface {
    MenuItems save(MenuItems menuItem);

    List<MenuItems> getAll();

    MenuItems findById(Integer id);

    MenuItems update(Integer id, MenuItems menuItem);

    void delete(Integer id);
}
