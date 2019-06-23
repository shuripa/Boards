package inout;

import panes.PlanElement;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlanCsvLoader {

    ArrayList<PlanElement> arrPlan;
    String line;
    String fileName = "src\\main\\resources\\planB9E.csv";
    public PlanCsvLoader() throws IOException {
        arrPlan = new ArrayList<>();
        Path path = Paths.get("src\\main\\resources\\");
//        String s = String.valueOf(Files.lines(Paths.get(fileName, "csv"), StandardCharsets.UTF_8));

        List<String> lines;
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

//        FileReader fr= new FileReader("src\\PizzaStore\\resources\\planB9E.csv");
//        Scanner sc = new Scanner(fr);

        for (String l: lines) {
            String[] tokens = l.split(";");
            String[] s = tokens[2].split(",");
            String tm;
            if (s.length > 1) {
                tm = s[0] + "." + s[1];
            } else {
                tm = s[0];
            }
            arrPlan.add(new PlanElement(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tm)));
        }

//        while (sc.hasNextLine()){
//            line = sc.nextLine();
//
//        }

//        fr.close();

//        for (PlanElement pe: arrPlan) {
//            System.out.println("М: " + pe.getModul() + ", C: " + pe.getCount() +", T: " + pe.getEttime());
//        }
    }

    public ArrayList<PlanElement> getArrPlan() {
        return arrPlan;
    }

}
