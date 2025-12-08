import java.util.Arrays;
import java.util.Scanner;

public class MovieManager {
    private Movie[] movies;  //array
    private int count;  //number of the film
    private Scanner scanner;
    private static final int MAX_MOVIES = 100;  //the max number of the film

    public MovieManager() {
        movies = new Movie[MAX_MOVIES];
        count = 0;
        scanner = new Scanner(System.in);
    }

    //add some films data in advance

    public void initializeSimpleMovies() {
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
        System.out.println("Done!" + count + "classic movies initialized!");
    }

    private boolean addMovie(Movie movie){
        if (count < MAX_MOVIES){
            movies[count]=movie;
            count++;
            return true;
        }
        return false;
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
                case 5:
                    updateMovie();
                    break;
                case 6:
                    showStatistics();
                    break;
                case 7:
                    showRatingRanking();
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
            return;
        }
        System.out.println("\n===All movie list");
        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i]);
        }
        System.out.println("\nEnter the sequence number to view details(0 to return)");
        int index1 = scanner.nextInt();
        if (index1 > 0 && index1 <= movies.length){
            System.out.println("\n" + movies[index1-1]);
        }

    }

    //2.add new movie

    private void addNewMovie() {
        if (count >= MAX_MOVIES){
            System.out.println("The data is full! Please delete some data first");
            return;
        }
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
        if (addMovie(newMovie)){
            System.out.println("\nmovie《"+ title +"》successfully added!");
            System.out.println("Currently,there are"+ count +"movies");
        }else {
            System.out.println("\nFail to add!" );
        }

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
                    if (movies[i].getTitle().toLowerCase().contains(keyword)) {//search the title which contains keyword
                        System.out.println("[#" + (i + 1) + "]" + movies.toString());
                        found = true;
                    }
                }
                break;

            case 2://director
                for (int i = 0; i < count; i++) {
                    if (movies[i].getDirector().toLowerCase().contains(keyword)) {
                        System.out.println("[#" + (i + 1) + "]" + movies.toString());
                        found = true;
                    }
                }
                break;

            case 3://genre
                for (int i = 0; i < count; i++) {
                    if (movies[i].getGenre().toLowerCase().contains(keyword)) {
                        System.out.println("[#" + (i + 1) + "]" + movies.toString());
                        found = true;
                    }
                }
                break;

            case 4://rating
                try {
                    double minRating = Double.parseDouble(keyword);//set the minimum of the rating
                    for (int i = 0; i < count; i++) {
                        if (movies[i].getRating() >= minRating) {
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
                        if (movies[i].getYear() == year) {
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
        int index2 = scanner.nextInt();
        if (index2 == 0)return;
        if (index2 > 0 && index2 <= count){
            Movie movie = movies[index2-1];
            System.out.println("\nAre you sure to delete 《" + movie.getTitle() +"》?(Input 'y' to confirm,'other keys' to cancel");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")){
                for (int i = index2-1; i < count-1; i++) {
                    movies[i]=movies[i+1];
                }
                movies[count-1] = null;
                count--;
                System.out.println("Delete successfully!");
            }else {
                System.out.println("Deleted cancelled!");
            }
        }else{
            System.out.println("Invalid serial number!");
        }
    }

    //5.Modify movie data

    private void updateMovie(){
        displayAllMovies();
        if (count == 0)return;
        System.out.println("\nPlease enter the sequence(0 to cancel):");
        int index3 = scanner.nextInt();
        if (index3 == 0)return;
        if (index3 > 0 && index3 <= count){
            Movie movie = movies[index3-1];
            System.out.println("\nCurrent movie data:");
            System.out.println(movies[index3-1]);
            System.out.println("\nPlease enter new data(Press Enter to keep unchanged):");
            System.out.print("Movie title ["+ movie.getTitle() +"]:");
            String title = scanner.nextLine();
            if (title!=null);//enter new title
            movie.setTitle(title);
            System.out.print("Director ["+ movie.getDirector() +"]:");
            String director = scanner.nextLine();
            if (director!=null);//enter new director
            movie.setDirector(director);
            System.out.print("Year["+movie.getYear()+"]:");
            String year = scanner.nextLine();
            if (year!=null){//enter new year
                try {
                    movie.setYear(Integer.parseInt(year)); //change String into Int
                }catch (NumberFormatException e){//check if the year format correct(Int)
                    System.out.println("Incorrect year format , remains unchanged ");
                }
            }
            System.out.println("Movie genre["+movie.getGenre()+"]:");
            String genre = scanner.nextLine();
            if (genre!=null);
            movie.setGenre(genre);
            System.out.print("Review["+movie.getReview()+"]:");
            String review = scanner.nextLine();
            if (review!=null);
            movie.setReview(review);
            System.out.println("\nMovie data update successfully");
            System.out.println(movies[index3-1]);
        }else{
            System.out.println("Invalid sequence!");
        }
    }
    private void showRatingRanking() {
        if (count == 0) {
            System.out.println("No movies to rank!");
            return;
        }


        Movie[] rankedMovies = new Movie[count];
        System.arraycopy(movies, 0, rankedMovies, 0, count);


        Arrays.sort(rankedMovies, (m1, m2) -> {

            return Double.compare(m2.getRating(), m1.getRating());
        });


        System.out.println("\n=== Movie Rating Ranking (High to Low) ===");
        for (int i = 0; i < rankedMovies.length; i++) {
            Movie movie = rankedMovies[i];
            System.out.printf(
                    "[%d] %s (Rating: %.1f) - Director: %s, Year: %d%n",
                    i + 1,
                    movie.getTitle(),
                    movie.getRating(),
                    movie.getDirector(),
                    movie.getYear()
            );
        }
    }
    private void showStatistics() {


        // Iterate through the movies collection and print the full data of all movies
        System.out.println("Complete information of all movies：");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }


}




