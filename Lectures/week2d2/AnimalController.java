
public class AnimalController {
    public static void main(String[]args){
        Animal an = new Animal();
        // System.out.println(an.getName());
        Frog frog1 = new Frog("Kermit");
        // System.out.println(Animal.animalCount);
        
        // System.out.println(Frog.getFrogCount());
        System.out.println(frog1.getName());
        System.out.println(frog1.getEnergy());
        Deer deer1 = new Deer("Bambi");

        frog1.jump();
        frog1.jump();
        frog1.jump();
        frog1.display();
        deer1.run();
        deer1.run();
        deer1.run();
        deer1.run();
        deer1.run();
        deer1.run();
        deer1.display();
        an.display();

   

    }
    
}
