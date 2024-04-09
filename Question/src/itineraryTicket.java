import java.util.HashMap;

public class itineraryTicket {
    private static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> revtickets=new HashMap<>();

        for(String key :tickets.keySet()){
            revtickets.put(tickets.get(key),key);
        }

        for(String key : tickets.keySet()){
            if(!revtickets.containsKey(key)) return key;
        }
        return null;
    }
    public static void main(String[] args) {
        //O(n)
        HashMap<String,String> tickets=new HashMap<>();
        tickets.put("Chennai","Benguluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String startpt=getStart(tickets);
        System.out.print(startpt);
        for(String place : tickets.keySet()){
            System.out.print("->"+tickets.get(startpt));
            startpt=tickets.get(startpt);
        }

        System.out.println();
    }
}
