
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMovie {
    public static void main(String[] args){
        
       Movies movie = new Movies();
       MovieDAL dal = new MovieDAL();
       List<Movies> list = new ArrayList<Movies>();
       Scanner sc = new Scanner(System.in);
       
    String choice = "";
        while (true){
            System.out.println("\n === MENU ===");
            System.out.println("1. Create a new Movie");
            System.out.println("2. Show All");
            System.out.println("3. Search and Delete the movie");
            System.out.println("4. Search Price to Price");
            System.out.println("5. Search by Brand");
            System.out.println("6. EXIT");
            System.out.print("Vui long chon [1-6]: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    movie.inputMovie();
                    dal.createMovie(movie);
                    break;
                case "2":
                    list = dal.showAll();
                    if(list.isEmpty()){
                        System.out.println("Cannot data to display !!!");
                        break;
                    }
                    System.out.println("==== Movies List ====");
                    for (Movies m : list) {
                        System.out.println(m);
                    }
                    break;
                case "3":
                    if(!dal.searchAndDelete()){
                        System.out.println("Not found ID !!!");
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
                      for (Movies m : list) {
                        System.out.println(m);
                      }
                    break;
                case "5":
                    System.out.print("Genre movie want search: ");
                    String sBrand = sc.nextLine();
                    list = dal.searchByGenre(sBrand);
                    if(list.isEmpty()){
                        System.out.println("Not found Genre !!!");
                    }
                      for (Movies m : list) {
                        System.out.println(m);
                      }
                    break;
                case "6":
                    System.out.println("EXIT");
                    return;
                default:
                    System.out.println("Wrong choice !!!");
            }
        }
    }
}
