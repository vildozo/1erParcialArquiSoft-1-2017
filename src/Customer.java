import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String customerName;
	private Vector rentals = new Vector();
	private double totalAmount=0;
	private int frequentRenterPoints;

	public Customer(String customerName) {
		this.customerName = customerName;
	}

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	public String getName() {
		return customerName;
	}

	public String generateReportOfMovieRentals() {
		frequentRenterPoints = 0;
		String message = "Rental Record for " + getName() + "\n";
		Enumeration rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			thisAmount = each.calculateAmountByMovieType();
			incrementPointsToFrecuentRenterPoints();
			hasBonusFor2DaysNewReleaseRental(each);
			message = returnMessageTabulatedOfMovieTitleAndAmount(message, thisAmount, each);
			totalAmount += thisAmount;
		}
		return returnMessageAmountOwedAndFrecuentRenterPoints(message);
	}

	private void hasBonusFor2DaysNewReleaseRental(Rental each) {
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
			incrementPointsToFrecuentRenterPoints();
	}

	private void incrementPointsToFrecuentRenterPoints() {
		frequentRenterPoints++;
	}

	private String returnMessageTabulatedOfMovieTitleAndAmount(String result, double thisAmount, Rental each) {
		result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
		return result;
	}

	private String returnMessageAmountOwedAndFrecuentRenterPoints(String result) {
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	public double getTotal() {
		return totalAmount;
	}

	public int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}
}
