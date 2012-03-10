public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateAmount(){
        return movie.calculateAmount(daysRented);
    }

    public boolean isTwoDayNewRelease() {
        if (daysRented>1 && movie instanceof NewRelease){
            return true;
        }
        return false;
    }
}