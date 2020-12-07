////////////////////////////////////////////////////////////////////
// [ANTONIO] [OSELE] [1186951]
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;
import java.time.LocalTime;
import java.util.List;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
public interface TakeAwayBill {
    double getOrderPrice(List<MenuItem> itemsOrdered, User user, 
    LocalTime time) 
        throws RestaurantBillException;
}
