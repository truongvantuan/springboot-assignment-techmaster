package vn.techmaster.demoannotation.model;

import vn.techmaster.demoannotation.annotation.MyNumberAnnotation;

public class HelloWorld {
    
    @MyNumberAnnotation
    public void sayHello() {
        System.out.println("Hello custom annotation");
    }
}
