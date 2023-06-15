

public class OOPTest {
    public static void main(String[]args){
        OOP appTest = new OOP();
        // appTest.name = "cheese";
        // System.out.println(appTest.name);
        String greeting = appTest.greet();
        String greetingWithName = appTest.greet("Eduardi", "mesh");
        System.out.println(greetingWithName);

    
    }
    
}
