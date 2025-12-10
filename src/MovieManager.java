import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MovieManager {//array
    private Scanner scanner;
    private static final int MAX_MOVIES = 100;  //the max number of the film
    ArrayList<Movie> addMovie = new ArrayList<>();

    public MovieManager() {
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
    }

    private void addMovie(Movie movie) {
        addMovie.add(movie);
    }

    //show the menu

    public void showMainMenu() {
        while (true) {
            // Top decorative separator + Title
            System.out.println("\n=========================================");
            System.out.println("          🎬 Douban Movie Manager         ");
            System.out.println("=========================================");
            // Menu options (unified indentation + alignment, add icon indicators)
            System.out.println("  1. 📋 View all movies");
            System.out.println("  2. ➕ Add new movies");
            System.out.println("  3. 🔍 Search movies");
            System.out.println("  4. ❌ Delete movies");
            System.out.println("  5. ✏️ Modify movie information");
            System.out.println("  6. 📊 Show movie data by ranking level");
            System.out.println("  7. ⭐ Rating ranking list");
            System.out.println("  0. 🚪 Log out");
            // Bottom separator + prominent input prompt
            System.out.println("=========================================");
            System.out.print("  👉 Please select an operation (enter the corresponding number): ");

            int choice1 = scanner.nextInt();
            scanner.nextLine();
            switch (choice1) {
                case 1:
                    displayAllMovies();
                    break;
                // Keep the original logic for other cases
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
                    showDataByRankingLevel();
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







    private void showRatingRanking() {// Check if there's any movie data first
        if (addMovie.isEmpty()) {
            System.out.println("No movie data available!");
            return;
        }
        int size = addMovie.size();
        // Perform bubble sort on the ArrayList (descending order by rating)
        for (int i = 0; i < size - 1; i++) { // Outer loop: control the number of sorting rounds (size-1 rounds total)
            for (int j = 0; j < size - 1 - i; j++) { // Inner loop: compare adjacent elements, skip sorted tail elements
                Movie movie1 = addMovie.get(j);
                Movie movie2 = addMovie.get(j + 1);
                // Descending order: swap if previous movie's rating is lower than the next
                if (movie1.getRating() < movie2.getRating()) {
                    // Swap elements in ArrayList using set method
                    addMovie.set(j, movie2);
                    addMovie.set(j + 1, movie1);
                }
            }
        }
        // Print the sorted ranking results
        System.out.println("\n=== Movie Rating Ranking (High to Low) ===");
        for (int i = 0; i < size; i++) {
            Movie movie = addMovie.get(i);
            System.out.printf("Rank %d: Title=%s, Rating=%.1f, Director=%s, Year=%d%n",
                    i + 1, movie.getTitle(), movie.getRating(), movie.getDirector(), movie.getYear());
        }
    }




    //1.display movie data

    // 1. Display all movies (with brief list + detail view support)
    public void displayAllMovies() {
        // Fix: Check if movie list is empty (ArrayList won't be null after initialization)
        if (addMovie.isEmpty()) {
            System.out.println("\n=========================================");
            System.out.println("          ❌ No Movie Data Available          ");
            System.out.println("=========================================");
            return; // Exit method to avoid subsequent code execution
        }

        // Polished list header
        System.out.println("\n=========================================");
        System.out.println("          📋 All Movie List          ");
        System.out.println("=========================================");
        // Format brief info (index + title) with neat alignment
        for (int i = 0; i < addMovie.size(); i++) {
            Movie movie = addMovie.get(i);
            System.out.printf("  %d. 《%s》%n", i + 1, movie.getTitle());
        }

        // User guidance (clearer prompt + visual indicator)
        System.out.println("=========================================");
        System.out.print("  👉 Enter sequence number to view details (0 to return): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline from input

        // Handle input logic
        if (index == 0) {
            System.out.println("\n← Returning to main menu...");
            return;
        }
        // Validate input range
        if (index > 0 && index <= addMovie.size()) {
            Movie selected = addMovie.get(index - 1);
            // Polished detail view (structured + full info)
            System.out.println("\n=========================================");
            System.out.println("          🎬 Movie Details          ");
            System.out.println("=========================================");
            System.out.printf("  Title:    %s%n", selected.getTitle());
            System.out.printf("  Director: %s%n", selected.getDirector());
            System.out.printf("  Year:     %d%n", selected.getYear());
            System.out.printf("  Rating:   %.1f/10%n", selected.getRating());
            System.out.printf("  Review:   %s%n", selected.getReview());
            System.out.println("=========================================");
        } else {
            // Invalid input prompt (visual warning)
            System.out.println("\n=========================================");
            System.out.println("          ⚠️ Invalid Sequence Number!          ");
            System.out.println("=========================================");
        }
    }





    // 2. Add new movie (with input validation & polished feedback)
    private void addNewMovie() {
        // Polished header with decoration
        System.out.println("\n=========================================");
        System.out.println("          ➕ Add New Movie          ");
        System.out.println("=========================================");

        // 1. Input movie title (with prompt indicator)
        System.out.print("  👉 Enter the movie title: ");
        String title = scanner.nextLine();

        // 2. Input director
        System.out.print("  👉 Enter the director: ");
        String director = scanner.nextLine();

        // 3. Input year (add range validation)
        int year = 0;
        while (true) {
            System.out.print("  👉 Enter the release year (e.g., 2023): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year > 1800 && year <= java.time.Year.now().getValue()) { // Reasonable year range
                    scanner.nextLine(); // Consume leftover newline
                    break;
                } else {
                    System.out.println("    ⚠️ Invalid year! Please enter a year between 1800 and current year.");
                }
            } else {
                System.out.println("    ⚠️ Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        // 4. Input rating (add 0-10 range validation)
        double rating = 0.0;
        while (true) {
            System.out.print("  👉 Enter the rating (0.0-10.0): ");
            if (scanner.hasNextDouble()) {
                rating = scanner.nextDouble();
                if (rating >= 0 && rating <= 10) {
                    scanner.nextLine(); // Consume leftover newline
                    break;
                } else {
                    System.out.println("    ⚠️ Invalid rating! Please enter a value between 0.0 and 10.0.");
                }
            } else {
                System.out.println("    ⚠️ Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        // 5. Input genre
        System.out.print("  👉 Enter the genre (e.g., Drama/Comedy): ");
        String genre = scanner.nextLine();

        // 6. Input review
        System.out.print("  👉 Enter a brief review: ");
        String review = scanner.nextLine();

        // Create & add new movie
        Movie newMovie = new Movie(title, director, year, rating, genre, review);
        addMovie.add(newMovie);

        // Polished success feedback (show added movie info)
        System.out.println("\n=========================================");
        System.out.println("          ✅ Movie Added Successfully!          ");
        System.out.println("-----------------------------------------");
        System.out.printf("  Title:    %s%n", newMovie.getTitle());
        System.out.printf("  Director: %s%n", newMovie.getDirector());
        System.out.printf("  Year:     %d%n", newMovie.getYear());
        System.out.printf("  Rating:   %.1f/10%n", newMovie.getRating());
        System.out.println("=========================================");
    }


    //3.search movies

    private void searchMovie() {
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
        if (choice2 == 0) return;
        System.out.print("\nPlease enter the keyword");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.println("\nResult:");
        System.out.println("=".repeat(50));
        boolean found = false;
        switch (choice2) {
            case 1://title
                for (int i = 0; i < addMovie.size(); i++) {
                    if (addMovie.get(i).getTitle().toLowerCase().contains(keyword)) {//search the title which contains keyword
                        System.out.println("[#" + (i + 1) + "]" + addMovie.toString());
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                    return;
                }
                break;

            case 2://director
                for (int i = 0; i < addMovie.size(); i++) {
                    if (addMovie.get(i).getDirector().toLowerCase().contains(keyword)) {
                        System.out.println("[#" + (i + 1) + "]" + addMovie.toString());
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                    return;
                }
                break;

            case 3://genre
                for (int i = 0; i < addMovie.size(); i++) {
                    if (addMovie.get(i).getGenre().toLowerCase().contains(keyword)) {
                        System.out.println("[#" + (i + 1) + "]" + addMovie.toString());
                        found = true;
                    }else {
                        System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                        return;
                    }
                }
                break;

            case 4://rating
                boolean judgement1 = false;
                while (!judgement1) {
                    try {
                        double minRating = Double.parseDouble(keyword);//set the minimum of the rating
                        for (int i = 0; i < addMovie.size(); i++) {
                            if (addMovie.get(i).getRating() >= minRating) {
                                System.out.println("[" + (i + 1) + "]" + addMovie.get(i));
                                found = true;
                                judgement1 = true;
                            }else{
                                System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                                return;
                            }
                        }
                    } catch (NumberFormatException e) {//check whether the input rating data is correct
                        System.out.println("Please enter the correct rating number!");
                        keyword = scanner.nextLine();
                    }

                }
                break;

            case 5://year
                boolean judgement2 = false;
                while (!judgement2) {
                    try {
                        int year = Integer.parseInt(keyword);
                        for (int i = 0; i < addMovie.size(); i++) {
                            if (addMovie.get(i).getYear() == year) {
                                System.out.println("[" + (i + 1) + "]" + addMovie.get(i));
                                found = true;
                                judgement2 = true;
                            }else {
                                System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                                return;
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter the correct year number!(0 to cancel)");//check whether the input year data is correct
                        keyword = scanner.nextLine();
                    }
                }
                break;


        }

    }

    //4.delete movie data

    private void deleteMovie() {
        displayAllMovies();
        if (addMovie.size() == 0) return;
        System.out.print("\nPlease enter the sequence number of the movie you want to delete(0 to cancel):");
        int index2 = scanner.nextInt();
        scanner.nextLine();
        if (index2 == 0) return;
        if (index2 > 0 && index2 <= addMovie.size()) {
            Movie movie = addMovie.get(index2 - 1);
            System.out.println("\nAre you sure to delete 《" + movie.getTitle() + "》?(Input 'y' to confirm,'other keys' to cancel");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                for (int i = index2 - 1; i < addMovie.size() - 1; i++) {
                    addMovie.set(i, addMovie.get(i + 1));
                }
                addMovie.remove(addMovie.size() - 1);
                System.out.println("Delete successfully!");
            } else {
                System.out.println("Deleted cancelled!");
            }
        } else {
            System.out.println("Invalid serial number!");
        }
    }

    //5.Modify movie data

    private void updateMovie() {
        displayAllMovies();
        if (addMovie.size() == 0) return;
        System.out.println("\nPlease enter the sequence(0 to cancel):");
        int index3 = scanner.nextInt();
        scanner.nextLine();
        if (index3 == 0 || index3 >=6) return;
        if (index3 > 0 && index3 <= addMovie.size()) {
            Movie movie = addMovie.get(index3 - 1);
            System.out.println("\nCurrent movie data:");
            System.out.println(addMovie.get(index3 - 1));
            System.out.println("\nPlease enter new data(Press Enter to keep unchanged):");
            System.out.print("Movie title [" + movie.getTitle() + "]:");
            String title2 = scanner.nextLine();
            if (title2 != null) ;//enter new title
            movie.setTitle(title2);
            System.out.print("Director [" + movie.getDirector() + "]:");
            String director = scanner.nextLine();
            if (director != null) ;//enter new director
            movie.setDirector(director);
            System.out.print("Year[" + movie.getYear() + "](1900-2025):");
            String year = scanner.nextLine();
            if (year != null) {//enter new year
                boolean judgement = false;
                while (!judgement) {
                    try {
                        int Validyear = Integer.parseInt(year);//change String into Int
                        if (Validyear >= 1900 && Validyear <= 2025) {
                            movie.setYear(Validyear);
                            judgement = true;
                        }else {
                            System.out.println("Year should between 1900 and 2025!Please re-enter:");
                            year = scanner.nextLine();
                        }
                    } catch (NumberFormatException e) {//check if the year format correct(Int)
                        System.out.println("Incorrect year format , please re-enter: ");
                        year = scanner.nextLine();
                    }
                }
            }
            System.out.print("Movie genre[" + movie.getGenre() + "]:");
            String genre = scanner.nextLine();
            if (genre != null) ;
            movie.setGenre(genre);
            System.out.print("Review[" + movie.getReview() + "]:");
            String review = scanner.nextLine();
            if (review != null) ;
            movie.setReview(review);
            System.out.println("\nMovie data update successfully");
            System.out.println(addMovie.get(index3 - 1));
        } else {
            System.out.println("Invalid sequence!");
        }

    }
    //6.show the data by ranking level

    private void showDataByRankingLevel() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║                   Ranking level                    ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ 1. ★★★★★ Masterpiece (>=9.0)                     ║");
        System.out.println("║ 2. ★★★★☆ Excellent (8.0-8.9)                     ║");
        System.out.println("║ 3. ★★★☆☆ Good (7.0-7.9)                          ║");
        System.out.println("║ 4. ★★☆☆☆ Average (6.0-6.9)                       ║");
        System.out.println("║ 5. ★☆☆☆☆ Poor (<=6.0)                            ║");
        System.out.println("║ 0. ↩️  Back to main menu                           ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.print("\nPlease chose the ranking level: ");
        int choice3 = scanner.nextInt();
        scanner.nextLine();
        if (choice3 == 0) return;
        System.out.println("=".repeat(25));
        for (int i = 0; i < addMovie.size(); i++) {
            Movie movie = new Movie();
            double rating = addMovie.get(i).getRating();
            int Level = movie.getRatingLevel(rating);
            if (Level == choice3) {
                System.out.println("[#" + (i + 1) + "]" + movie.toString());
            } else {
                System.out.println("There is no such movie");
                System.out.println("=".repeat(25));
            }
            return;
        }


    }
}