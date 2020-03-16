package graphics.leyout.controllers;

import graphics.leyout.components.CompositMao;
import inout.CompositBuilder;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.assertTrue;

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
        CompositBuilder builder = new CompositBuilder(4012, "CompositMao").title("UO_MB12").xyas(200, 300, 90, 60);
        mao2 = new CompositMao(builder);
        controller2 = new CompositMaoController(mao2, builder);

    }

    @Test
    public void componentTest(){
        assertTrue("UO_MB23".equals(((CompositMao)controller1.component()).getTitle()));
        assertTrue("UO_MB12".equals(((CompositMao)controller2.component()).getTitle()));
    }

    @Test
    public void  builderTest(){
        assertTrue(100 == controller1.X());
        assertTrue(200 == controller1.Y());
        assertTrue(45 == controller1.A());
        assertTrue(60 == controller1.S());

        assertTrue(200 == controller2.X());
        assertTrue(300 == controller2.Y());
        assertTrue(90 == controller2.A());
        assertTrue(60 == controller2.S());
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