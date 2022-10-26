package managemovie;

import java.util.Scanner;

public class Movie {

    public String movieName;
    public int price;
    public float duration;
    public String Genere;
    Scanner sc = new Scanner(System.in);

    public Movie() {
        System.out.print("Movie name: ");
        movieName = sc.nextLine();

        System.out.print("Price: ");
        price = Integer.parseInt(sc.nextLine());

        while (true) {
            try {
                System.out.print("Enter duration: ");
                duration = Float.parseFloat(sc.nextLine());
                if (duration > 1 && duration < 3) {
                    break;
                } else {
                    throw new Exception("1 < Duration < 3!!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Gerere: ");
                Genere = sc.nextLine();
                if ("Action".equals(Genere)
                        || "Drama".equals(Genere)
                        || "Comedy".equals(Genere)
                        || "Adventure".equals(Genere)) {
                    break;
                } else {
                    throw new Exception("Genere must be belong ['Action', 'Drama', 'Comedy', 'Adventure'] !!!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return " Movie Name: " + movieName
                + ", Price: " + price
                + ", Duration: " + duration
                + ", Genere: " + Genere;
    }
}
