package ru.aleksandraKulikova.homeWorks.dz14.message;

import java.util.*;

public class MessageTask {

    // I. Подсчитать количество сообщений для каждого приоритета
    //   Ответ в консоль
    public static void countEachPriority(List<Message> messageList) {
        // я сделала через создание миллиона переменных и if
        // это правильно, но не красиво и для программы напряжно

        int[] counts = new int[MessagePriority.values().length]; // создали массив, количество элементов котого равен
        // количеству элементов перечисления
        for (Message message : messageList) { // перебираем пришедший список
            counts[message.getPriority().ordinal()] += 1; // элемент массива с индексом равным индексу его перечисления
            // увеличивается на 1
        }
        for (MessagePriority priority : MessagePriority.values()) { // красиво выводим
            System.out.println(priority + ": " + counts[priority.ordinal()]);
        }
    }


    // II. Подсчитать количество сообщений для каждого кода сообщения
    //   Ответ в консоль
    public static void countEachCode(List<Message> messageList) {

        int[] counts = new int[10]; // на этот раз мы знаем, какие коды и сколько их
        for (Message message : messageList) {
            counts[message.getCode()] += 1;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("Код " + i + ", встречается = " + counts[i]);
        }
    }

    // III. Подсчитать количество уникальных сообщений
        // Ответ в консоль
    public static void uniqueMessageCount(List<Message> messageList) {
        // я делала массив и пыталас сделать через вложенные циклы - в принципе реализуемо,
        // но программа ругалась на приведение типов, и вообше это по дурацки
        /* Message[] messages = (Message[]) messageList.toArray();
        int ds = 0;
        for(int i = 0; i < messages.length; i++) {
            for (int j = i + 1; j < messages.length; j++) {
                if (messages[i].equals(messages[j])) {
                    ds++;
                }
            }
        }
        int un = messageList.size() - ds;
        System.out.println("Количество уникальных сообщений: " + un);*/

        System.out.println("Количество уникальных сообщений: " +
                new HashSet<>(messageList).size());
        // В сетах хранятся только уникальные элементы!!
        // поэтому размер множества из списка будет количеством уникальных элементов!
    }

    // VI. вернуть только неповторяющиеся сообщения и в том порядке,
    //        //  в котором они встретились в первоначальном списке
    //        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
    //        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // тоже самое - пыталась через массивы

        return new ArrayList<>(new LinkedHashSet<>(messageList));
        // создаем новый список на основе LinkedHashSet, который на основе переданного
    }

    // V. удалить из коллекции каждое сообщение с заданным приоритетом
    //    вывод в консоль до удаления и после удаления
    public static void removeEach(List<Message> messageList, MessagePriority priority) {

        System.out.println("До удаления: " + messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getPriority() == priority) {
                iterator.remove();
            }
        }
        System.out.println("После удаления: " + messageList);
    }

    // VI. удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
    //     вывод в консоль до удаления и после удаления
    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        System.out.println("До удаления: " + messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getPriority() != priority) {
                iterator.remove();
            }
        }
        System.out.println("После удаления: " + messageList);

    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);
        System.out.println(messages);

        MessageTask.countEachPriority(messages);

        MessageTask.countEachCode(messages);

        MessageTask.uniqueMessageCount(messages);

        MessageTask.uniqueMessagesInOriginalOrder(messages);

        MessageTask.removeEach(messages, MessagePriority.HIGH);

        MessageTask.removeOther(messages, MessagePriority.URGENT);



    }
}
