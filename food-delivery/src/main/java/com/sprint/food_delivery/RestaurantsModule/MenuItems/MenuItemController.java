package com.sprint.food_delivery.RestaurantsModule.MenuItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; 

@RestController
@RequestMapping("/menuItem")
public class MenuItemController {

    @Autowired
    private MenuItemsService menuItemService; 

    @PostMapping("/add")
    public MenuItems save(@RequestBody MenuItems menuItem) {
        return menuItemService.save(menuItem);
    }

    @GetMapping("/getAll")
    public List<MenuItems> getAll() {
        return menuItemService.getAll();
    }

    @GetMapping("/findbyid/{id}")
    public MenuItems findById(@PathVariable Integer id) {
        return menuItemService.findById(id);
    }

    @PutMapping("/update/{id}")
    public MenuItems update(@PathVariable Integer id, @RequestBody MenuItems menuItem) {
        return menuItemService.update(id, menuItem);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        menuItemService.delete(id);
    }
}