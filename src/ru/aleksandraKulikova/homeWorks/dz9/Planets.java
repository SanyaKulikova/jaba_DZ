package ru.aleksandraKulikova.homeWorks.dz9;

public enum Planets {
    MERCURY("mercury", 436746, 75856), URANUS("uranus",46764,48478) , VENUS ("venus", 68567856, 4746747);

    private  double mass;
    private String name;
    private double radius;

    Planets (String name, double mass, double radius ){
        setMass(mass);
        setName(name);
        setRadius(radius);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        if (mass < 0) {
            throw new IllegalArgumentException("Масса планеты не может быть меньше 0");
        }
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3){
            throw new IllegalArgumentException("название планеты не может быть короче 3 символов");
        }
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (mass < 0) {
            throw new IllegalArgumentException("Радиус планеты не может быть меньше 0");
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Planets{" +
                "mass=" + mass +
                ", name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }

}
