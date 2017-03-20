
public class RegularMovie implements CalcularPelis{

	
	@Override
	public double calculateTotal(double movieTotal, Rental rental) {
		movieTotal += 2;
		if (rental.getDaysRented() > 2)
			movieTotal += (rental.getDaysRented() - 2) * 1.5;
		return  movieTotal;

	}


}
