package surefire;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredsHandler {

    private static Properties prop = new Properties();

    public static String getProperty(String name){
        try (InputStream input = new FileInputStream("creds.properties")){
            prop.load(input);
            return prop.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
