package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class EmployerTest {
    Employer em1;

    /*
    1. Skill содержит метод getMaterialBlank() т.е. скил предназначен для хранения шаблонов в любой их форме,
    в т.ч. если задан не шаблон а конкретный материал. Продуктивность хранится в скиле и имеет тип Double.
    2. Employer содержит два метода getProductivity с возварщаемыми типами Double и int с параметрами
    Material и WorkPlacedComposit соответственно.

    */


    public EmployerTest(){
        em1 = new Employer("12630", "Korchinskiy Andriy", "555-555-555", "C", Profession.BINDER, "Audi", "1910");
        em1.setSkill(new Skill(em1, "MFC1847087***", 110, 85));
        em1.setSkill(new Skill(em1, "MFC1847081***", 110, 79));
        em1.setSkill(new Skill(em1, "MFC1847164***", 110, 97));
    }

    @Test
    public void getId() {
        assertTrue("12630".equals(em1.getId()));
    }

//    @Test
//    public void setId() {
//        em1.setId("12671");
//        assertTrue("12671".equals(em1.getId()));
//    }

    @Test
    public void idProperty() {
        assertTrue("12630".equals(em1.idProperty().get()));
    }

    @Test
    public void getName() {
        assertTrue("Korchinskiy Andriy".equals(em1.getName()));
    }

    @Test
    public void setName() {
        em1.setName("Korchinska Irina");
        assertTrue("Korchinska Irina".equals(em1.getName()));
    }

    @Test
    public void nameProperty() {
        assertTrue("Korchinskiy Andriy".equals(em1.nameProperty().get()));
    }

    @Test
    public void getPhone() {
        assertTrue("555-555-555".equals(em1.getPhone()));
    }

    @Test
    public void setPhone() {
        em1.setPhone("666-666-666");
        assertTrue("666-666-666".equals(em1.getPhone()));
    }

    @Test
    public void phoneProperty() {
        assertTrue("555-555-555".equals(em1.phoneProperty().get()));
    }

    @Test
    public void getShift() {
        assertTrue("C".equals(em1.getShift()));
    }

    @Test
    public void setShift() {
        em1.setShift("B");
        assertTrue("B".equals(em1.getShift()));
    }

    @Test
    public void shiftProperty() {
        assertTrue("C".equals(em1.shiftProperty().get()));
    }

    @Test
    public void getBindWorkPlaces() {
    }

    @Test
    public void isActivated() {
        assertTrue(false == em1.isActivated());
    }

    @Test
    public void isLogined() {
        assertTrue(false == em1.isLogined());
    }

    @Test
    public void activatedProperty() {
        assertTrue(false == em1.activatedProperty().get());
    }

    @Test
    public void setActivated() {
        em1.setActivated(true);
        assertTrue(true == em1.isActivated());
    }

    @Test
    public void setSkill() {
        em1.setSkill(new Skill(em1, "MFC1847089***", 110, 85));
        assertTrue(85.0 == em1.productivity(new Material("MFC1847089***")));
    }

    @Test
    public void getSkills() {
        Collection<Skill> s = em1.getSkills();
        assertTrue(3 == s.size());
    }

    @Test
    public void getSortedSkills() {
        ArrayList<Skill> skills = em1.getSortedSkills();
        assertTrue("MFC1847164***".equals(skills.get(0).getMaterialBlank()));       //97
        assertTrue("MFC1847087***".equals(skills.get(1).getMaterialBlank()));       //85
        assertTrue("MFC1847081***".equals(skills.get(2).getMaterialBlank()));       //79
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
    public void getWorkPlase() {
    }

    @Test
    public void setWorkPlace() {
    }

    @Test
    public void free() {
    }

    @Test
    public void getProfession() {
        assertTrue(Profession.BINDER.equals(em1.getProfession()));
    }

    @Test
    public void testToString() {
    }
}