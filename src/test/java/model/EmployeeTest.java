package model;

import graphics.leyout.components.WorkPlace;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    Employee em1;

    /*
    1. Skill содержит метод getMaterialBlank() т.е. скил предназначен для хранения шаблонов в любой их форме,
    в т.ч. если задан не шаблон а конкретный материал. Продуктивность хранится в скиле и имеет тип Double.
    2. Employer содержит два метода getProductivity с возварщаемыми типами Double и int с параметрами
    Material и WorkPlacedComposit соответственно.
    (3 - обов’язок працівника)До робочого місці прив’язується працівник. (Оскільки
    змін декілька, в кожній зміні може бути по привязаному працівникові, тобто
    привязок може бути багато)
    */


    public EmployeeTest(){
        em1 = new Employee("12630", "Korchinskiy Andriy", "555-555-555", "C", Profession.BINDER, "Audi", "1910");
        em1.setSkill(new Skill(em1, "MFC1847087***", 110, 85));
        em1.setSkill(new Skill(em1, "MFC1847081***", 110, 79));
        em1.setSkill(new Skill(em1, "MFC1847164***", 110, 97));
    }

    @Test
    public void getId() {
        assertEquals("12630", em1.getId());
    }

//    @Test
//    public void setId() {
//        em1.setId("12671");
//        assertTrue("12671".equals(em1.getId()));
//    }

    @Test
    public void idProperty() {
        assertEquals("12630", em1.idProperty().get());
    }

    @Test
    public void getName() {
        assertEquals("Korchinskiy Andriy", em1.getName());
    }

    @Test
    public void setName() {
        em1.setName("Korchinska Irina");
        assertEquals("Korchinska Irina", em1.getName());
    }

    @Test
    public void nameProperty() {
        assertEquals("Korchinskiy Andriy", em1.nameProperty().get());
    }

    @Test
    public void getPhone() {
        assertEquals("555-555-555", em1.getPhone());
    }

    @Test
    public void setPhone() {
        em1.setPhone("666-666-666");
        assertEquals("666-666-666", em1.getPhone());
    }

    @Test
    public void phoneProperty() {
        assertEquals("555-555-555", em1.phoneProperty().get());
    }

    @Test
    public void getShift() {
        assertEquals("C", em1.getShift());
    }

    @Test
    public void setShift() {
        em1.setShift("B");
        assertEquals("B", em1.getShift());
    }

    @Test
    public void shiftProperty() {
        assertEquals("C", em1.shiftProperty().get());
    }

    @Test
    public void getBindWorkPlaces() {
    }

    @Test
    public void isActivated() {
        assertEquals(false, em1.isActivated());
    }

    @Test
    public void isLogined() {
        assertEquals(false, em1.isLogined());
    }

    @Test
    public void activatedProperty() {
        assertEquals(false, em1.activatedProperty().get());
    }

    @Test
    public void setActivated() {
        em1.setActivated(true);
        assertEquals(true, em1.isActivated());
    }

    @Test
    public void setSkill() {
        em1.setSkill(new Skill(em1, "MFC1847089***", 110, 85));
        assertEquals(85.0, em1.productivity(new Material("MFC1847089***")), 0.0);
    }

    @Test
    public void getSkills() {
        Collection<Skill> s = em1.getSkills();
        assertEquals(3, s.size());
    }

    @Test
    public void getSortedSkills() {
        ArrayList<Skill> skills = em1.getSortedSkills();
        assertEquals("MFC1847164***", skills.get(0).getMaterialBlank());       //97
        assertEquals("MFC1847087***", skills.get(1).getMaterialBlank());       //85
        assertEquals("MFC1847081***", skills.get(2).getMaterialBlank());       //79
    }

    @Test
    public void getProductivityMaterial() {
    }

    @Test
    public void getProductivityComponent() {
//        12700
//        1525 - KM-25 - 85%
//        1910 - KM 217Cb - 54%
//        1913 - KM 164Cb - 54$%
//        1903 - KM087Cb -
    }

    @Test
    public void WorkPlace() {
        WorkPlace wp = new WorkPlace();
        System.out.println(wp.toString());
        wp.setEmployee(em1);
        System.out.println(wp.toString());
//        em1.setWorkPlace(wp);
    }

    @Test
    public void free() {
    }

    @Test
    public void getProfession() {
        assertEquals(Profession.BINDER, em1.getProfession());
    }

    @Test
    public void testToString() {
    }
}