package ru.aleksandraKulikova.homeWorks.dz25;

import java.util.concurrent.CopyOnWriteArrayList;

public class SecondThread  extends Thread{

    private CopyOnWriteArrayList<String> strings;

    public SecondThread(CopyOnWriteArrayList<String> strings) {
        this.strings = strings;
    }

    public void run(){
        Handler<String> handler = new Handler<>();
        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String minBySize = strings.stream()
                .min((s1, s2) -> s1.length() - s2.length())
                .get();
        handler.writeToFile(minBySize);
        strings.remove(minBySize);

    }
}
