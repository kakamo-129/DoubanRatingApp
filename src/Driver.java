import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    Movie temp;
    ArrayList<Movie> movies =new ArrayList<>();
    Movie sample = new Movie();
    Movie VioletEvergarden = new Movie(12,"Yes","Taichi Ishidate\n Haruka Fujita"
            ,"20mins per episode","VioletEvergarden",
            """
            The war is over, and Violet Evergarden needs a job. 
            Scarred and emotionless, she takes a job as a letter writer to understand herself and her past.
            """);
    Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("------------------");
        System.out.println("Douban rating app");
        System.out.println("------------------");
        new Driver();
    }
        Driver(){

            movies.add(sample);
            movies.add(VioletEvergarden);
            runMenu();
        }

        private int menuInMovie() {
            System.out.println("""
                    1)Rate for this movie/series!
                    2)Comment on this movie/series!
                    0)Exit
                    Enter a number here=>
                    """);
            int option = input.nextInt();
            input.nextLine();
            return option;
        }

        private void runMenuInMovie(){
            int option = menuInMovie();
            while (true) {
                switch (option) {
                    case 1:
                        System.out.println("Your rate(plz enter an integer between 1 to 10!): ");
                        input.nextInt();
                        break;
                    case 2:
                        System.out.println("Write a friendly comment on this piece!");
                        break;
                    case 0:

                        break;

                    default:System.out.println("Invalid number!");
                }
            if  (option == 0){
                System.out.println("Turning to the main menu...");
                break;
            }
                option =menuInMovie();
            }

        }

        private int mainMenu(){
        System.out.println("""
                1)Search the movie
                2)Create a movie entry
                0)Exit
                Enter a number here=>
                """);
        int option = input.nextInt();
        input.nextLine();
        return option;
    }

        private void runMenu(){
        int option = mainMenu() ;
        while (true) {
            switch (option) {
                case 1:
                    searchMovie();
                    break;
                case 2:
                    addMovie();
                    break;
                case 0:break;
                default:System.out.println("Invalid number!");
            }
            if (option == 0) {
                System.out.println("Are you sure you want to quit?(yes/no)");
                char choice = input.nextLine().charAt(0);
                if (choice == 'y') {
                    System.out.println("Bye...");
                    break;
                }
            }
            option =mainMenu();
        }

    }


        private void addMovie(){
        System.out.println("To create a movie entry,please provide the following information");
        System.out.println("Movie's Name: ");
        String movieName = input.nextLine();
        System.out.println("Name of Director(s): ");
        String directorName = input.nextLine();
        System.out.println("Number of episodes: ");
        int episodeNumber = input.nextInt();
        input.nextLine();
        System.out.println("Is it finished(Yes/No)");
        String isFinished = input.nextLine();
        System.out.println("Duration of the film(or per episode): ");
        String duration = input.nextLine();
        System.out.println("Description: ");
        String description = input.nextLine();
        System.out.println("Thank you for creating this movie entry for our app!");
        temp = new Movie(episodeNumber,isFinished,directorName,duration,
                movieName,description);
        movies.add(temp);


    }

        private void searchMovie(){
        System.out.println("Enter the name of movie/series(Do not type any wrong letter!)");
        String searchName = input.nextLine();
        int totalMoviesNumber = movies.size();
        boolean flag = false;
        //System.out.println(totalMoviesNumber);
        for (int i = 0;i < totalMoviesNumber;i++){
            Movie targetMovie = movies.get(i);
            String movieName = targetMovie.getMovieName();
            if (searchName.equals(targetMovie.getMovieName()))//Using String class method to judge whether two String are identical.
            {
                flag = true;
                System.out.println(targetMovie);
                runMenuInMovie();
                break;
            }

            }
            if (!flag){
                System.out.println("Oops,nothing is found!");
            }
        }

    }



