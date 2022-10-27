
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreList {

    HashMap<String, Mobile> mList = new HashMap<String, Mobile>();

    public void addNew() {
        String regexID = "M[0-9]{3}";
        String regexBrand = "^(?:Iphone||Samsung||Xiaomi)$";
        Scanner sc = new Scanner(System.in);
        Mobile m = new Mobile();
        while (true) {
            try {
                System.out.print("Enter Id: ");
                m.ID = sc.nextLine();
                if (Pattern.compile(regexID).matcher(m.ID).matches() && !mList.containsKey(m.ID)) {
                    break;
                } else if (mList.containsKey(m.ID)) {
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
                m.BandName = sc.nextLine();
                if (Pattern.compile(regexBrand).matcher(m.BandName).matches()) {
                    break;
                } else {
                    throw new Exception("Brand must be belong ['Iphone','Samsung','Xiaomi'] !!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter UnitPrice: ");
                m.UnitPrice = Integer.parseInt(sc.nextLine());
                if (m.UnitPrice >= 100 && m.UnitPrice <= 2000) {
                    break;
                } else {
                    throw new Exception("Unit price must be [100,2000]");
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
        mList.put(m.ID, m);
    }

    public void findByBrand(String sBrand) {
        int flag = 0;
        for (String i : mList.keySet()) {
            if (mList.get(i).BandName.equals(sBrand)) {
                System.out.println(mList.get(i));
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("Not found !!!");
        }
    }

    public void saveFile() {
        FileWriter fw = null;
        try {
            if (mList.isEmpty()) {
                System.out.println("Cannot data to save !!!");
                return;
            }

            fw = new FileWriter("mobile.txt", true);
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
