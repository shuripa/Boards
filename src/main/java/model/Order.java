package model;

 /* Замовлення використовується в спрощеній формі. Не впроваджена різниця
 між замовленнями ХППС і МАО, які можуть бути розділені на частини. */

public class Order {
    private int id;
    private Material material;
    private double etalonTime;
    private int count;

    public Order(int id, Material material, int count, double etalonTime) {
        this.id = id;
        this.material = material;
        this.etalonTime = etalonTime;
        this.count = count;
    }

    public Material getMaterial() {
        return material;
    }

    public String getTitle() {
        return material.getTitle();
    }

    public Integer getCount() {
        return count;
    }

    public Double getEtalonTime() {
        return etalonTime;
    }

    public double totalEtalonTime(){      //Общее время заказа по еталонному времени
        return count * etalonTime;
    }

    public double employerTime(Employee employee){
        double result = .0;
        final double totalEmployerTime = totalEtalonTime() / employee.productivity(material) * 100;           //25*5 = 125, 125/75/100 = 166 //Время выполнения заказа работником минутах //TODO: не понятно ни название ни формула
        final double totalEmplpoyerTimeInHours = Math.ceil(totalEmployerTime / 0.6) / 100;                      //166 мин = (166*100/60)/100  166*100/60<=>166/0.6     //Перевод минут в часы и округление //TODO: не понятно ни название ни формула ни единицы измерения ни смысл рассчетов. Это отдельное результирующее значение или промежуточное?
        result += totalEmplpoyerTimeInHours;
        return result;
    }

    public String orderRecord(Employee employee){
        return "\n" + getMaterial() + " - "
                + getCount() + " : "
                + getEtalonTime() + " * "
                + employee.productivity(getMaterial()) + "% = "
                + employerTime(employee) + " год";
    }

    @Override
    public String toString() {
        return  "" + id +
                ", " + material.title +
                ", " + count +
                ", " + etalonTime;
    }
}
