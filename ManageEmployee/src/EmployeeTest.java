
import java.util.Scanner;

public class EmployeeTest {
     public static void main(String[] args) {
        EmployeeList emp = new EmployeeList();
        Scanner sc = new Scanner(System.in); 
        String choice = "";
        while (true){
            System.out.println("\n === MENU ===");
            System.out.println("1. Add new Employee");
            System.out.println("2. Display employee");
            System.out.println("3. Save list of employee");
            System.out.println("4. Display file text");
            System.out.println("5. Exit");
            System.out.print("Vui long chon [1-5]: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    emp.addNew();
                    break;
                case "2":
                    emp.display();
                    break;
                case "3":
                   emp.save();
                    break;
                case "4":
                     Runtime r = Runtime.getRuntime();
                    try {
                        r.exec("NotePad.exe Employee.txt");
                    } catch (Exception e) {
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
