package examples.House;

public class HouseBuilder {
    House house;

    public HouseBuilder() {
        house = new House();
    }

    void buildWalls(int walls){
        house.setWalls(walls);
    }

    void buildDoors(int doors){
        house.setDoors(doors);
    }

    void buildWondows(int windows){
        house.setWindows(windows);
    }

    void buildRoof(boolean roof){
        house.setRoof(roof);
    }

    void buildGarage(boolean garage){
        house.setGarage(garage);
    }

    public House getResult (){
        return house;
    }

}
