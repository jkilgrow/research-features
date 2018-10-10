package com.doterra.research.guice.providerPt2;

public class NoDiscount implements Discountable
{
    @Override
    public double getDiscount()
    {
        return 0.0D;
    }
}
