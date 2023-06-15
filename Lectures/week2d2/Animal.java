
public class Animal {
    // member variable
    private String name;
    private double height;
    private int weight;
    protected int energy =20;
    private boolean isLiving = true;
    public static int animalCount;

    public Animal(){
        this.name = "defualt123";
        this.height = 0.0;
        this.weight = 0;

        animalCount ++;
    }
    // Constructors
    public Animal(String name){
        this.name = name;
        this.height = 0;
        this.weight = 0;
        animalCount ++;
    
    }
    public Animal(String name, double height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
        animalCount++;

    }
    // method 

    public void display(){
        System.out.printf("\n Animal Class");
        System.out.printf(" \n name %s",this.name);
        System.out.printf("\n energy %s ",this.energy);
        System.out.printf("\n All animal %s",animalCount);
    }
    public boolean isLivingCheck(){
        if(this.energy <= 0){
    
            this.setIsLiving(false);
        }
        else{
            return this.isLiving;
        }
        return isLiving;
    }
    public void decrementEnergy(int values){
        this.energy -= values;
    }

    // we need getter and setter to access to member variable since they are private
    // ! getter and setter
    public String getName(){
        return this.name ;
    }
    public double getHeight(){
        return this.height;
    }
    public double getAnimalCount(){
        return this.animalCount;
    }
    public double  getWeight (){
        return this.weight ;
    }
    public double  getEnergy(){
        return this.energy ;
    }
    public boolean getIsLiving(){
        return this.isLiving ;
    }

    public void setName(String  name){
        this.name = name;
    }
   
    public void setHeight(double height){
        this.height = height;
    }
   
    public void setWeight(int weight){
        this.weight = weight;
    }
   
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public void setIsLiving (boolean isLiving){
        this.isLiving = isLiving;
    }

   
   
    
}
