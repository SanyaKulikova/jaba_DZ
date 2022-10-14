package ru.aleksandraKulikova.homeWorks.dz6.task1.mountains;

public class Mountaineer {

    private String name;
    private String address;

    // КОНСТРУКТОР
    public Mountaineer(String name, String address) {
        setName(name);
        setAddress(address);

    }
    // если нет сетеров , значение свойства не меняется (если можно менять - то нужен сетер)
    // добавить гетеры - если хотим чтобы можно было по отдельности узнать значения свойства

    public void setName(String name){
        if (name == null || name.length() < 3 ) { // добавила проверку на null!!!!!
            throw new IllegalArgumentException("Имя должно быть строкой, не короче 3 символов");
        }
        this.name = name;
    }
    public void setAddress(String address) {
        if (address == null || address.length() < 5) {
            throw new IllegalArgumentException("Адрес должно быть строкой, не короче 5 символов");
        }
        this.address = address;
    }
    public String getName(){
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Mountaineer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
