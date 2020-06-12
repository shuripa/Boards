package sets.stock;

import java.util.HashMap;

public class Transactions {
    //Ключ пока не придуман дата+время+номер. Числа такого размера нет. Поэтому тут строка.
    //20170815/231610/0 -> 201 708 152 316 100 -> 1 708 152 316 109  Дата * 10 000 000 + Время * 10 + Номер
    Integer nextNo;
    Transaction action;
    Boolean faction = false;
    long key;
    HashMap<Long, Transaction> transaction = new HashMap<>();


    protected void setTransaction(Integer date, Integer time, Double amt, Double rst, String kod, String user){
        faction = false;
        if (transaction.containsKey(date*10000000+time*10)){

            for (int i = 0; i < 9; i++) {
                if (transaction.containsKey(date*10000000+time*10 +i)){
                    action = transaction.get(date*10000000+time*10 +i);
                    if ((amt == action.getAmt()) && (rst == action.getRst())){
                        faction = true;
                    }
                    nextNo = i+1;
                }
            }

        } else nextNo = 0;

        if(faction = false){
            action = new Transaction(amt, rst, kod, user);
            key = date*10000000+time*10+nextNo;
            transaction.put(key, action);
        }

    }

}
