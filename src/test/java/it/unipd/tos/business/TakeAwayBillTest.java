package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class TakeAwayBillTest {

    private TakeAwayBill takeAwayBill;
    private MenuItem drink;
    private MenuItem sandwich;
    private MenuItem bigSandwich;
    private MenuItem fries;

    LinkedList<MenuItem> list = new LinkedList<>();


    @Before
    public void setup() {


        drink = new MenuItem(MenuItem.ItemType.BEVANDA, "Fanta", 2.5D);
        sandwich = new MenuItem(MenuItem.ItemType.PANINO, "Hot dog", 5D);
        bigSandwich = new MenuItem(MenuItem.ItemType.PANINO, "XL", 10D);
        fries = new MenuItem(MenuItem.ItemType.FRITTO, "Fries", 3.5D);

        takeAwayBill = new TakeAwayBillImpl();
        list = new LinkedList<>();
    }

    @Test
    public void test_getOrderPriceFeeApplied() throws TakeAwayBillException {
        list.add(drink);
        assertEquals(3D, takeAwayBill.getOrderPrice(list), 0.0001D);
    }

    @Test
    public void test_getOrderPrice50DiscountApplied() throws TakeAwayBillException {
        list.add(sandwich);
        list.add(sandwich);
        list.add(sandwich);
        list.add(bigSandwich);
        list.add(bigSandwich);
        list.add(bigSandwich);
        assertEquals(42.5D, takeAwayBill.getOrderPrice(list), 0.0001D);
    }

    @Test
    public void test_getOrderPrice10DiscountApplied() throws TakeAwayBillException {
        for (int i = 0; i < 20; i++) {
            list.add(fries);
        }
        assertEquals(63D, takeAwayBill.getOrderPrice(list), 0.0001D);
    }


    @Test
    public void test_getOrderPrice50plus10DiscountApplied() throws TakeAwayBillException {
        list.add(sandwich);
        list.add(sandwich);
        list.add(drink);
        list.add(fries);
        list.add(bigSandwich);
        list.add(bigSandwich);
        list.add(bigSandwich);
        list.add(bigSandwich);
        assertEquals(48.15D, takeAwayBill.getOrderPrice(list), 0.0001D);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getOrderPriceNullItems() throws TakeAwayBillException {
        takeAwayBill.getOrderPrice(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getOrderPrice0Items() throws TakeAwayBillException {
        takeAwayBill.getOrderPrice(list);
    }

    @Test(expected = TakeAwayBillException.class)
    public void test_getOrderPrice40Items() throws TakeAwayBillException {
        for (int i = 0; i < 40; i++) {
            list.add(drink);
        }
        takeAwayBill.getOrderPrice(list);
    }
}
