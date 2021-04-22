package vn.techmaster.readcsv.controller;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.techmaster.readcsv.model.Car;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = "/")
    public String getcar(Model model) {

        List<Car> carList = readFromCsv("car.csv");
        model.addAttribute("cars", carList);
        model.addAttribute("storeName", appName);
        return "home";
    }

    /**
     * Hàm đọc dữ liệu từ file .csv
     * 
     * @param fileName tên file csv truyền vào, file đặt tại thư mục gốc cùng cấp
     * @return trả về dang sách đối tượng Car.
     */
    public static List<Car> readFromCsv(String fileName) {

        ArrayList<Car> carList = new ArrayList<>();

        try (Scanner inputFile = new Scanner(Paths.get(fileName))) {

            while (inputFile.hasNext()) {
                String row = inputFile.nextLine();
                String[] parts = row.split(",");
                int id = Integer.parseInt(parts[0]);
                int price = Integer.parseInt(parts[3]);

                Car car = new Car(id, parts[1], parts[2], price);
                carList.add(car);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return carList;
    }
}
