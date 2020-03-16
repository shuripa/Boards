package examples.movies;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental (Movie movie, int daysRented){
        _movie = movie;
        _daysRented = daysRented;
    }

    public int get_daysRented(){
        return _daysRented;
    }

    public Movie get_movie(){
        return _movie;
    }

    public double getCharge(){
        return _movie.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints(){
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}
