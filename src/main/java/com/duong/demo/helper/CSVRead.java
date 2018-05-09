package com.duong.demo.helper;

import au.com.bytecode.opencsv.CSVReader;
import javafx.util.Pair;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVRead implements IReadData{
    private CSVReader reader;

    public CSVRead(FileReader fileReader){
        reader = new CSVReader(fileReader);
    }

    @Override
    public Pair<String, String> readElement() throws IOException {
        String[] row = null;
        row = reader.readNext();
        return new Pair<>(row[0], row[1]);
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
