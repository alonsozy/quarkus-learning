package com.bcp.training;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

import java.util.Optional;

@ConfigMapping(prefix = "expense")
public interface ExpenseConfigurator {

    @WithDefault("false")
    boolean debugEnabled(); // here the common case is with - in the property, debug-enabled

    int rangeHigh(); // range-high
    int rangeLow(); // range-low

    Optional<String> debugMessage();
}
