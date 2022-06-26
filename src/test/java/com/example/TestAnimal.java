package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class TestAnimal {

    private final String animalType;
    private final List<String> expected;

    public TestAnimal(String animalType, List<String> expected) {
        this.animalType = animalType;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodTest() throws Exception{
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalType);
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodException() {

        Animal animal = new Animal();
        Exception actualException = null;
        try {
            assertEquals(animal.getFood("blablabla"), List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        } catch (Exception e) {
            actualException = e;
        }
        assertNotNull(actualException);
    }

    @Test
    public void getFamilyReturnFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }

}
