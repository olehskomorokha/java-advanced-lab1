import java.math.BigDecimal;

/**
 * The Statistics class is used to represent the statistical summary of a collection of car prices.
 * It includes the minimum price, maximum price, average price, and standard deviation of the prices.
 */
public class Statistics {
    private BigDecimal minPrice;         // Minimum price of the cars
    private BigDecimal maxPrice;         // Maximum price of the cars
    private BigDecimal averagePrice;     // Average price of the cars
    private double standardDeviation;    // Standard deviation of the car prices

    /**
     * Constructor to initialize the Statistics object with the provided values.
     *
     * @param minPrice the minimum price
     * @param maxPrice the maximum price
     * @param averagePrice the average price
     * @param standardDeviation the standard deviation of the prices
     */
    public Statistics(BigDecimal minPrice, BigDecimal maxPrice, BigDecimal averagePrice, double standardDeviation) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.averagePrice = averagePrice;
        this.standardDeviation = standardDeviation;
    }

    /**
     * Returns a string representation of the Statistics object.
     *
     * @return a string summarizing the statistics
     */
    @Override
    public String toString() {
        // Format and return the statistics as a string
        return String.format("Statistics{minPrice = %s, maxPrice = %s, avgPrice = %s, standardDeviation = %.2f}",
                minPrice, maxPrice, averagePrice, standardDeviation);
    }
}
