package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    Order order;
    Material material;
    Employee employee;

    public OrderTest(){
        material = new Material("MFC187001A0B");
        order = new Order(125125, material, 20, 25.5);
        employee = new Employee("12713", "Some Employer","096-089-10-20", "C", Profession.BINDER, "B9", "3150");
//        TODO: Дико виглядає, що в скіл потрібно передавати ще й робітника власника.
        employee.setSkill(new Skill(employee, "MFC187001A0B", 110, 75.0));
    }

    @Test
    public void getMaterial() {
//        TODO: Для класу Material відсутня перевірка еквівалентності і рівності двох класів
        assertTrue(material == order.getMaterial());
        Material test = new Material("MFC187001A0B");
        assertFalse(test == order.getMaterial());
    }

    @Test
    public void getTitle() {
        assertEquals("MFC187001A0B", order.getTitle());
    }

    @Test
    public void getCount() {
        assertTrue(20 == order.getCount());
    }

    @Test
    public void getEtalonTime() {
        assertTrue(25.5 == order.getEtalonTime());
    }

    @Test
    public void totalEtalonTime() {
        assertTrue(510 == order.totalEtalonTime());
    }

    @Test
    public void employerTime() {
        assertTrue(11.34 == order.employerTime(employee));
    }

    @Test
    public void orderRecord() {
//        TODO: orderRecord залежить від працівника що не зовсім корректно, потрібно перенести цей функціонал в клас Employee
        System.out.println(order.orderRecord(employee));
        assertEquals("\nMFC187001A0B - 20 : 25.5 * 75.0% = 11.34 год", order.orderRecord(employee));
    }

    @Test
    public void testToString() {
        assertEquals("125125, MFC187001A0B, 20, 25.5", order.toString());
    }
}