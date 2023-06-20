
public class Frog extends Animal {
    static int frogCount;
    // every time we create frog instance it going to increment
    public Frog(String name){
        // when we call super it going to call parent class which means where it get inherited from
        // and call the constructor we get it arguments for it
        super(name);
        this.energy = 10;
        frogCount ++;
    }

    public void display(){
        System.out.println("Frog Class");
        super.display();
        System.out.printf("All Frogs: %s \n", frogCount);
    }
    public void move(){
        // if(this.energy <= 0){
            if(this.isLivingCheck()){
            super.decrementEnergy(15);
            }
        //     this.setIsLiving(false);
        //     System.out.println("Your dead, you can't jup");
        // }
        else{
        // this.energy -= 5;
        // System.out.println("Hop Hop");
        
            super.decrementEnergy(15);
            System.out.printf("%s ded, you can't hop. \n", this.getName());
        }
    }

public static int getFrogCount(){
    return frogCount;
}
public void setFrogCount(int frogCount){
    this.frogCount = frogCount;

}
}
