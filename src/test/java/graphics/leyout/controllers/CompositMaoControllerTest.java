package graphics.leyout.controllers;

import graphics.leyout.components.CompositMao;
import inout.CompositBuilder;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CompositMaoControllerTest {

    CompositMao mao1, mao2;
    CompositMaoController controller1, controller2;

    public CompositMaoControllerTest() throws IOException {
//        TODO: контроллеры пока тестировать не возможно.
//        Родительский класс контроллера LeyoutComponentController содержит в конструкторе
//        подсказку Popup hint, которой для отображежия необходим Leyout.
//        Когда найдется решение - расскоментировать закомментированный код
        mao1 = new CompositMao();
        mao1.setTitle("UO_MB23");
//        mao1.addCondition("MFC1847087***");
        controller1 = new CompositMaoController(mao1);
        controller1.setXYAS(100, 200, 45, 60);

        //TODO Builder условия пока не поддерживает. Дополнить тест позже.
        CompositBuilder builder = new CompositBuilder(4012,"UO_MB12", "CompositMao")
                .xyas(200, 300, 90, 60);
        mao2 = new CompositMao(builder);
        controller2 = new CompositMaoController(mao2, builder);

    }

    @Test
    public void componentTest(){
        assertEquals("UO_MB23", ((CompositMao) controller1.component()).getTitle());
        assertEquals("UO_MB12", ((CompositMao) controller2.component()).getTitle());
    }

    @Test
    public void  builderTest(){
        assertEquals(100, controller1.X());
        assertEquals(200, controller1.Y());
        assertEquals(45, controller1.A());
        assertEquals(60, controller1.S());

        assertEquals(200, controller2.X());
        assertEquals(300, controller2.Y());
        assertEquals(90, controller2.A());
        assertEquals(60, controller2.S());
    }

    @Test
    public void setTitle() {

    }

    @Test
    public void setComponentProperties() {
    }

    @Test
    public void getConditions() {
    }
}