package com.doterra.research.guice.customFactory;

import com.google.inject.ImplementedBy;

@ImplementedBy(CartDiscountFactory.class)
public interface DiscountFactory
{
    Discountable getDiscount(ShoppingCart cart);
}
