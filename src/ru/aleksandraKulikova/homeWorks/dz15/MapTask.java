package ru.aleksandraKulikova.homeWorks.dz15;

import java.util.*;

public class MapTask {

    //  написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city),
    //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу
    private static List<String> getLoginsByCity(HashMap<String, String> firstTaskMap, String city){
        List<String> logins = new ArrayList<>(); // было: ArrayList<String> logins - так не очень хорошо, потому что отдаем то лист
        for (Map.Entry<String, String> pair: firstTaskMap.entrySet()) {
            if (pair.getValue().equalsIgnoreCase(city)) logins.add(pair.getKey()); // было просто equals(city)
        }
        return logins;
    }


    // дан список слов (words).
    //  Написать статический метод, который будет возвращать количество одинаковых слов
    //  в мапе вида Map<String, Integer>, где String - слово и Integer - количество повторений
    private static Map<String, Integer> getMonthsCount(List<String> monthsList){ // принимает список слов- месяцев
        HashMap<String, Integer> monthsCount = new HashMap<>(); // создаем новую мапу
        for (String month : monthsList) { // перебираем пришедший список
            int count = monthsCount.getOrDefault(month, 0); // если в мапе уже есть ключ равный данному месяцу
            // то счетчик равен значению по этому ключу
            // если же нет счетчик равен дефолтному значению ноль
            monthsCount.put(month, count + 1); // кладем в мапу по ключу (данный месяц) новое знаечение, равноое счетчику плюс один
            // снова же слово встретилось

            // или (тоже самое по сути)

            /*if (monthsCount.containsKey(month)) { // если мапа содержит ключ = месяц, то
                monthsCount.replace(month, monthsCount.get(month) + 1); // значение по этому ключу заменяется на тоже значение +1
            } else { // если же нет
                monthsCount.put(month, 1); // то создается новая пара с ключем - месяцем и значением 1
            }*/
        }
        return monthsCount;
    }


    //  дана мапа (customerMap).
    //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
    //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)
    private static HashMap<String, Customer> filterByAge(HashMap<String, Customer> customerMap, int from, int to){
        HashMap<String, Customer> customerFromToMap = new HashMap<>();
        for (Map.Entry<String, Customer> pair: customerMap.entrySet()) {
            if (pair.getValue().getAge() >= from && pair.getValue().getAge() < to){
                customerFromToMap.put(pair.getKey(), pair.getValue());
            }
        }
        return customerFromToMap;
    }

    //1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
    //  (Map<String, Long>, где - ключи (String) - слово, значения (Long) - частота встречаемости)
    public static long frequencyOfWord(String text, String word){
        String[] textByWords = text.toLowerCase().split(" ");// если есть возможность обработать весь текст целиком,
        // то лучше его а не каждое слово
        long frequency = 0L;
        for (String oneWord: textByWords) {
            if (oneWord.equals(word.toLowerCase())){ // equalsIgnoreCase или переделай для всего текста целиком
                frequency++;
            }
        }
        return frequency;
    }
    public static HashMap<String, Long> getWordAndFrequency(String text){
        HashMap<String, Long> wordAndFrequency = new HashMap<>();
        String[] textByWords = text.split(" ");
        for (String oneWord: textByWords) {
            if (!wordAndFrequency.containsKey(oneWord)) wordAndFrequency.put(oneWord, MapTask.frequencyOfWord(text,oneWord));

        }
        return wordAndFrequency;
    }


    //  2. написать метод, который собирает все слова в группы по количеству букв:
    // например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
    // (Map<Integer, ArrayList<String>>, где - ключи (Integer) - количество букв, значения (ArrayList<String>) - слова)

    // в задании просят значения в виде ArrayList
    // можно еще в виде множества - тогла там будут только уникальные слова
    private static Map<Integer, ArrayList<String >> getGroupsByLettersCount(String text) {
        Map<Integer, ArrayList<String>> map = new TreeMap<>(); // создаем мапу, которую будем возвращать

        String[] words = text.trim().toLowerCase().split(" "); // делаем массив слов из текста

        for (String word : words) { // перебираем массив
            // опять же два варианта (теперь другой в скобочках)
            int wordLen = word.length(); // переменная - количество букв в слове
            if (map.containsKey(wordLen)) { // если в мапе уже есть такой ключ
                map.get(wordLen).add(word); // то добавляем это слово по этому ключу в список
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                map.put(wordLen, list);
            }

            //  или

            /*Set<String> strings = map.getOrDefault(word.length(), new HashSet<>());
            strings.add(word);
            map.put(word.length(), strings);*/
        }
        return map;
    }


    // 3. написать метод, который выводит в консоль топ 10 самых часто встречаемых в тексте слов (артикли и предлоги тоже считаем за слова)
    private static void printTopTen(String text) {
        String[] words = text.trim().toLowerCase().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        // мы хотим сортировать по значению (а не по ключу)
        // Мапы такое не делают
        // и некоторые множества тоже
        // нужен список
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(hashMap.entrySet()); // создаем список из объектов Entry
        // Entry {key: , Value:
        // у списка есть метод sort (принимает на вход корпораторы)
        entries.sort(new ValueComparator()); // написали компоратор отдельным классом, хотя можно было и через лямбду
        // entries.sort((e1, e2) -> e1.getValue() - e2.getValue() );
        for (int i = 0; i < 10; i++) {
            System.out.println(entries.get(i).getKey());
        }

    }




    public static void main(String[] args) {

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");
        String city = "Тверь";
        System.out.println(MapTask.getLoginsByCity(firstTaskMap, city));


        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");
        System.out.println(MapTask.getMonthsCount(words));


        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(MapTask.filterByAge(customerMap,20, 50));


        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(MapTask.getWordAndFrequency(text));
        System.out.println(MapTask.getGroupsByLettersCount(text));
        MapTask.printTopTen(text);


    }

}

class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue() - o1.getValue();
    }
}