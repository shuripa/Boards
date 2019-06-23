package stock;

public class Transaction {
    Integer date = 0;
    Integer time = 0;
    Integer no = 0;

    Double amt = 0.0; //Количество
    Double rst = 0.0; //Остаток
    String kod = "";
    String user= "";

    protected Transaction (Double amt, Double rst, String kod, String user){
        this.amt = amt;
        this.rst = rst;
        this.kod = kod;
        this.user = user;
    }

    protected Transaction (Integer date, Integer time, Integer no, Double amt, Double rst, String kod, String user){
        this.date = date;
        this.time = time;
        this.no = no;
        this.amt = amt;
        this.rst = rst;
        this.kod = kod;
        this.user = user;
    }

    protected Double getAmt(){
        return amt;
    }

    public Double getRst() {
        return rst;
    }
}
