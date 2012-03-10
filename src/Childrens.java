public class Childrens extends Movie {
    public Childrens(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented>3?(daysRented-2)*1.5:1.5;
    }
}
