package com.example;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestFeline {

    @Test
    public void eatMeatFelineReturnFood() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyReturnFeline() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensReturnKittensCount() {
        Feline feline = new Feline();
        int expected = 10;
        int actual = feline.getKittens(10);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithoutParameterReturn1() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals(expected, actual);
    }

}
