/* package com.sprint.food_delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.DeliveryAddresses;
import com.sprint.food_delivery.repository.DeliveryAddressRepository;


@Service
public class DeliveryAddressesService {

	@Autowired
	private DeliveryAddressRepository addressRepository;
	  public DeliveryAddresses save(DeliveryAddresses address) {
	        return addressRepository.save(address);
	    }
	    public List<DeliveryAddresses> getAll() {
	        return addressRepository.findAll();
	    }
	    public DeliveryAddresses findById(Integer id) {
	        return addressRepository.findById(id).orElse(null);
	    }
	    public DeliveryAddresses update(Integer id, DeliveryAddresses address) {
	        DeliveryAddresses existing = addressRepository.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setAddressLine1(address.getAddressLine1());
	            existing.setAddressLine2(address.getAddressLine2());
	            existing.setCity(address.getCity());
	            existing.setState(address.getState());
	            existing.setPostalCode(address.getPostalCode());
	            existing.setCustomer(address.getCustomer());
	            return addressRepository.save(existing);
	        }
	        return null;
	    }
	    public void delete(Integer id) {
	        addressRepository.deleteById(id);
	        System.out.println("Deleted address: " + id);
	    }
	}

	*/


