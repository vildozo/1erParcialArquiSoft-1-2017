
public class RegularMovie implements CalcularPelis{

	
	@Override
	public float calculateTotal(double movieTotal, Rental rental) {
		// TODO Auto-generated method stub
		return 0;
	}

	double calculateRegularMovieTotal(double movieTotal, Rental rental) {
		movieTotal += 2;
		if (rental.getDaysRented() > 2)
			movieTotal += (rental.getDaysRented() - 2) * 1.5;
		return movieTotal;
	}

}
