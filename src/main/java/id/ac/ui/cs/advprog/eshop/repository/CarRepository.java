package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository implements IRepository<Car> {
    private List<Car> carData;

    public CarRepository() {
        carData = new ArrayList<>();
    }

    @Override
    public Car create(Car car) {
        if (car.getCarId() == null) {
            car.setCarId(generateId());
        }
        carData.add(car);
        return car;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Iterator<Car> findAll() {
        return carData.iterator();
    }

    @Override
    public Car findById(String id) {
        for (Car car : carData) {
            if (car.getCarId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car update(String id, Car updatedCar) {
        Car car = findById(id);
        if (car != null) {
            updateCarProperties(car, updatedCar);
            return car;
        }
        return null;
    }

    private void updateCarProperties(Car car, Car updatedCar) {
        car.setCarName(updatedCar.getCarName());
        car.setCarColor(updatedCar.getCarColor());
        car.setCarQuantity(updatedCar.getCarQuantity());
    }

    @Override
    public void delete(String id) {
        carData.removeIf(car -> car.getCarId().equals(id));
    }
}
