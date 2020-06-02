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
    Statement stmt1, stmt2;
    ResultSet set1, set2;

    public boolean connect() {
        con = null;
        boolean result = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            metadata();
            stmt2 = con.createStatement();
            set2 = stmt2.executeQuery("SELECT * FROM components;");
            building();
            result = true;
        } catch (Exception e) {
            SQLException ex = new SQLException("Error Establishing Connection: " + e.getMessage());
            System.out.println("Error" + e);
            result = false;
        }

        try {
//            set.close();
//            stmt1.close();
//            stmt2.close();
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

        String  tp, title, prof, side, stepName, condition;
        int id, pid, eid, x, y, a, s, l, c, stepLvl;
        LeyoutComponent component;

        while (set2.next()){
            id = set2.getInt("id");
            tp = (set2.getString("tp")).trim();
            title = (set2.getString("ttl")).trim();
            pid = set2.getInt("pid");
            x = set2.getInt("x");
            y = set2.getInt("y");
            a = set2.getInt("a");
            s = set2.getInt("s");
            l = set2.getInt("l");
            c = set2.getInt("c");
            eid = set2.getInt("emp");
            prof = (set2.getString("prof")).trim();
            side = (set2.getString("side")).trim();
            stepLvl = set2.getInt("steplvl");
            stepName = (set2.getString("stepname")).trim();
            condition =(set2.getString("condition"));

            System.out.println(id + "  " + title + " " +  tp + " x: " + x + ", y: " + y + ", a: " +  a + ", s: " + s);

            builder = new CompositBuilder(id, title, tp)
                    .xyas(x, y, a, s).leafs(l).parid(pid).cards(c).employer(eid).profession(prof)
                    .side(side).stepLevel(stepLvl).stepName(stepName).condition(condition);
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
