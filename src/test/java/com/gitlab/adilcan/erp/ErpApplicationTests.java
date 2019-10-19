package com.gitlab.adilcan.erp;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/tags.feature","src/test/resources/services.feature"} ,
        plugin = {"pretty", "html:target/cucumber"})
public class ErpApplicationTests {

}
