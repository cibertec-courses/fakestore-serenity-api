package edu.pe.cibertec.steps;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.*;

public class ProductsSteps {

    private static final String BASE_URL = "https://fakestoreapi.com";
    private Response response;

    @Given("el servicio de productos esta diponible")
    public void elServicioDeProductosEstaDisponible(){

    }

    @When("envio una peticion GET a productos")
    public void envioUnaPeticionGETAProductos(){
        response = SerenityRest.given()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Safari/605.1.15")
                .baseUri(BASE_URL)
                .when()
                .get("/products");
    }

    @When("envio una perticion GET al producto con ID {int}")
    public void envioUnaPeticionGETAProductosConID( int id){
        response = SerenityRest.given()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Safari/605.1.15")
                .baseUri(BASE_URL)
                .when()
                .get("/products/"+id);
    }

    @Then("el codigo de respues debe ser {int}")
    public void elCodigoDeRespuestaDebeSer(int statusCode){
        response.then().statusCode(statusCode);
    }

    @And("la respuesta debe contener una lista de productos")
    public void laRespuestaDebeContenerUnaListaDeProductos(){
        response.then()
                .body("$", is(not(empty())))
                .body("size()", greaterThan(0));
    }

    @And("la respuesta debe contener el producto con ID {int}")
    public  void laRespuestaDebeContenerElProductoConID(int id){
        response.then()
                .body("id", equalTo(id))
                .body("title", is(not(empty())))
                .body("title", is(notNullValue()));

    }
}

