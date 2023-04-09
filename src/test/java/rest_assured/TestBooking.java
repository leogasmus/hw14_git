package rest_assured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest_assured.pojo.BookingDates;
import rest_assured.pojo.CreateBookingRequest;

import static io.restassured.RestAssured.given;


public class TestBooking {
    @Test
    public void createToken() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String responseBody = given()
                //.log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
        .when()
                .post("/auth")
        .then()
                //.log().all()
                .assertThat()
                .statusCode(200)
                .body("token", Matchers.not(Matchers.blankOrNullString()))
                .header("Server", "Cowboy").extract().body().asString();

        System.out.println(responseBody);
        JsonPath jsonPath = new JsonPath(responseBody);
        System.out.println(" path: " + jsonPath.getString("token"));;
    }

    private CreateBookingRequest getRequest() {
     CreateBookingRequest request = new CreateBookingRequest();
     request.setFirstname("Jim");
     request.setLastname("Brown");
     request.setTotalprice(111);
     request.setDepositpaid(true);
        BookingDates dates = new BookingDates();
        dates.setCheckin("2018-01-01");
        dates.setCheckout("2019-01-01");
     request.setBookingdates(dates);
     request.setAdditionalneeds("Breakfast");
        return request;
    };
    @Test
    public void createBooking() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        JsonPath jPath = given()
                .log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(getRequest())
        .when()
                .post("/booking")
        .then()
                .log().all()
                .statusCode(200)
                .extract().body().jsonPath();
        String firstName = jPath.getString("booking.firstname");

        Assert.assertEquals(firstName, "Jim");

        String checkInDate = jPath.getString("booking.bookingdates.checkin");
        Assert.assertEquals(checkInDate, "2018-01-01");
    }
}






























