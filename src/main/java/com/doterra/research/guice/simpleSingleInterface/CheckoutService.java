package com.doterra.research.guice.simpleSingleInterface;

import javax.inject.Inject;

public class CheckoutService
{
    private final Discountable discount;

    @Inject
    public CheckoutService(Discountable discount)
    {
        this.discount = discount;
    }

    public double checkout(double cartTotal)
    {
        double totalAfterDiscount = cartTotal - (cartTotal * this.discount.getDiscount());

        System.out.println("Original cart total: " + cartTotal + "::Cart with discount: " + totalAfterDiscount);

        return totalAfterDiscount;
    }
}
