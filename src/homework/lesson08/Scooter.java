package homework.lesson08;

public class Scooter extends Transport{
    int numberOfWheels = 2;
    String type = "urban";
    boolean isElectric;

    @Override
    public void repair(){
        if(depreciation > 0){
            if(isElectric){
                depreciation -= 2;
                if(depreciation < 0){
                    depreciation = 0;
                }
            } else {
                depreciation -= 3;
                if(depreciation < 0){
                    depreciation = 0;
                }
            }
        }
    }


}
