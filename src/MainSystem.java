import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class MainSystem {

	static String fileName = null;
	static hostel hos = new hostel();
	static Scanner in = new Scanner(System.in);
	static Scanner scan = new Scanner(System.in).useDelimiter("\n");
	static Boolean running = true;
	static Boolean running1 = true;
	static Boolean running2 = true;
	 

	public static void main(String[] args) {
		
		int answer,addChoice;

		while (running) {
			
			System.out.println("[----Welcome to UTHM Hostel Application----]");
			System.out.print("\n1 for ADMIN and 2 for TENANT"+"\n >");
			int roles = in.nextInt();
			
			//Divide roles between users and admins using the switch case method.
			switch (roles) {
			case 1:
				
				System.out.print("\nPlease enter ADMIN password : ");
				String inPass = scan.nextLine();
				
				if("admin123".equals(inPass)) {//Check the password whether it is the same or not.
					
					while(running1) {
						
						System.out.print("\nEnter 1 for list tenant in Hostel"+"\nEnter 2 for add tenant to hostel"
						+"\nEnter 3 for delete tenant"+"\nEnter 4 for quit"+"\n > ");
						answer = in.nextInt();
						
						switch (answer) {	
						case 1:			
							listTenant();	
							break;
							
						case 2:
							System.out.println("\n1 for TSN"+"\n2 for TSI");
							addChoice =  in.nextInt(); 
							
							switch (addChoice) {
							case 1:
								fileName = "tsn";
								loadScript(fileName);
								
								addTenant();
								save(fileName);
								break;
							case 2:
								fileName = "tsi";
								loadScript(fileName);
								
								addTenant();
								save(fileName);
								break;	
							}
							break;
							
						case 3:
							System.out.println("\n1 for TSN"+"\n2 for TSI");
							addChoice =  in.nextInt(); 
							
							switch (addChoice) {
							case 1:
								fileName = "tsn";
								loadScript(fileName);
								System.out.println(hos.toString());
								hos.removeTenant();//Call removeTenant method from hostel class.
								save(fileName);
								break;
							case 2:
								fileName = "tsi";
								loadScript(fileName);
								System.out.println(hos.toString());
								hos.removeTenant();//Call removeTenant method from hostel class.
								save(fileName);
								break;	
							}
							break;
						case 4:							
							running1=false;
							System.out.println("System Exited...\n");
							break;
						}
					}	
					break;
						
					}System.exit(0);					
			case 2:
				
				while (running2) {
					System.out.print("1 for Register Hostel\n2 for Quit and Save\n > ");
					addChoice =  in.nextInt();
					
					switch(addChoice) {
					case 1:
						System.out.print("Please choose the hostel:\n1 for TSN\n2 for TSI\n > ");
						addChoice =  in.nextInt(); 
				
						switch (addChoice) {
						case 1:
							fileName = "tsn";
							loadScript(fileName);
							
							addTenant();
							save(fileName);
							break;
						case 2:
							fileName = "tsi";
							loadScript(fileName);
							addTenant();
							save(fileName);
							break;	
						}
						break;
					
					case 2: 
						running2=false;
						System.out.println("System Exited...\n");
						break;
					}
				}
				break;	
			}
		}
		System.exit(0);
	}

	//This method is use for listing all tenant information based on admin choices.
	private static void listTenant() {
		int listChoice;
		
		System.out.println("0 for list all tenant"+"\n1 for list all tenant from TSN"+"\n2 for list all tenant from TSI");
		listChoice = in.nextInt();
		
		switch (listChoice) {
		case 0:
			System.out.print("\nTun Syed Nassir ");
			fileName = "tsn";
			loadScript(fileName);
			System.out.println(hos.toString());
			
			System.out.print("\nTun Syed Ismail ");
			fileName = "tsi";
			loadScript(fileName);
			System.out.println(hos.toString());				
			break;
		case 1:
			System.out.println("\nTun Syed Nassir ");
			fileName = "tsn";
			loadScript(fileName);
			System.out.println(hos.toString());
			break;
		case 2:
			System.out.println("\nTun Syed Ismail ");
			fileName = "tsi";
			loadScript(fileName);
			System.out.println(hos.toString());
			break;
		}
	}

	
	//This method is to display instruction for tenant information input 
	private static void addTenant() {
		String matric,name,ic;
		int age ;	
		
		System.out.println("\nEnter Name:");
		name = scan.nextLine();		
		
		System.out.println("\nEnter Matric No:");
		matric = scan.nextLine();
		
		System.out.println("\nEnter Age:");
		age = in.nextInt();
		
		System.out.println("\nEnter IC:");
		ic = scan.nextLine();
		
		tenant b = new tenant(matric, name, age,ic);
		hos.addTenant(b);
	}
	
	/*private static void saveAndQuit() {
		System.out.print("Enter file name:");
		fileName = in.next() + ".ser";
		running = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(hos);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	//This method is to save tenant information into Array List that had been created named tsn.ser and tsi.ser
	private static void save(String hostelName) {
		
		fileName = hostelName+".ser";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(hos);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//This method is use to load file.ser such as tsn.ser and tsi.ser
	private static void loadScript(String name) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		File file = new File(name+".ser");
		if(file.exists()) {
			try {//The try statement allows you to define a block of code to be tested for errors while it is being executed.
				fis = new FileInputStream(file);//The InputStream is used to read data from a source.
				in = new ObjectInputStream(fis);
				hos = (hostel) in.readObject();
				fis.close();
				in.close();
				
			//The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.	
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {					
			System.out.print("\nThe file does not exist! ");				
		}	
	}
}
