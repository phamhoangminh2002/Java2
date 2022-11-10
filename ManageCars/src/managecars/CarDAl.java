package managecars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDAl {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Scanner sc = new Scanner(System.in);

    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=CarDb";
            con = DriverManager.getConnection(url, "sa", "password");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addCar(Car car) {
        con = getCon();
        String sqlInsert = "insert into Car values(?,?,?,?)";
        try {
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, car.code);
            ps.setString(2, car.carName);
            ps.setInt(3, car.price);
            ps.setString(4, car.model);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Car> showAll() {
        List<Car> list = new ArrayList<Car>();
        con = getCon();
        String sqlSelect = "select * from Car";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                list.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean searchAndDelete() {
        List<Car> list = new ArrayList<Car>();
        con = getCon();
        String sqlSelect = "select * from Car";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                list.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("Enter Code: ");
        String code = sc.nextLine();
        int flag = 0;
        for (Car car : list) {
            if (car.getCode().equals(code)) {
                Delete(code);
                System.out.println("This movie has deleted !!!");
                return true;
            }
        }
        return false;
    }

    private void Delete(String code) {
        con = getCon();
        String sqlDelete = "Delete from Car where code = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setString(1, code);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Car> searchPriceToPrice(int priceFrom, int priceTo) {
        List<Car> list = new ArrayList<Car>();
        con = getCon();
        String sqlSelect = "select * from Car where price between ? and ? ";
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, priceFrom);
            ps.setInt(2, priceTo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                list.add(car);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
