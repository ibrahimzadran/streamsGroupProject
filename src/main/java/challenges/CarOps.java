package challenges;

import domain.Car;
import org.checkerframework.checker.units.qual.C;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarOps {

    //Question 21: Filter by Make: Filter the list of cars to only include cars with a specific make.
    public static List<Car> carWithSpecificMake(List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("BMW"))
                .limit(5)
                .collect(Collectors.toList());
    }

    //Question 22: Filter by Year: Filter the list of cars to only include cars from a specific year.
    public static List<Car> carsFromSpecificYear(List<Car> cars) {
        return cars
                .stream()
                .filter(car -> car.getYear().equals(2008))
                .limit(5)
                .collect(Collectors.toList());
    }

    //Question 23: Filter by Price: Filter the list of cars to only include cars within a price range.
    public static List<Car> carsWithinPriceRange(List<Car> cars) {
        return cars
                .stream()
                .filter(car -> car.getPrice() >= 20000 && car.getPrice() <= 50000)
                .limit(5)
                .collect(Collectors.toList());
    }

    //Question 24:Map to Model Names: Create a list of car model names from the list of cars.
    public static List<String> listOfCarModels(List<Car> cars) {
        return cars
                .stream()
                .map(Car::getModel)
                .limit(5)
                .collect(Collectors.toList());
    }

    //Question 25: Map to Upper Case Makes: Create a list of car makes in uppercase from the list of cars.
    public static List<String> listOfCarsInUppercase(List<Car> cars) {
        return cars
                .stream()
                .map(car -> car.getMake().toUpperCase())
                .limit(5)
                .collect(Collectors.toList());
    }

    //Question 26: Sort by Year: Sort the list of cars based on the year in ascending order.
    public static List<Integer> sortByYearAscending(List<Car> cars) {
        return cars
                .stream()
                .map(Car::getYear)
                .sorted()
                .limit(5)
                .toList();
    }

    //Question 27: Sort by Price (descending): Sort the list of cars based on the price in descending order.
    public static List<Double> sortPriceInDescendingOrder(List<Car> cars) {
        return cars
                .stream()
                .map(Car::getPrice)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
    }

    // Question 28: Get the Highest Priced Car: Find the car with the highest price.
    public static Car carWithTheHighestPrice(List<Car> cars) {
        return cars
                .stream()
                .max(Comparator.comparing(Car::getPrice))
                .orElse(null);
    }

    // Question 29: Get the Lowest Priced Car: Find the car with the lowest price.
    public static Car carWithLowestPrice(List<Car> cars) {
        return cars
                .stream()
                .min(Comparator.comparingDouble(Car::getPrice))
                .orElse(null);
    }

    // Question 30: Group by Make: Group the cars by their make.
    public static Map<String, List<Car>> groupByMake(List<Car> cars) {
        return cars
                .stream()
                .limit(5)
                .collect(Collectors.groupingBy(Car::getMake));
    }

    // Question 31: Count Cars by Make: Count the number of cars for each make.
    public static Map<String, Long> countCarsByMake(List<Car> cars) {
        return cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake, Collectors.counting()));
    }

    // Question 32: Average Price: Calculate the average price of all cars.
    public static double averagePriceOfAllCars(List<Car> cars) {
        return cars
                .stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);
    }

    // Question 33: Sum of Prices: Calculate the sum of all car prices.
    public static double sumOfCarsPrices(List<Car> cars) {
        return cars
                .stream()
                .mapToDouble(Car::getPrice)
                .sum();
    }

    // Question 34: Any Car with Blue Color: Check if there's any car with a blue color.
    public static boolean checkIfAnyCarIsBlue(List<Car> cars) {
        return cars
                .stream()
                .anyMatch(car -> car.getColor().equalsIgnoreCase("Blue"));
    }

    // Question 35: All Cars are Expensive: Check if all cars are expensive (e.g., price > 50000).
    public static boolean checkIfAnyCarIsExpensive(List<Car> cars) {
        return cars
                .stream()
                .anyMatch(car -> car.getPrice() >= 50000);
    }

    // Question 36: None Match the Condition: Check if none of the cars match a specific condition.
    public static boolean nonOfCarMatchThisCondition(List<Car> cars) {
        return cars
                .stream()
                .noneMatch(car -> car.getModel().equalsIgnoreCase("tesla"));
    }

    // Question 37: Skip First N Cars: Skip the first N cars from the list.
    public static List<Car> skipNCars(List<Car> cars, int n) {
        return cars
                .stream()
                .skip(n)
                .limit(10)
                .collect(Collectors.toList());
    }

    // Question 38:Limit to N Cars: Limit the list to the first N cars.
    static public List<Car> limitToNCars(List<Car> cars, int n) {
        return cars
                .stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    // Question 39: Distinct Colors: Get a list of distinct car colors
    public static List<String> distinctCarColors(List<Car> cars) {
        return cars
                .stream()
                .map(Car::getColor)
                .distinct()
                .toList();
    }

    // Question 40: Concatenate Make and Model: Concatenate the make and model of each car.
    public static void concatenateMakeAndModel(List<Car> cars) {
        cars
                .stream()
                .map(car -> car.getMake() + " - " + car.getModel())
                .limit(5)
                .forEach(System.out::println);
    }

    // Question 41: Find First Car: Find the first car in the list
    public static Car findFirstCar(List<Car> cars) {
        return cars
                .stream()
                .findFirst()
                .orElse(null);
    }

    // Question 42: Find Any Car: Find any car in the list.
    public static Car findAnyCAr(List<Car> cars) {
        return cars
                .stream()
                .findAny()
                .orElse(null);
    }

    // *Question 43: Remove Duplicates: Remove duplicate cars from the list based on make and model.
    public static List<Car> removeDuplicateCars(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.toMap(
                        car -> car.getMake() + ":" + car.getModel(),
                        Function.identity(),
                        (existing, replacement) -> existing
                ))
                .values()
                .stream()
                .limit(2)
                .sorted(Comparator.comparing(Car::getMake).thenComparing(Car::getModel))
                .collect(Collectors.toList());
    }

    // Question 44:Partition Cars by Price: Partition the cars into two groups based on whether their price is above a certain value.

    public static Map<Boolean,List<Car>> partitionByPrice(List<Car>cars,double thresholdPrice){
        return cars
                .stream()
                .limit(10)
                .collect(Collectors.partitioningBy(car -> car.getPrice() > thresholdPrice));
    }

    // Question 45: Calculate Total Price by Make: Calculate the total price of cars for each make.

    public static Map<String,Long> totalPriceByMake (List<Car>cars){
        return cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake,Collectors.counting()));
    }

    // Question 46: Join Car Names into a String: Join the names of all cars into a single comma-separated string.
    public static String joiningCarNames(List<Car>cars){
        return cars
                .stream()
                .map(Car::getMake)
                .limit(10)
                .collect(Collectors.joining(", "));
    }

    // Question 47: Peek and Print: Use peek to print the details of each car in the stream.
    public static void peekAndPrint (List<Car>cars){
        cars
                .stream()
                .peek(car -> System.out.println("Id: " + car.getId() + ", Make: " + car.getMake() + ", Model: "
                        + car.getModel() + ", Year " + car.getYear() + ", Price: " + car.getPrice() + ", Color: " + car.getColor()))
                .limit(5)
                .forEach(car -> {});
    }

    // Question 48: Average Price by Make: Calculate the average price of cars for each make.
    public static Map<String, Double> averagePriceByMake(List<Car>cars){
        return cars
                .stream()
                .limit(5)
                .collect(Collectors.groupingBy(Car::getMake,Collectors.averagingDouble(Car::getPrice)));
    }

    // Question 49: Concatenate All Car Details: Concatenate all car details into a single string.
    public static String joiningAllCarDetails(List<Car>cars){
        return cars
                .stream()
                .map(car -> car.getId() +" "+ car.getMake()+" " + car.getModel() +" "+ car.getYear()
                        +" "+ car.getPrice() +" "+ car.getColor()+", ")
                .limit(5)
                .collect(Collectors.joining());
    }

    // Question 50: Find the Newest Car: Find the newest (latest year) car in the list.
    public static Car findNewestCar(List<Car>cars){
        return cars
                .stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }
}



