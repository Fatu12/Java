

public class Mammal {
    // member variable 
    public int energyLevel  = 100 ;
    // since we have default value we don't need to pass energyLevel as parameter 
    public Mammal(){
    
    }

    // this method should show the animal's energy level as well as return it 
    public int displayEnergy(){
        int totalCount = 0;
        totalCount += energyLevel;
        System.out.printf("\n Mammals Energy Level %s", this.energyLevel);
        return  this.energyLevel ;

    }
    // getter
    public int  getEnergyLevel(){
       return this.energyLevel ;
    }
    // setter
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
