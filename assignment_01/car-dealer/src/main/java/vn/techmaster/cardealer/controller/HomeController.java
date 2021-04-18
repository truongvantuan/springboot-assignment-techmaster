package vn.techmaster.cardealer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.techmaster.cardealer.model.Car;

@Controller
public class HomeController {

    static final String APP_NAME = "storeName";
    static final String CAR_LIST = "cars";


    @Value("${spring.application.name}")
    private String storeName;

    @GetMapping(value = "/")
    public String getHome(Model model) {

        Car[] carList = { new Car(1, "Triton 4×4 Premium", "Misubishi", 869, "triton.jpg"),
                new Car(2, "Ranger", "Ford", 1205, "ranger.jpg"), new Car(3, "XL7 Premium", "Suzuki", 620, "xl7.png") };
        model.addAttribute(CAR_LIST, carList);
        model.addAttribute(APP_NAME, storeName);
        return "home";
    }

}
