package com.doterra.research.guice.providerPt2;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class BasicApplication
{
    private final CheckoutService checkoutService;

    // inject the top level dependency: CheckoutService
    @Inject
    public BasicApplication(CheckoutService checkoutService)
    {
        this.checkoutService = checkoutService;
    }

    void start()
    {
        this.checkoutService.checkout(100.0D);
    }

    public static void main(String[] args)
    {
        // inject the Guice master factory which creates the object graph of all our factories via the GuiceModule
        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        // Inject the application which contains a separate object graph which contains all the business logic
        // When we call the top level class, BasicApplication, guice will inject every static dependency that we request
        // via @Inject
        BasicApplication basicApplication = guice.getInstance(BasicApplication.class);

        // now start the application
        basicApplication.start();
    }
}
