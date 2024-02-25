package homework.lesson06class.task1;

public class Mountain {
    private String name;
    private String country;
    private int height;

    public Mountain(String name, String country, int height){
        if(name.length() < 4){
            throw new IllegalArgumentException("Название должно быть больше 4 символов");
        }
        if(country.length() < 4){
            throw new IllegalArgumentException("Название страны долно быть больше 4 символов");
        }
        if(height < 100){
            throw new IllegalArgumentException("Высота горы должна быть больше 100 метров");
        }

        this.name = name;
        this.country = country;
        this.height = height;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getHeight() {
        return height;
    }
}
