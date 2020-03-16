package examples.movies;

public class NewReleasePrice extends Price{

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3)*1.5;
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented>1 ? 2 : 1;
    }
}
