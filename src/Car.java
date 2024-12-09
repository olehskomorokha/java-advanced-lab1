import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

/**
 * Car class represents a car with various properties such as brand, model,
 * manufacture date, car class, and price.
 */
public class Car {
    private String brand;             // Brand of the car
    private String model;             // Model of the car
    private LocalDate manufactureDate; // Manufacture date of the car
    private String carClass;          // Class of the car (e.g., sedan, SUV, etc.)
    private BigDecimal price;         // Price of the car

    /**
     * Constructor to initialize a Car object with the given parameters.
     *
     * @param brand           the brand of the car
     * @param model          the model of the car
     * @param manufactureDate the manufacture date of the car
     * @param carClass       the class of the car
     * @param price          the price of the car
     */
    public Car(String brand, String model, LocalDate manufactureDate, String carClass, BigDecimal price) {
        this.brand = brand;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.carClass = carClass;
        this.price = price;
    }

    /**
     * Gets the brand of the car.
     *
     * @return the brand of the car
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the model of the car.
     *
     * @return the model of the car
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the manufacture date of the car.
     *
     * @return the manufacture date of the car
     */
    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    /**
     * Gets the class of the car.
     *
     * @return the class of the car
     */
    public String getCarClass() {
        return carClass;
    }

    /**
     * Gets the price of the car.
     *
     * @return the price of the car
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Overrides the toString method to return a string representation of the Car object.
     *
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        return String.format("Car{brand='%s', model='%s', date=%s, class='%s', price=%s}",
                brand, model, manufactureDate, carClass, price);
    }
}