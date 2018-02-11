import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class full_time extends Employees{
	
	private int salary;
	
	public full_time(){
		super();
	}
	
	public full_time(long ID, String firstname, String familyname, String city, int hireYear, int salary){
		super(ID, firstname, familyname, city, hireYear);
		this.salary=salary;
		
		
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString(){
		return super.toString()+"	"+salary;
	}
	
	
	public void addFTRecords(){
		Long ID1=(long)0;
		int hireYear=0;
		int salaryNum=0;
		try{
			
		ArrayList<String> ArrL = new ArrayList<String>(); 
		ArrayList<String> ArrTA = new ArrayList<String>();
		ArrayList<String> ArrPart = new ArrayList<String>();
		ArrayList<String> ArrStaff = new ArrayList<String>();
		BufferedReader inStaff = new BufferedReader(new FileReader("Staff.txt"));
		BufferedReader in = new BufferedReader( new FileReader("Full-Time-Faculty.txt"));
		BufferedReader inPart = new BufferedReader(new FileReader("Part-Time-Faculty.txt"));
		BufferedReader inTA = new BufferedReader (new FileReader("TAs.txt"));
		String line;
		

		while((line=inStaff.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrStaff.add(line);
	
		}
		while((line=inPart.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrPart.add(line);
		
		}
		while((line=inTA.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrTA.add(line);
		
		}
		while((line=in.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrL.add(line);
		
		}
	
		inStaff.close();
		in.close();
		inPart.close();
		inTA.close();
		Scanner keys = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileOutputStream("Full-Time-Faculty.txt",true));
	System.out.println("Enter your new records for full time, write -1 to finish");
	
	C:while(true){//when -1 breaks this loop
	A:while(true){//duplicate breaks this loop --> goes to loop C which restart the ID
		boolean longue =false;
		//id
		
		while(!longue){
		System.out.println("Enter ID");
		boolean duplicate=true;
		try{
		ID1=keys.nextLong();
		String blank = keys.nextLine();
		longue=true;
		
		}
catch(InputMismatchException e){
	String blank = keys.nextLine();
	System.out.println("wrong input");
	duplicate=false;
		}
		if(ID1==-1){
			break C;
		}
		
		
		
		B:while(duplicate){
			for(int i =0; i<ArrL.size();i++){
			String ArrayLine=	ArrL.get(i);
			String record [] = ArrayLine.split("\\s+");
			Long IDCompare = Long.parseLong(record[0]);
		
			if(IDCompare.equals(ID1)){
				System.out.println("Duplicate Id please enter a new one");
				break A;
			}
			else{
				duplicate=false;
				}
			}
			
			for(int i =0; i<ArrPart.size();i++){
				String ArrayLine=	ArrPart.get(i);
				String record [] = ArrayLine.split("\\s+");
				Long IDCompare = Long.parseLong(record[0]);
			
				if(IDCompare.equals(ID1)){
					System.out.println("Duplicate Id please enter a new one");
					break A;
				}
				else{
					duplicate=false;
					}
				}
			for(int i =0; i<ArrTA.size();i++){
				String ArrayLine=	ArrTA.get(i);
				String record [] = ArrayLine.split("\\s+");
				Long IDCompare = Long.parseLong(record[0]);
			
				if(IDCompare.equals(ID1)){
					System.out.println("Duplicate Id please enter a new one");
					break A;
				}
				else{
					duplicate=false;
					}
				}
			for(int i =0; i<ArrStaff.size();i++){
				String ArrayLine=	ArrStaff.get(i);
				String record [] = ArrayLine.split("\\s+");
				Long IDCompare = Long.parseLong(record[0]);
			
				if(IDCompare.equals(ID1)){
					System.out.println("Duplicate Id please enter a new one");
					break A;
				}
				else{
					duplicate=false;
					}
				}
			
		
		
		}
		
		}
		//name
		System.out.println(ID1);
		System.out.println("Enter first name");
		String fname = keys.nextLine();
		
		
		
		//name
		System.out.println("Enter last name");
		String lname = keys.nextLine();
		//city
		System.out.println("Enter city");
		String city = keys.nextLine();
		
		//hireyear
		boolean HireInt=false;
		while(!HireInt){
		try{System.out.println("Enter Hire year");
		hireYear = keys.nextInt();
		String blank2 = keys.nextLine();
		HireInt=true;
		
		}
		catch(InputMismatchException e){
			String blank = keys.nextLine();
			System.out.println("wrong input");
					
				}
		boolean salaryamount= false;
		while(!salaryamount){
			try{
				System.out.println("Enter Salary");
				salaryNum = keys.nextInt();
				String blank3 = keys.nextLine();
				salaryamount =true;
						
			
			}
			catch(InputMismatchException e){
				String blank = keys.nextLine();
				System.out.println("wrong input");
						
					}
		}
	
		}
		
				
		
		try{
			ArrL.add(new full_time(ID1, fname,lname,city,hireYear,salaryNum).toString());
		}
		catch(NumberFormatException e){
			ArrL.add(new full_time(ID1, fname,lname,city,hireYear,salaryNum).toString());
		}
		out.print("\r\n"+new full_time(ID1, fname,lname,city,hireYear,salaryNum).toString());
	
		
	}
	

		}
	
	out.close();
	
	}
		catch (IOException e){
			System.out.println("Error");
		}
		
		
	
	
	
	
	}
	
	
	
	

}
