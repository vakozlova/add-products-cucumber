package com.autotest.runner;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters(value = {
        @ConfigurationParameter(key = "cucumber.filter.tags", value = "@all"),
        @ConfigurationParameter(key = "cucumber.features", value = "src/test/resources/features"),
        @ConfigurationParameter(key = "cucumber.glue", value = "com.autotest.steps"),
        @ConfigurationParameter(key = "cucumber.plugin", value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm, pretty")
})
public class TestRunner {
}
