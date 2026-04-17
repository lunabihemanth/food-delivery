package com.sprint.food_delivery.RestaurantsModule.Restaurants;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantsService implements IRestaurantsService {

    @Autowired
    private RestaurantsRepository repository;

    @Override
    public RestaurantResponseDTO save(RestaurantsRequestDTO dto) {

        if (repository.existsByRestaurantName(dto.getRestaurantName())) {
            throw new RuntimeException("Restaurant already exists");
        }

        Restaurants r = new Restaurants();
        r.setRestaurantName(dto.getRestaurantName());
        r.setRestaurantAddress(dto.getRestaurantAddress());
        r.setRestaurantPhone(dto.getRestaurantPhone());

        return map(repository.save(r));
    }

    @Override
    public List<RestaurantResponseDTO> getAll() {
        return repository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public RestaurantResponseDTO findById(Integer id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found")));
    }

    @Override
    public RestaurantResponseDTO update(Integer id, RestaurantsRequestDTO dto) {

        Restaurants r = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        r.setRestaurantName(dto.getRestaurantName());
        r.setRestaurantAddress(dto.getRestaurantAddress());
        r.setRestaurantPhone(dto.getRestaurantPhone());

        return map(repository.save(r));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Restaurant not found");
        }
        repository.deleteById(id);
    }

    private RestaurantResponseDTO map(Restaurants r) {
        return new RestaurantResponseDTO(
        );
    }
}