package com.gitlab.adilcan.erp;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ServicesModuleSteps extends SpringIntegrationTest {

    //Ya se cuenta con los primeros steps en el modulo de tags por lo que se omite su declaracion
    //@Given("^se tiene acceso al sistema \\(user=test, password=test\\) usando la url http://(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+):(\\d+)/login$")
    //@Given("^acceso al dashboard principal$")
    //@When("^se expande el menu Services$")



    @Then("^se redirige a la url http://(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+):(\\d+)/services$")
    public void se_redirige_a_la_url_http_services(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        assertEquals(getDriver().getCurrentUrl(), "http://localhost:5665/services");
    }

    @Then("^se visualiza el modulo de services$")
    public void se_visualiza_el_modulo_de_services() throws Throwable {
        assertNotNull(getDriver().findElement(By.id("services-table")));
    }

    @When("^se selecciona el apartado Services")
    public void se_selecciona_el_apartado_services() throws Exception{
        getDriver().findElement(By.id("services-id")).click();
    }

    @When("^se selecciona Create Service$")
    public void se_selecciona_Create_Service() throws Throwable {
        getDriver().findElement(By.id("creates-service")).click();
    }

    @Then("^se redirige a la url http://(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+):(\\d+)/services/new$")
    public void se_redirige_a_la_url_http_services_new(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        assertEquals(getDriver().getCurrentUrl(), "http://localhost:5665/services/new");
    }

    @Then("^se visualiza el formulario para agregar service$")
    public void se_visualiza_el_formulario_para_agregar_service() throws Throwable {
        assertNotNull(getDriver().findElement(By.id("create-service")));
    }

    @When("^se selecciona la opcion 'For Sale'$")
    public void se_selecciona_la_opcion_For_Sale() throws Throwable {
        getDriver().findElement(By.id("service-for-sale")).click();
    }

    @Then("^se redirige a la url http://(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+):(\\d+)/services\\?sale_status=FOR_SALE$")
    public void se_redirige_a_la_url_http_services_sale_status_FOR_SALE(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        assertEquals(getDriver().getCurrentUrl(), "http://localhost:5665/services?sale_status=FOR_SALE");

    }

    @Then("^se visualizan unicamente los services con estado 'For Sale'$")
    public void se_visualizan_unicamente_los_services_con_estado_For_Sale() throws Throwable {
        //Se vuelve a visualizar la tabla con la data devuelta de sales.
        assertNotNull(getDriver().findElement(By.id("services-table")));
    }
}
