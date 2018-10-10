package com.doterra.research.guice.simpleSingleInterface;

import com.google.inject.AbstractModule;

/**
 * This is a google guice module. This class needs to be instantiated as a guice injector when the application
 * starts up. In this case, we are doing this in the Main class
 * @see com.doterra.research.guice.simpleSingleInterface.Main
 */
public class DiscountGuiceModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        // any time you see someone asking for a type of Discountable, inject an instance of NightOwlDiscount
        bind(Discountable.class).to(NightOwlDiscount.class);
    }
}
