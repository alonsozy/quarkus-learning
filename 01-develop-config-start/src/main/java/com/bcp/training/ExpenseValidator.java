package com.bcp.training;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ExpenseValidator {

    /*@ConfigProperty(name = "debug-enabled", defaultValue = "false")
    boolean debugEnabled;
    //private static final boolean DEBUG_ENABLED = true;

    @ConfigProperty(name = "range-high")
    int targetRangeHigh;
    //private static final int RANGE_HIGH = 1000;

    @ConfigProperty(name = "range-low")
    int targetRangeLow;
    //private static final int RANGE_LOW = 250;

     */
    @Inject
    ExpenseConfigurator expenseConfigurator;

    public void debugRanges() {
        System.out.println("Range - High: " + expenseConfigurator.rangeHigh());
        System.out.println("Range - Low: " + expenseConfigurator.rangeLow());
        expenseConfigurator.debugMessage().ifPresent(System.out::println);
    }

    public boolean isValidAmount(int amount) {
        if (expenseConfigurator.debugEnabled()) {
            debugRanges();
        }

        return amount >= expenseConfigurator.rangeLow() && amount <= expenseConfigurator.rangeHigh();
    }
}

