////////////////////////////////////////////////////////////////////
// [ANTONIO] [OSELE] [1186951]
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImpl implements TakeAwayBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
        throws RestaurantBillException {
            int sum = 0;
            for (MenuItem menuItem : itemsOrdered) {
                sum += menuItem.getPrice();
        }

        return sum;
    }

}
