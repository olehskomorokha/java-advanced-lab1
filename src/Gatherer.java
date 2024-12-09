import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Gatherer class is responsible for processing a stream of cars.
 * It skips the first `skip` number of elements and collects the next 500 elements into a list.
 */
public class Gatherer {

    /**
     * Processes the stream of cars, skipping the first `skip` elements and limiting the result to 500 elements.
     *
     * @param stream the stream of cars to process
     * @param skip the number of cars to skip at the beginning of the stream
     * @return a list of 500 cars after skipping the specified number of cars
     */
    public static List<Car> gather(Stream<Car> stream, int skip) {
        return stream
                .skip(skip) // Skip the first 'skip' cars in the stream
                .limit(500) // Limit the result to the next 500 cars
                .collect(Collectors.toList()); // Collect the resulting cars into a list
    }
}