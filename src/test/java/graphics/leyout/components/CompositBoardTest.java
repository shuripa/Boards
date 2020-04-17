package graphics.leyout.components;

import inout.CompositBuilder;
import org.junit.Test;
import sets.SetEmployees;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

/*Проверка двух методов создания CompositBoard*/

public class CompositBoardTest {
    CompositBoard cb1, cb2;

    public CompositBoardTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SetEmployees employees = SetEmployees.getInstance();
        cb1 = new CompositBoard();
        cb1.setTitle("KM 034Cb");
        cb1.setId("1211");
        //TODO условие логично.
        cb1.setCondition("MFC1847034***");
        //TODO это лишний шаг. возможно пора его завершить.
        cb1.setProc(50);
        cb1.logining(employees.getEmployeeByID("12630"));

        //TODO в builder-е пока не реализовано условия и связи. Дополнить тест позже.
        CompositBuilder builder = new CompositBuilder(1212, "CompositBoard").title("KM 035Cb")
                .employer(12713).condition("MFC1847034***");
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
        assertEquals("KM 034Cb", (cb1.getTitle()));
        assertEquals("KM 035Cb", (cb2.getTitle()));
    }

    @Test
    public void setId() {
    }

    @Test
    public void getId() {
        assertEquals("1211", (cb1.getId()));
        assertEquals("1212", (cb2.getId()));
    }

    @Test
    public void setCondition() {
    }

    @Test
    public void testSetCondition() {
    }

    @Test
    public void getCondition() {
        assertEquals("MFC1847034***", cb1.condition().getConditionAsString());
        assertEquals("MFC1847034***", cb2.condition().getConditionAsString());
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