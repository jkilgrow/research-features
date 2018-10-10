package com.doterra.research.guice.simpleSingleInterface;

public class DiscountTest implements Discountable
{
    @Override
    public double getDiscount()
    {
        return CheckoutServiceTest.discountVal;
    }
}
