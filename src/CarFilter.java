import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;

/**
 * CarFilter class is responsible for filtering and grouping cars
 * based on the number of months since their manufacture date.
 */
public class CarFilter {

    /**
     * Filters cars based on the given range of months since their manufacture date,
     * and groups them by car class.
     *
     * @param cars       the list of cars to be filtered and grouped
     * @param minMonths the minimum number of months since the car's manufacture date
     * @param maxMonths the maximum number of months since the car's manufacture date
     * @return a map grouping cars by their car class, filtered by the month range
     */
    public static Map<String, List<Car>> filterAndGroup(List<Car> cars, int minMonths, int maxMonths) {
        return cars.stream()
                // Filter cars based on the months between the manufacture date and the current date
                .filter(car -> {
                    long months = ChronoUnit.MONTHS.between(car.getManufactureDate(), LocalDate.now());
                    return months >= minMonths && months <= maxMonths;
                })
                // Group the filtered cars by their car class
                .collect(Collectors.groupingBy(Car::getCarClass));
    }
}