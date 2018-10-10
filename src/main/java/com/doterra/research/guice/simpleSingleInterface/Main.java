package com.doterra.research.guice.simpleSingleInterface;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * This is the driver class for this simpleSingleInterface tutorial.
 */
public class Main
{
    public static void main(String[] args)
    {
        // instantiate the guice module DiscountGuiceModule as a guice injectable resource
        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        // the CheckoutService constructor needs a Discountable dependency. Use the injector to give it that dependency.
        CheckoutService service = guice.getInstance(CheckoutService.class);

        service.checkout(100.0);
    }
}
