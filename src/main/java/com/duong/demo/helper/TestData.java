package com.duong.demo.helper;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TestData {
    public static HashMap<String, String> metaData = new HashMap<>();
    IReadData reader;
    private TestData(String testData)  {
        try {
            FileReader fileReader = new FileReader(testData);
            if(testData.contains("csv")){
                reader = new CSVRead(fileReader);
            }
            metaData = reader.readAllElement();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readData(String testData){
        TestData data = new TestData(testData);
    }

}
