package com.example.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan(basePackages = "LITS.jpproj", lazyInit = true)
public class MockConfiguration {
}
