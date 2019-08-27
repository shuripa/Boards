package graphics.leyout.components;

import inout.CompositBuilder;
import inout.EmployesCsvLoader;
import model.Condition;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/*Проверка двух методов создания CompositBoard*/

public class CompositBoardTest {
    CompositBoard cb1, cb2;

    public CompositBoardTest() throws IOException {
        EmployesCsvLoader employes = EmployesCsvLoader.getInstance();                   // Загрузка работников
        cb1 = new CompositBoard();
        cb1.setTitle("KM 034Cb");
        cb1.setId("1211");
        //TODO условие логично.
        cb1.setCondition(new Condition("MFC1847034***", 110));
        //TODO это лишний шаг. возможно пора его завершить.
        cb1.setProc(50);
        cb1.logining(employes.getEmployerByID("12630"));

        //TODO в builder-е пока не реализовано условия и связи. Дополнить тест позже.
        CompositBuilder builder = new CompositBuilder(1212, "CompositBoard").title("KM 035Cb")
                .assigned(12713);
        try {
            cb2 = (CompositBoard) builder.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
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
    }

    @Test
    public void getConditions() {
    }

    @Test
    public void setProc() {
    }

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