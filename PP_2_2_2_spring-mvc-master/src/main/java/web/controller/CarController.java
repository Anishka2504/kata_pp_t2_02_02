package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.service.CarService;

@Controller
public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping(value = "/cars")
    public String getAllCars(ModelMap model) {
        model.addAttribute("carList", carService.findAll());
        return "cars";
    }

    @GetMapping(value = "/cars/count={count}")
    public String getCountOfCars(ModelMap model, @PathVariable int count) {
        model.addAttribute("carList", carService.getCountOfCars(count));
        return "cars";
    }
}
