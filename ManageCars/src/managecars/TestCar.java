
package managecars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCar {
    public static void main(String[] args){
       Car car = new Car();
       CarDAl dal = new CarDAl();
       List<Car> list = new ArrayList<Car>();
       Scanner sc = new Scanner(System.in);
       
    String choice = "";
        while (true){
            System.out.println("\n === MENU ===");
            System.out.println("1. Add new Car");
            System.out.println("2. Show All");
            System.out.println("3. Delete the Car");
            System.out.println("4. Search Price to Price");
            System.out.println("5. EXIT");
            System.out.print("Vui long chon [1-5]: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    car.input();
                    dal.addCar(car);
                    break;
                case "2":
                    list = dal.showAll();
                    if(list.isEmpty()){
                        System.out.println("Cannot data to display !!!");
                        break;
                    }
                    System.out.println("==== Car List ====");
                    for (Car c : list) {
                        System.out.println(c);
                    }
                    break;
                case "3":
                    if(!dal.searchAndDelete()){
                        System.out.println("Not found Code !!!");
                    }
                    break;
                 case "4":
                     System.out.print("Price From: ");
                     int priceFrom = Integer.parseInt(sc.nextLine());
                     System.out.print("Price To: ");
                     int priceTo = Integer.parseInt(sc.nextLine());
                     list = dal.searchPriceToPrice(priceFrom, priceTo);
                     if(list.isEmpty()){
                        System.out.println("Not found Price from " + priceFrom + " to " + priceTo);
                     }
                      for (Car c : list) {
                        System.out.println(c);
                      }
                    break;
                case "5":
                    System.out.println("EXIT");
                    return;
                default:
                    System.out.println("Wrong choice !!!");
            }
        }
    }
}
