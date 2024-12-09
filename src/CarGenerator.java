import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * CarGenerator class is responsible for generating an infinite stream of Car objects
 * with random but realistic values for brand, model, manufacture date, car class, and price.
 */
public class CarGenerator {
    private static final Random RANDOM = new Random();

    // Arrays containing possible values for car attributes
    private static final String[] BRANDS = {"Toyota", "Ford", "BMW", "Audi", "Mercedes"};
    private static final String[] MODELS = {"A1", "X3", "Corolla", "Focus", "Civic"};
    private static final String[] CLASSES = {"Economy", "Compact", "Midsize", "Luxury", "SUV"};

    /**
     * Generates an infinite stream of Car objects with random attributes.
     *
     * @return a stream of Car objects with random values
     */
    public static Stream<Car> generate() {
        return Stream.generate(() -> {
            // Randomly select a brand, model, car class, and generate a random manufacture date and price
            String brand = BRANDS[RANDOM.nextInt(BRANDS.length)];
            String model = MODELS[RANDOM.nextInt(MODELS.length)];
            LocalDate manufactureDate = LocalDate.now().minusMonths(RANDOM.nextInt(120)); // Random manufacture date within the last 10 years
            String carClass = CLASSES[RANDOM.nextInt(CLASSES.length)];
            BigDecimal price = BigDecimal.valueOf(200_000 + RANDOM.nextInt(800_000)); // Price between 200,000 and 1,000,000

            // Return a new Car object with the generated values
            return new Car(brand, model, manufactureDate, carClass, price);
        });
    }
}