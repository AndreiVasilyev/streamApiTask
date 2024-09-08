package by.clevertec.source;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static List<Animal> task1() {
        List<Animal> animals = Util.getAnimals();
        return animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(14)
                .limit(7)
                .peek(System.out::println)
                .toList();

    }

    public static List<String> task2() {
        List<Animal> animals = Util.getAnimals();
        return animals.stream()
                .filter(animal -> "Japanese".equalsIgnoreCase(animal.getOrigin()))
                .map(animal -> "Female".equalsIgnoreCase(animal.getGender()) ? animal.getBread().toUpperCase() : animal.getBread())
                .peek(System.out::println)
                .toList();
    }

    public static List<String> task3() {
        List<Animal> animals = Util.getAnimals();
        return animals.stream()
                .filter(animal -> animal.getAge() > 30 && animal.getOrigin().startsWith("A"))
                .map(Animal::getOrigin)
                .distinct()
                .peek(System.out::println)
                .toList();
    }

    public static long task4() {
        List<Animal> animals = Util.getAnimals();
        long count = animals.stream()
                .filter(animal -> "Female".equalsIgnoreCase(animal.getGender()))
                .count();
        System.out.println("\n Total female animals: " + count + "\n");
        return count;
    }

    public static boolean task5() {
        List<Animal> animals = Util.getAnimals();
        boolean isExist = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equalsIgnoreCase("Hungarian"));
        System.out.println("\n Is exist any animal from Hungarian with age from 20 to 30: " + isExist + "\n");
        return isExist;
    }

    public static boolean task6() {
        List<Animal> animals = Util.getAnimals();
        boolean isOnlyMaleAndFemale = animals.stream()
                .noneMatch(animal -> !"Male".equalsIgnoreCase(animal.getGender()) && !"Female".equalsIgnoreCase(animal.getGender()));
        System.out.println("\n Is only male or female gender: " + isOnlyMaleAndFemale + "\n");
        return isOnlyMaleAndFemale;
    }

    public static boolean task7() {
        List<Animal> animals = Util.getAnimals();
        boolean isExistFromOceania = animals.stream()
                .anyMatch(animal -> animal.getOrigin().equalsIgnoreCase("Oceania"));
        System.out.println("\n Is exist any animal from Oceania: " + isExistFromOceania + "\n");
        return isExistFromOceania;
    }

    public static int task8() {
        List<Animal> animals = Util.getAnimals();
        Integer maxAge = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .map(Animal::getAge)
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println("\n The max age of animal from sorted 100: " + maxAge + "\n");
        return maxAge;
    }

    public static int task9() {
        List<Animal> animals = Util.getAnimals();
        int shortestBreadLength = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(array -> array.length)
                .min()
                .orElseThrow();
        System.out.println("\n Shortest bread length: " + shortestBreadLength + "\n");
        return shortestBreadLength
                ;
    }

    public static int task10() {
        List<Animal> animals = Util.getAnimals();
        int totalAge = animals.stream().
                mapToInt(Animal::getAge)
                .sum();
        System.out.println("\n Total age of all animals: " + totalAge + "\n");
        return totalAge;
    }

    public static double task11() {
        List<Animal> animals = Util.getAnimals();
        double averageAgeIndonesianAnimals = animals.stream()
                .filter(animal -> "Indonesian".equalsIgnoreCase(animal.getOrigin()))
                .mapToInt(Animal::getAge)
                .average()
                .orElseThrow();
        System.out.println("\n Average age of Indonesian animals is: " + averageAgeIndonesianAnimals + "\n");
        return averageAgeIndonesianAnimals;
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(person -> "Male".equalsIgnoreCase(person.getGender())
                        && (getAge(person) >= 18 && getAge(person) < 27))
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    private static int getAge(Person person) {
        int birthYear = person.getDateOfBirth().getYear();
        int thisYear = LocalDate.now().getYear();
        return thisYear - birthYear;
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
        houses.stream()
                .collect(Collectors.partitioningBy(house -> !"Hospital".equalsIgnoreCase(house.getBuildingType())))
                .values()
                .stream()
                .map(housesList -> housesList.stream().map(House::getPersonList).collect(Collectors.toCollection(ArrayList::new)))
                .map(g -> g.stream().flatMap(Collection::stream).collect(Collectors.toCollection(ArrayList::new)))
                .flatMap(people -> people.stream().sorted(getPersonComparator()))
                .limit(500)
                .forEach(System.out::println);
    }

    private static Comparator<Person> getPersonComparator() {
        return new Comparator<>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (getAge(o1) == getAge(o2)) return 0;
                if ((getAge(o1) <= 18 || getAge(o1) > 65) && (getAge(o2) <= 18 || getAge(o2) > 65)) return 0;
                if ((getAge(o1) > 18 && getAge(o1) <= 65) && (getAge(o2) > 18 && getAge(o2) <= 65)) return 0;
                if ((getAge(o1) <= 18 || getAge(o1) > 65) && (getAge(o2) > 18 && getAge(o2) <= 65)) return -1;
                return 1;
            }
        };
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
        Map<Boolean, List<Car>> partitionedCars = cars.stream()
                .collect(Collectors.partitioningBy(car -> "Jaguar".equalsIgnoreCase(car.getCarMake()) || "White".equalsIgnoreCase(car.getColor())));
        List<Car> firstGroup = partitionedCars.get(true);
        partitionedCars = partitionedCars.get(false).stream()
                .collect(Collectors.partitioningBy(car -> car.getMass() < 1500
                        || "BMW".equalsIgnoreCase(car.getCarMake())
                        || "Lexus".equalsIgnoreCase(car.getCarMake())
                        || "Chrysler".equalsIgnoreCase(car.getCarMake())
                        || "Toyota".equalsIgnoreCase(car.getCarMake())));
        List<Car> secondGroup = partitionedCars.get(true);
        partitionedCars = partitionedCars.get(false).stream()
                .collect(Collectors.partitioningBy(car -> (car.getColor().equalsIgnoreCase("Black") && car.getMass() > 4000)
                        || "GMC".equalsIgnoreCase(car.getCarMake())
                        || "Dodge".equalsIgnoreCase(car.getCarMake())));
        List<Car> thirdGroup = partitionedCars.get(true);
        partitionedCars = partitionedCars.get(false).stream()
                .collect(Collectors.partitioningBy(car -> car.getReleaseYear() < 1982
                        || "Civic".equalsIgnoreCase(car.getCarModel())
                        || "Cherokee".equalsIgnoreCase(car.getCarModel())));
        List<Car> forthGroup = partitionedCars.get(true);
        partitionedCars = partitionedCars.get(false).stream()
                .collect(Collectors.partitioningBy(car -> (!"Yellow".equalsIgnoreCase(car.getColor())
                        && !"Red".equalsIgnoreCase(car.getColor())
                        && !"Green".equalsIgnoreCase(car.getColor())
                        && !"Blue ".equalsIgnoreCase(car.getColor()))
                        || car.getPrice() > 40000));
        List<Car> fifthGroup = partitionedCars.get(true);
        partitionedCars = partitionedCars.get(false).stream()
                .collect(Collectors.partitioningBy(car -> car.getVin().contains("59")));
        List<Car> sixthGroup = partitionedCars.get(true);
        double totalCost = Stream.of(firstGroup, secondGroup, thirdGroup, forthGroup, fifthGroup, sixthGroup)
                .map(carsList -> carsList.stream().mapToInt(Car::getMass).sum())
                .mapToDouble(mass -> (double) mass / 1000 * 7.14)
                .peek(cost -> System.out.printf("%n%.2f%n", cost))
                .sum();
        System.out.printf("%nTotal cost: %.2f%n", totalCost);

    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
        double totalCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin)
                        .reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay)
                        .reversed())
                .filter(flower -> flower.getCommonName().compareToIgnoreCase("C") <= 0
                        || flower.getCommonName().compareToIgnoreCase("S") >= 0)
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().contains("Glass")
                        || flower.getFlowerVaseMaterial().contains("Aluminum")
                        || flower.getFlowerVaseMaterial().contains("Steel"))
                .mapToDouble(flower -> flower.getPrice() + (flower.getWaterConsumptionPerDay() * 365 * 5 * 1.39))
                .sum();
        System.out.printf("%nTotal service cost: %.2f%n%n", totalCost);
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        students.stream()
                .filter(student -> student.getAge() <= 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student -> System.out.println(student.getSurname() + " " + student.getAge()));
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);

    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingInt(Student::getAge)))
                .entrySet()
                .stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        String group = "P-1";
        students.stream()
                .filter(student -> student.getGroup().equalsIgnoreCase(group))
                .filter(student -> examinations.stream()
                        .anyMatch(examination -> examination.getStudentId() == student.getId() && examination.getExam3() > 4))
                .forEach(System.out::println);
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        students.stream()
                .filter(st -> examinations.stream().anyMatch(ex -> ex.getId() == st.getId()))
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingInt(student -> examinations.stream()
                        .filter(p -> student.getId() == p.getId())
                        .findFirst()
                        .orElseThrow()
                        .getExam1())))
                .entrySet().stream().forEach(System.out::println);
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()))
                .entrySet().stream()
                .forEach(System.out::println);
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.minBy(Comparator.comparing(Student::getAge))))
                .entrySet().stream()
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().get().getAge()))
                .entrySet().stream()
                .forEach(System.out::println);
    }
}
