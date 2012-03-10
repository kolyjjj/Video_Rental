public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateAmount(){
        return movie.calculateAmount(daysRented);
    }

    public boolean isTwoDayNewRelease() {
        return daysRented > 1 && movie instanceof NewRelease;
    }
}