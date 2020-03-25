package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrdersTest {


    Orders orders;
    Employee employee;

    public OrdersTest(){
        orders = new Orders();
        orders.addOrder(new Order(1, new Material("MFC225317A0B" ), 25, 5.7));
        orders.addOrder(new Order(1, new Material("MFC271012A0C" ), 30, 15.5));

        employee = new Employee("12713", "", "6801020304", "C", Profession.BINDER, "C8", "C8","1271", "1272");
        employee.setSkill(new Skill(employee, "MFC225317A0B", 110, 75));
        employee.setSkill(new Skill(employee, "MFC271012A0C", 110, 60));
    }

    @Test
    public void addOrder() {
        orders.addOrder(new Order(1, new Material("MFC225517C0A" ), 15, 10.3));
    }

    @Test
    public void totalEtalonTime() {
        assertEquals(orders.totalEtalonTime(), 142.5 + 465, 0.0);
    }

    @Test
    public void totalEtalonTimeToShift() {
        assertEquals(1.3, orders.totalEtalonTimeToShift(480), 0.0);
    }

    @Test
    public void agrEmployerTime() {
        assertEquals(16.09, orders.agrEmployerTime(employee), 0.0);
    }

    @Test
    public void agrEmployerTimeToShift() {
        assertEquals(2.1, orders.agrEmployerTimeToShift(employee, 480), 0.0);
    }

    @Test
    public void tableRecords() {
        assertEquals(("\nMFC225317A0B - 25 : 5.7 * 75.0% = 3.17 год\nMFC271012A0C - 30 : 15.5 * 60.0% = 12.92 год"), orders.tableRecords(employee));
    }

    @Test
    public void orderSummaryBlock() {
//        System.out.println(orders.orderSummaryBlock(employee));
        assertEquals("\n Сумарний час потужності: 1.3 змін\n Сумарний робочий час: 2.1 змін", orders.orderSummaryBlock(employee));
    }

    @Test
    public void update() {
    }
}