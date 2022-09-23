package model;

public class Lorry extends Vehicle{

    int[] lorySlot = {5,6,7,8,9,10,11};
    String[] park= {"null","null","null","null","null","null","null"};
    int slot;
    String data;

    @Override
    public void parking(String vehicle,String type){
        if (park[slot].equals("null")){
            park[slot] = vehicle;
            System.out.println("added..."+slot);
        }else {
            System.out.println("Already Parking");
        }
    }

    @Override
    public void leaveParking(String vehicle,String type){
        for (int i=0; i<park.length; i++){
            if (vehicle.equals(park[i])){
                System.out.println("Delivery : "+park[i]);
                park[i]=null;
                slot=i;
                break;
            }else {
                System.out.println("Not Leave");
            }
        }
    }

    @Override
    public String parkingSlot(String vehicle,String type){
        for (int i=0; i<lorySlot.length; i++){
            if (park[i].equals(vehicle)){
                data="Parked";
                System.out.println("Parking slot...");
                break;
            }else {
                if (park[i].equals("null")){
                    System.out.println("view "+lorySlot[i]);
                    slot=i;
                    data=Integer.toString(lorySlot[slot]);
                    break;
                }
            }
        }
        return data;
    }
}
