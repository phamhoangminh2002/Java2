
import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee {

    public String id, name, address, email;

    public Employee() {
        String regexID = "M[0-9]{4}";
        String rexgexEmail = "^(.+)@(.+)$";
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter Id: ");
                id = sc.nextLine();
                if (Pattern.compile(regexID).matcher(id).matches()) {
                    break;
                } else {
                    throw new Exception("ID format invalid . Math format: Mxxxx. x:digit !!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Name: ");
                name = sc.nextLine();
                if (name.isBlank() || name.isEmpty()) {
                    throw new Exception("Name must be not Blank");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Address: ");
                address = sc.nextLine();
                if (address.isBlank() || address.isEmpty()) {
                    throw new Exception("Address must be not Blank");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Email: ");
                email = sc.nextLine();
                if (Pattern.compile(rexgexEmail).matcher(email).matches()) {
                    break;
                } else {
                    throw new Exception("Email format invalid  !!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Employee(String id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return " ID: " + id
                + ", Name: " + name
                + ", Address: " + address
                + ", Email: " + email;
    }
}
