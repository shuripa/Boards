package examples.movies;

public class Movie {
    public static final int REGULAR = 0;        //Обычные
    public static final int NEW_RELEASE = 1;    //Новинки
    public static final int CHILDRENS = 2;      //Детские

    private String _title;                       //Название
    private int _priceCode;                      //?
    private Price _price;

    public Movie (String title, int priceCode){
        _title = title;
        set_priceCode(priceCode);
    }

    public int get_priceCode(){
        return _priceCode;
    }

    public void set_priceCode(int arg){
        switch (arg){
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorect price code");
        }
        _priceCode = arg;
    }

    public String get_title(){
        return _title;
    }

    public double getCharge(int daysRented){
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented){
        return _price.getFrequentRenterPoints(daysRented);
    }

}
