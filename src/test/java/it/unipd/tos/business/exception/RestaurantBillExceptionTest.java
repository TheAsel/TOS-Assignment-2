package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RestaurantBillExceptionTest {

    @Test
    public void restaurantBillExceptionTest() {

        assertEquals("J",new RestaurantBillException("J").getMessage());

    }

}
