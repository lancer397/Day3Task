package edu.epam.car.service;

import edu.epam.car.model.Car;
import edu.epam.car.model.CarsShop;
import edu.epam.car.model.Brand;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CarServiceTest {

    CarService carService;
    Car honda;

    @BeforeTest
    public void setUp() {
        this.carService = new CarService();
        this.honda = new Car(Brand.HONDA, 5000.0, 4, 2010, "Civic");
    }

    @Test
    public void testFindCarByBrand() {
        CarsShop carsShop = new CarsShop("cars", 2, "3334433", "somAddress");
        carsShop.addCar(honda);

        List<Car> expResult = new ArrayList<>();
        expResult.add(honda);

        List<Car> result = carService.findCarByBrand(carsShop, Brand.valueOf("HONDA"));

        assertEquals(result, expResult);
    }

    @Test
    public void testFindCarByModelAndExploitation() {
        CarsShop carsShop = new CarsShop("cars", 2, "3334433", "somAddress");
        carsShop.addCar(honda);

        List<Car> expResult = new ArrayList<>();
        expResult.add(honda);

        List<Car> result = carService.findCarByModelAndExploitation(carsShop, "Civic", 1);

        assertEquals(result, expResult);
    }

    @Test
    public void testFindCarByYearAndPrice() {
        CarsShop carsShop = new CarsShop("cars", 2, "3334433", "somAddress");
        carsShop.addCar(honda);

        List<Car> result = carService.findCarByYearAndPrice(carsShop, 2010, 1000.0);

        List<Car> expResult = new ArrayList<>();
        expResult.add(honda);

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.carService = null;
        this.honda = null;
    }

}