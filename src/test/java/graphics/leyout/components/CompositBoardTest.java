package graphics.leyout.components;

import inout.CompositBuilder;
import inout.EmployesCsvLoader;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertTrue;

/*Проверка двух методов создания CompositBoard*/

public class CompositBoardTest {
    CompositBoard cb1, cb2;

    public CompositBoardTest() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EmployesCsvLoader employes = EmployesCsvLoader.getInstance();                   // Загрузка работников
        cb1 = new CompositBoard();
        cb1.setTitle("KM 034Cb");
        cb1.setId("1211");
        //TODO условие логично.
        cb1.setCondition("MFC1847034***");
        //TODO это лишний шаг. возможно пора его завершить.
        cb1.setProc(50);
        cb1.logining(employes.getEmployerByID("12630"));

        //TODO в builder-е пока не реализовано условия и связи. Дополнить тест позже.
        CompositBuilder builder = new CompositBuilder(1212, "CompositBoard").title("KM 035Cb")
                .assigned(12713).condition("MFC1847034***");
        cb2 = (CompositBoard) builder.build();

    }

    @Test
    public void getBoard() {
    }

    @Test
    public void getWorkPlace() {
    }

    @Test
    public void getBoardIndex() {
    }

    @Test
    public void getGrid() {
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void getTitle() {
        assertTrue("KM 034Cb".equals(cb1.getTitle()));
        assertTrue("KM 035Cb".equals(cb2.getTitle()));
    }

    @Test
    public void setId() {
    }

    @Test
    public void getId() {
        assertTrue("1211".equals(cb1.getId()));
        assertTrue("1212".equals(cb2.getId()));
    }

    @Test
    public void setCondition() {
    }

    @Test
    public void testSetCondition() {
    }

    @Test
    public void getCondition() {
        assertTrue("MFC1847034***".equals(cb1.condition().getConditionString()));
        assertTrue("MFC1847034***".equals(cb2.condition().getConditionString()));
    }

    @Test
    public void setProc() {
    }
    //</editor-fold>

    @Test
    public void getEffectivity() {
    }

    @Test
    public void getCountFreeWorkPlace() {
    }

    @Test
    public void testToString() {
    }
}