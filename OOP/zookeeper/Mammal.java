

public class Mammal {
    // member variable 
    protected int energyLevel = 100;
    
    // 
    public Mammal( int energyLevel){
        this.energyLevel  = energyLevel;
    }

    // this method should show the animal's energy level as well as return it 
    public int displayEnergy(){
        int totalCount = 0;
        totalCount += energyLevel;
        System.out.printf("\n Mammals Energy Level %s", this.energyLevel);
       return  this.energyLevel ;

    }
    

    public int  getEnergyLevel(){
       return this.energyLevel ;
    }
    public void  setEnergyLevel( int energyLevel){
         this.energyLevel= energyLevel;
    }
    public void decrementEnergy(int values ){
        this.energyLevel -= values;

    }
    public void incrementEnergy(int values){
        this.energyLevel += values;
    }

    
}
