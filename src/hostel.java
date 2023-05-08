import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class hostel extends Object implements Serializable {

	static Scanner in = new Scanner(System.in);
	
	private List<tenant> collection;

	/*Array List has been created*/
	public hostel() {
		collection = new ArrayList<tenant>();		
	}
	
	/*This method is use for add tenant information from from addTenant.MainSystem 
	to array list*/
	public void addTenant(tenant Tenant) {
			
		if(collection.size()<2) {
			collection.add(Tenant);
			System.out.println("\nYour information has been saved. Thank You!!\n");
		}else {
			System.out.println("\nSorry, your choosen hotel is full. Please register other hostel !\n");
		}
	}
	
	/*This method is to remove tenant info based on index number in array list*/
	public void removeTenant() {
		System.out.println("Select index you want to delete");
		int bil= in.nextInt();
		collection.remove(bil-1);
		System.out.println("Delete successfully");
	}
	
	/*toString method is use for collect add type of data in Array List and 
	 return to one string value named total*/
	public String toString() {
		String total = "\n";
		Iterator<tenant> i = collection.iterator();
		while(i.hasNext()) {
			tenant b = (tenant)i.next();	
			total = total+b.toString();

		}
		return total;
	}	
}
