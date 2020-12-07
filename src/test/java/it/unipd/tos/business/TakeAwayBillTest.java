package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalTime;
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
        TakeAwayBillImpl.lotteryCounter = 10;
    }


    @Test
    public void testPieno() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",5));
        lista.add(new MenuItem(ItemType.Bevande,"Cola",2));
        lista.add(new MenuItem(ItemType.Budini,"Pinguino",6));


        try {
            assertEquals(13,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }


    @Test
    public void testVuoto() {
        List<MenuItem> emptyList = new ArrayList<MenuItem>();
        try {
            assertEquals(0,test.getOrderPrice(emptyList, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
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
            assertEquals(23.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testSix");
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
            assertEquals(24.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testFivePlusOne");
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
            assertEquals(31.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testSixPlusOne");
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
            assertEquals(79.2,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPrimoSconto10");
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
            assertEquals(106.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testSecSconto10");
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
            assertEquals(92.25,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testTerSconto10");
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
            assertEquals(121.95,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testQuarSconto10");
            e.printStackTrace();
        }
	}


	@Test(expected = RestaurantBillException.class)
    public void testException() throws RestaurantBillException{
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Budini,"1",15));
        lista.add(new MenuItem(ItemType.Budini,"2",38));
        lista.add(new MenuItem(ItemType.Budini,"3",5));
        lista.add(new MenuItem(ItemType.Budini,"4",4));
        lista.add(new MenuItem(ItemType.Budini,"5",4.3));
        lista.add(new MenuItem(ItemType.Budini,"6",2));
        lista.add(new MenuItem(ItemType.Budini,"7",1));
        lista.add(new MenuItem(ItemType.Budini,"8",20.5));
        lista.add(new MenuItem(ItemType.Budini,"9",31));
        lista.add(new MenuItem(ItemType.Budini,"10",5));
        lista.add(new MenuItem(ItemType.Budini,"11",10));
        lista.add(new MenuItem(ItemType.Budini,"12",4.3));
        lista.add(new MenuItem(ItemType.Budini,"13",7));
        lista.add(new MenuItem(ItemType.Budini,"14",1));
        lista.add(new MenuItem(ItemType.Budini,"15",16));
        lista.add(new MenuItem(ItemType.Budini,"16",38));
        lista.add(new MenuItem(ItemType.Budini,"17",5));
        lista.add(new MenuItem(ItemType.Budini,"18",22));
        lista.add(new MenuItem(ItemType.Budini,"19",7.2));
        lista.add(new MenuItem(ItemType.Budini,"20",7));
        lista.add(new MenuItem(ItemType.Budini,"21",1));
        lista.add(new MenuItem(ItemType.Budini,"22",38));
        lista.add(new MenuItem(ItemType.Budini,"23",6));
        lista.add(new MenuItem(ItemType.Budini,"24",22));
        lista.add(new MenuItem(ItemType.Budini,"25",4.3));
        lista.add(new MenuItem(ItemType.Budini,"26",10));
        lista.add(new MenuItem(ItemType.Budini,"27",14));
        lista.add(new MenuItem(ItemType.Budini,"28",22));
        lista.add(new MenuItem(ItemType.Budini,"29",31));
        lista.add(new MenuItem(ItemType.Budini,"30",19));
        lista.add(new MenuItem(ItemType.Budini,"31",23));

        test.getOrderPrice(lista,new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0));
    }


    @Test
    public void testPrimaCommissione() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",2));
        lista.add(new MenuItem(ItemType.Bevande,"Cola",2));
        lista.add(new MenuItem(ItemType.Budini,"Biscotto",2));

        try {
            assertEquals(6.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPrimaCommissione");
            e.printStackTrace();
        }

    }


    @Test
    public void testSecCommissione() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Mini Cioccolato",3));
        lista.add(new MenuItem(ItemType.Bevande,"Mini Cola",3));
        lista.add(new MenuItem(ItemType.Budini,"Mini Biscotto",3));
        lista.add(new MenuItem(ItemType.Budini,"Mini Biancaneve",1));     
        try {
            assertEquals(10,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        }
        catch (RestaurantBillException e) {
            fail("Failed testSecCommissione");
            e.printStackTrace();
        }

    }


    @Test 
    public void testThirdCommissione() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Mini Cioccolato",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Nafta",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Vaniglia",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Fragola",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Stracciatella",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Banana",5));

        try {
            assertEquals(10,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        }
        catch (RestaurantBillException e) {
            fail("Failed testThirdCommissione");
            e.printStackTrace();
        }

    }


    @Test
    public void testQuarCommissione() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Mini Cioccolato",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Nafta",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Vaniglia",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Fragola",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Stracciatella",1));
        lista.add(new MenuItem(ItemType.Gelati,"Mini Banana",6));

        try {
            assertEquals(10.5,test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(20,0,0)),0);
        }
        catch (RestaurantBillException e) {
            fail("Failed testQuarCommissione");
            e.printStackTrace();
        }

    }


    @Test 
    public void testFirstRandomUnder() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",1));
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",1));
        lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",1));
        lista.add(new MenuItem(ItemType.Gelati,"Fragola",1));
        lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",1));
        lista.add(new MenuItem(ItemType.Budini,"Banana",5));
        double x = 0;
        for (int i = 0;i<100;++i) {          
            try {
                x+=test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now()),LocalTime.of(18,0,0));
            }
		    catch (RestaurantBillException e) {
			    fail("Failed testFirstRandomUnder");
                e.printStackTrace();
            }
        }   
        assertEquals(900,x,0);    
    }


   @Test 
   public void testSecondRandomUnder() {
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",1));
       lista.add(new MenuItem(ItemType.Gelati,"Nafta",1));
       lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",1));
       lista.add(new MenuItem(ItemType.Gelati,"Fragola",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",1));
       lista.add(new MenuItem(ItemType.Budini,"Banana",5));
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
               x+=test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now()),LocalTime.of(17,59,59));
            }
            catch (RestaurantBillException e) {
			    fail("Failed testSecondRandomUnder");
                e.printStackTrace();
            }
        }
        assertEquals(1000,x,0);    
    }


    @Test 
    public void testTerRandomUnder() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",1));
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",1));
        lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",1));
        lista.add(new MenuItem(ItemType.Gelati,"Fragola",1));
        lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",1));
        lista.add(new MenuItem(ItemType.Budini,"Banana",5));
        double x = 0;
        for (int i = 0;i<100;++i) {          
            try {
                x+=test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now()),LocalTime.of(19,0,1));
            }
            catch (RestaurantBillException e) {
			    fail("Failed testTerRandomUnder");
                e.printStackTrace();
            }
        }
        assertEquals(1000,x,0);    
    }


    @Test 
    public void testQuarRandomUnder() {
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",1));
       lista.add(new MenuItem(ItemType.Gelati,"Nafta",1));
       lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",1));
       lista.add(new MenuItem(ItemType.Gelati,"Fragola",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",1));
       lista.add(new MenuItem(ItemType.Budini,"Banana",5));
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
                x+=test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now()),LocalTime.of(19,0,0));
            }
            catch (RestaurantBillException e) {
			    fail("Failed testQuarRandomUnder");
                e.printStackTrace();
            }
       }   
       assertEquals(900,x,0);    
    }


    @Test
    public void testRandomOver() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",1));
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",1));
        lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",1));
        lista.add(new MenuItem(ItemType.Gelati,"Fragola",1));
        lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",1));
        lista.add(new MenuItem(ItemType.Budini,"Banana",5));
        double x = 0;
        for (int i = 0;i<100;++i) {          
            try {
                x+=test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.of(2000,1,1)),LocalTime.of(18,3,0));
            }
            catch (RestaurantBillException e) {
			    fail("Failed testRandomOver");
                e.printStackTrace();
            }
       }   
       assertEquals(1000,x,0);    
    }


    @Test
    public void testSixPlusRandom() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",1));
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",1));
        lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",1));
        lista.add(new MenuItem(ItemType.Gelati,"Fragola",1));
        lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",1));
        lista.add(new MenuItem(ItemType.Gelati,"Biscotto",3));
	 
        double x = 0;
        for (int i = 0;i<100;++i) {          
            try {
                x+=test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now()),LocalTime.of(18,3,0));
            }
			catch (RestaurantBillException e) {
			    fail("Failed testSixPlusRandom");
                e.printStackTrace();
            }
        }
        assertEquals(720,x,0);  
    }


    @Test
    public void testCommissionePlusRandom() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",2));
        lista.add(new MenuItem(ItemType.Bevande,"Cola",2));
        lista.add(new MenuItem(ItemType.Budini,"Biscotto",2));
   
        double x = 0;
        for (int i = 0;i<100;++i) {          
            try {
                x+=test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now()),LocalTime.of(18,3,0));
            }
            catch (RestaurantBillException e) {
			    fail("Failed testCommissionePlusRandom");
                e.printStackTrace();
            }
        }
        assertEquals(585,x,0);
    }


    @Test
    public void testSconto10PlusRandom() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Cioccolato",20));
        lista.add(new MenuItem(ItemType.Gelati,"Nafta",38));
        lista.add(new MenuItem(ItemType.Gelati,"Vaniglia",5));
        lista.add(new MenuItem(ItemType.Gelati,"Fragola",22));
        lista.add(new MenuItem(ItemType.Gelati,"Stracciatella",4));
        lista.add(new MenuItem(ItemType.Gelati,"Biscotto",7));
        lista.add(new MenuItem(ItemType.Budini,"Pinguino",1));
    
        double x = 0;
        for (int i = 0;i<100;++i) {          
            try {
                x+=test.getOrderPrice(lista, new User("primo","Gigi","Rossi",LocalDate.now()),LocalTime.of(18,3,0));
            }
            catch (RestaurantBillException e) {
			    fail("Failed testSconto10PlusRandom");
                e.printStackTrace();
            }
        }
        assertEquals(7695,x,0);    
    }
}
