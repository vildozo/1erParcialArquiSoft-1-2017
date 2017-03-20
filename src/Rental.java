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
		CalcularPelis movie = null;
		movie = createMovieType(movie);
		movieTotal = movie.calculateTotal(movieTotal, this);
		return movieTotal;
	}

	private CalcularPelis createMovieType(CalcularPelis movie) {
		if ((getMovie().getPriceCode()) == Movie.REGULAR) {
			movie=new RegularMovie();
		}
		if ((getMovie().getPriceCode()) == Movie.NEW_RELEASE) {
			movie = new New_Release();
		}
		if ((getMovie().getPriceCode()) == Movie.CHILDRENS) {
			movie = new Children();
		}
		return movie;
	}



}
