package rest_assured;

import io.restassured.path.json.JsonPath;

import java.io.File;

public class TestArraysWithJSONPath {
    public static void main(String[] args) {
        File jsonFile = new File("src/test/resources/demo.json");
        JsonPath jsonPath = new JsonPath(jsonFile);

        System.out.println(jsonPath.getString("[1].email"));
        System.out.println(jsonPath.getJsonObject("[1]").toString());
        System.out.println(jsonPath.getList("given_name"));

        System.out.println(jsonPath.getList("findAll{it.logins_count > 2}.given_name"));
        System.out.println(jsonPath.getInt("logins_count.max()"));
    }
}
