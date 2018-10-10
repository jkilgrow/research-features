package com.doterra.research.guice.simpleProvider;

public class EarlyBirdDiscount implements Discountable
{
    @Override
    public double getDiscount()
    {
        return 0.25d;
    }
}
