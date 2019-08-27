package examples.House;

import org.junit.Test;

import static org.junit.Assert.*;

public class HouseBuilderTest {
    HouseBuilder houseBuilder;

    public HouseBuilderTest(){
        houseBuilder = new HouseBuilder();
    }

    @Test
    public void buildWalls() {
        houseBuilder.buildWalls(4);
        assertTrue(houseBuilder.getResult().getWalls() == 4);
    }

    @Test
    public void buildDoors() {
        houseBuilder.buildDoors(2);
        assertTrue(houseBuilder.getResult().getDoors() == 2);
    }

    @Test
    public void buildWondows() {
        houseBuilder.buildWondows(3);
        assertTrue(houseBuilder.getResult().getWindows() == 3);
    }

    @Test
    public void buildRoof() {
        houseBuilder.buildRoof(true);
        assertTrue(houseBuilder.getResult().isRoof() == true);
    }

    @Test
    public void buildGarage() {
        houseBuilder.buildGarage(false);
        assertTrue(houseBuilder.getResult().isGarage() == false);
    }

    @Test
    public void getResult() {
        // Проверяется паттерн Строитель, в общем случае не всегда известно какой именно объект возвратит Строитель.
        // Вернуться к этой проверке позже.
        assertTrue(houseBuilder.getResult() instanceof House );
    }
}