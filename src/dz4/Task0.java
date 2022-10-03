package dz4;

public class Task0 {
    public static void main(String[] args) {

        String string1 = "домашнее задание";
        String string2 = string1.replaceAll("задание","мучение");
        System.out.println( string2); //домашнее мучение

        String string3 = "домашнее задание домашнее мучение домашнее";
        String string4 = string3.replaceAll("домашнее","классное");
        String string5 = string3.replaceFirst("домашнее", "классное");
        System.out.println( string4 );//классное задание классное мучение классное
        System.out.println( string5 );//классное задание домашнее мучение домашнее

        String string6 = "Мурманск";
        if (string6.contains("М")) System.out.println("Да"); // Да
        if (string6.contains("M")) System.out.println("Да"); // Нетушки -- чувствителен к языку
        else System.out.println("Нетушки");
        if (string6.contains("а")) System.out.println("Да"); //Да-- и к регистру тоже
        else System.out.println("Нетушки");
        if (string6.contains("Владивосток")) System.out.println("Еще раз да");
        else System.out.println("Нетушки"); // Нетушки

        boolean b = string6.startsWith("Мур");
        boolean bb = string6.startsWith("Мур", 4);
        boolean bbb = string6.startsWith("мур");
        boolean bbbb = string6.startsWith("ма", 3); // начинаем как обычно с 0
        System.out.println(b); //true
        System.out.println(bb); //false
        System.out.println(bbb);//false
        System.out.println(bbbb);//true

        b = string6.endsWith("ск");
        bb = string6.endsWith("сK");
        bbb = string6.endsWith("Ск");
        bbbb = string6.endsWith("Мур");
        System.out.println(b); // true
        System.out.println(bb); // false
        System.out.println(bbb);//false
        System.out.println(bbbb);//false

        String string7 = "   Мурмурино   \n   Мурмурманск   ";
        System.out.println(string7);
        System.out.println(string7.trim()); // убирает пробелы до первого не пробела на одной строке
        System.out.println(string7.strip()); //Этот метод убирает все пробелы, находящиеся до первого не-пробела и после последнего
        System.out.println(string7.stripIndent()); // убирает все пробелы, находящиеся до первого не-пробела и после последнего на каждой строке
        System.out.println(string7.stripLeading()); // убирает все пробелы, находящиеся до первого не-пробела
        System.out.println(string7.stripTrailing()); // убирает все пробелы после последнего

        String string8 = "Лямбда";
        String string9 = "Гамма";
        String string10 = "лямбда";
        String string11 = "Огромная строка";
        int a = string8.compareTo(string9);
        int c = string8.compareTo(string10);
        int d = string9.compareTo(string8);
        int e = string9.compareTo(string11);
        int aa = string8.compareToIgnoreCase(string9);
        int cc = string8.compareToIgnoreCase(string10);
        int dd = string9.compareToIgnoreCase(string8);
        int ee = string9.compareToIgnoreCase(string11);
        System.out.println(a); // больше
        System.out.println(c); // равны
        System.out.println(d); // меньше
        System.out.println(e); // не понимаю откуда такие числа

        System.out.println(aa); // больше
        System.out.println(cc); // уже не равны
        System.out.println(dd); // меньше
        System.out.println(ee);


        String string12 = "   ";
        String string13 = "";
        System.out.println(string12.isBlank()); //t
        System.out.println(string13.isBlank()); //t
        System.out.println(string12.isEmpty()); //f
        System.out.println(string13.isEmpty()); //t

        System.out.println(string8.repeat(2)); //ЛямбдаЛямбда

        System.out.println(string8.toLowerCase()); // лямбда

        System.out.println(string8.toUpperCase()); // ЛЯМБДА

        System.out.println(string8.charAt(2)); // м





    }
}
