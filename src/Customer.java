import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String customerName;
	private Vector rentals = new Vector();
	private double totalAmount;
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

	public String generate() {
		totalAmount = 0;
		frequentRenterPoints = 0;
		Enumeration rentals = this.rentals.elements();
		String message = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();

			//determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}

			
			incrementPointsToFrecuentRenterPoints();
			hasBonusFor2DaysNewReleaseRental(each);

			
			message = returnMessageTabulatedOfMovieTitleAndAmount(message, thisAmount, each);
			totalAmount += thisAmount;
		}

		
		message = returnMessageAmountOwedAndFrecuentRenterPoints(message);

		return message;
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
