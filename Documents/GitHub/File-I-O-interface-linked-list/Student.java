import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends Employees {
	
	private String studentType;
	private int numclass;
	private int hours;
	private double price;
	
	public Student(){
		super();
	}
	
	public Student(long ID, String firstname, String familyname, String city, int hireYear, String studentType, int numclass, int hours){
		super(ID, firstname, familyname, city, hireYear);
		this.studentType=studentType;
		this.numclass=numclass;
		this.hours=hours;
		
	
		
	}
	
	public double salary(){
		if(studentType.equals("UGrad")){
			this.price=18.25*hours;
		}
		else if(studentType.equals("Grad")){
			this.price =18.25*1.2*hours;
		}
		return price;
	}
	
	
	public void addTARecords(){
		Long ID1=(long)0;
		int hireYear=0;

		String TAclass="";
		int numbclass =0;
		int totalhours=0;
		
		try{
		ArrayList<String> ArrPart = new ArrayList<String>();
		ArrayList<String> ArrFull = new ArrayList<String>();
		ArrayList<String> ArrL = new ArrayList<String>(); //use ArrayList or List?
		ArrayList<String> ArrStaff = new ArrayList<String>();
		BufferedReader inStaff = new BufferedReader(new FileReader("Staff.txt"));
		BufferedReader in = new BufferedReader( new FileReader("TAs.txt"));
		BufferedReader inFull = new BufferedReader(new FileReader("Full-Time-Faculty.txt"));
		BufferedReader inPart = new BufferedReader( new FileReader("Part-Time-Faculty.txt"));
		String line;
		
		while((line=in.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrL.add(line);
		
		}
		while((line=inPart.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrFull.add(line);
		
		}
		while((line=inFull.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrFull.add(line);
		
		}
		
		in.close();
		inFull.close();
		inPart.close();
		Scanner keys = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileOutputStream("TAs.txt",true));
	System.out.println("Enter your new records for TAs, write -1 to finish");
	
	C:while(true){//when -1 breaks this loop
	A:while(true){//duplicate breaks this loop --> goes to loop C which restart the ID
		boolean longue =false;
		//id
		
		while(!longue){
			boolean duplicate=true;
		System.out.println("Enter ID");
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
			for(int i =0; i<ArrFull.size();i++){
				String ArrayLine=	ArrFull.get(i);
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
					
				}}
		//hour rate
		boolean doubleClass=false;
		while(!doubleClass){
		try{
			System.out.println("Enter what kind of TA (UGrad or Grad)");
		
		TAclass = keys.nextLine();
		
		doubleClass = true;
		}
		
		catch(InputMismatchException e){
			String blank = keys.nextLine();
			System.out.println("wrong input");
					
				}
		}
		//hours
		boolean totalclass=false;
		while(!totalclass){
			try{
		System.out.println("Enter amount of hours");
		 numbclass = keys.nextInt();
		String blank4 = keys.nextLine();
		totalclass=true;
			}
			catch(InputMismatchException e){
				String blank = keys.nextLine();
				System.out.println("wrong input");

					}}
		//students
			boolean numhours=false;
			while(!numhours){
				try{
		System.out.println("enter how many students");
		 totalhours = keys.nextInt();
		String blank5 = keys.nextLine();
		numhours=true;}
				
				catch(InputMismatchException e){
					String blank = keys.nextLine();
					System.out.println("wrong input");

						}
				}
		
		try{
			ArrL.add(new Student(ID1, fname,lname,city,hireYear,TAclass,numbclass,totalhours).toString());
		}
		catch(NumberFormatException e){
			ArrL.add(new Student(ID1, fname,lname,city,hireYear,TAclass,numbclass,totalhours).toString());
		}
		out.print("\r\n"+new Student(ID1, fname,lname,city,hireYear,TAclass,numbclass,totalhours).toString());
	
		
	}
	

		}
	
	out.close();
	
	}
		catch (IOException e){
			System.out.println("Error");
		}
	}
	
public String toString(){
	return super.toString()+ " "+studentType+" "+ numclass +" "+ hours;
}
}
