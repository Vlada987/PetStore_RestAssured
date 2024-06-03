package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.sun.tools.javac.code.Attribute.Array;

import endpoints.Methods;
import io.restassured.response.Response;
import pojo.Animal;

public class Test_Class {

	Animal an;
	String pet_id;
	Faker f;

	@BeforeTest
	public void createData() {

		f = new Faker();
		an = new Animal();
		an.setId("0");
		an.setCategory("id", "33");
		an.setCategory("name", "cat");
		an.setName(f.name().firstName());
		an.setPhotoUrls("www.google.com");
		an.setPhotoUrls("www.rwerw.com");
		HashMap<String, String> tagMap = new HashMap<String, String>();
		tagMap.put("id", "20");
		tagMap.put("name", f.name().username());
		an.setTags(tagMap);
		an.setStatus("available");

	}

	@Test(priority = 1)
	public void test_01_AddNewPet() {

		Response res = Methods.addPetToTheStore(an);
		int statusCode = res.getStatusCode();
		pet_id = res.jsonPath().get("id").toString();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 2)
	public void test_02_getCreatedPetWithId() {

		Response res = Methods.getPetWithId(pet_id);
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 3)
	public void test_03_uploadPhoto() {

		String path = "";
		Response res = Methods.uploadPhoto(pet_id);
		Assert.assertTrue(res.statusCode() == 200);

	}

	@Test(priority = 4)
	public void test_04_updatePet() {

		an.setId(pet_id);
		an.setCategory("id", "33");
		an.setCategory("name", "cat");
		an.setName("zef");
		int size = an.PhotosListSize();
		an.removeAllPhotoUrls(size);
		an.setPhotoUrls("www.instagram.com");
		an.setPhotoUrls("www.facebook.com");
		HashMap<String, String> tagMap = new HashMap<String, String>();
		tagMap.put("id", "20");
		tagMap.put("name", f.name().username());
		an.setTags(tagMap);
		an.setStatus("available");
		Response res = Methods.updatePet(an);
		int statusCode = res.getStatusCode();
		Assert.assertTrue(res.statusCode() == 200);
	}

	@Test(priority = 5)
	public void test_05_getPetWithId_AfterUpdate() {

		Response res = Methods.getPetWithId(pet_id);
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		res.then().log().all();
	}

}
