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
        assertEquals(4, houseBuilder.getResult().getWalls());
    }

    @Test
    public void buildDoors() {
        houseBuilder.buildDoors(2);
        assertEquals(2, houseBuilder.getResult().getDoors());
    }

    @Test
    public void buildWondows() {
        houseBuilder.buildWondows(3);
        assertEquals(3, houseBuilder.getResult().getWindows());
    }

    @Test
    public void buildRoof() {
        houseBuilder.buildRoof(true);
        assertEquals(true, houseBuilder.getResult().isRoof());
    }

    @Test
    public void buildGarage() {
        houseBuilder.buildGarage(false);
        assertEquals(false, houseBuilder.getResult().isGarage());
    }

    @Test
    public void getResult() {
        // Проверяется паттерн Строитель, в общем случае не всегда известно какой именно объект возвратит Строитель.
        // Вернуться к этой проверке позже.
        assertTrue(houseBuilder.getResult() instanceof House );
    }
}