package utilities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;

    static { //En basta bir defa calisir
        mapper = new ObjectMapper();
    }

    //1. Method: JSON Data'sini Java Obje'sine cevirir.(De-Serialization)

    // Class<T> cls ==> Gelen data nin Type nin Object olarak degil kendi Type'i ile kullanilmasi icin create edildi
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls) {  //Generic Method
        T javaResult = null;

        try {
            javaResult = mapper.readValue(json, cls); //mapper obje'si cls yi okuyamazsam diye trycatch kullandi
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaResult;
    }


    //2. Method: Java Obje'sini JSON Data'sina cevirir.(Serialization)
    public static String convertJavaObjectToJson(Object obj) {
        String jsonResult = null;

        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
}
