package phoneshop;

import java.util.Scanner;

public class Phone {
    public String phoneId, phoneName,Supplier;
    public int price;

    public Phone() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Phone Id: ");
        phoneId = sc.nextLine();
        System.out.print("Phone Name: ");
        phoneName = sc.nextLine();
        System.out.print("Supplier: ");
        Supplier = sc.nextLine();
        System.out.print("Price: ");
        price = Integer.parseInt(sc.nextLine());
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public Phone(String phoneId, String phoneName, String Supplier, int price) {
        this.phoneId = phoneId;
        this.phoneName = phoneName;
        this.Supplier = Supplier;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Phone ["
                + "Phone Id: " + phoneId
                + ", Phone Name: " + phoneName
                + ", Supplier: " + Supplier
                + ", Price: " + price
                + "]";
    }
}
