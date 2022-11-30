package HomeWork;

/*
В файле содержится строка с исходными данными в такой форме: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";

Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
*/

import java.util.HashMap;
import java.util.Map;

public class HW_4 {
    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>();

        param.put("name", "Ivanov");
        param.put("country", "Russia");
        param.put("city", "Moscow");
        param.put("age", null);
        System.out.println(param);

        StringBuilder sb = new StringBuilder();
        sb.append("select * from students where ");
        boolean notFirst = false;
        for (Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getValue() != null) {
                if (notFirst)
                    sb.append(" and ");
                sb.append(String.format("%s = \"%s\"", entry.getKey(), entry.getValue()));
                notFirst = true;
            }
        }
        System.out.println(sb);
    }
}
