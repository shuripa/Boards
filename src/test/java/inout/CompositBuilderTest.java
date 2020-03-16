package inout;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/* Проверка работоспособности и типа всех предусмотренных методов класса*/

public class CompositBuilderTest {
    CompositBuilder builder, builder2;

    public CompositBuilderTest(){
        //TODO не созданы Связи и не использован метод build.
        // Пока не тестируются сеттеры.
        builder = new CompositBuilder(1219, "CompositBoard").parid(1220).title("KM 035Cb")
                .assigned(12713).profession("Binder").leafs(3).cards(2).side("Left").stepLevel(4)
                .stepName("Binding module").xyas(100, 200, 180, 60).condition("MFC1802012***");
    }

    @Test
    public void title() {
        assertTrue("KM 035Cb".equals(builder.getTitle()));
    }

    @Test
    public void xyas() {
        assertTrue(100 == builder.getX());
        assertTrue(200 == builder.getY());
        assertTrue(180 == builder.getA());
        assertTrue(60 == builder.getS());
    }

    @Test
    public void leafs() {

    }

    @Test
    public void cards() {

    }

    @Test
    public void assigned() {

    }

    @Test
    public void profession() {

    }

    @Test
    public void side() {

    }

    @Test
    public void parid() {

    }

    @Test
    public void stepName() {

    }

    @Test
    public void stepLevel() {

    }

    @Test
    public void conditions() {
    }

    @Test
    public void bindings() {
    }

    @Test
    public void getId() {
        assertTrue(1219 == builder.getId());
    }

    @Test
    public void getTp() {
        assertTrue("CompositBoard".equals(builder.getTp()));
    }

    @Test
    public void getTitle() {
        assertTrue("KM 035Cb".equals(builder.getTitle()));
    }

    @Test
    public void getX() {
        assertTrue(100 == builder.getX());
    }

    @Test
    public void getY() {
        assertTrue(200 == builder.getY());
    }

    @Test
    public void getA() {
        assertTrue(180 == builder.getA());
    }

    @Test
    public void getS() {
        assertTrue(60 == builder.getS());
    }

    @Test
    public void getLeafs() {
        assertTrue(3 == builder.getLeafs());
    }

    @Test
    public void getCards() {
        assertTrue(2 == builder.getCards());
    }

    @Test
    public void getEmployer() {
        assertTrue(12713 == builder.getEmployer());
    }

    @Test
    public void getProfession() {
        assertTrue("Binder".equals(builder.getProfession()));
    }

    @Test
    public void getSide() {
        assertTrue("Left".equals(builder.getSide()));
    }

    @Test
    public void getParid() {
        assertTrue(1220 == builder.getParid());
    }

    @Test
    public void getStepName() {
        assertTrue("Binding module".equals(builder.getStepName()));
    }

    @Test
    public void getStepLevel() {
        assertTrue(4 == builder.getStepLevel());
    }

    @Test
    public void getConditions() {
//        int size = builder.getConditions().size();
        assertTrue("MFC1802012***".equals(builder.getCondition()));
    }

    @Test
    public void getBindings() {
    }

    @Test
    public void build() {
    }
}