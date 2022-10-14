package ru.aleksandraKulikova.homeWorks.dz6.task1.mountains;

import java.util.Arrays;

//Группа для восхождения на гору создаётся со следующими характеристиками и возможностями:
//идёт набор в группу или нет;
//массив альпинистов;
//гора;
//должна быть возможность добавить альпиниста в группу, если набор ещё идёт
public class Group {
    private boolean isRecruited;
    private Mountaineer[] mountaineers;
    private Mountain mountain;
    private int mountaineerCount;

    // Констурктор - дефолтный


    public void setMountain(Mountain mountain) {
        if (mountain == null) {
            throw new IllegalArgumentException("гора не может быть null");
        }
        this.mountain = mountain;
    }

    public void setMountaineerCount(int mountaineerCount) {
        if (mountaineerCount < 0) {
            throw new IllegalArgumentException("Число альпинистов в группе и не может быть меньше 0");
        }
        this.mountaineerCount = mountaineerCount;
        mountaineers = new Mountaineer[mountaineerCount];
    }
    public void setMountaineersLarge(int mountaineerCount){
        if (mountaineerCount < this.mountaineerCount ) {
            isRecruited = true;
        } else {
            isRecruited = false;
            System.out.println("Рзамер группы " + this.mountaineerCount);
        }
    }
    public void addMountaineer(Mountaineer mountaineer) {
        for (int j = 0; j < mountaineers.length; j++) {
            if (mountaineers[j] == null) {
                mountaineers[j] = mountaineer;
                return;
            }
        }
        isRecruited = false;
        System.out.println("Набор в данную группу закрыт");
    }

    @Override
    public String toString() {
        return "Group{" +
                "isRecruited=" + isRecruited +
                ", mountaineers=" + Arrays.toString(mountaineers) +
                ", mountain=" + mountain +
                ", mountaineerCount=" + mountaineerCount +
                '}';
    }
}
