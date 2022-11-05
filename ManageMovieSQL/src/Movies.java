
import java.util.Scanner;

public class Movies {

    public int id;
    public String movieName;
    public int price;
    public String genre;
    public float duration;

    public Movies() {
    }

    public Movies(int id, String movieName, int price, String genre, float duration) {
        this.id = id;
        this.movieName = movieName;
        this.price = price;
        this.genre = genre;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    
    Scanner sc = new Scanner(System.in);

    public void inputMovie() {
        while (true) {
            try {
                System.out.print("Enter movieName: ");
                movieName = sc.nextLine();
                if (movieName.isBlank()) {
                    throw new Exception("MovieName not blank ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Price: ");
                price = Integer.parseInt(sc.nextLine());
                if (price > 0) {
                    break;
                } else {
                    throw new Exception("Price must be > 0 ");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Genre: ");
                genre = sc.nextLine();
                if (genre.isBlank()) {
                    throw new Exception("Genre not blank ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true) {
            try {
                System.out.print("Enter Duration: ");
                duration = Float.parseFloat(sc.nextLine());
                if (duration>=1 && duration <=3) {
                    break;
                } else {
                    throw new Exception("Duration must be between 1 and 3 ");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    
     @Override
    public String toString() {
        return "Movie ["
                + "Id: " + id
                + ", MovieName: " + movieName
                + ", Price: " + price
                + ", Genre: " + genre
                + ", Duration: " + duration
                + "]";
    }

}
