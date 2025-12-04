public class Movie {
    private int episodeNumber;
    private String  isFinished;
    private String directorName;
    private String duration;
    private String movieName;
    private String description;

    Movie(){
        episodeNumber = 12;
        isFinished = "Yes";
        directorName = "directorName";
        duration = "20mins per episode";
        movieName = "movieName";
        description = "It's a sample movie!:D";
    }

    Movie(int episodeNumber, String isFinished
            , String directorName, String duration, String movieName,
          String description){
        setEpisodeNumber(episodeNumber);
        setDirectorName(directorName);
        setFinished(isFinished);
        setMovieName(movieName);
        setDuration(duration);
        setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDuration() {
        return duration;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setFinished(String finished) {
        isFinished = finished;
    }

    @Override
    public String toString() {
        return "Details of the movie\n\n" +
                "Number of episodes: " + episodeNumber +"\n"+
                "Is it finished:" + isFinished +"\n"+
                "Director:" + directorName + "\n"+
                "Duration:" + duration;
    }
}
