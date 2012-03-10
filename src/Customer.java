import java.util.ArrayList;

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
        calculateAmountAndRentalPoints();
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

    private void calculateAmountAndRentalPoints() {
        for (Rental each : rentalList) {
            calculateAmountAndPointsForEachRental(each);
        }
    }

    private void calculateAmountAndPointsForEachRental(Rental each) {
        double thisAmount;
        thisAmount = each.calculateAmount();
        calculateFrequentRenterPoints(each);
        attachAmountToStatement(each, thisAmount);
        totalAmount += thisAmount;
    }

    private void attachAmountToStatement(Rental each, double thisAmount) {
        statement += "\t" + each.getMovie().getTitle() + "\t"
            + String.valueOf(thisAmount) + "\n";
    }

    private void calculateFrequentRenterPoints(Rental each) {
        if (each.isTwoDayNewRelease()) {
            frequentRenterPoints = frequentRenterPoints + 2;
        } else {
            frequentRenterPoints++;
        }
    }

    public void setRental(int index, Movie movie, int daysRented) {
        rentalList.set(index, new Rental(movie, daysRented));
    }
}
