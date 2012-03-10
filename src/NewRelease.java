/**
* Created by IntelliJ IDEA.
* User: koly
* Date: 3/9/12
* Time: 4:30 PM
* To change this template use File | Settings | File Templates.
*/
public class NewRelease extends Movie {
    public NewRelease(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented*3;
    }
}
