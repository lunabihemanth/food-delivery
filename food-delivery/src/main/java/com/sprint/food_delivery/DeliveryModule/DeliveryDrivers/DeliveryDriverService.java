package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryDriverService implements IDeliveryDriverService {

    @Autowired
    private DeliveryDriverRepository repository;

    @Override
    public DeliveryDriverResponseDTO save(DeliveryDriverRequestDTO dto) {

        DeliveryDrivers d = new DeliveryDrivers();
        d.setDriverName(dto.getDriverName());
        d.setDriverPhone(dto.getDriverPhone());
        d.setDriverVehicle(dto.getDriverVehicle());

        DeliveryDrivers saved = repository.save(d);

        return new DeliveryDriverResponseDTO(
                saved.getDriverId(),
                saved.getDriverName(),
                saved.getDriverPhone(),
                saved.getDriverVehicle()
        );
    }

    @Override
    public List<DeliveryDriverResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(d -> new DeliveryDriverResponseDTO(
                        d.getDriverId(),
                        d.getDriverName(),
                        d.getDriverPhone(),
                        d.getDriverVehicle()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDriverResponseDTO findById(Integer id) {

        DeliveryDrivers d = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        return new DeliveryDriverResponseDTO(
                d.getDriverId(),
                d.getDriverName(),
                d.getDriverPhone(),
                d.getDriverVehicle()
        );
    }

    @Override
    public DeliveryDriverResponseDTO update(Integer id, DeliveryDriverRequestDTO dto) {

        DeliveryDrivers existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        existing.setDriverName(dto.getDriverName());
        existing.setDriverPhone(dto.getDriverPhone());
        existing.setDriverVehicle(dto.getDriverVehicle());

        DeliveryDrivers updated = repository.save(existing);

        return new DeliveryDriverResponseDTO(
                updated.getDriverId(),
                updated.getDriverName(),
                updated.getDriverPhone(),
                updated.getDriverVehicle()
        );
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Driver not found");
        }
        repository.deleteById(id);
    }
}