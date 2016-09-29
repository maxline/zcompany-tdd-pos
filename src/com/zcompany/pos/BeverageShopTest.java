package com.zcompany.pos;

import org.junit.Before;
import org.junit.Test;

import static com.zcompany.pos.EProduct.COFFEE;
import static com.zcompany.pos.EProduct.JUICE;
import static com.zcompany.pos.EProduct.TEA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The test class for the BeverageShop class.
 */
public class BeverageShopTest {
    private static final int COIN_1 = 1;
    private static final int COIN_5 = 5;
    private static final int COIN_10 = 10;
    private static final int COIN_25 = 25;
    private static final int COIN_50 = 50;
    private BeverageShop beverageShop;

    @Before
    public void setup() {
        beverageShop = new BeverageShop();
    }

    @Test
    public void addCash() {
        beverageShop.addCash(COIN_1);
        assertEquals(COIN_1, beverageShop.getCash());
    }

    @Test
    public void addMultipleCash() {
        beverageShop.addCash(COIN_1);
        assertEquals(COIN_1, beverageShop.getCash());
        beverageShop.addCash(COIN_5);
        assertEquals(COIN_1 + COIN_5, beverageShop.getCash());
        beverageShop.addCash(COIN_10);
        assertEquals(COIN_1 + COIN_5 + COIN_10, beverageShop.getCash());
        beverageShop.addCash(COIN_25);
        assertEquals(COIN_1 + COIN_5 + COIN_10 + COIN_25, beverageShop.getCash());
        beverageShop.addCash(COIN_50);
        assertEquals(COIN_1 + COIN_5 + COIN_10 + COIN_25 + COIN_50, beverageShop.getCash());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addWrongCash() {
        beverageShop.addCash(COIN_5-1);
    }

    @Test
    public void chooseProduct(){
        beverageShop.chooseProduct(COFFEE.getProduct());
        assertEquals(COFFEE.getProduct(), beverageShop.getProduct());

        beverageShop.chooseProduct(TEA.getProduct());
        assertEquals(TEA.getProduct(), beverageShop.getProduct());

        beverageShop.chooseProduct(JUICE.getProduct());
        assertEquals(JUICE.getProduct(), beverageShop.getProduct());
    }

    @Test
    public void chargeBack(){
        beverageShop.addCash(COIN_50);
        beverageShop.addCash(COIN_1);

        assertEquals(COIN_50 + COIN_1, beverageShop.chargeBack());
        assertEquals(0, beverageShop.getCash());
    }

    @Test
    public void makePayment(){
        beverageShop.addCash(COIN_50);
        beverageShop.addCash(COIN_1);
        beverageShop.chooseProduct(TEA.getProduct());

        assertEquals(COIN_50 + COIN_1 - TEA.getProduct().getPrice(), beverageShop.makePayment());
        assertNull(beverageShop.getProduct());
    }


    @Test (expected = NullPointerException.class)
    public void makePaymentWithoutProduct(){
        beverageShop.addCash(COIN_50);
        beverageShop.makePayment();
    }

    @Test
    public void makePaymentNotEnoughCash(){
        beverageShop.addCash(COIN_10);
        beverageShop.chooseProduct(TEA.getProduct());

        assertEquals(-1, beverageShop.makePayment());
        assertEquals(TEA.getProduct(), beverageShop.getProduct());
    }
}
