package homework.lesson06class.task1;

public class Climber {
    private String name;
    private String address;

    public Climber(String name, String address){
        if(name.length() < 3){
            throw new IllegalArgumentException("В имени должно быть больше трех букв");
        }
        if(address.length() < 5){
            throw new IllegalArgumentException("В адресе должно быть больше 5 букв");
        }

        this.name = name;
        this.address = address;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
