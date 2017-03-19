
public class New_Release implements CalcularPelis{

	double calculateNew_ReleaseMovieTotal(double movieTotal, Rental rental) {
		movieTotal += rental.getDaysRented() * 3;
		return movieTotal;
	}



	public float calculateTotal(double movieTotal, Rental rental) {
		// TODO Auto-generated method stub
		return 0;
	}

}
