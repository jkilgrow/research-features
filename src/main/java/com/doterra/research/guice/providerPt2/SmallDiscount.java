package com.doterra.research.guice.providerPt2;

public class SmallDiscount implements Discountable
{
    @Override
    public double getDiscount()
    {
        return 0.05D;
    }
}
