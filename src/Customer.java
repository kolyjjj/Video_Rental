import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();
    private int frequentRenterPoints;
    private double totalAmount;
    private String statement;

    public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		statement = "Rental Record for " + getName() + "\n";
        calculateRentalRecord();
        acquireTotalAmountStatement();
        acquireFrequentRenterPointsStatement();
	    return statement;
    }

    private void acquireFrequentRenterPointsStatement() {
        statement += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
    }

    private void acquireTotalAmountStatement() {
        statement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    }

    private void calculateRentalRecord() {
       calculateAmountAndRentalPoints();
    }

    private void calculateAmountAndRentalPoints() {
        Iterator<Rental> rentals = rentalList.iterator();
        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental each = rentals.next();
            thisAmount = calculateAmount(each);
            calculateFrequentRenterPoints(each);
            statement += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
    }

    private void calculateFrequentRenterPoints(Rental each) {
        if (each.isTwoDayNewRelease()) {
            frequentRenterPoints = frequentRenterPoints + 2;
        } else {
            frequentRenterPoints++;
        }
    }

    private double calculateAmount(Rental each) {
        return each.calculateAmount();
    }

    public void setRental(int index, Movie movie, int daysRented) {
        rentalList.set(index, new Rental(movie, daysRented));
    }
}
