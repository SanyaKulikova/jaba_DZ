package ru.aleksandraKulikova.homeWorks.dz6.task1;

import ru.aleksandraKulikova.homeWorks.dz6.task1.mountains.Group;
import ru.aleksandraKulikova.homeWorks.dz6.task1.mountains.Mountain;
import ru.aleksandraKulikova.homeWorks.dz6.task1.mountains.Mountaineer;

public class Application {
    public static void main(String[] args) {
        Mountaineer mountaineer01 = new Mountaineer("Василий", "Россия");
        Mountaineer mountaineer02 = new Mountaineer("Ольга", "Россия");
        Mountaineer mountaineer03 = new Mountaineer("Дмитрий", "Россия");


        Mountain mountain01 = new Mountain("Эверест", "Китай", 8_848_000);
        Mountain mountain02 = new Mountain("Ключевская сопка", "Россия", 4_750_000);
        Mountain mountain03 = new Mountain("Фудзияма", "Япония", 3_776_000);

        Group group01 = new Group();
        group01.setMountaineerCount(3);
        group01.setMountain(mountain01);
        group01.addMountaineer(mountaineer01);
        group01.addMountaineer(mountaineer03);
        group01.addMountaineer(mountaineer02);
        group01.addMountaineer(mountaineer01);









    }
}
