package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    public static Properties properties;

    static {
        String dosyaYolu = "configuration.properties";

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            //  fis dosyaYolu'nu tanimladigimiz configuration.properties dosyasini okudu
            properties = new Properties();
            properties.load(fis);  //fis'in okudugu bilgileri properties'e yukledi

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
/*
Test Method'undan yolladigimiz String key degerini alip Properties Class'indan getProperty()
 */
        return properties.getProperty(key);
    }
}
