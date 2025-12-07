import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {

    private int count;  //number of the film
    private Scanner scanner;
    ArrayList<Movie> movies =new ArrayList<>();

    public MovieManager() {

        count = 0;
        scanner = new Scanner(System.in);
    }

    //add some films data in advance

    void initializeSampleMovies() {
        addMovie(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9.7,
                "Drama/Crime", "Hope can set you free"));

        addMovie(new Movie("Farewell My Concubine", "Chen Kaige", 1993, 9.6,
                "Drama/Romance", "A timeless classic"));

        addMovie(new Movie("Leon: The Professional", "Luc Besson", 1994, 9.4,
                "Drama/Crime", "The story of a hitman and a young girl"));

        addMovie(new Movie("Interstellar", "Christopher Nolan", 2014, 9.4,
                "Sci-fi/Adventure", "Love is the one thing that transcends time and space"));

        addMovie(new Movie("Spirited Away", "Hayao Miyazaki", 2001, 9.4,
                "Animation/Fantasy", "Best of Miyazaki, best of Joe Hisaishi"));

    }

    private void addMovie(Movie movie){
        movies.add(movie);


    }

    //show the menu

    public void showMainMenu() {
        while (true) {
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
            int choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    displayAllMovies();
                    break;
                case 2:
                    addNewMovie();
                    break;
                case 3:
                    searchMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 0:
                    System.out.println("Thank you for using!The data has been automatically saved");
                    return;
                default:
                    System.out.println("Invalid selection,please re-enter");
            }

        }
    }

    //1.display movie data

    public void displayAllMovies() {
        if (movies == null) {
            System.out.println("These no movie data");
        }
        System.out.println("\n===All movie list");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }
        System.out.println("\nEnter the sequence number to view details(0 to return)");
        int index = scanner.nextInt();
        if (index > 0 && index <= movies.size()){
            System.out.println("\n" + movies.get(index-1));
        }

    }

    //2.add new movie

    private void addNewMovie() {
        System.out.println("\n===Add new movies===");
        System.out.print("Enter the title:");
        String title = scanner.nextLine();
        System.out.print("Enter the director:" );
        String director = scanner.nextLine();
        System.out.print("Enter the year:");
        int year = scanner.nextInt();
        System.out.print("Enter the rating(0-10):");
        double rating = scanner.nextDouble();
        System.out.print("Enter the genre");
        String genre = scanner.nextLine();
        System.out.print("Enter the review");
        String review = scanner.nextLine();
        Movie newMovie = new Movie(title,director,year,rating,genre,review);

    }

    //3.search movies

    private void searchMovie(){
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║                    Search movie                     ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ 1. 🔤 Search by title                              ║");
        System.out.println("║ 2. 🎥 Search by director                           ║");
        System.out.println("║ 3. 🏷️ Search by genre                              ║");
        System.out.println("║ 4. ⭐ Search by rating                             ║");
        System.out.println("║ 5. 📅 Search by year                               ║");
        System.out.println("║ 0. ↩️ Return to the main menu                      ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("Please choose your search method");
        int choice2 = scanner.nextInt();
        if (choice2 == 0)return;
        System.out.print("\nPlease enter the keyword");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.println("\nResult:");
        System.out.println("=".repeat(50));
        boolean found = false;
        switch (choice2) {
            case 1://title
                for (int i = 0; i < count; i++) {
                    if (movies.get(i).getTitle().toLowerCase().contains(keyword)) {//search the title which contains keyword
                        System.out.println("[#" + (i + 1) + "]" + movies.toString());
                        found = true;
                    }
                }
                break;

            case 2://director
                for (int i = 0; i < count; i++) {
                    if (movies.get(i).getDirector().toLowerCase().contains(keyword)) {
                        System.out.println("[#" + (i + 1) + "]" + movies.toString());
                        found = true;
                    }
                }
                break;

            case 3://genre
                for (int i = 0; i < count; i++) {
                    if (movies.get(i).getGenre().toLowerCase().contains(keyword)) {
                        System.out.println("[#" + (i + 1) + "]" + movies.toString());
                        found = true;
                    }
                }
                break;

            case 4://rating
                try {
                    double minRating = Double.parseDouble(keyword);//set the minimum of the rating
                    for (int i = 0; i < count; i++) {
                        if (movies.get(i).getRating() >= minRating) {
                            System.out.println("[#" + (i + 1) + "]" + movies.toString());
                            found = true;
                        }
                    }
                } catch (NumberFormatException e) {//check whether the input rating data is correct
                    System.out.println("Please enter the correct rating number!");
                    return;
                }
                break;

            case 5://year
                try {
                    int year = Integer.parseInt(keyword);
                    for (int i = 0; i < count; i++) {
                        if (movies.get(i).getYear() == year) {
                            System.out.println("[#" + (i + 1) + "]" + movies.toString());
                            found = true;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter the correct year number!");//check whether the input year data is correct
                    return;
                }
                break;
            default:
                System.out.println("Ineffective choice");
                return;
        }

        //if there is no movie data relative to the keyword

        if(!found){
            System.out.println("No relevant movies here");
        }
    }

    //4.delete movie data

    private void deleteMovie(){
        displayAllMovies();
        if (count == 0)return;
        System.out.print("\nPlease enter the sequence number of the movie you want to delete(0 to cancel):");
    }
}




