package vn.techmaster.demoannotation.controller;

import java.lang.reflect.Method;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.demoannotation.annotation.MyNumberAnnotation;
import vn.techmaster.demoannotation.model.HelloWorld;

@Controller
public class HomeController {

    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getAnnotation() {
        try {
            Class myClass = HelloWorld.class;
            Method mth = myClass.getMethod("sayHello", null);
            MyNumberAnnotation annotation = mth.getAnnotation(MyNumberAnnotation.class);
            return "Value: " + annotation.value();
        } catch (Exception e) {
            return "error: " + e.toString();
        }
    }
}
