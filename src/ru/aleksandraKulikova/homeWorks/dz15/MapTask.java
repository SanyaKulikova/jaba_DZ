package ru.aleksandraKulikova.homeWorks.dz15;

import java.util.*;

public class MapTask {

    // написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city),
    //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу
    public static List<String> loginsByCity(HashMap<String, String> firstTaskMap, String city){
        ArrayList<String> logins = new ArrayList<>();
        for (Map.Entry<String, String> pair: firstTaskMap.entrySet()) {
            if (pair.getValue().equals(city)) logins.add(pair.getKey());
        }
        return logins;
    }
    // TODO:: дан список слов (words).
    //  Написать статический метод, который будет возвращать количество одинаковых слов
    //  в мапе вида Map<String, Integer>, где String - слово и Integer - количество повторений
    /* public static Map<String, Integer> countSameWords(List<String> words){
        HashMap<String, Integer> sameWords = new HashMap<>();
        for (String word: words) {
            if word.equals()
        }
    }*/


    // дана мапа (customerMap).
    //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
    //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)
    public static HashMap<String, Customer> customerAgeFromTo(HashMap<String, Customer> customerMap, int from, int to){
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
        String[] textByWords = text.split(" ");
        long frequency = 0L;
        for (String oneWord: textByWords) {
            if (oneWord.toLowerCase().equals(word.toLowerCase())){
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





    public static void main(String[] args) {

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");
        String city = "Тверь";
        System.out.println(MapTask.loginsByCity(firstTaskMap, city));


        // TODO:: дан список слов (words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов
        //  в мапе вида Map<String, Integer>, где String - слово и Integer - количество повторений

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



        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(MapTask.customerAgeFromTo(customerMap,20, 50));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  (Map<String, Long>, где - ключи (String) - слово, значения (Long) - частота встречаемости)
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  (Map<Integer, ArrayList<String>>, где - ключи (Integer) - количество букв, значения (ArrayList<String>) - слова)
        //  3. написать метод, который выводит в консоль топ 10 самых часто встречаемых в тексте слов (артикли и предлоги тоже считаем за слова)

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(MapTask.getWordAndFrequency(text));


    }

}
