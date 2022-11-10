
import java.util.Scanner;

public class TestCellPhone {
    public static void main(String[] args) {
        StoreList store = new StoreList();
        Scanner sc = new Scanner(System.in); 
        String choice = "";
        while (true){
            System.out.println("\n === MENU ===");
            System.out.println("1. Add new Cellphone");
            System.out.println("2. Display all  ");
            System.out.println("3. Save list of cellphone");
            System.out.println("4. Delete");
            System.out.println("5. Display text file");
            System.out.println("6. Exit");
            System.out.print("Vui long chon [1-5]: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    store.addNew();
                    break;
                case "2":
                    store.displayAll();
                    break;
                case "3":
                    store.saveFile();
                    break;
                case "4":
                    System.out.print("Enter Code Delete: ");
                    String sCode = sc.nextLine();
                    store.delete(sCode);
                    break;
                case "5":
                     Runtime r = Runtime.getRuntime();
                    try {
                        r.exec("NotePad.exe Cellphone.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
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
