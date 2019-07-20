package inout;

import model.Material;
import model.Order;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 0	ERPNr
 * 1	MAONr
 * 2	PartNbr
 * 3	Quantity
 * 4	Prio
 * 5	OrderTime
 * 6	Status
 * 7	Workplace
 * 8	MasterNr
 * 9	Order_Class
 * 10	PLAINTEXT
 * 11	SUBCONTRACTOR
 * 12	TARGET
 * 13	TARGETDATE
 * 14	Time/1Pc
 * 15	OPTMODE
 * 16	PLANMACH
 * 17	Workplace_Group
 * 18	Subsystem_Status
 * 19	OPERATOR1
 * 20	OPERATOR2
 * 21	BatchSize
 * 22	Produced
 * 23	In_Production
 * 24	DESCRIPTION
 * 25	RELEASED
 * 26	INS_DATE
 * 27	INS_USER
 * 28	OPT_DATE
 * 29	OPT_USER
 * 30	PRD_DATE
 * 31	END_DATE
 * 32	CAN_DATE
 * 33	CAN_USER
 * 34	RST_DATE
 * 35	RST_USER
 * 36	PRIO_DATE
 * 37	PRIO_USER
 * 38	VLD_USER
 * 39	VLD_COMMENTS
 */

public class MaoQueryOrderLoader {

    HashMap<String,ArrayList<Order>> maoOrders;


    String fileName = "src\\main\\resources\\qo1.csv";
    List<String> lines;
    String[] tokens;
    static MaoQueryOrderLoader instance;


    private MaoQueryOrderLoader() throws IOException {
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        boolean firstline = true;
        maoOrders = new HashMap<>();

        for (String l: lines) {
            if ( firstline == false ) {
                tokens = l.split(";");
                if (!maoOrders.containsKey(tokens[16])){
                    maoOrders.put(tokens[16], new ArrayList<>());
                }
//              Замена запятой на точку
                String[] temps = tokens[5].split(",");
                String chTemps;
                
                if (temps.length > 1) {
                    chTemps = temps[0] + "." + temps[1];
                } else{
                    chTemps = temps[0];
                }

//              int id, Material material, int count, double etalonTime
                maoOrders.get(tokens[16]).
                        add(
                                new Order(
                                        Integer.parseInt(tokens[1]),
                                        new Material(tokens[2]),
                                        Integer.parseInt(tokens[3]),
                                        Double.parseDouble(chTemps)
                                )
                        );

            } else {
                firstline = false;
            }
        }
    }

    public static MaoQueryOrderLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new MaoQueryOrderLoader();
        }
        return instance;
    }

    public ArrayList<Order> getOrders(String title) {
        if (maoOrders.containsKey(title)){
            return maoOrders.get(title);
        } else
        return null;
    }

}
