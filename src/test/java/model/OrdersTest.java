package model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrdersTest {

    Orders orders;
    Employer employer;

    public OrdersTest(){
        orders = new Orders();
        orders.addOrder(new Order(1, new Material("MFC225317A0B" ), 25, 5.7));
        orders.addOrder(new Order(1, new Material("MFC271012A0C" ), 30, 15.5));

        employer = new Employer("12713", "", "6801020304", "C", Profession.BINDER, "C8", "C8","1271", "1272");
        employer.setSkill(new Skill(employer, "MFC225317A0B", 110, 75));
        employer.setSkill(new Skill(employer, "MFC271012A0C", 110, 60));
    }

    @Test
    public void addOrder() {
        orders.addOrder(new Order(1, new Material("MFC225517C0A" ), 15, 10.3));
    }

    @Test
    public void totalEtalonTime() {
        assertTrue(orders.totalEtalonTime() == 142.5+465);
    }

    @Test
    public void totalEtalonTimeToShift() {
        assertTrue(orders.totalEtalonTimeToShift(480) == 1.3);
    }

    @Test
    public void agrEmployerTime() {
        assertTrue(orders.agrEmployerTime(employer) == 0.02);
    }

    @Test
    public void agrEmployerTimeToShift() {
        assertTrue(orders.agrEmployerTimeToShift(employer, 480) == 0.1);
    }

    @Test
    public void tableRecords() {
        assertTrue(("\nMFC225317A0B - 25 : 5.7 * 75.0% = 0.01 год\nMFC271012A0C - 30 : 15.5 * 60.0% = 0.01 год").equals(orders.tableRecords(employer)));
    }

    @Test
    public void orderSummaryBlock() {
        System.out.println(orders.orderSummaryBlock(employer));
        assertTrue("\n Сумарний час потужності: 1.3 змін\n Сумарний робочий час: 0.1 змін".equals(orders.orderSummaryBlock(employer)));
    }

    @Test
    public void update() {
    }
}