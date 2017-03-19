
public class Children implements CalcularPelis{



	double calculateChildrensMovieTotal(double movieTotal, Rental rental) {
		movieTotal += 1.5;
		if (rental.getDaysRented() > 3)
			movieTotal += (rental.getDaysRented() - 3) * 1.5;
		return movieTotal;
	}

	@Override
	public float calculateTotal(double movieTotal, Rental rental) {
		// TODO Auto-generated method stub
		return 0;
	}

}
