package api;

public class Routes {

public static String url="https://petstore.swagger.io/v2";
public static String getByStatus=url+"/pet/findByStatus?status=available";
public static String post = "https://petstore.swagger.io/v2/pet";
public static String getById=url+"/pet/{petId}";
public static String addImg=url+"/pet/{petId}/uploadImage";
public static String update=url+"/pet";
	

}
