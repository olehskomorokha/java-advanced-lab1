import java.util.List;
import java.util.Map;

/**
 * Main class that demonstrates the process of generating, filtering, grouping,
 * and statistical analysis of cars.
 */
public class Main {

    /**
     * The main method that runs the program.
     * It generates cars, filters and groups them, collects statistics for each group,
     * and calculates the interquartile range.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // 1. Generate an infinite stream of cars
        int skip = 50; // Number of objects to skip
        // Call the gather method to get a list of cars after skipping the first N elements
        List<Car> cars = Gatherer.gather(CarGenerator.generate(), skip);

        // 2. Filter and group cars by car class
        int minMonths = 12; // Minimum number of months
        int maxMonths = 60; // Maximum number of months
        // Filter cars by the range of months since manufacture and group them by car class
        Map<String, List<Car>> groupedCars = CarFilter.filterAndGroup(cars, minMonths, maxMonths);

        // Print the grouped cars
        groupedCars.forEach((carClass, carsList) -> {
            System.out.println("Class: " + carClass);
            // Print each car in the group
            carsList.forEach(System.out::println);
        });

        // 3. Collect statistics for each group
        groupedCars.forEach((carClass, carsList) -> {
            System.out.println("\nStatistics for class: " + carClass);
            // Collect statistics for each group of cars
            Statistics stats = CarStatisticsCollector.collect(carsList);
            // Print the statistics
            System.out.println(stats);
        });

        // 4. Calculate the interquartile range (IQR) for all cars
        // Calculate the interquartile range for the list of cars
        double iqr = InterquartileRange.calculate(cars);
        // Print the interquartile range
        System.out.println("\nInterquartile Range (IQR): " + iqr);
    }
}
