/**
* Created by IntelliJ IDEA.
* User: koly
* Date: 3/9/12
* Time: 4:30 PM
* To change this template use File | Settings | File Templates.
*/
public class Regular extends Movie {
    public Regular(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented>2?((daysRented-2)*1.5+2):2;
    }
}
