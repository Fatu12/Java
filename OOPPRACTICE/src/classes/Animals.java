package classes;

public class Animals {
//	protect and it is inherited by other class then its subclasses can see those attributes
	 private String name;
	 private  int weight;
	 private  double height;
	  //static to make globale variable that all animal have same thing for all in this case
	  public static int aniamlCount;
	  
//   not need to be  have parmeter and also you can have as many as you want but 
	  // what makes them diffrent is that having prameters
	  public Animals(){
		  
	  }
	  
	  public Animals(String name){
		 this.setName(name);
		 this.height = 0;
		 aniamlCount ++;
		  
	  
	  }
	  //
	 public Animals(int weight, double height){
		  this.weight = weight;
		  this.height = height;	    
		  
	  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public static int getAniamlCount() {
		return aniamlCount;
	}

	public static void setAniamlCount(int aniamlCount) {
		Animals.aniamlCount = aniamlCount;
	}
	  
	  
	  
	 
	

}
