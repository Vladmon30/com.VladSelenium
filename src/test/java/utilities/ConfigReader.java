package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public  static Properties properties;
    static {
                                        //this the path to the location of the file
        String path="config.properties";
        try {
                                        //java cannot read files directly, it needs inputstream to read files
                                        // inputstream takes the location of the file as a constructor
            FileInputStream fileInputStream=new FileInputStream(path);
                                         //Properties is used to read specifically properties files, files with key value pairs
            properties=new Properties();
                                        //file contents are load to properties from the inputstream
            properties.load(fileInputStream);
                                         //all inputstreams must be closed
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getProperty(String property){
// (String property) its just data inside config.properties folder what we save by key-value
// property is -->  browser, value is  -->  chrome
        return  properties.getProperty(property);
    }
}
