package model;

public class Van extends Vehicle{

    int vanSlot[] = {1,2,3,4,12,13};
    String park[] = {"null","null","null","null","null","null"};
    int slot;
    String data;

    @Override
    public void parking(String number,String type){
        if (park[slot].equals("null")){
            park[slot] = number;
            System.out.println("added..."+slot);
        }else {
            System.out.println("Already Parked");
        }
    }

    @Override
    public void leaveParking(String number,String type){
        for (int i=0; i<park.length; i++){
            if(number.equals(park[i])){
                park[i]=null;
                slot=i;
                break;
            }else {
                System.out.println("Not Leave");
            }
        }
    }

    @Override
    public String parkingSlot(String number,String type){
        for (int i=0; i<vanSlot.length; i++){
            if (park[i].equals(number)){
                data="Parked";
                break;
            }else {
                if (park[i].equals("null")){
                    slot=i;
                    data=Integer.toString(vanSlot[slot]);
                    break;
                }
            }
        }
        return data;
    }

}
