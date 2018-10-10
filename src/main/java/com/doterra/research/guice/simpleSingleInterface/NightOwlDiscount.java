package com.doterra.research.guice.simpleSingleInterface;

public class NightOwlDiscount implements Discountable
{
    @Override
    public double getDiscount()
    {
        return 0.35d;
    }
}
