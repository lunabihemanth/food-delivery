package com.sprint.food_delivery.servicetest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sprint.food_delivery.Exception.BadRequestException;
import com.sprint.food_delivery.Exception.ConflictException;
import com.sprint.food_delivery.Exception.ResourceNotFoundException;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.IRestaurantsService;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.RestaurantResponseDTO;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.RestaurantsRequestDTO;

@SpringBootTest
@Transactional
public class RestaurantsServiceTest {

    @Autowired
    private IRestaurantsService restaurantService;

    // 🔧 Helper
    private RestaurantsRequestDTO createDTO(String name) {
        RestaurantsRequestDTO dto = new RestaurantsRequestDTO();
        dto.setRestaurantName(name);
        dto.setRestaurantAddress("Mumbai");
        dto.setRestaurantPhone("9" + System.currentTimeMillis());
        return dto;
    }

    // ✅ 1. Save Restaurant - Valid
    @Test
    void testSaveRestaurantSuccess() {
        RestaurantsRequestDTO dto = createDTO("Dominos" + System.currentTimeMillis());

        RestaurantResponseDTO res = restaurantService.save(dto);

        assertNotNull(res);
        assertEquals(dto.getRestaurantName(), res.getRestaurantName());
    }

    // ❌ 2. Save Restaurant - Empty Name
    @Test
    void testSaveRestaurantEmptyName() {
        RestaurantsRequestDTO dto = createDTO("");
        assertThrows(BadRequestException.class, () -> restaurantService.save(dto));
    }

    // ❌ 3. Save Restaurant - Null Name
    @Test
    void testSaveRestaurantNullName() {
        RestaurantsRequestDTO dto = createDTO(null);
        assertThrows(BadRequestException.class, () -> restaurantService.save(dto));
    }

    // ❌ 4. Save Restaurant - Empty Address
    @Test
    void testSaveRestaurantEmptyAddress() {
        RestaurantsRequestDTO dto = createDTO("KFC");
        dto.setRestaurantAddress("");

        assertThrows(BadRequestException.class, () -> restaurantService.save(dto));
    }

    // ❌ 5. Save Restaurant - Null Address
    @Test
    void testSaveRestaurantNullAddress() {
        RestaurantsRequestDTO dto = createDTO("KFC");
        dto.setRestaurantAddress(null);

        assertThrows(BadRequestException.class, () -> restaurantService.save(dto));
    }

    // ❌ 6. Save Restaurant - Empty Phone
    @Test
    void testSaveRestaurantEmptyPhone() {
        RestaurantsRequestDTO dto = createDTO("PizzaHut");
        dto.setRestaurantPhone("");

        assertThrows(BadRequestException.class, () -> restaurantService.save(dto));
    }

    // ❌ 7. Save Restaurant - Duplicate Name
    @Test
    void testSaveRestaurantDuplicateName() {
        String name = "McDonalds" + System.currentTimeMillis();

        restaurantService.save(createDTO(name));

        assertThrows(ConflictException.class,
                () -> restaurantService.save(createDTO(name)));
    }

    // ✅ 8. Get All Restaurants
    @Test
    void testGetAllRestaurants() {
        List<RestaurantResponseDTO> list = restaurantService.getAll();
        assertNotNull(list);
    }

    // ✅ 9. Find By ID - Valid
    @Test
    void testFindByIdSuccess() {
        RestaurantResponseDTO saved =
                restaurantService.save(createDTO("BurgerKing" + System.currentTimeMillis()));

        RestaurantResponseDTO found =
                restaurantService.findById(saved.getRestaurantId());

        assertEquals(saved.getRestaurantId(), found.getRestaurantId());
    }

    // ❌ 10. Find By ID - Not Found
    @Test
    void testFindByIdNotFound() {
        assertThrows(ResourceNotFoundException.class,
                () -> restaurantService.findById(9999));
    }

    // ✅ 11. Update Restaurant - Valid
    @Test
    void testUpdateRestaurantSuccess() {
        RestaurantResponseDTO saved =
                restaurantService.save(createDTO("OldName" + System.currentTimeMillis()));

        RestaurantsRequestDTO update = new RestaurantsRequestDTO();
        update.setRestaurantName("NewName" + System.currentTimeMillis());
        update.setRestaurantAddress("Delhi");
        update.setRestaurantPhone("8888888888");

        RestaurantResponseDTO updated =
                restaurantService.update(saved.getRestaurantId(), update);

        assertEquals(update.getRestaurantName(), updated.getRestaurantName());
    }

    // ❌ 12. Update Restaurant - Not Found
    @Test
    void testUpdateRestaurantNotFound() {
        RestaurantsRequestDTO dto = createDTO("Test");

        assertThrows(ResourceNotFoundException.class,
                () -> restaurantService.update(9999, dto));
    }

    // ❌ 13. Update Restaurant - Duplicate Name
    @Test
    void testUpdateRestaurantDuplicateName() {
        String name1 = "A" + System.currentTimeMillis();
        String name2 = "B" + System.currentTimeMillis();

        RestaurantResponseDTO r1 = restaurantService.save(createDTO(name1));
        restaurantService.save(createDTO(name2));

        RestaurantsRequestDTO update = new RestaurantsRequestDTO();
        update.setRestaurantName(name2); // duplicate
        update.setRestaurantAddress("City");
        update.setRestaurantPhone("9999999999");

        assertThrows(ConflictException.class,
                () -> restaurantService.update(r1.getRestaurantId(), update));
    }

    // ✅ 14. Delete Restaurant - Valid
    @Test
    void testDeleteRestaurantSuccess() {
        RestaurantResponseDTO saved =
                restaurantService.save(createDTO("DeleteMe" + System.currentTimeMillis()));

        String result = restaurantService.delete(saved.getRestaurantId());

        assertTrue(result.contains("deleted"));
    }

    // ❌ 15. Delete Restaurant - Not Found
    @Test
    void testDeleteRestaurantNotFound() {
        assertThrows(ResourceNotFoundException.class,
                () -> restaurantService.delete(9999));
    }
}