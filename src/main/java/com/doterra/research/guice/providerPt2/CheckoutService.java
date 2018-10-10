package com.doterra.research.guice.providerPt2;

import javax.inject.Inject;

/**
 * A little bit different using a Provider<T>. In this case, you don't have to have an instance until you actually
 * use the implementation in the checkout() method. This allows us to use a lazy instantiation.
 */
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
        // this is the first place the implementation of Discountable is used. We have to use the Provider factory
        // method get to get the instance and then we can call the implementation's getDiscount() method.
        double totalAfterDiscount = cartTotal - (cartTotal * this.discount.getDiscount());

        System.out.println("Original cart total: " + cartTotal + "::Cart with discount: " + totalAfterDiscount);

        return totalAfterDiscount;
    }
}
