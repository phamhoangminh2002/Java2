package managemovie;

import java.io.IOException;
import java.util.Scanner;

public class TestMovie {
    public static void main(String[] args) throws IOException {
        TreeMovies movies = new TreeMovies();
        Scanner sc = new Scanner(System.in); 
        String choice = "";
        while (true){
            System.out.println("\n === MENU ===");
            System.out.println("1. Create a new movie");
            System.out.println("2. Search and Delete movie");
            System.out.println("3. Save text File");
            System.out.println("4. Display file text");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Vui long chon [1-4]: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    movies.insertMovie();
                    break;
                case "2":
                    System.out.print("Enter Genere movie want delete: ");
                    String sGenere = sc.nextLine();
                    movies.findByGenere(sGenere);
                    break;
                case "3":
                    movies.writeToFile();
                    break;
                case "4":
                    Runtime r = Runtime.getRuntime();
                    try {
                        r.exec("NotePad.exe Movie.txt");
                    } catch (Exception e) {
                    }
                    break;
                case "5":
                     movies.showAll();
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
