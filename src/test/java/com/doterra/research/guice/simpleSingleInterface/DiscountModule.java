package com.doterra.research.guice.simpleSingleInterface;

import com.google.inject.AbstractModule;

public class DiscountModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Discountable.class).to(DiscountTest.class);
    }
}