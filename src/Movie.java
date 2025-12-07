public class Movie {
    private String title;
    private String director;
    private int year;
    private double rating;
    private String genre;
    private String review;

    public Movie(String title,String director,int year,double rating,String genre,String review){
        this.title = title;
        this.director = director;
        this.rating =rating;
        this.review =review;
        this.genre = genre;
        this.year = year;
    }

    public Movie(){
        this("unknown","unknown",0,0.0,"unknown","empty");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <=10) {
            this.rating = rating;
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return String.format("《%s》(%d) - director:%s - rating:%.1f",title,year,director,rating);
    }

//Rating level

    public String getRatingLevel() {
        if (rating >= 9.0) return "Masterpiece";
        else if (rating >= 8.0) return "Excellent";
        else if (rating >= 7.0) return "Good";
        else if (rating >= 6.0) return "Average";
        else return "Poor";
    }

}


