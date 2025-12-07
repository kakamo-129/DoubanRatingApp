//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {
    private int count = 0;
    private Scanner scanner;
    ArrayList<Movie> movies = new ArrayList();

    public MovieManager() {
        this.scanner = new Scanner(System.in);
    }

    public void initializeSampleMovies() {
        this.addMovie(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9.7, "Drama/Crime", "Hope can set you free"));
        this.addMovie(new Movie("Farewell My Concubine", "Chen Kaige", 1993, 9.6, "Drama/Romance", "A timeless classic"));
        this.addMovie(new Movie("Leon: The Professional", "Luc Besson", 1994, 9.4, "Drama/Crime", "The story of a hitman and a young girl"));
        this.addMovie(new Movie("Interstellar", "Christopher Nolan", 2014, 9.4, "Sci-fi/Adventure", "Love is the one thing that transcends time and space"));
        this.addMovie(new Movie("Spirited Away", "Hayao Miyazaki", 2001, 9.4, "Animation/Fantasy", "Best of Miyazaki, best of Joe Hisaishi"));
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public void showMainMenu() {
        while(true) {
            System.out.println("\n===Douban MovieManager===");
            System.out.println("1.View all movies");
            System.out.println("2.Add new movies");
            System.out.println("3.Search movies");
            System.out.println("4.Delete movies");
            System.out.println("5.Modify movie information");
            System.out.println("6.Movie statistics information");
            System.out.println("7.Rating ranking list");
            System.out.println("8.Export movie information");
            System.out.println("0.Log out");
            System.out.println("Please select an operation");
            int choice1 = this.scanner.nextInt();
            switch (choice1) {
                case 0:
                    System.out.println("Thank you for using!The data has been automatically saved");
                    return;
                case 1:
                    this.displayAllMovies();
                    break;
                case 2:
                    this.addNewMovie();
                    break;
                case 3:
                    this.searchMovie();
                    break;
                case 4:
                    this.deleteMovie();
                    break;
                default:
                    System.out.println("Invalid selection,please re-enter");
            }
        }
    }

    public void displayAllMovies() {
        if (this.movies == null) {
            System.out.println("These no movie data");
        }

        System.out.println("\n===All movie list");

        for(int i = 0; i < this.movies.size(); ++i) {
            System.out.println(this.movies.get(i));
        }

        System.out.println("\nEnter the sequence number to view details(0 to return)");
        int index = this.scanner.nextInt();
        if (index > 0 && index <= this.movies.size()) {
            PrintStream var10000 = System.out;
            Object var10001 = this.movies.get(index - 1);
            var10000.println("\n" + String.valueOf(var10001));
        }

    }

    private void addNewMovie() {
        System.out.println("\n===Add new movies===");
        System.out.print("Enter the title:");
        String title = this.scanner.nextLine();
        System.out.print("Enter the director:");
        String director = this.scanner.nextLine();
        System.out.print("Enter the year:");
        int year = this.scanner.nextInt();
        System.out.print("Enter the rating(0-10):");
        double rating = this.scanner.nextDouble();
        System.out.print("Enter the genre");
        String genre = this.scanner.nextLine();
        System.out.print("Enter the review");
        String review = this.scanner.nextLine();
        new Movie(title, director, year, rating, genre, review);
    }

    private void searchMovie() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║                    Search movie                     ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ 1. \ud83d\udd24 Search by title                              ║");
        System.out.println("║ 2. \ud83c\udfa5 Search by director                           ║");
        System.out.println("║ 3. \ud83c\udff7️ Search by genre                              ║");
        System.out.println("║ 4. ⭐ Search by rating                             ║");
        System.out.println("║ 5. \ud83d\udcc5 Search by year                               ║");
        System.out.println("║ 0. ↩️ Return to the main menu                      ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("Please choose your search method");
        int choice2 = this.scanner.nextInt();
        if (choice2 != 0) {
            System.out.print("\nPlease enter the keyword");
            String keyword = this.scanner.nextLine().toLowerCase();
            System.out.println("\nResult:");
            System.out.println("=".repeat(50));
            boolean found = false;
            switch (choice2) {
                case 1:
                    for(int i = 0; i < this.count; ++i) {
                        if (((Movie)this.movies.get(i)).getTitle().toLowerCase().contains(keyword)) {
                            System.out.println("[#" + (i + 1) + "]" + this.movies.toString());
                            found = true;
                        }
                    }
                    break;
                case 2:
                    for(int i = 0; i < this.count; ++i) {
                        if (((Movie)this.movies.get(i)).getDirector().toLowerCase().contains(keyword)) {
                            System.out.println("[#" + (i + 1) + "]" + this.movies.toString());
                            found = true;
                        }
                    }
                    break;
                case 3:
                    for(int i = 0; i < this.count; ++i) {
                        if (((Movie)this.movies.get(i)).getGenre().toLowerCase().contains(keyword)) {
                            System.out.println("[#" + (i + 1) + "]" + this.movies.toString());
                            found = true;
                        }
                    }
                    break;
                case 4:
                    try {
                        double minRating = Double.parseDouble(keyword);

                        for(int i = 0; i < this.count; ++i) {
                            if (((Movie)this.movies.get(i)).getRating() >= minRating) {
                                System.out.println("[#" + (i + 1) + "]" + this.movies.toString());
                                found = true;
                            }
                        }
                        break;
                    } catch (NumberFormatException var8) {
                        System.out.println("Please enter the correct rating number!");
                        return;
                    }
                case 5:
                    try {
                        int year = Integer.parseInt(keyword);

                        for(int i = 0; i < this.count; ++i) {
                            if (((Movie)this.movies.get(i)).getYear() == year) {
                                System.out.println("[#" + (i + 1) + "]" + this.movies.toString());
                                found = true;
                            }
                        }
                        break;
                    } catch (NumberFormatException var7) {
                        System.out.println("Please enter the correct year number!");
                        return;
                    }
                default:
                    System.out.println("Ineffective choice");
                    return;
            }

            if (!found) {
                System.out.println("No relevant movies here");
            }

        }
    }

    private void deleteMovie() {
        this.displayAllMovies();
        if (this.count != 0) {
            System.out.print("\nPlease enter the sequence number of the movie you want to delete(0 to cancel):");
        }
    }
}
