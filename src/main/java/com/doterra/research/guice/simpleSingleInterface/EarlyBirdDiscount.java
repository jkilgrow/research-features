package com.doterra.research.guice.simpleSingleInterface;

public class EarlyBirdDiscount implements Discountable
{
    @Override
    public double getDiscount()
    {
        return 0.25d;
    }
}
