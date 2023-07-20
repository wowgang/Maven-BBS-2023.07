package utillity;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class JSONTest {
	
	public static void main(String[] args) {
		JsonUtil ju = new JsonUtil();
		List<String> list = new ArrayList<>();
		list.add("apple"); list.add("banana"); list.add("cherry");
		String jStr = ju.listToJson(list);
		System.out.println(jStr);
		
		list = ju.jsonToList(jStr);
		list.forEach(x -> System.out.println(x));
	}
}
