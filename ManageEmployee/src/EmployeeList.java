
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeList {

    TreeMap<String, Employee> treeEmp = new TreeMap<String, Employee>();

    public void addNew() {
        Employee e = new Employee();
        treeEmp.put(e.id, e);
    }

    public void display() {
        if (treeEmp.isEmpty()) {
            System.out.println("Employee List is empty !!!");
            return;
        }
        for (Map.Entry<String, Employee> entry : treeEmp.entrySet()) {
            System.out.println(
                    "Employee [ Id: " + entry.getKey()
                    + ", " + entry.getValue() + "]");
        }
    }

    public void save() {
        FileWriter fw = null;
        try {
            if (treeEmp.isEmpty()) {
                System.out.println("Cannot data to save !!!");
                return;
            }

            fw = new FileWriter("Employee.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Employee> entry : treeEmp.entrySet()) {
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
