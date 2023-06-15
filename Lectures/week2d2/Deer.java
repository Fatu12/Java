
public class Deer extends Animal {
    static int deerCount;
    // every time we create frog instance it going to increment
    public Deer(String name){
        // when we call super it going to call parent class which means where it get inherited from
        // and call the constructor we get it arguments for it
        super(name);
        this.energy = 50;
        deerCount ++;
    }
    public void display(){
        System.out.println("Deer  Class");
        super.display();
        System.out.printf("All Deer: %s \n", deerCount);
    }
    public void run(){
        if(this.isLivingCheck()){
            super.decrementEnergy(15);
            //  this.energy -= 15;
             System.out.printf(" \n  Hop Hop", this.getName());
            // this.setIsLiving(false);
            // System.out.println("Your dead, you can't run");
        }
        else{
            System.out.printf("\n  Your dead, you can't jump");
        }
        
        
    }
    
}
