public class NewRelease extends Movie {
    public NewRelease(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented*3;
    }
}
