package phoneshop;

import java.util.Scanner;

public class PhoneShop {
    public static void main(String[] args) {
        PhoneManage phone = new PhoneManage();
        Scanner sc = new Scanner(System.in); 
        String choice = "";
        while (true){
            System.out.println("\n === MENU ===");
            System.out.println("1. Add new Phone");
            System.out.println("2. Display All");
            System.out.println("3. Save File");
            System.out.println("4. Search By Name");
            System.out.println("5. Display text File");
            System.out.println("6. Exit");
            System.out.print("Vui long chon [1-5]: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    phone.addPhone();
                    break;
                case "2":
                    phone.displayAll();
                    break;
                case "3":
                    phone.saveFile();
                    break;
                case "4":
                    System.out.print("Enter phone Name want search: ");
                    String sPhoneName = sc.nextLine();
                    phone.searchPhone(sPhoneName);
                     break;
                case "5":
                   Runtime r = Runtime.getRuntime();
                    try {
                        r.exec("NotePad.exe Phone.txt");
                    } catch (Exception e) {
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
