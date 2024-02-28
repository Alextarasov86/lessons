package homework.lesson08;

public class Train extends Transport {
    int numberOfCarriage;
    boolean isClimateControl;

    @Override
    public void repair(){
        if(depreciation > 0){
            if(numberOfCarriage < 7){
                depreciation -= 2;
                if(depreciation < 0){
                    depreciation = 0;
                }
            } else {
                depreciation--;
            }
        }
    }
}
