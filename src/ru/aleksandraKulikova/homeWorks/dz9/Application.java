package ru.aleksandraKulikova.homeWorks.dz9;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {

        Planets pl1 = Planets.MERCURY;
        pl1.setMass(57878);
        pl1.setRadius(5478);

        Planets pl2 = Planets.URANUS;
        pl1.setMass(78758);
        pl1.setRadius(578578);

        Planets pl3 = Planets.VENUS;
        pl1.setMass(4);
        pl1.setRadius(948);

        Planets[] planets = Planets.values();
        for (Planets planet: planets) {
            System.out.println(planet.toString());
        }



    }
}
