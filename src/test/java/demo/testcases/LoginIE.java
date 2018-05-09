package demo.testcases;

import demo.helper.TestData;

public class LoginIE extends Login {
    private final String DATA_PATH = "testdata/loginie.csv";

    @Override
    void init(){
        TestData.readData(DATA_PATH);
    }
}
