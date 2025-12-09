//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Movie {
    private String title;
    private String director;
    private int year;
    private double rating;
    private String genre;
    private String review;

    public Movie(String title, String director, int year, double rating, String genre, String review) {
        this.title = title;
        this.director = director;
        this.rating = rating;
        this.review = review;
        this.genre = genre;
        this.year = year;
    }

    public Movie() {
        this("unknown", "unknown", 0, (double)0.0F, "unknown", "empty");
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        if (rating >= (double)0.0F && rating <= (double)10.0F) {
            this.rating = rating;
        }

    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String toString() {
        return String.format("《%s》(%d) - director:%s - rating:%.1f", this.title, this.year, this.director, this.rating);
    }

    public String getRatingLevel(double rating) {
        if (this.rating >= (double)9.0F) {
            return "Masterpiece";
        } else if (this.rating >= (double)8.0F) {
            return "Excellent";
        } else if (this.rating >= (double)7.0F) {
            return "Good";
        } else {
            return this.rating >= (double)6.0F ? "Average" : "Poor";
        }
    }
}
