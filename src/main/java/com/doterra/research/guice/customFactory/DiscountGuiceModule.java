package com.doterra.research.guice.customFactory;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/**
 * This is a google guice module. This class needs to be instantiated as a guice injector when the application
 * starts up. In this case, we are doing this in the Main class
 */
public class DiscountGuiceModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        // MapBinder is a guice class that binds implementations to a map.
        // the binder() method is the way it does this. it automatically binds the MapBinder to a Map if you want it
        // injected automatically without having to do an explicit binding.
        // MapBinder is not a map. It becomes a map when the binder() method is invoked when the @Inject asks for
        // a type of Map<Integer, Discountable>.
        // @see BasicApplication
        MapBinder<Integer, Discountable> mapBinder = MapBinder.newMapBinder(binder(), Integer.class, Discountable.class);
        mapBinder.addBinding(0).to(EarlyBirdDiscount.class);
        mapBinder.addBinding(1).to(NightOwlDiscount.class);
        mapBinder.addBinding(2).to(NoDiscount.class);
    }
}
