package com.duong.demo.helper;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class CSVRead implements IReadData{
    private CSVReader reader;

    public CSVRead(FileReader fileReader){
        reader = new CSVReader(fileReader);
    }


    @Override
    public HashMap<String, String> readAllElement() throws IOException {
        HashMap<String, String> data = new HashMap<>();
        String[] row = null;
        List content = reader.readAll();
        for (Object object : content) {
            row = (String[]) object;
            data.put(row[0], row[1]);
        }
        reader.close();
        return data;
    }

}
