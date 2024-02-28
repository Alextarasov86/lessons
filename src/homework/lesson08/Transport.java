package homework.lesson08;

public class Transport {
    protected int id;
    protected int depreciation;
    protected int maxSpeed = 120;

    public void repair(){
        if(depreciation > 0){
            depreciation--;
        }
    }
}
