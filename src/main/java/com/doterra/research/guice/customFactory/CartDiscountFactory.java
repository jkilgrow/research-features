package com.doterra.research.guice.customFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Map;

@Singleton
public class CartDiscountFactory implements DiscountFactory
{
    final Map<Integer, Discountable> discountableBinder;

    @Inject
    public CartDiscountFactory(Map<Integer, Discountable> mapBinder)
    {
        this.discountableBinder = mapBinder;
    }

    @Override
    public Discountable getDiscount(ShoppingCart cart)
    {
        int currentHour = cart.getTimeOfCheckout();

        if (isEarlyMorning(currentHour))
        {
            return discountableBinder.get(0);
        }
        else if (isLateAtNight(currentHour))
        {
            return discountableBinder.get(1);
        }

        return discountableBinder.get(2);
    }

    private boolean isEarlyMorning(int currentHour)
    {
        return (currentHour >= 5 && currentHour <= 9);
    }

    private boolean isLateAtNight(int currentHour)
    {
        return (currentHour >= 0 && currentHour <= 4);
    }
}
