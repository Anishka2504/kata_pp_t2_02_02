package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    public static final List<Car> carList = Collections.unmodifiableList(
            new ArrayList<>() {
                {
                    add(new Car(1, "Brand1", "model1"));
                    add(new Car(2, "Brand2", "model2"));
                    add(new Car(3, "Brand3", "model3"));
                    add(new Car(4, "Brand4", "model4"));
                    add(new Car(5, "Brand5", "model5"));
                }
            }
    );

    public List<Car> findAll() {
        return carList;
    }

    public List<Car> getCountOfCars(int count) {
        return count >= carList.size() ? carList : carList.subList(0, count);
    }
}
