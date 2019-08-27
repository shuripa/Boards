package inout;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionTest {

    @Test
    public void connect() {
        Connection con = new Connection();
        assertTrue(con.connect());
    }
}