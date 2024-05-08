package com.tsi.training;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = {"src/test/resources/features"})
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
@CucumberContextConfiguration
@AutoConfigureMockMvc
public class DemoApplicationTests {



}
