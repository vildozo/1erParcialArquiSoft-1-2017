/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	double calculateAmountByMovieType() {	
		double movieTotal=0;
		if ((getMovie().getPriceCode()) == Movie.REGULAR) {
			movieTotal += 2;
			if (getDaysRented() > 2)
				movieTotal += (getDaysRented() - 2) * 1.5;
		}
		if ((getMovie().getPriceCode()) == Movie.NEW_RELEASE) {
			movieTotal += getDaysRented() * 3;
		}
		if ((getMovie().getPriceCode()) == Movie.CHILDRENS) {
			movieTotal += 1.5;
			if (getDaysRented() > 3)
				movieTotal += (getDaysRented() - 3) * 1.5;
		}
		
		return movieTotal;
	}



}
