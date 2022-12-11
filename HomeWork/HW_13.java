/*
Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

package HomeWork;

import java.util.*;

public class HW_13 {
    public static void main(String[] args) {
        List<String> spisok = List.of("Иван Иванов", "Антон Захаров", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
            "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
            "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");

        Map<String, Integer> spisokImen = new HashMap<String, Integer>(); // создаем список с количеством повторений имен
        for (String strElem : spisok) { 
            String[] tempArr = strElem.split(" ");
            if (spisokImen.containsKey(tempArr[0])) {
                spisokImen.put(tempArr[0], spisokImen.get(tempArr[0]) + 1);
            } else {
                spisokImen.put(tempArr[0], 1);
            }
        }

        for (var item : spisokImen.entrySet()) { // выводим какое имя сколько раз повторялось
            System.out.printf("Имя: %s, встречается %d раз(а)\n", item.getKey(), item.getValue());
        }

        List<String> tempListName = new ArrayList<String>(); // создаем временный список с именами по порядку возрастания
        int tempNumber = 1;
        while(tempNumber < spisok.size()) {
            for (Map.Entry<String, Integer> item : spisokImen.entrySet()) {
                if (item.getValue() == tempNumber) tempListName.add(0, item.getKey());
            }
            tempNumber++;
        }
        System.out.println(tempListName);

        for (String str : tempListName) { //выводим список по убыванию популярности имени
            for (String strElem : spisok) {
                String[] tempArr = strElem.split(" ");
                if (str.equals(tempArr[0])) System.out.println(strElem);
            }
        }
    }
}
