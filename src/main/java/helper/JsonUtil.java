package helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {
	
	
	public static JsonObject getJsonObject(String str) {
		
		return JsonParser.parseString(str).getAsJsonObject();
	}

}
