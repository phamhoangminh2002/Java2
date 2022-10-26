package managemovie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class TreeMovies {

    public String id;
    TreeMap<String, Movie> mMovies = new TreeMap<String, Movie>();

    public void insertMovie() {
        String regex = "M[0-9]{4}";
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter Id: ");
                id = sc.nextLine();
                if (Pattern.compile(regex).matcher(id).matches() && !mMovies.containsKey(id)) {
                    break;
                } else if (mMovies.containsKey(id)) {
                    System.out.println("Key already exists !!");
                } else {
                    throw new Exception("ID format invalid . Math format: Mxxxx. x:digit !!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Movie m = new Movie();
        mMovies.put(id, m);
    }

    public void showAll() {
        if (mMovies.isEmpty()) {
            System.out.println("Movie List is empty !!!");
            return;
        }
        for (Map.Entry<String, Movie> entry : mMovies.entrySet()) {
            System.out.println(
                    "Movie [ Id: " + entry.getKey()
                    + ", " + entry.getValue() + "]");
        }
    }

    public void findByGenere(String sGenere) {
        int flag = 0;
        for (Map.Entry<String, Movie> entry : mMovies.entrySet()) {
            if (entry.getValue().Genere.contains(sGenere)) {
                mMovies.remove(entry.getKey());
                System.out.print("Deleted successfully !!!");
                System.out.println(
                        "Movie [ Id: " + entry.getKey()
                        + ", " + entry.getValue() + "]");
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("No search results");
        }
    }

    public void writeToFile() {
        FileWriter fw = null;
        try {
            if (mMovies.isEmpty()) {
                System.out.println("Cannot data to save !!!");
                return;
            }

            fw = new FileWriter("Movie.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Movie> entry : mMovies.entrySet()) {
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
