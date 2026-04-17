package com.sprint.food_delivery.RestaurantsModule.MenuItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemsService implements MenuItemsInterface {

	@Autowired
	private MenuItemsRepository menuItemsRepository;

	public MenuItems save(MenuItems menuItem) {
		return menuItemsRepository.save(menuItem);
	}

	public List<MenuItems> getAll() {
		return menuItemsRepository.findAll();
	}

	public MenuItems findById(Integer id) {
		return menuItemsRepository.findById(id).orElse(null);
	}

	public MenuItems update(Integer id, MenuItems menuItem) {
		MenuItems existing = menuItemsRepository.findById(id).orElse(null);
		if (existing != null) {
			existing.setItemName(menuItem.getItemName());
			existing.setDescription(menuItem.getDescription()); // fixed
			existing.setPrice(menuItem.getPrice()); // fixed
			existing.setRestaurant(menuItem.getRestaurant());
			return menuItemsRepository.save(existing);
		}
		return null;
	}

	public void delete(Integer id) {
		menuItemsRepository.deleteById(id);
		System.out.println("Deleted menu item: " + id);
	}
}