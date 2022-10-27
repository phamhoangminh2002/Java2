
import java.util.Scanner;

public class StoreTest {
    public static void main(String[] args) {
        StoreList store = new StoreList();
        Scanner sc = new Scanner(System.in); 
        String choice = "";
        while (true){
            System.out.println("\n === MENU ===");
            System.out.println("1. Create a new mobile");
            System.out.println("2. Find by Brand ");
            System.out.println("3. Save text File");
            System.out.println("4. Display text File");
            System.out.println("5. Exit");
            System.out.print("Vui long chon [1-5]: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    store.addNew();
                    break;
                case "2":
                    System.out.print("Enter mobile want search: ");
                    String sbrand = sc.nextLine();
                    store.findByBrand(sbrand);
                    break;
                case "3":
                    store.saveFile();
                    break;
                case "4":
                     Runtime r = Runtime.getRuntime();
                    try {
                        r.exec("NotePad.exe mobile.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
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
