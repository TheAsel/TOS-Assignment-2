package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillTest {

    private TakeAwayBillImpl test;

    @Before
    public void BeforeClass() {
        test = new TakeAwayBillImpl();
    }


    @Test
    public void testPieno() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",5));
        lista.add(new MenuItem(ItemType.Bevande,"Cola",2));
        lista.add(new MenuItem(ItemType.Budini,"Pinguino",6));


        try {
            assertEquals(13,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }


    @Test
    public void testVuoto() {
        List<MenuItem> emptyList = new ArrayList<MenuItem>();
        try {
            assertEquals(0,test.getOrderPrice(emptyList, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testVuoto");
            e.printStackTrace();
        }
    }


	@Test
    public void testSix() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",5));
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",2));
        lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",3));
        lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",6));
        lista.add(new MenuItem(ItemType.Gelati,"Fragola",4));
        lista.add(new MenuItem(ItemType.Gelati,"Biscotto",4.5));

        try {
            assertEquals(23.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }


    @Test
    public void testFivePlusOne() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",5));
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",2));
        lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",3));
        lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",6));
        lista.add(new MenuItem(ItemType.Gelati,"Fragola",4));
        lista.add(new MenuItem(ItemType.Budini,"Biscotto",4.5));

        try {
            assertEquals(24.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }


    @Test
    public void testSixPlusOne() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",5));
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",2));
        lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",3));
        lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",6));
        lista.add(new MenuItem(ItemType.Gelati,"Fragola",4));
        lista.add(new MenuItem(ItemType.Gelati,"Biscotto",4.5));
        lista.add(new MenuItem(ItemType.Budini,"Nutella",8));

        try {
            assertEquals(31.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }


    @Test
    public void testPrimoSconto10() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Big Nafta",11));
        lista.add(new MenuItem(ItemType.Gelati,"Big Cioccolato",13));
        lista.add(new MenuItem(ItemType.Gelati,"Big Vaniglia",16));
        lista.add(new MenuItem(ItemType.Gelati,"Big Stracciatella",14));
        lista.add(new MenuItem(ItemType.Gelati,"Big Fragola",12));
        lista.add(new MenuItem(ItemType.Gelati,"Big Biscotto",12.5));
        lista.add(new MenuItem(ItemType.Budini,"Big Nutella",15));

        try {
            assertEquals(79.2,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }


	@Test
    public void testSecSconto10() {

        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Bevande,"Big Cola",15));
        lista.add(new MenuItem(ItemType.Bevande,"Big Fanta",20));
        lista.add(new MenuItem(ItemType.Bevande,"Big Sprite",17));
        lista.add(new MenuItem(ItemType.Bevande,"Big Acqua",5));
        lista.add(new MenuItem(ItemType.Bevande,"Big The",9));
        lista.add(new MenuItem(ItemType.Bevande,"Big Birra",18));
        lista.add(new MenuItem(ItemType.Bevande,"Big Vino",22.5));

        try {
            assertEquals(106.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }


    @Test
    public void testTerSconto10() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Bevande,"Big Cola",15));
        lista.add(new MenuItem(ItemType.Bevande,"Big Fanta",20));
        lista.add(new MenuItem(ItemType.Gelati,"Big Cioccolato",13));
        lista.add(new MenuItem(ItemType.Bevande,"Big Sprite",17));
        lista.add(new MenuItem(ItemType.Gelati,"Big Stracciatella",14));
        lista.add(new MenuItem(ItemType.Gelati,"Big Nafta",11));
        lista.add(new MenuItem(ItemType.Budini,"Big Biscotto",12.5));

        try {
            assertEquals(92.25,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }


    @Test
    public void testQuarSconto10() {

        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Budini,"Big Nutella",21));
        lista.add(new MenuItem(ItemType.Budini,"Big Pinguino",19));
        lista.add(new MenuItem(ItemType.Budini,"Big Biancaneve",18));
        lista.add(new MenuItem(ItemType.Budini,"Big Variegato",20));
        lista.add(new MenuItem(ItemType.Budini,"Big Caramello",18.5));
        lista.add(new MenuItem(ItemType.Budini,"Big Panna Cotta",17));
        lista.add(new MenuItem(ItemType.Budini,"Big Topolino",22));

        try {
            assertEquals(121.95,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
	}
}
