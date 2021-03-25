package br.com.it2.api.java.config;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, plugin = { "pretty",
		"html:target/cucumber" }, glue = "br.com.it2.api.java.steps")
public class CucumberConfigTest {

}