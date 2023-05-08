import java.io.Serializable;

public class tenant implements Serializable {

	private String matric;
	private String name;
	private String ic;
	private int age;
	
	//Initialized value for each parameter
	public tenant(){
		age=0;
		name=null;
		matric=null;
		ic=null;	
	}
	
	 // Constructor with a parameter.
	public tenant(String matric, String name, int age,String ic) {
		this.name=name;
		this.matric = matric;
		this.age = age;
		this.ic= ic;	
	}
	
	//Display all tenant information.
	public String toString() {
		return "\n\n\tMatric No : "+ matric+"\n\tName : "+name+"\n\tAge : "+age+"\n\tIC : "+ic;
	}
	
}
