package inout;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class CSVReader implements Iterator {

    private List<String> lines;
    private int counter;

    public CSVReader(String fileName){
        counter = 0;
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return counter < lines.size();
    }

    @Override
    public String[] next(){
        String[] result = null;
        if (hasNext()) {
            result = lines.get(counter).split(";");
            counter++;
        }
        return result;
    }
}
