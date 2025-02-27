package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarRepositoryTest {
    @InjectMocks
    CarRepository carRepository;

    @BeforeEach
    void setUp() {}

    @Test
    void testCreateAndFind() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Toyota Avanza");
        car.setCarColor("Silver");
        car.setCarQuantity(10);
        carRepository.create(car);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car.getCarId(), savedCar.getCarId());
        assertEquals(car.getCarName(), savedCar.getCarName());
        assertEquals(car.getCarColor(), savedCar.getCarColor());
        assertEquals(car.getCarQuantity(), savedCar.getCarQuantity());
    }

    @Test
    void testCreateWithGeneratedId() {
        Car car = new Car();
        car.setCarName("Honda Civic");
        car.setCarColor("Black");
        car.setCarQuantity(5);
        Car savedCar = carRepository.create(car);

        assertNotNull(savedCar.getCarId());

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car retrievedCar = carIterator.next();
        assertEquals(savedCar.getCarId(), retrievedCar.getCarId());
    }

    @Test
    void testUpdateCar() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Toyota Avanza");
        car.setCarColor("Silver");
        car.setCarQuantity(10);
        carRepository.create(car);

        Car updatedCar = new Car();
        updatedCar.setCarName("Toyota Avanza Veloz");
        updatedCar.setCarColor("Black");
        updatedCar.setCarQuantity(15);

        Car result = carRepository.update(car.getCarId(), updatedCar);
        assertEquals(car.getCarId(), result.getCarId());
        assertEquals("Toyota Avanza Veloz", result.getCarName());
        assertEquals("Black", result.getCarColor());
        assertEquals(15, result.getCarQuantity());
    }

    @Test
    void testUpdateNonExistentCar() {
        Car car = new Car();
        car.setCarName("Toyota Avanza");
        car.setCarColor("Silver");
        car.setCarQuantity(10);

        Car result = carRepository.update("eb558e9f-1c39-460e-8860-71af6af63bd6", car);
        assertNull(result);
    }

    @Test
    void testDeleteCar() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Toyota Avanza");
        car.setCarColor("Silver");
        car.setCarQuantity(10);
        carRepository.create(car);

        carRepository.delete(car.getCarId());
        Iterator<Car> carIterator = carRepository.findAll();
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testDeleteNonExistentCar() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Toyota Avanza");
        car1.setCarColor("Silver");
        car1.setCarQuantity(10);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Honda Jazz");
        car2.setCarColor("Red");
        car2.setCarQuantity(5);
        carRepository.create(car2);

        int initialCount = 0;
        Iterator<Car> initialIterator = carRepository.findAll();
        while (initialIterator.hasNext()) {
            initialIterator.next();
            initialCount++;
        }

        carRepository.delete("83478d3a-56a7-4d78-a57f-665a92b7a40b");

        int finalCount = 0;
        Iterator<Car> finalIterator = carRepository.findAll();
        while (finalIterator.hasNext()) {
            finalIterator.next();
            finalCount++;
        }

        assertEquals(initialCount, finalCount);
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Car> carIterator = carRepository.findAll();
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneCar() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Toyota Avanza");
        car1.setCarColor("Silver");
        car1.setCarQuantity(10);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Honda Jazz");
        car2.setCarColor("Red");
        car2.setCarQuantity(5);
        carRepository.create(car2);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car1.getCarId(), savedCar.getCarId());
        savedCar = carIterator.next();
        assertEquals(car2.getCarId(), savedCar.getCarId());
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindById() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Toyota Avanza");
        car.setCarColor("Silver");
        car.setCarQuantity(10);
        carRepository.create(car);

        Car foundCar = carRepository.findById(car.getCarId());
        assertNotNull(foundCar);
        assertEquals(car.getCarId(), foundCar.getCarId());
        assertEquals(car.getCarName(), foundCar.getCarName());
        assertEquals(car.getCarColor(), foundCar.getCarColor());
        assertEquals(car.getCarQuantity(), foundCar.getCarQuantity());
    }

    @Test
    void testFindByIdWithNonExistentId() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Toyota Avanza");
        car.setCarColor("Silver");
        car.setCarQuantity(10);
        carRepository.create(car);

        Car foundCar = carRepository.findById("non-existent-id");
        assertNull(foundCar);
    }
}