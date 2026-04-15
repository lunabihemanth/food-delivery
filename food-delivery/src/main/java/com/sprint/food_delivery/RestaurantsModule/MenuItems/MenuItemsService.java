/* package com.sprint.food_delivery.RestaurantsModule.MenuItems;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.MenuItems;
import com.sprint.food_delivery.repository.MenuItemsRepository;

@Service
public class MenuItemsService {

	@Autowired
	private MenuItemsRepository menuItemRepository;
	 public MenuItems save(MenuItems menuItem) {
	        return menuItemRepository.save(menuItem);
	    }
	    public List<MenuItems> getAll() {
	        return menuItemRepository.findAll();
	    }
	    public MenuItems findById(Integer id) {
	        return menuItemRepository.findById(id).orElse(null);
	    }
	    public MenuItems update(Integer id, MenuItems menuItem) {
	        MenuItems existing = menuItemRepository.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setItemName(menuItem.getItemName());
	            existing.setItemDescription(menuItem.getItemDescription());
	            existing.setItemPrice(menuItem.getItemPrice());
	            existing.setRestaurant(menuItem.getRestaurant());
	            return menuItemRepository.save(existing);
	        }
	        return null;
	    }
	    public void delete(Integer id) {
	        menuItemRepository.deleteById(id);
	        System.out.println("Deleted menu item: " + id);
	    }
	}

*/