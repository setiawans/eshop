package id.ac.ui.cs.advprog.eshop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {
    @InjectMocks
    CarRepository carRepository;

    @InjectMocks
    CarServiceImpl carService;

    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
        this.car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.car.setCarName("BMW");
        this.car.setCarColor("blue");
        this.car.setCarQuantity(10);
    }

    @Test
    void testCreateAddCarToCarRepository() {
        carService.create(car);
        assertEquals(car, carService.findAll().get(0));
    }

    @Test
    void testEditCarWorksProperly() {
        carService.create(car);
        Car editedCar = new Car();
        editedCar.setCarName("Ferrari");
        editedCar.setCarColor("red");
        editedCar.setCarQuantity(15);
        carService.update("eb558e9f-1c39-460e-8860-71af6af63bd6", editedCar);

        Car updatedCar = carService.findById("eb558e9f-1c39-460e-8860-71af6af63bd6");

        assertEquals("Ferrari", updatedCar.getCarName());
        assertEquals("red", updatedCar.getCarColor());
        assertEquals(15, updatedCar.getCarQuantity());
    }

    @Test
    void testDeleteCarWorksProperly() {
        carService.create(car);
        carService.deleteCarById(car.getCarId());
        assertEquals(0, carService.findAll().size());
    }

    @Test
    void testFindByIdCarWorksProperly() {
        carService.create(car);
        assertEquals(car, carService.findById(car.getCarId()));
    }
}
