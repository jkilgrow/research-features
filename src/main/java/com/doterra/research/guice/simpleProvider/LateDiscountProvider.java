package com.doterra.research.guice.simpleProvider;

import javax.inject.Provider;

public class LateDiscountProvider implements Provider<Discountable>
{
    @Override
    public Discountable get()
    {
        return new NightOwlDiscount();
    }
}
