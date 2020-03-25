package graphics.leyout.components;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Grid - "MaterialStore"
 * ТЗ: Grid має мати позиції для матеріалу. Інструкцію. Матеріал що закінчується повинен поповнятись.
 * Для цього працівник сканує штрих код матеріалу в програму для конторських і конторський
 * службовець бачить на лейауті робоче місце і матеріал який потрібно довезти.
 * Паралельно з цим може працювати й інший сценарій. По мінімальному залишку матеріалу згідно
 * черги замовлень визначається максимальний час наявності матеріалу і візуально відображається
 * у вигляді індикатору. Для цього необхідно знати точну кількість матеріалу, яким закомплектовано
 * позицію. Це не завжди можна відслідкувати. Для цього можна використати
 * 1) Розмір найстаршого замовлення.
 * 2) Внесення кількості закомплектованого матеріалу конторським при комплектації.
 * 3) Корекція працівником, який зголошує про закінчення матеріалу.
 * Працівник також вносить кількість. Завдяки чому конторський не тільки бачить критичний матеріал,
 * але й розрахований час який залишився до його повного закінчення відповідно до продуктивності
 * працівника.
 *
 * Сітка містить матеріал для виконання замовлень. При нажатті старт-фініш зі складу "F5" списується матеріал
 * Властивості:
 *      - матеріал
 * (Методи доступу)
 * (Список матеріалів без повторів)
 * (Інформаційний текст)
 * Тексн не сформований.
 */

public class Grid extends LeyoutComponent {
    private ArrayList<String> materials;


    public void addMaterial(String material) {
        this.materials.add(material);
    }

    public void setMaterials(ArrayList<String> materials) {
        this.materials = materials;
    }

    public ArrayList<String> getMaterials() {
        return materials;
    }

    public ArrayList<String> getSingleMaterial(){           //Список материалов без дубликатов
        HashMap<String, String> sm = new HashMap<>();
        for (String m: materials) {
            if(!sm.containsKey(m)) sm.put(m, m);
        }
        return new ArrayList<>(sm.values());
    }

//    @Override
//    public String toString() {
//        String s = "Матеріал:";
//        for (String m: getSingleMaterial()) {
//            s = s + "\n" + m;
//        }
//        return s;
//    }


    @Override
    public String toString() {
        return "Grid{" +
//                "materials=" + materials +
                + '}';
    }

}