package com.zcompany.pos;

import java.util.Arrays;

/**
 * The BeverageShop class.
 * It allows:
 * - to take cash,
 * - to choose product,
 * - to charge back,
 * - to give chosen product,
 * - to give change
 */
public class BeverageShop {
    private int cash;
    private static final Integer[] coins = {1, 5, 10, 25, 50};
    private Product product;


    public void addCash(int coin) {
        if (!Arrays.asList(coins).contains(coin)) {
            throw new IllegalArgumentException();
        }
        cash += coin;
    }

    public int getCash() {
        return cash;
    }

    public Product getProduct() {
        return product;
    }

    public void chooseProduct(Product productParam) {
        product = productParam;
    }

    public int chargeBack() {
        int chargeBack = cash;
        cash = 0;
        return chargeBack;
    }


    /**
     * Provides the payment.
     * Checks whether you have enough cash for buying a product.
     * Returns change.
     *
     * @return change after buying of product
     */
    public int makePayment() {

        if (product == null) {
            throw new NullPointerException();
        }

        if (cash > product.getPrice()){
            cash -= product.getPrice();
            giveProduct();

        } else {
            return -1;
        }

        return cash;
    }

    private void giveProduct() {
        product = null;
    }
}
