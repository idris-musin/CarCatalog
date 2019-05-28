package ru.itpark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Catalog {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "X3", 2012, 1_500_000));
        cars.add(new Car("Chevrolet", "Captiva", 2014, 1_000_000));
        cars.add(new Car("Volkswagen", "Touareg", 2017, 3_000_000));
        cars.add(new Car("Mazda", "CX-7", 2007, 700_000));
        cars.add(new Car("Volkswagen", "Polo", 2010, 400_000));
        cars.add(new Car("Hyundai", "IX35", 2015, 1_300_000));

        Collections.sort(cars, new YearAscComparator());
        System.out.println(cars);

        Collections.sort(cars, new PriceAscComparator());
        System.out.println(cars);

        Collections.sort(cars, new PriceDescComparator());
        System.out.println(cars);

    }
}

class Car implements Comparable<Car> {
    private String brend;
    private String model;
    private int yearOfIssue;
    private int price;

    public Car(String brend, String model, int yearOfIssue, int price) {
        this.brend = brend;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.price = price;
    }

    public String getBrend() {
        return brend;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brend='" + brend + '\'' +
                ", model='" + model + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return 0;
    }
}

class YearAscComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getYearOfIssue() - o2.getYearOfIssue();
    }
}

class PriceAscComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPrice() - o2.getPrice();
    }
}

class PriceDescComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return -(o1.getPrice() - o2.getPrice());
    }
}
