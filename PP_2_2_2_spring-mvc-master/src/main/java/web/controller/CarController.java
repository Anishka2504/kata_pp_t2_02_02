package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class CarController {

    public static final List<Car> carList = Collections.unmodifiableList(
            new ArrayList<Car>() {
                {
                    add(new Car(1, "Brand1", "model1"));
                    add(new Car(2, "Brand2", "model2"));
                    add(new Car(3, "Brand3", "model3"));
                    add(new Car(4, "Brand4", "model4"));
                    add(new Car(5, "Brand5", "model5"));
                }
            }
    );

    @GetMapping(value = "/cars")
    public String getAllCars(ModelMap model) {
        model.addAttribute("carList", carList);
        return "cars";
    }

    @GetMapping(value = "/cars?count={count}")
    public String getCountOfCars (ModelMap model, @PathVariable int count) {
        model.addAttribute("carList", count >= carList.size() ? carList : carList.subList(0, count));
        return "cars";
    }
}
