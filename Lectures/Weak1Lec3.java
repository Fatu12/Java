import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
public class Weak1Lec3{
//    public String fixedArrays(){
//     // fixed array is you can't change them while you create them
//     // you can't decoder   and defend   in the same line
//     // you cannot add or remove values but you can change them
//     int [] myArray = new int[6];
//     int [] myOtherArray = {11,22,32,43,54,46};
//     System.out.println( String.format( "my other array %s",myOtherArray));
//     System.out.println( myArray);
//     // while we use this 
//     for(int iterator: myArray){
//         System.out.println(iterator);
//     }
//     for( int i = 0; i< myOtherArray.length; i++){
//         System.out.println(i);
//         System.out.println(myOtherArray[i]);
//     }
//     // this can return our array as string
//     return Arrays.toString(myOtherArray);
// }
    //ArrayList is class  
//    public  void ArrayList(){
//         ArrayList <String> myArrayList = new ArrayList <String>();
//         myArrayList.add("Tima");
//         myArrayList.add("John");
//         myArrayList.add("java");
//         myArrayList.add("python");
//         myArrayList.remove(0);
//         System.out.println(myArrayList);
//         System.out.println(myArrayList.size());

        // int i =0;
        // while(i<= 10){
        //     System.out.println("Doing stuff and things");
        //     i++;
        // }
        // for each
        // for(String i : myArrayList){
        //     System.out.println(i);


       // }
        // public void Maps(){
        //     // 
        //     HashMap <String, String> myMap = new HashMap<String, String>();
        //     myMap.put("name1","Cameron");
        //     myMap.put("name2", "Fatu");
        //     myMap.put("name3", "John");
        //     System.out.println(myMap);
        //     System.out.println(myMap.get("name2"));
        //     // you  can't iterate to map to you need to create setKey through that you can do it 
        //   Set<String> myMapKey = myMap.keySet();
        //     for(String i: myMapKey){
        //         System.out.println(i);
        //         System.out.println(myMap.get(i));
        //     }

        // }

       public ArrayList<Character> Alphabet(){
        ArrayList<Character> alpha = new ArrayList<Character>();
       for(char i = 'a'; i <= 'z'; i++){
        alpha.add(i);
        // System.out.println(i);
       }
    //    System.out.println(alpha);
       return alpha;
            } 
        }
