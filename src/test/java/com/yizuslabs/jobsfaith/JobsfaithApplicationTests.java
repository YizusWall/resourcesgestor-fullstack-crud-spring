package com.yizuslabs.jobsfaith;

import com.yizuslabs.jobsfaith.persistence.model.TbUsuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={JobsfaithApplication.class},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JobsfaithApplicationTests {

    private static final String API_ROOT
            = "http://localhost:9091/api/usuario";
    @Test
    public void whenGetAllBooks_thenOK() {
        Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }



    // ===============================

    private TbUsuario createRandomBook() {
        final TbUsuario user = new TbUsuario();
        user.setCodEmpleado(randomAlphabetic(10));
        user.setNomUsuario(randomAlphabetic(15));
        return user;
    }

    private String createBookAsUri(TbUsuario user) {
        final Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(user)
                .post(API_ROOT);
        System.out.println("jsonPath "+response.jsonPath());

        return API_ROOT + "/" + response.jsonPath().get("codUsuario");
    }

    @Test
    public void whenGetUsuarioPorNombre_thenOK() {
        final TbUsuario user = createRandomBook();
        createBookAsUri(user);
        System.out.println("name "+user.getNomUsuario());
        final Response response = RestAssured.get(API_ROOT + "/name/" + user.getNomUsuario());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class)
                .size() > 0);
    }

}
