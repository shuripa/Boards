package graphics.leyout.components;

import inout.CompositBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositMaoTest {
    CompositMao mao1, mao2;

    public CompositMaoTest(){
        mao1 = new CompositMao();
        mao1.setTitle("UO_MB23");
//        mao1.addCondition("MFC1847087***");

        //TODO Builder условия пока не поддерживает. Дополнить тест позже.
        CompositBuilder builder = new CompositBuilder(4012, "UO_MB12", "CompositMao");
        mao2 = new CompositMao(builder);
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void getTitle() {
        assertEquals("UO_MB23", mao1.getTitle());
        assertEquals("UO_MB12", mao2.getTitle());
    }

    @Test
    public void titleProperty() {
    }

    @Test
    public void addCondition() {
    }

    @Test
    public void addOrder() {
    }

    @Test
    public void getOrders() {
    }

    @Test
    public void testGetOrders() {
    }

    @Test
    public void addBoard() {
    }

    @Test
    public void isContainBoard() {
    }

    @Test
    public void testToString() {
    }
}