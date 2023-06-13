import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListVsList{
    public static void main(String[] args){
        // fixed after you declared your array you it can't grow or shrink 
        String [] friendsArray = new String[4];
        String[ ] friendsArray2 = {"John", "Chris", "Eric","Luke"};

        // ArrayList does't have fixed size which means that you can dynamically either
        // expand or contract their size automatically
        ArrayList<String> friendsArrayList = new ArrayList<String>();
        ArrayList<String> friendArrayList2 = new ArrayList<String>(Arrays.asList("John", "fatush"));

        // getting values

        System.out.println(friendsArray[0]);
        System.out.println(friendArrayList2.get(0));
        System.out.println(friendsArray.length);
        System.out.println(friendArrayList2.size());

        // how you can add 
        // ?YOU CAN'T DO THAT WITH ARRAYS SINCE THEY HAVE FIXED SIZE    
        friendArrayList2.add("Mitch");
        // Set
        friendsArray[0] = "Carl";
        System.out.println(friendsArray[0]);
        friendArrayList2.set(0,"Calr");
        System.out.println(friendArrayList2.get(0));
        // Remove element 
        //? CAN'T DO THIS ARRAY 
        friendArrayList2.remove("Chris");
        System.out.println(friendsArrayList.get(0));
        // print
        // ? this give as the memory location
        System.out.println(friendsArray);
        // ? this give us exactly what is inside.
        System.out.println(friendArrayList2);
    

 
    }
}