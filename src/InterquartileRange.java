import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The InterquartileRange class calculates the interquartile range (IQR) for a list of cars based on their prices.
 */
public class InterquartileRange {

    /**
     * Calculates the interquartile range (IQR) for the given list of cars.
     * The IQR is the difference between the third quartile (Q3) and the first quartile (Q1) of the prices.
     *
     * @param cars the list of cars to process
     * @return the interquartile range (IQR) of the car prices
     */
    public static double calculate(List<Car> cars) {
        // Extract the prices of the cars, sort them, and collect them into a list
        List<BigDecimal> prices = cars.stream()
                .map(Car::getPrice) // Get the price of each car
                .sorted() // Sort the prices in ascending order
                .collect(Collectors.toList()); // Collect the sorted prices into a list

        // Calculate the size of the list of prices
        int size = prices.size();

        // Calculate the first quartile (Q1) - the median of the lower half of the data
        double q1 = prices.get(size / 4).doubleValue();

        // Calculate the third quartile (Q3) - the median of the upper half of the data
        double q3 = prices.get(3 * size / 4).doubleValue();

        // Return the difference between Q3 and Q1, which is the interquartile range
        return q3 - q1;
    }
}
