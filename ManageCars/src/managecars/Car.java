package managecars;

import java.util.Scanner;

public class Car {

    public String code, carName;
    public int price;
    public String model;

    public Car() {

    }

    public Car(String code, String carName, int price, String model) {
        this.code = code;
        this.carName = carName;
        this.price = price;
        this.model = model;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Code: ");
        code = sc.nextLine();
        System.out.print("Enter Car Name: ");
        carName = sc.nextLine();
        System.out.print("Enter Price: ");
        price = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Model: ");
        model = sc.nextLine();
    }
    
     @Override
    public String toString() {
        return "Car ["
                + "Code: " + code
                + ", CarName: " + carName
                + ", Price: " + price
                + ", Model: " + model
                + "]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
