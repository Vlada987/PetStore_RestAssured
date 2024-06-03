package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Animal {

	String id;
	Map<String, Object> category = new HashMap<String, Object>();
	String name;
	List<String> photoUrls = new ArrayList<String>();
	List<Map<String, String>> tags = new ArrayList<>();
	String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTags(HashMap<String, String> a) {

		tags.add(a);
	}

	public Map<String, Object> getCategory() {
		return category;
	}

	public void setCategory(String ob1, Object ob2) {
		category.put(ob1, ob2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(String url) {
		photoUrls.add(url);
	}

	public int PhotosListSize() {
		int size = photoUrls.size();
		return size;
	}

	public void removeAllPhotoUrls(int size) {

		try {
			for (int a = 0; a < size; a++) {
				photoUrls.remove(a);
			}
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
