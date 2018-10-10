package com.doterra.research.guice.simpleProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.time.Instant;

/**
 * This is a google guice module. This class needs to be instantiated as a guice injector when the application
 * starts up. In this case, we are doing this in the Main class
 * @see Main
 */
public class DiscountGuiceModule extends AbstractModule
{
    @Override
    protected void configure()
    {
//        // There are two implementations of Discountable. Use the getCurrentTimeQuadrant() method to figure out which
//        // one to inject at runtime.
//        int timeQuadrant = getCurrentTimeQuadrant();
//        System.out.println("quadrant: " + timeQuadrant);
//
//        if (timeQuadrant == 1 || timeQuadrant == 3)
//        {
//            bind(Discountable.class).toProvider(EarlyDiscountProvider.class);
//        }
//        else if (timeQuadrant == 2 || timeQuadrant == 4)
//        {
//            bind(Discountable.class).toProvider(LateDiscountProvider.class);
//        }
    }

    @Provides
    public Discountable get()
    {
        // There are two implementations of Discountable. Use the getCurrentTimeQuadrant() method to figure out which
        // one to inject at runtime.
        int timeQuadrant = getCurrentTimeQuadrant();
        System.out.println("quadrant: " + timeQuadrant);

        if (timeQuadrant == 1 || timeQuadrant == 3)
        {
            return new EarlyBirdDiscount();
        }
        else if (timeQuadrant == 2 || timeQuadrant == 4)
        {
            return new NightOwlDiscount();
        }
        else
        {
            return null;
        }
    }

    /*
     * gets the number of seconds from the epoch and determines if the current time is in one of the 4 quadrands of the
     * clock.
     * seconds between 0 and 24 return 1 (for the first quadrant)
     * seconds between 25 and 49 return 2 (for the second quadrant)
     * seconds between 50 and 74 return 3 (for the third quadrant)
     * seconds between 75 and 99 return 4 (for the fourth quadrant)
     * something else returns 0 (error condition)
     */
    private int getCurrentTimeQuadrant()
    {
        long secs = (Instant.now().getEpochSecond() % 100);

        if (secs >= 0 && secs <=24)
        {
            return 1;
        }
        else if (secs >= 25 && secs <= 49)
        {
            return 2;
        }
        else if (secs >= 50 && secs <= 74)
        {
            return 3;
        }
        else if (secs >= 75 && secs <= 99)
        {
            return 4;
        }
        else
        {
            return 0;
        }
    }
}
