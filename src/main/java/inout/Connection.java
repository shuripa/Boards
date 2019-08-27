package inout;

import graphics.leyout.components.LeyoutComponent;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;

public class Connection {
    private HashMap<Integer, CompositBuilder> builders;
    CompositBuilder builder;
    private String url = "jdbc:sqlserver://localhost;databaseName=boards;user=shur;password=shur";
    java.sql.Connection con;
    Statement snt;
    ResultSet set;

    public boolean connect() {
        con = null;
        boolean result = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            metadata();
            snt = con.createStatement();
            set = snt.executeQuery("SELECT * FROM components;");
            building();
            result = true;
        } catch (Exception e) {
            SQLException ex = new SQLException("Error Establishing Connection: " + e.getMessage());
            System.out.println("Error" + e);
            result = false;
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    private void building() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //            Statement, Resultset
        builders = new HashMap<>();

        String  tp, title, prof, side, stepName;
        int id, pid, eid, x, y, a, s, l, c, stepLvl;
        LeyoutComponent component;

        while (set.next()){
            id = set.getInt("id");
            tp = (set.getString("tp")).trim();
            title = (set.getString("ttl")).trim();
            pid = set.getInt("pid");
            x = set.getInt("x");
            y = set.getInt("y");
            a = set.getInt("a");
            s = set.getInt("s");
            l = set.getInt("l");
            c = set.getInt("c");
            eid = set.getInt("emp");
            prof = (set.getString("prof")).trim();
            side = (set.getString("side")).trim();
            stepLvl = set.getInt("steplvl");
            stepName = (set.getString("stepname")).trim();

            System.out.println(id + "  " + title + " " +  tp + " x: " + x + ", y: " + y + ", a: " +  a + ", s: " + s);

            builder = new CompositBuilder(id, tp).title(title).parid(pid)
                    .xyas(x, y, a, s).leafs(l).cards(c).assigned(eid).profession(prof)
                    .side(side).stepLevel(stepLvl).stepName(stepName);
            component = builder.build();
            builders.put(id, builder);
        }
    }

    private void metadata() throws SQLException {
        //            Metadata
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println( "\nConnected with " +
            dbmd.getDriverName() + " " + dbmd.getDriverVersion()
            + "{ " + dbmd.getDriverMajorVersion() + "," +
            dbmd.getDriverMinorVersion() +" }" + " to " +
            dbmd.getDatabaseProductName() + " " +
            dbmd.getDatabaseProductVersion() + "\n");
    }

    public static void main(String[] args) {
        Connection connection = new Connection();
        connection.connect();
    }

}
