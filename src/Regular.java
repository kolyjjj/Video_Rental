public class Regular extends Movie {
    public Regular(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented>2?((daysRented-2)*1.5+2):2;
    }
}
