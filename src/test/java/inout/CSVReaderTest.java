package inout;

import org.junit.Test;

import static org.junit.Assert.*;

public class CSVReaderTest {

    @Test
    public void create(){
        CSVReader reader = new CSVReader("src\\main\\resources\\14.Lagerbestand.csv", ",");
//        CSVReader reader = new CSVReader("main/resources/14.Lagerbestand.csv", ",");
        int count = 0;
        for (CSVReader it = reader; it.hasNext(); ) {
            String[] s = it.next();
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void readAllLines() {
    }

    @Test
    public void hasNext() {
    }

    @Test
    public void next() {
    }
}