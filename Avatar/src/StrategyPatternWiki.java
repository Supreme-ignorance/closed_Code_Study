import java.util.ArrayList;
import java.util.List;

public class StrategyPatternWiki {
	public static void Main(String[] args) {
		Customer firstCustomer = new Customer(new NormalStrategy());

		// Normal billing
		firstCustomer.Add(1.0, 1);

		// Start Happy Hour
		firstCustomer.setStrategy(new HappyHourStrategy());
		firstCustomer.Add(1.0, 2);

		// New Customer
		Customer secondCustomer = new Customer(new HappyHourStrategy());
		secondCustomer.Add(0.8, 1);
		// The Customer pays
		firstCustomer.PrintBill();

		// End Happy Hour
		secondCustomer.setStrategy(new NormalStrategy());
		secondCustomer.Add(1.3, 2);
		secondCustomer.Add(2.5, 1);
		secondCustomer.PrintBill();
	}
}

class Customer {
	private List<Double> drinks;
	private IBillingStrategy strategy;

	// Get/Set Strategy
	public IBillingStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IBillingStrategy strategy) {
		this.strategy = strategy;
	}

	public Customer(IBillingStrategy strategy) {
		this.drinks = new ArrayList<Double>();
		this.strategy = strategy;
	}

	public void Add(double price, int quantity) {
		drinks.add(strategy.GetActPrice(price * quantity));
	}

	// Payment of bill
	public void PrintBill() {
		double sum = 0;
		for (double i : drinks) {
			sum += i;
		}
		System.out.println("Total due: " + sum);
		drinks.clear();
	}
}

interface IBillingStrategy {
	double GetActPrice(double rawPrice);
}

// Normal billing strategy (unchanged price)
class NormalStrategy implements IBillingStrategy {
	public double GetActPrice(double rawPrice) {
		return rawPrice;
	}
}

// Strategy for Happy hour (50% discount)
class HappyHourStrategy implements IBillingStrategy {
	public double GetActPrice(double rawPrice) {
		return rawPrice * 0.5;
	}
}
