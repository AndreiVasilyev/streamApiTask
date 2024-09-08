package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.source.Main;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {


    @Test
    void checkIfReturnListEqualsExpectedListInTask1() {
        List<Animal> expectedList = List.of(new Animal(614, "Snake, buttermilk", 10, "Belarusian", "Bigender"),
                new Animal(649, "European stork", 10, "Danish", "Female"),
                new Animal(712, "Flamingo, chilean", 10, "Somali", "Male"),
                new Animal(713, "Red-breasted cockatoo", 10, "Papiamento", "Female"),
                new Animal(744, "Blue-tongued lizard", 10, "Swati", "Male"),
                new Animal(775, "Wolf spider", 10, "Romanian", "Female"),
                new Animal(857, "Jackal, silver-backed", 10, "Kazakh", "Female"));
        List<Animal> actualList = Main.task1();
        assertEquals(expectedList, actualList);
    }

    @Test
    void checkIfReturnListEqualsExpectedListInTask2() {
        List<String> expectedList = List.of("HURON", "Lorikeet, scaly-breasted", "BOA, MALAGASY GROUND", "BRAZILIAN TAPIR",
                "JAEGER, LONG-TAILED", "Mourning collared dove", "BLUE AND YELLOW MACAW", "GULL, LAVA", "GOLIATH HERON",
                "TORTOISE, INDIAN STAR", "SOUTH AMERICAN PUMA", "LONG-FINNED PILOT WHALE", "Penguin, galapagos",
                "Woodpecker, red-headed", "Mexican beaded lizard", "Common dolphin", "GULL, LAVA");
        List<String> actualList = Main.task2();
        assertEquals(expectedList, actualList);
    }

    @Test
    void checkIfReturnListEqualsExpectedListInTask3() {
        List<String> expectedList = List.of("Azeri", "Aymara", "Afrikaans", "Arabic", "Armenian",
                "Amharic", "Assamese", "Albanian");
        List<String> actualList = Main.task3();
        assertEquals(expectedList, actualList);
    }

    @Test
    void checkIfReturnValueEqualsExpectedValueInTask4() {
        long expectedValue = 476;
        long actualValue = Main.task4();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void returnTrueIfExistAnimalFromHungarianInTask5() {
        assertTrue(Main.task5());
    }

    @Test
    void returnFalseIfNotOnlyMaleAndFemaleAnimalsInTask6() {
        assertFalse(Main.task6());
    }

    @Test
    void returnFalseExistAnimalsFromOceaniaInTask7() {
        assertFalse(Main.task7());
    }

    @Test
    void checkIfReturnValueEqualsExpectedValueInTask8() {
        long expectedValue = 48;
        long actualValue = Main.task8();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void checkIfReturnValueEqualsExpectedValueInTask9() {
        long expectedValue = 3;
        long actualValue = Main.task9();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void checkIfReturnValueEqualsExpectedValueInTask10() {
        long expectedValue = 25329;
        long actualValue = Main.task10();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void checkIfReturnValueEqualsExpectedValueInTask11() {
        double expectedValue = 25.8;
        double actualValue = Main.task11();
        assertEquals(expectedValue, actualValue);
    }

}
