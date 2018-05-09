package demo.helper;

import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;

public interface IReadData {
    Pair<String, String> readElement() throws IOException;
    HashMap<String, String> readAllElement() throws IOException;
}
