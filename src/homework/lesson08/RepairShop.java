package homework.lesson08;

public class RepairShop {
    protected Transport[] transports;

    public void addTransport(Transport t){
        for(int i = 0; i < transports.length; i++){
            if(transports[i] == null){
                transports[i] = t;
                break;
            }
        }
    }

    public void repairAll(Transport[] transports){
        for (Transport transport : transports) {
            if(transport != null){
                transport.repair();
                transport = null;
            }
        }
    }

    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.depreciation = 10;
        Scooter scooter = new Scooter();
        scooter.depreciation = 4;
        Train train = new Train();
        train.depreciation = 2;
        train.numberOfCarriage = 8;
        RepairShop repairShop = new RepairShop();
        repairShop.transports = new Transport[3];
        repairShop.addTransport(bike);
        repairShop.addTransport(scooter);
        repairShop.addTransport(train);

        repairShop.repairAll(repairShop.transports);
        for(Transport transport: repairShop.transports){
            System.out.println(transport.depreciation);
        }
    }
}
