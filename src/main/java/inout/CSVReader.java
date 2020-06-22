package inout;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader implements Iterator {
    private static final Logger logger = Logger.getLogger("MainApp");
    private List<String> lines;
    private int counter =0;
    String split;

    public CSVReader(String fileName, String split){
        this.split = split;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            Stream<String> stream = reader.lines();
            lines = stream.collect(Collectors.toCollection( ArrayList::new) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "File read error: " + fileName + ": string count = " + lines.size());
        }
        logger.log(Level.INFO, "File end. " + fileName + ": string count = " + lines.size());
    }

    @Override
    public boolean hasNext() {
        return counter < lines.size();
    }

    @Override
    public String[] next(){
        String[] result = null;
        if (hasNext()) {
            result = lines.get(counter).split(split);
            counter++;
        }
        return result;
    }
}
