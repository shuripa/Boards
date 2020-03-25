package sets;

import model.Employee;
import model.Profession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class SetEmployeesTest {
    SetEmployees set;


    public SetEmployeesTest(){
        set = SetEmployees.getInstance();
    }

    @Test
    public void getInstance() {
        assertTrue(set != null);
    }

    @Test
    public void addEmployer() {
        Employee e = new Employee("12713", "Some Employer","096-089-10-20", "C", Profession.BINDER, "B9", "3150");
        set.addEmployee(e);
        assertTrue(e == set.getEmployeeByID(e.getId()));
    }

    @Test
    public void getEmployeeByID() {
        assertEquals("Employee{id=12700, name=Пліско Ольга, phone=(068)333-13-27, shift=C}" , set.getEmployeeByID("12700").toString());
    }

    @Test
    public void getEmployees() {
        ArrayList<Employee> employees = set.getEmployees();
        assertEquals("Optional[Employee{id=12700, name=Пліско Ольга, phone=(068)333-13-27, shift=C}]",
                employees.stream()
                        .filter(employee -> "12700".equals(employee.getId()))
                        .findFirst()
                        .toString()
        );
    }

    @Test
    public void getBufferEmploers() {
        Buffer<Employee> bf =set.getBufferEmploers();
        assertFalse(bf.isEmpty());
    }

    @Test
    public void iterator() {
        Iterator<String> i = set.iterator();
        assertTrue(i.hasNext());
    }
}