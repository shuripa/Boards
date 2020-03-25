package examples.imperative;

import java.util.Arrays;
import java.util.List;

public class Sempler {

    public static void main(String[] args) {

//        Знайти подвоєння, першого парного числа, з масиву більшого за 3
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> values2 = Arrays.asList(1, 3, 5, 7, 9);

//        Варіант 1
        int result = 0;
        for (int e: values) {
            if (e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println(result);

//        Варіант 2 Ми використали наступний дуже виразний код
        System.out.println(
                values2.stream()
                        .filter(e -> e > 3)         //Враховуючи елемент, скажи чи більший він за 3
                        .filter(e -> e % 2 == 0)    //Враховуючи елемент, скажи чи ділиться він на 2
                        .map(e -> e * 2)            //Перемножити всі значення на 2
                        .findFirst()                //Знайти перший, що задовільняє фільтрам
//                        .get()                      //Отримання результату. Без цієї команди вивід буде наступним Optional[8]
                                                    //Це означає що я не дам тобі результату, я дам тобі необовязкову 8, тому
                                                    //що даний набір може не містити парного числа. Або може не містити числа більше 3.
                                                    //Або бути пустим взагалі. Результатом буде Optional.empty
                                                    //В імпиративі ця проблема прихована.
        );



//        Варіант 3 Робимо крок далі.
        System.out.println(
                values.stream()
                        .filter(Sempler::isGreaterThen3)    //Виклик процедури isGreaterThen3 класу Sempler
                        .filter(Sempler::isEven)            //Виклик процедури isEven(чиПарне) класу Sempler
                        .map(e -> e * 2)
                        .findFirst()
        );
        // Тепер ми можемо починати читати код. Що ми робимо?
        // - По даному набору фільтруємо всі числа більші 3.
        // - Фільтруємо всі парні числа.
        // - Множимо всі числа на 2.
        // - Далі знаходимо перший елемент, який задовільняє умовам.
        // І код поинає читатися як постановка задачі.
    }

    public static boolean isGreaterThen3(int number){
        return number >3;
    }

    public static boolean isEven(int number){
        return number % 2 == 0;
    }
}
