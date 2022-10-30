package ru.aleksandraKulikova.homeWorks.dz14.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MessageTask {

    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритета
        // Ответ в консоль

        int high = 0;
        int low = 0;
        int medium = 0;
        int urgent = 0;
        for (Message message: messageList) {
            if (message.getPriority() == MessagePriority.LOW) low++;
            else if (message.getPriority() == MessagePriority.HIGH) high++;
            else if (message.getPriority() == MessagePriority.MEDIUM) medium++;
            else urgent++;
        }
        System.out.println("Количество сообщений с приоритетом LOW: " + low);
        System.out.println("Количество сообщений с приоритетом MEDIUM: " + medium);
        System.out.println("Количество сообщений с приоритетом HIGH: " + high);
        System.out.println("Количество сообщений с приоритетом URGENT: " + urgent);
    }

    public static void countEachCode(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль

        int zero = 0; // вроде можно делать это не так, карсивее и короче, но не могу вспомнить
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        for (Message message: messageList) {
            switch (message.getCode()){
                case 0 -> zero++;
                case 1 -> one++;
                case 2 -> two++;
                case 3 -> three++;
                case 4 -> four++;
                case 5 -> five++;
                case 6 -> six++;
                case 7 -> seven++;
                case 8 -> eight++;
                case 9 -> nine++;
            }
        }
        System.out.println("Количество сообщений с кодом 0: " + zero);
        System.out.println("Количество сообщений с кодом 1: " + one);
        System.out.println("Количество сообщений с кодом 2: " + two);
        System.out.println("Количество сообщений с кодом 3: " + three);
        System.out.println("Количество сообщений с кодом 4: " + four);
        System.out.println("Количество сообщений с кодом 5: " + five);
        System.out.println("Количество сообщений с кодом 6: " + six);
        System.out.println("Количество сообщений с кодом 7: " + seven);
        System.out.println("Количество сообщений с кодом 8: " + eight);
        System.out.println("Количество сообщений с кодом 9: " + nine);
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        Message[] messages = (Message[]) messageList.toArray();
        int ds = 0;
        for(int i = 0; i < messages.length; i++) {
            for (int j = i + 1; j < messages.length; j++) {
                if (messages[i].equals(messages[j])) {
                    ds++;
                }
            }
        }
        int un = messageList.size() - ds;
        System.out.println("Количество уникальных сообщений: " + un);

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        Message[] messages = (Message[]) messageList.toArray();
        int ds = 0;
        ArrayList<Message> nonUniqueMessages = new ArrayList<>();
        for(int i = 0; i < messages.length; i++) {
            for (int j = i + 1; j < messages.length; j++) {
                if (messages[i].equals(messages[j])) {
                    ds++;
                    nonUniqueMessages.add(messages[i]);
                }
            }
        }
        ArrayList<Message> uniqueMessages = new ArrayList<>();
        uniqueMessages.addAll(messageList);
        uniqueMessages.removeAll(nonUniqueMessages);
        return uniqueMessages;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getPriority() == priority) {
                iterator.remove();
            }
        }
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println(messageList);
        Iterator<Message> iterator = messageList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getPriority() != priority) {
                iterator.remove();
            }
        }
        System.out.println(messageList);

    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);
        System.out.println(messages);

        MessageTask.countEachPriority(messages);

        MessageTask.countEachCode(messages);

        // MessageTask.uniqueMessageCount(messages);

        MessageTask.removeEach(messages, MessagePriority.HIGH);

        MessageTask.removeOther(messages, MessagePriority.URGENT);



    }
}
