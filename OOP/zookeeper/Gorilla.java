
public class Gorilla extends Mammal { 
// super key must has constructor
// ! that super is inheriting 
    public Gorilla(){
        super();
    }
    // methods
    public void throwSomething(){
        this.decrementEnergy(5);
        System.out.printf("\n Gorilla throw something %s",this.energyLevel);
    }
    
    public void eatBananas(){
        // this.energyLevel += 10;
        super.incrementEnergy(10);
        System.out.printf("\n Gorilla has eaten banana %s", this.energyLevel);
    }
    public void climb(){
        super.decrementEnergy(10);
        System.out.printf("\n Gorilla has climbed  a tree %s ", energyLevel);

    }
    
}
