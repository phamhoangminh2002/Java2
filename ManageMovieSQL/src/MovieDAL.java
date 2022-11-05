
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDAL {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Scanner sc = new Scanner(System.in);

    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=MoviesDb";
            con = DriverManager.getConnection(url, "sa", "password");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createMovie(Movies movie) {
        con = getCon();
        String sqlInsert = "insert into Movie values(?,?,?,?)";
        try {
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, movie.getMovieName());
            ps.setInt(2, movie.getPrice());
            ps.setString(3, movie.getGenre());
            ps.setFloat(4, movie.getDuration());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Movies> showAll() {
        List<Movies> list = new ArrayList<Movies>();
        con = getCon();
        String sqlSelect = "select * from Movie";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Movies movie = new Movies(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5));
                list.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean searchAndDelete() {
        List<Movies> list = new ArrayList<Movies>();
        con = getCon();
        String sqlSelect = "select * from Movie";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Movies movie = new Movies(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5));
                list.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("Enter Id: ");
        int id = Integer.parseInt(sc.nextLine());
        int flag = 0;
        for (Movies movie : list) {
            if (movie.getId() == id) {
                Delete(id);
                System.out.println("This movie has deleted !!!");
                return true;
            }
        }
        return false;
    }

    private void Delete(int id) {
        con = getCon();
        String sqlDelete = "Delete from Movie where id = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Movies> searchPriceToPrice(int priceFrom, int priceTo) {
        List<Movies> list = new ArrayList<Movies>();
        con = getCon();
        String sqlSelect = "select * from Movie where price between ? and ? ";
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, priceFrom);
            ps.setInt(2, priceTo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Movies movie = new Movies(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5));
                list.add(movie);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movies> searchByGenre(String sBrand) {
        List<Movies> list = new ArrayList<Movies>();
        con = getCon();
        String sqlSelect = "select * from Movie where genre = ? ";
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, sBrand);
            rs = ps.executeQuery();
            while (rs.next()) {
                Movies movie = new Movies(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5));
                list.add(movie);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
