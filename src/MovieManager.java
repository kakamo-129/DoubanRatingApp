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
            System.out.println("\n===Douban MovieManager===");
            System.out.println("1.View all movies");
            System.out.println("2.Add new movies");
            System.out.println("3.Search movies");
            System.out.println("4.Delete movies");
            System.out.println("5.Modify movie information");
            System.out.println("6.Show movie data by ranking level");
            System.out.println("7.Rating ranking list");
            System.out.println("0.Log out");
            System.out.println("Please select an operation");
            int choice1 = scanner.nextInt();
            scanner.nextLine();
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

    //1.display movie data

    public void displayAllMovies() {
        if (addMovie == null) {
            System.out.println("These no movie data");
        }
        System.out.println("\n===All movie list");
        for (int i = 0; i < addMovie.size(); i++) {
            System.out.println(i + 1 + "." + "《" + addMovie.get(i).getTitle() + "》");
        }
        System.out.println("\nEnter the sequence number to view details(0 to return)");
        int index = scanner.nextInt();
        if (index > 0 && index <= addMovie.size()) {
            System.out.println("\n" + addMovie.get(index - 1));
        }
    }

    //2.add new movie

    private void addNewMovie() {
        System.out.println("\n===Add new movies===");
        System.out.print("Enter the title:");
        String title1 = scanner.nextLine();
        System.out.print("Enter the director:");
        String director = scanner.nextLine();
        System.out.print("Enter the year:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the rating(0-10):");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter the genre:");
        String genre = scanner.nextLine();
        System.out.print("Enter the review:");
        String review = scanner.nextLine();
        Movie newMovie = new Movie(title1, director, year, rating, genre, review);
        addMovie.add(newMovie);
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
        scanner.nextLine();
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
                        System.out.println("[" + (i + 1) + "]" + addMovie.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                    return;
                }
                System.out.println("=".repeat(50));
                break;

            case 2://director
                for (int i = 0; i < addMovie.size(); i++) {
                    if (addMovie.get(i).getDirector().toLowerCase().contains(keyword)) {
                        System.out.println("[" + (i + 1) + "]" + addMovie.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                    return;
                }
                System.out.println("=".repeat(50));
                break;

            case 3://genre
                for (int i = 0; i < addMovie.size(); i++) {
                    if (addMovie.get(i).getGenre().toLowerCase().contains(keyword)) {
                        System.out.println("[" + (i + 1) + "]" + addMovie.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                    return;
                }
                System.out.println("=".repeat(50));
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
                            }
                        }
                    } catch (NumberFormatException e) {//check whether the input rating data is correct
                        System.out.println("Please enter the correct rating number!");
                        keyword = scanner.nextLine();
                    }
                    if (!found) {
                        System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                        return;
                    }
                    System.out.println("=".repeat(50));
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
                            }

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter the correct year number!(0 to cancel)");//check whether the input year data is correct
                        keyword = scanner.nextLine();
                    }
                    if (!found) {
                        System.out.println("No relevant movies here"); //if there is no movie data relative to the keyword
                        return;
                    }
                    System.out.println("=".repeat(50));
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
                System.out.println("[" + (i + 1) + "]" + addMovie.get(i) );
            } else {
                System.out.println("There is no such movie");
                System.out.println("=".repeat(25));
                return;
            }

        }

    }


        //7.rank the movie by rating

    private void showRatingRanking () {
        if (addMovie.size() == 0) {
            System.out.println("No movies to rank!");
            return;
        }

        Movie[] rankedMovies = new Movie[addMovie.size()];
        System.arraycopy(addMovie, 0, rankedMovies, 0, addMovie.size());


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





}

