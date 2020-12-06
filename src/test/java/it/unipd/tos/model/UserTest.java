package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

 private User test;

    @Before
    public void BeforeClass() {
        test = new User("secondo","Mario","Bianchi",LocalDate.of(2020,1,1));
    }

    @Test
    public void testID() {
        assertEquals("secondo",test.getId());
    }

    @Test

    public void testName() {
        assertEquals("Mario",test.getNome());
    }

    @Test

    public void testCognome() {
        assertEquals("Bianchi",test.getCognome());
    }

    @Test

    public void testNascita() {
        assertEquals(LocalDate.of(2020,1,1),test.getNascita());
    }

}
