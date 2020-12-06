////////////////////////////////////////////////////////////////////
// [ANTONIO] [OSELE] [1186951]
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImpl implements TakeAwayBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
        throws RestaurantBillException {
            checkException(itemsOrdered);
            double sum = 0;
            double min = Double.MAX_VALUE;
            int i = 0;
            for (MenuItem menuItem : itemsOrdered) {      
                if (menuItem.getItemType() == ItemType.Gelati) {
                    double x = menuItem.getPrice();
                    if (min>x) {
                        min =x;
                }
                ++i;  
            }
        }
        boolean sconto = i>5;
        for (MenuItem menuItem : itemsOrdered) {
                sum += menuItem.getPrice();
        }
        if (sconto) {
            sum =sum-(min/2);
        }
        return calcoloTotale(itemsOrdered,sum);
    }

    private double calcoloTotale(List<MenuItem> itemsOrdered,double sum) {
        double prov = sum;
        for (MenuItem menuItem : itemsOrdered) {

            if (menuItem.getItemType() == ItemType.Bevande) {

                prov -= menuItem.getPrice();

            }

        }

        if (prov >50) {
            return sum- (sum*0.1);
        }
        else if (sum !=0 && sum<10) {
            sum+=0.5;
        }
        return sum;
    }

    private void checkException(List<MenuItem> itemsOrdered) 
        throws RestaurantBillException {
        if (itemsOrdered.size()>30) {
            throw new RestaurantBillException(""
                + "Errore: numero massimo di elementi ordinabili = 30");
        }
    }
}
