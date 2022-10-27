package phoneshop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneManage {

    HashMap<String, Phone> phoneList = new HashMap<String, Phone>();

    public void addPhone() {
        Phone p = new Phone();
        phoneList.put(p.getPhoneId(), p);
    }

    public void displayAll() {
        if (phoneList.isEmpty()) {
            System.out.println("Phone List is empty !!!");
            return;
        }
        for (String i : phoneList.keySet()) {
            System.out.println(phoneList.get(i));
        }
    }

    public void saveFile() {
        FileWriter fw = null;
        try {
            if (phoneList.isEmpty()) {
                System.out.println("Cannot data to save !!!");
                return;
            }

            fw = new FileWriter("Phone.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Phone> entry : phoneList.entrySet()) {
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

    public void searchPhone(String sPhoneName) {
        int flag = 0;
        for (String i : phoneList.keySet()) {
            if (phoneList.get(i).phoneName.equals(sPhoneName)) {
                System.out.println(phoneList.get(i));
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("Not found !!!");
        }
    }

}
