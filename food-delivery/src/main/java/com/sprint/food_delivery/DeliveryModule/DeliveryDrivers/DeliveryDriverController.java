package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/delivery-drivers")
public class DeliveryDriverController {

    @Autowired
    private IDeliveryDriverService service;

    private Map<String, Object> buildResponse(int status, String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("message", message);
        response.put("data", data);
        response.put("timestamp", LocalDateTime.now());
        return response;
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> save(
            @Valid @RequestBody DeliveryDriverRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(buildResponse(201, "Driver created successfully",
                        service.save(dto)));
    }

    @GetMapping("/getall")
    public ResponseEntity<Map<String, Object>> getAll() {

        return ResponseEntity.ok(
                buildResponse(200, "Drivers fetched successfully",
                        service.getAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(
                buildResponse(200, "Driver fetched successfully",
                        service.findById(id))
        );
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(
            @PathVariable Integer id,
            @Valid @RequestBody DeliveryDriverRequestDTO dto) {

        return ResponseEntity.ok(
                buildResponse(200, "Driver updated successfully",
                        service.update(id, dto))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {

        service.delete(id);

        return ResponseEntity.ok(
                buildResponse(200, "Driver deleted successfully", null)
        );
    }
}