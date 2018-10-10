package com.doterra.research.guice.customFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicApplication
{
    private final CheckoutService checkoutService;

    @Inject
    public BasicApplication(CheckoutService checkoutService)
    {
        this.checkoutService = checkoutService;
    }

    void start()
    {
        while (true)
        {
            this.checkoutService.checkout(getNewUserCheckout());
        }
    }

    public static void main(String[] args)
    {
        Injector guice = Guice.createInjector(new DiscountGuiceModule());
        BasicApplication basicApplication = guice.getInstance(BasicApplication.class);
        basicApplication.start();
    }

    ShoppingCart getNewUserCheckout()
    {
        ShoppingCart cart = new ShoppingCart();
        cart.setCartTotal(getTotalFromInput());
        cart.setTimeOfCheckout(getCheckoutTimeFromInput());
        return cart;
    }

    private double getTotalFromInput()
    {
        String total = null;
        System.out.print("Enter Cart Total: ");

        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            total = bufferedReader.readLine();
        }
        catch (IOException wellShoot)
        {
            System.out.println("bummer");
        }

        return Double.valueOf(total);
    }

    private int getCheckoutTimeFromInput()
    {
        String hour = null;
        System.out.print("Enter Checkout Hour: ");

        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            hour = bufferedReader.readLine();
        }
        catch (IOException dangit)
        {
            System.out.println("crap");
        }


        return Integer.valueOf(hour);
    }
}
