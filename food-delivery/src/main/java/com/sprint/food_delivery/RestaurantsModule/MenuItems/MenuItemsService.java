package com.sprint.food_delivery.RestaurantsModule.MenuItems;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.RestaurantsModule.Restaurants.*;

@Service
public class MenuItemsService implements IMenuItemsService {

    @Autowired
    private MenuItemsRepository repository;

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    // CREATE
    @Override
    public MenuItemsResponseDTO save(MenuItemsRequestDTO dto) {

        Restaurants restaurant = restaurantsRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        MenuItems item = new MenuItems();
        item.setItemName(dto.getItemName());
        item.setItemDescription(dto.getItemDescription());
        item.setItemPrice(dto.getItemPrice());
        item.setRestaurant(restaurant);

        return map(repository.save(item));
    }

    // GET ALL
    @Override
    public List<MenuItemsResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public MenuItemsResponseDTO findById(Integer id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found")));
    }

    // GET BY RESTAURANT
    @Override
    public List<MenuItemsResponseDTO> getByRestaurantId(Integer restaurantId) {
        return repository.findByRestaurant_RestaurantId(restaurantId)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public MenuItemsResponseDTO update(Integer id, MenuItemsRequestDTO dto) {

        MenuItems existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        Restaurants restaurant = restaurantsRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        existing.setItemName(dto.getItemName());
        existing.setItemDescription(dto.getItemDescription());
        existing.setItemPrice(dto.getItemPrice());
        existing.setRestaurant(restaurant);

        return map(repository.save(existing));
    }

    // DELETE
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    // MAPPER
    private MenuItemsResponseDTO map(MenuItems m) {
        return new MenuItemsResponseDTO(
                m.getItemId(),
                m.getItemName(),
                m.getItemDescription(),
                m.getItemPrice(),
                m.getRestaurant().getRestaurantId()
        );
    }
}