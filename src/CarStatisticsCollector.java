import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * CarStatisticsCollector class is responsible for collecting statistical data
 * on a list of cars, including minimum, maximum, average price, and standard deviation.
 */
public class CarStatisticsCollector {

    /**
     * Collects statistics from the provided list of cars.
     *
     * @param cars the list of cars to collect statistics from
     * @return a Statistics object containing min, max, average price, and standard deviation
     */
    public static Statistics collect(List<Car> cars) {
        // Use a stream to calculate summary statistics (min, max, average) for the car prices
        DoubleSummaryStatistics stats = cars.stream()
                .map(Car::getPrice) // Map Car objects to their price
                .mapToDouble(BigDecimal::doubleValue) // Convert the price to a double for statistics
                .summaryStatistics(); // Collect summary statistics (min, max, avg)

        // Calculate the variance based on the prices of the cars
        double mean = stats.getAverage(); // Get the average (mean) price from the statistics
        double variance = cars.stream()
                .mapToDouble(car -> Math.pow(car.getPrice().doubleValue() - mean, 2)) // Calculate squared difference from the mean
                .average() // Get the average of squared differences (variance)
                .orElse(0); // Return 0 if the average is empty

        // Create a new Statistics object with the calculated statistics
        return new Statistics(
                BigDecimal.valueOf(stats.getMin()), // Minimum price
                BigDecimal.valueOf(stats.getMax()), // Maximum price
                BigDecimal.valueOf(stats.getAverage()), // Average price
                Math.sqrt(variance) // Standard deviation (square root of variance)
        );
    }
}