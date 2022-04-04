package utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //1- peoperties objesi oluşturcaz
   static  Properties properties;
    //2- bu clas ın amacı configuratin properties dosasını okumak
    // ve oradaki key value ikiliklerini kullanarak istediğimiz key e
    // ait value bize getirmek
     static {
         String dosyaYolu="configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
            properties =new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //3- test class larından configReader class ına ulaşıp yukarıdaki işlemleri yapmamızı sağlayacak
    // bir method oluşturacağız.
          public static String getProperty(String key){
         String value=properties.getProperty(key);
         return value;
          }

}
