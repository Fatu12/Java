
// this class Encapsulation
public class Bat extends Mammal{
    public Bat(){
        // Inheritance is the idea that we pass along attributes and methods from 
        //one class into a "sub-class" or child class thought out super key
        super();
        energyLevel = 300;
    }
    public void fly(){
        if(energyLevel <=0){
            System.out.printf("\n You dead you can't flay", energyLevel);
        }
        else{
             super.decrementEnergy(50);
             System.out.printf("\n Bat  has fly a tree %s ", energyLevel);
        }
        displayEnergy();
   
    }
    public  void eatHuman(){
        super.incrementEnergy(25);
        System.out.printf("\n so-well, never mind  %s", this.energyLevel);
        displayEnergy();

    }
    public void attackTown(){
        super.decrementEnergy(100);
        System.out.printf("\n Town on fire %s", this.energyLevel);
        displayEnergy();

    }
    
}
