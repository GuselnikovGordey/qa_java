package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {

    @Mock
    Feline feline;

    @Test
    public void shouldThrowExpectedException(){
        String invalidSex= "блаблабла";
        Exception actualException = null;
        try {
            new Lion(invalidSex, feline);
        } catch (Exception e){
            actualException = e;
        }
        Assert.assertNotNull(actualException);
    }

    @Test
    public void getKittensTest() throws Exception {

        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

}
