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

        // Controllo limite items
        if(itemsOrdered.size() > 30) {
            throw new TakeAwayBillException();
        }

        double result = 0;
        int nSandwich = 0;
        MenuItem cheapestSandwich = null;

        for (MenuItem m : itemsOrdered) {
            result += m.getPrice();

            if(m.getItemType() == MenuItem.ItemType.PANINO) {
                nSandwich++;
                if(cheapestSandwich == null ||
                        cheapestSandwich.getPrice() > m.getPrice()) {
                    cheapestSandwich = m;
                }
            }
        }

        // Calcolo sconto > 5 panini
        if(nSandwich > 5) {
            result -= cheapestSandwich.getPrice() * 0.5D;
        }

        // Applicazione sconto totale > 50 euro
        if(result > 50D) {
            result -= result * 0.1D;
        }

        // Commissione
        if(result < 10D) {
            result += 0.5D;
        }


        return result;
    }
}
