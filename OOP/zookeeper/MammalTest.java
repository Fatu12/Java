

public class MammalTest {
    public static void main(String[] args){
        Mammal mm = new Mammal(100);
        Gorilla gg = new Gorilla(120);
        System.out.printf(" ++++========= %s",gg.energyLevel);

        gg.throwSomething();
        gg.throwSomething();
        gg.throwSomething();
        gg.eatBananas();
        gg.eatBananas();
        gg.eatBananas();
        gg.climb();
        mm.displayEnergy();
        

    }
    
}
