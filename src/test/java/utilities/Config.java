package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
    private static Properties properties;

    static {
        String path = "config.properties";   //this the path to the location of the file

        try{
                 //java cannot read files directly, it needs inputstream to read files
                 // inputstream takes the location of the file as a constructor
            FileInputStream file = new FileInputStream(path);
                 //Properties is used to read specifically properties files, files with key value pairs
            properties = new Properties();
                 //file contents are load to properties from the inputstream
            properties.load(file);
                 //all inputstreams must be closed
            file.close();

        } catch (java.io.IOException e) {
            System.out.println("Path: " + path + "-not found");

        }
    }
    public static String getProperty(String key){
     // key its just data inside config.properties folder what we save by key-value
     // key is -->  browser, value is  -->  chrome

        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        String s = properties.getProperty("name");
        System.out.println(s);
    }
}
