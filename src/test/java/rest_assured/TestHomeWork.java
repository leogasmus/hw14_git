package rest_assured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestHomeWork {

    @Test
    public void getUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        JsonPath response = given().
        when().
                get("/users").
        then().
                extract().body().jsonPath();

        //Роздрукувати всі email
        System.out.println("======");
        System.out.println("Роздрукувати всі email");
        System.out.println(response.getList("email"));


        //Роздрукувати всі zipcode
        System.out.println("======");
        System.out.println("Роздрукувати всі zipcode");
        System.out.println(response.getList("address.zipcode"));


        //Вивести на екран ті zipcodes, які без тире
        System.out.println("======");
        System.out.println("zipcodes, які без тире");
        System.out.println(response.getList("findAll{!it.address.zipcode.contains('-')}.address.zipcode"));


        //Для кожного name вивести значення lat та lng (приклад: Leanne Graham is situated at: lat = -37.3159 and lng = 81.1496)
        System.out.println("======");
        System.out.println("name вивести значення lat та lng");


        //Роздрукувати username лише для тих, в кого значення lat та lng відʼємні
        System.out.println("======");
        System.out.println("username лише для тих, в кого значення lat та lng відʼємні");
        System.out.println(response.getList("findAll{it.address.geo.lng.toDouble() < 0.0 && it.address.geo.lat.toDouble() < 0.0}.name"));


        //Роздрукувати username лише для тих в кого значення website закінчується на .info (приклад: Samantha - ramiro.info і так далі)
        System.out.println("======");
        System.out.println("username лише для тих в кого значення website закінчується на .info");
        System.out.println(response.getList("findAll{it.email.endsWith('.info')}.username") + " - " + response.getList("findAll{it.email.endsWith('.info')}.email"));


        //!! треба name Вивести на екран name в якого значення lng найбільше
        System.out.println("======");
        System.out.println("name в якого значення lng найбільше");
        System.out.println(response.getDouble("collect{it.address.geo.lng.toDouble()}.max()"));



        //!!! треба name Вивести на екран name в якого найдовша catchPhrase
        System.out.println("======");
        System.out.println("name в якого найдовша catchPhrase");
        System.out.println(response.getInt("collect{it.company.catchPhrase.length()}.max()"));

    }
}


