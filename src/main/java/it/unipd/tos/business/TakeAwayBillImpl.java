////////////////////////////////////////////////////////////////////
// Nicholas Miazzo 1161392
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public class TakeAwayBillImpl implements TakeAwayBill {
    public double getOrderPrice(List<MenuItem> itemsOrdered)
            throws TakeAwayBillException {

        if(itemsOrdered == null) {
            throw new IllegalArgumentException("ItemsOrder is null");
        }
        if(itemsOrdered.size() == 0) {
            throw new IllegalArgumentException("ItemsOrder is empty");
        }
        if(itemsOrdered.size() > 30) {
            throw new TakeAwayBillException();
        }

        double result = 0;
        for (MenuItem m : itemsOrdered) {
            result += m.getPrice();
        }
        return result;
    }
}
