package com.doterra.research.guice.simpleSingleInterface;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutServiceTest
{
    public static double discountVal = .5d;
    private static double cartTotal = 100.0d;

    @Test
    public void testValueProvidesPositiveResult()
    {
        discountVal = .2d;

        Injector guice = Guice.createInjector(new DiscountModule());
        CheckoutService service = guice.getInstance(CheckoutService.class);
        double delta = 0;
        assertEquals("should be " + discountVal + " off", (cartTotal - (discountVal * cartTotal)), service.checkout(cartTotal), delta);
    }
}