
public class New_Release implements CalcularPelis{


	public double calculateTotal(double movieTotal, Rental rental) {
		movieTotal += rental.getDaysRented() * 3;
		return  movieTotal;
	}

}
