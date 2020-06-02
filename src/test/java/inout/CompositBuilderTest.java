package inout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/* Проверка работоспособности и типа всех предусмотренных методов класса*/

public class CompositBuilderTest {
    CompositBuilder builder, builder2;

    public CompositBuilderTest(){
        //TODO не созданы Связи и не использован метод build.
        // Пока не тестируются сеттеры.
        builder = new CompositBuilder(1219, "KM 035Cb","CompositBoard").parid(1220)
                .employer(12713).profession("Binder").leafs(3).cards(2).side("Left").stepLevel(4)
                .stepName("Binding module").xyas(100, 200, 180, 60).condition("MFC1802012***");
    }

    @Test
    public void title() {
        assertEquals("KM 035Cb", builder.getTitle());
    }

    @Test
    public void xyas() {
        assertEquals(100, builder.getX());
        assertEquals(200, builder.getY());
        assertEquals(180, builder.getA());
        assertEquals(60, builder.getS());
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
        assertEquals(1219, builder.getId());
    }

    @Test
    public void getTp() {
        assertEquals("CompositBoard", builder.getType());
    }

    @Test
    public void getTitle() {
        assertEquals("KM 035Cb", builder.getTitle());
    }

    @Test
    public void getX() {
        assertEquals(100, builder.getX());
    }

    @Test
    public void getY() {
        assertEquals(200, builder.getY());
    }

    @Test
    public void getA() {
        assertEquals(180, builder.getA());
    }

    @Test
    public void getS() {
        assertEquals(60, builder.getS());
    }

    @Test
    public void getLeafs() {
        assertEquals(3, builder.getLeafs());
    }

    @Test
    public void getCards() {
        assertEquals(2, builder.getCards());
    }

    @Test
    public void getEmployer() {
        assertEquals(12713, builder.getEmployeeId());
    }

    @Test
    public void getProfession() {
        assertEquals("Binder", builder.getProfession());
    }

    @Test
    public void getSide() {
        assertEquals("Left", builder.getSide());
    }

    @Test
    public void getParid() {
        assertEquals(1220, builder.getParid());
    }

    @Test
    public void getStepName() {
        assertEquals("Binding module", builder.getStepName());
    }

    @Test
    public void getStepLevel() {
        assertEquals(4, builder.getStepLevel());
    }

    @Test
    public void getConditions() {
//        int size = builder.getConditions().size();
        assertEquals("MFC1802012***", builder.getConditionString());
    }

    @Test
    public void getBindings() {
    }

    @Test
    public void build() {
    }
}