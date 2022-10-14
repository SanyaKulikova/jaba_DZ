package ru.aleksandraKulikova.homeWorks.dz6.task1.mountains;
// Гора создаётся с названием (не менее 4 символов), страной (не менее 4 символов) и высотой (не менее 100 метров)
public class Mountain {
    private String mountainName;
    private String country;
    private double height;

    // Констурктор
    public Mountain(String mountainName, String country, double height) {
        setMountainName(mountainName);
        setCountry(country);
        setHeight(height);
    }

    public void setMountainName(String mountainName){
        if (mountainName == null || mountainName.length() < 4) {
            throw new IllegalArgumentException("Название горы не может быть короче 4 символов");
        }
        this.mountainName = mountainName;
    }
    public void setCountry(String country){
        if (country == null || country.length() < 4) {
            throw new IllegalArgumentException("Страна не может быть короче 4 символов");
        }
        this.country = country;
    }
    public void setHeight(double height){
        if (height < 100) {
            throw new IllegalArgumentException("Высота горы не может быть меньше 100 метров"); // примитивы на null не проверяем
        }
        this.height = height;
    }

    public String getMountainName(){
        return mountainName;
    }
    public String getCountry(){
        return country;
    }
    public double getHeight(){
        return height;
    }


    @Override
    public String toString() {
        return "Mountain{" +
                "mountainName='" + mountainName + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}
