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
			RegularMovie regular=new RegularMovie();
			movieTotal = regular.calculateRegularMovieTotal(movieTotal, this);
		}
		if ((getMovie().getPriceCode()) == Movie.NEW_RELEASE) {
			New_Release new_Release = new New_Release();
			movieTotal = new_Release.calculateNew_ReleaseMovieTotal(movieTotal, this);
		}
		if ((getMovie().getPriceCode()) == Movie.CHILDRENS) {
			Children children = new Children();
			movieTotal = children.calculateChildrensMovieTotal(movieTotal, this);
		}
		
		return movieTotal;
	}



}
