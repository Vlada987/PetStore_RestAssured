package endpoints;

import static io.restassured.RestAssured.*;

import java.io.File;

import api.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Animal;

public class Methods {

	public static Response addPetToTheStore(Animal an) {

		Response res = given().contentType("application/json").accept(ContentType.JSON).body(an).post(Routes.post);
		return res;
	}

	public static Response getPetWithId(String id) {

		Response res = given().pathParam("petId", id).get(Routes.getById);
		return res;
	}

	public static Response uploadPhoto(String id) {

		File img = new File("C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\ras1\\pet.bmp");
		Response res = given().pathParam("petId", id).multiPart("file", img, "multipart/form-data").post(Routes.addImg);
		return res;
	}

	public static Response updatePet(Animal an) {

		Response resp = given().contentType("application/json").accept(ContentType.JSON).body(an).put(Routes.update);
		return resp;
	}

	public static int getSizeOfArray(Response resp, String json) {

		int size = 0;
		while (3 == 3) {
			if (resp.jsonPath().get(json + "[" + size + "]") == null) {
				break;
			}
			size++;
		}
		return size;
	}

}
