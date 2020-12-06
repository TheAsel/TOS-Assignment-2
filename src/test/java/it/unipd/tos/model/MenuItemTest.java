package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {


 private MenuItem test;

    @Before
    public void BeforeClass() {
        test = new MenuItem(ItemType.Gelati,"Nafta",5);
    }

    @Test
    public void testItemType() {
        assertEquals(ItemType.Gelati,test.getItemType());
    }

    @Test

    public void testName() {
        assertEquals("Nafta",test.getName());
    }

    @Test

    public void testPrice() {
        assertEquals(5,test.getPrice(),0);
    }

}
