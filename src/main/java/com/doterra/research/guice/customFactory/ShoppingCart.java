package com.doterra.research.guice.customFactory;

public class ShoppingCart
{
    private double cartTotal;
    private int timeOfCheckout;

    public double getCartTotal()
    {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal)
    {
        this.cartTotal = cartTotal;
    }

    public int getTimeOfCheckout()
    {
        return timeOfCheckout;
    }

    public void setTimeOfCheckout(int timeOfCheckout)
    {
        this.timeOfCheckout = timeOfCheckout;
    }
}
