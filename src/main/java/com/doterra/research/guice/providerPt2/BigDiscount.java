package com.doterra.research.guice.providerPt2;

public class BigDiscount implements Discountable
{
    @Override
    public double getDiscount()
    {
        return 0.35D;
    }
}
