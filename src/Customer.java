import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();
    private int frequentRenterPoints;
    private double totalAmount;

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
		String result = "Rental Record for " + getName() + "\n";
        return  result + calculateRentalRecord();
	}

    private String calculateRentalRecord() {
        String result = "";
        result = calculateAmountAndRentalPoints();
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;

    }

    private String calculateAmountAndRentalPoints() {
        Iterator<Rental> rentals = rentalList.iterator();
        String result = "";
        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental each = rentals.next();
            thisAmount = calculateAmount(each);
            calculateFrequentRenterPoints(each);
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        return result;
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

}
