package homework.lesson11.animals;

import java.util.Arrays;
import java.util.Objects;

public class Wolf extends WildAnimal{
    private final String[] likeToEat;
    private final String color;

    public Wolf(String[] likeToEat, String color) {
        this.likeToEat = likeToEat;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Wolf wolf = (Wolf) o;
        if((getName() != null && ((Wolf) o).getName() != null) &&
                (getColor() != null && ((Wolf) o).getColor() != null)){
            return getName().equals(((Wolf) o).getName()) && getColor().equals(((Wolf) o).getColor()) &&
                    getAge() == ((Wolf) o).getAge() && getStrength() == ((Wolf) o).getStrength() &&
                    Arrays.equals(likeToEat, ((Wolf) o).likeToEat);
        }
        else if(getName() == null && ((Wolf) o).getName() == null && getColor() != null && ((Wolf) o).getColor() != null){
            return getAge() == ((Wolf) o).getAge() && getStrength() == ((Wolf) o).getStrength() &&
                    Arrays.equals(likeToEat, ((Wolf) o).likeToEat);
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getStrength(), color, Arrays.hashCode(likeToEat));
    }
}