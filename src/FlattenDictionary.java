

import java.util.HashMap;

public class FlattenDictionary {

	/*
input:  dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : "1"
                }
            }
        }

output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
        }
	 */

	static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
		HashMap<String, String> flatDictionary = new HashMap<String, String>();

		flattenDictionaryHelper("", dict, flatDictionary);

		return flatDictionary;

	}

	static HashMap<String, String> flattenDictionaryHelper(String initialKey, HashMap<String, Object> dict,
			HashMap<String, String> flatDictionary) {
		Object value;
		for (String key : dict.keySet()) {

			value = dict.get(key);

			if (!isDictionary(value)) // test if the value is of a String of integer
			{
				if (initialKey == null || initialKey == "")
					flatDictionary.put(key, (String) value);
				else
					flatDictionary.put(initialKey + "." + key, (String) value);
			} else {

				if (initialKey == null || initialKey == "")

					flattenDictionaryHelper(key, (HashMap <String, Object>) value, flatDictionary);
				else

					flattenDictionaryHelper(initialKey + "." + key, (HashMap<String, Object>) value, flatDictionary);
			}
		}

		return flatDictionary;
	}

	//

	// test if the value is of a String of integer
	private static boolean isDictionary(Object value) {
		
	   String s=(String)value;
	   if (s.matches("/d"))
		return true;
	   return false;
	}

}
