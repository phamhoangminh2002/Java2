
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreList {

    HashMap<String, Mobile> mList = new HashMap<String, Mobile>();
    public static File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\ManageCellPhone\\Cellphone.txt");

    public void addNew() {
        String regexID = "M[0-9]{3}";
        String regexBrand = "^(?:Iphone||Samsung||Oppo)$";
        Scanner sc = new Scanner(System.in);
        Mobile m = new Mobile();
        while (true) {
            try {
                System.out.print("Enter Id: ");
                m.id = sc.nextLine();
                if (Pattern.compile(regexID).matcher(m.id).matches() && !mList.containsKey(m.id)) {
                    break;
                } else if (mList.containsKey(m.id)) {
                    System.out.println("Key already exists !!");
                } else {
                    throw new Exception("ID format invalid . Math format: Mxxx. x:digit !!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Brand: ");
                m.bandName = sc.nextLine();
                if (Pattern.compile(regexBrand).matcher(m.bandName).matches()) {
                    break;
                } else {
                    throw new Exception("Brand must be belong ['Iphone','Samsung','Oppo'] !!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Price: ");
                m.price = Integer.parseInt(sc.nextLine());
                if (m.price >= 100 && m.price <= 200) {
                    break;
                } else {
                    throw new Exception("Price must be [100,200]");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter QoH: ");
                m.QoH = Integer.parseInt(sc.nextLine());
                if (m.QoH >= 0 && m.QoH <= 200) {
                    break;
                } else {
                    throw new Exception("QoH must be [0,200]");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        mList.put(m.id, m);
    }

    public void displayAll() {
        if (mList.isEmpty()) {
            System.out.println("Mobile List is empty !!!");
            return;
        }
        for (Map.Entry<String, Mobile> entry : mList.entrySet()) {
            System.out.println(
                    "Movie [ Id: " + entry.getKey()
                    + ", " + entry.getValue() + "]");
        }

    }

    public void delete(String sCode) {
        int flag = 0;
        for (Map.Entry<String, Mobile> entry : mList.entrySet()) {
            if (entry.getValue().id.contains(sCode)) {
                mList.remove(entry.getKey());
                try {
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(mList.toString());
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.print("Deleted successfully !!!");
                System.out.println(
                        "Mobile [ Id: " + entry.getKey()
                        + ", " + entry.getValue() + "]");
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("No search results");
        }
    }

    public void saveFile() {
        FileWriter fw = null;
        try {
            if (mList.isEmpty()) {
                System.out.println("Cannot data to save !!!");
                return;
            }
            fw = new FileWriter("Cellphone.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Mobile> entry : mList.entrySet()) {
                fw.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
            System.out.println("Save SuccessFully !!!");
            bw.flush();
            fw.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
