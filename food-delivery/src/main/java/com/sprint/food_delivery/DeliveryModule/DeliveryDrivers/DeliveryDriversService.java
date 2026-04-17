package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryDriversService implements IDeliveryDriversService {

    @Autowired
    private DeliveryDriversRepository repository;

    // Create
    @Override
    public DeliveryDriversResponseDTO save(DeliveryDriversRequestDTO dto) {

        if (repository.existsByDriverPhone(dto.getDriverPhone())) {
            throw new RuntimeException("Driver already exists");
        }

        DeliveryDrivers d = new DeliveryDrivers();
        d.setDriverName(dto.getDriverName());
        d.setDriverPhone(dto.getDriverPhone());
        d.setDriverVehicle(dto.getDriverVehicle());

        return map(repository.save(d));
    }

    // Get all
    @Override
    public List<DeliveryDriversResponseDTO> getAll() {
        return repository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public DeliveryDriversResponseDTO findById(Integer id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found")));
    }

    // Update
    @Override
    public DeliveryDriversResponseDTO update(Integer id, DeliveryDriversRequestDTO dto) {

        DeliveryDrivers existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        existing.setDriverName(dto.getDriverName());
        existing.setDriverPhone(dto.getDriverPhone());
        existing.setDriverVehicle(dto.getDriverVehicle());

        return map(repository.save(existing));
    }

    // Delete
    @Override
    public String delete(Integer id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Driver not found");
        }

        repository.deleteById(id);
        
        return "Deleted this id : "+id;
    }

    private DeliveryDriversResponseDTO map(DeliveryDrivers d) {
        return new DeliveryDriversResponseDTO(
                d.getDriverId(),
                d.getDriverName(),
                d.getDriverPhone(),
                d.getDriverVehicle()
        );
    }
}