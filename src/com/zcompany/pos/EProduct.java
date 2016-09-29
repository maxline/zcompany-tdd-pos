package com.zcompany.pos;

public enum EProduct {
    COFFEE(new Product("Coffee", 35)),
    TEA(new Product("Tea", 25)),
    JUICE(new Product("Juice", 45));

    EProduct(Product product) {
        this.product = product;
    }

    private final Product product;

    public Product getProduct() {
        return product;
    }
}
