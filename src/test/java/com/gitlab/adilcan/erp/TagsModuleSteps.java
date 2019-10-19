package com.gitlab.adilcan.erp;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.*;


public class TagsModuleSteps extends SpringIntegrationTest {

    @Given("^se tiene acceso al sistema \\(user=test, password=test\\) usando la url http://(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+):(\\d+)/login$")
    public void se_tiene_acceso_al_sistema_user_test_password_test_usando_la_url_http_login(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        getDriver().get("http://localhost:5665/login");
        getDriver().findElement(By.id("username")).click();
        getDriver().findElement(By.id("username")).clear();
        getDriver().findElement(By.id("username")).sendKeys("test");
        getDriver().findElement(By.id("password")).click();
        getDriver().findElement(By.id("password")).clear();
        getDriver().findElement(By.id("password")).sendKeys("test");
        getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]")).click();
    }

    @Given("^acceso al dashboard principal$")
    public void acceso_al_dashboard_principal() throws Exception {
        System.out.println("Actual URL :" + getDriver().getCurrentUrl());
        assertEquals(getDriver().getCurrentUrl(), "http://localhost:5665/");

    }

    @When("^se expande el menu Services$")
    public void se_expande_el_menu_Services() throws Exception {
        getDriver().findElement(By.id("menu-btn")).click();
        getDriver().findElement(By.id("services-nav")).click();
    }


    @When("^se selecciona el apartado Tags$")
    public void se_selecciona_el_apartado_Tags() throws Throwable {
        System.out.println("DATA" + getDriver().findElement(By.id("tags-id")).getText());
        getDriver().findElement(By.id("tags-id")).click();
    }

    @Then("^se redirige a la url http://(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+):(\\d+)/tags$")
    public void se_redirige_a_la_url_http_tags(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        System.out.println("Actual URL :" + getDriver().getCurrentUrl());
        assertEquals(getDriver().getCurrentUrl(), "http://localhost:5665/tags");
    }

    @Then("^se visualiza el modulo de tags$")
    public void se_visualiza_el_modulo_de_tags() throws Throwable {
        assertNotNull(getDriver().findElement(By.id("tags-table")));
    }

    @Given("^acceso al modulo de tags$")
    public void acceso_al_modulo_de_tags() throws Throwable {
        getDriver().findElement(By.id("menu-btn")).click();
        getDriver().findElement(By.id("services-nav")).click();
        getDriver().findElement(By.id("tags-id")).click();
    }

    @When("^se selecciona Create Tag$")
    public void se_selecciona_Create_Tag() throws Throwable {
        getDriver().findElement(By.id("create-tag")).click();
    }

    @Then("^se redirige a la url http://(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+):(\\d+)/tags/new$")
    public void se_redirige_a_la_url_http_tags_new(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        assertEquals(getDriver().getCurrentUrl(), "http://localhost:5665/tags/new");
    }

    @Then("^se visualiza el formulario para agregar tag$")
    public void se_visualiza_el_formulario_para_agregar_tag() throws Throwable {
        assertTrue(isElementPresent(By.xpath(".//*[@id=\"page-top\"]/div/div/div/form")));

    }

    private boolean isElementPresent(By by) throws Exception {
        try {
            getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
