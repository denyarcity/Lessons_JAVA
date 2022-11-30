package HomeWork;

/*
В файле содержится строка с данными:

[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:

Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

public class HW_6 {
    public static void main(String[] args) {
        String str = """
                [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
                {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
                {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]""";

        System.out.println();
        System.out.println(parseBuilderStr(str));
    }

    static String parseBuilderStr(String str) {
        String[] arrStr = str.split("[{(\\[\\]}\\n)]"); // [{}] // [{(}\\n)] \[\]
        StringBuilder sb = new StringBuilder();
        for (String el : arrStr) {
            // System.out.println(el);
            if (el.length() > 1) {
                String[] param = el.split(",");
                String[] p1 = param[0].split(":");
                String[] p2 = param[1].split(":");
                String[] p3 = param[2].split(":");
                sb.append("Студент ").append(p1[1], 1, p1[1].length() - 1).append(" получил оценку ")
                        .append(p2[1], 1, p2[1].length() - 1).append(" по предмету ")
                        .append(p3[1], 1, p3[1].length() - 1).append(".\n");
            }
        }
        return sb.toString();
    }
}
