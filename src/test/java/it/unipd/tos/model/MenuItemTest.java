package it.unipd.tos.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuItemTest {

    private MenuItem item;

    @Before
    public void setup() {
        item = new MenuItem(MenuItem.ItemType.BEVANDA, "Sprite", 2D);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidItemTypeParam() {
        new MenuItem(null, "Vegetariano", 10D);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullNameParam() {
        new MenuItem(MenuItem.ItemType.BEVANDA, null, 4D);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test0LenNameParam() {
        new MenuItem(MenuItem.ItemType.BEVANDA, "", 4D);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPriceParam() {
        new MenuItem(MenuItem.ItemType.BEVANDA, "Coca cola", -2D);
    }

    @Test
    public void testNameGetter() {
        assertEquals("Sprite", item.getName());
    }

    @Test
    public void testPriceGetter() {
        assertEquals(2D, item.getPrice(), 0.0001D);
    }

    @Test
    public void testTypeGetter() {
        assertEquals(MenuItem.ItemType.BEVANDA, item.getItemType());
    }
}
