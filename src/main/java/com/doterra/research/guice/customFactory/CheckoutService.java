package com.doterra.research.guice.customFactory;

import javax.inject.Inject;

/**
 * A little bit different using a Provider<T>. In this case, you don't have to have an instance until you actually
 * use the implementation in the checkout() method. This allows us to use a lazy instantiation.
 */
public class CheckoutService
{
    private final DiscountFactory discountFactory;

    @Inject
    public CheckoutService(DiscountFactory discountFactory)
    {
        this.discountFactory = discountFactory;
    }

    public double checkout(ShoppingCart cart)
    {
        Discountable discountable = discountFactory.getDiscount(cart);
        double discount = discountable.getDiscount();
        double total = cart.getCartTotal();
        double totalAfterDiscount = total - (total * discount);
        System.out.println("Shopping cart initially " + total + " with a discount of " + discount + " = " + totalAfterDiscount);

        return totalAfterDiscount;
    }
}
