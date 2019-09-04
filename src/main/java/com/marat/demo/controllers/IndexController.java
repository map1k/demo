package com.marat.demo.controllers;

import com.marat.demo.domain.Car;
import com.marat.demo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController
{
    @Autowired
    private CarRepository carRepository;

    @RequestMapping({"", "/", "index"})
    public String getIndexPage() {
        return "index";
    }

    @PostMapping({"", "/", "index"})
    public String save (@RequestParam("name") String name) {
        Car car = new Car();
        car.setName(name);
        carRepository.save(car);
        return "index";
    }
}
