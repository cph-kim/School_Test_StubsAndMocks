/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.ExtractableResponse;

/**
 *
 * @author Kim
 */
public class EducationJoke implements IJokeFetcher {

    @Override
    public Joke getJoke() {
        try {
            ExtractableResponse res = given().get("http://jokes-plaul.rhcloud.com/api/joke").then().extract();
            String joke = res.path("joke");
            String reference = res.path("reference");
            return new Joke(joke, reference);
        } catch (Exception e) {
            return null;
        }
    }

}
