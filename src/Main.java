import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║                                                    ║");
        System.out.println("║       Welcome to Douban Movie Management System    ║");
        System.out.println("║                                                    ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("Please log in first!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        String correctUsername = "Qijie,Wang";
        String correctPassword = "123456";
        if (username.equals(correctUsername)){
            if (password.equals(correctPassword)){
                System.out.println("Login successful!Welcome to use the system ~");
            }else {
                System.out.println("Wrong password,please try again");
            }

        } else {
            System.out.println("Wrong account,try please again");}
            //haha,i made a commit
            //Create movie manager and display menu
            MovieManager manager = new MovieManager();
            manager.initializeSampleMovies();
            manager.showMainMenu();
            //test messages:嗨害嗨，来了奥


    }





}

