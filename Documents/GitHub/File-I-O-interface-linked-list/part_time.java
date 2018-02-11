import java.io.*;

import java.util.*;

public class part_time extends Employees{
	
	private double hourRate;
	private int hours;
	private int students;
	private double price;
	
	public part_time(){
		super();
	}
	
	public part_time(long ID, String firstname, String familyname, String city, int hireYear, double hourRate, int hours, int students){
		super(ID, firstname, familyname, city, hireYear);
		this.hourRate =hourRate;
		this.hours = hours;
		this.students=students;
	}

	public double getHourRate() {
		return hourRate;
	}

	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getStudents() {
		return students;
	}

	public void setStudents(int students) {
		this.students = students;
	}
	
	public boolean precedes(Object a){
		if(this.getHireYear()<((Employees) a).getHireYear()){
			return true;
		}
		else
			return false;
	}
	
	public boolean follows(Object b){
		if(this.getHireYear()>((Employees) b).getHireYear()){
			return true;
		}
		else 
			return false;
		
	}
	
	public double salary(){
		if(students>40&&students<60){
			this.price= hourRate*hours+500;
		}
		else if(students>60){
			this.price= hourRate*hours+1000;
		}
		else
			this.price= hourRate*hours;
		return price; 
		
	}

	
	public String toString() {
	return super.toString()+ "	" + hourRate+ "	" +hours+ "	"+students;
	}
	



	
	public void addPTRecords(){
		Long ID1=(long)0;
		int hireYear=0;
		double hourRateIn=0;
		int hoursIn=0;
		int studentsIn=0;
		
		try{
			
		ArrayList<String> ArrL = new ArrayList<String>(); //use ArrayList or List?
		ArrayList<String> ArrTA = new ArrayList<String>();
		ArrayList<String> ArrFull = new ArrayList<String>();
		ArrayList<String> ArrStaff = new ArrayList<String>();
		BufferedReader inStaff = new BufferedReader(new FileReader("Staff.txt"));
		BufferedReader inFull = new BufferedReader(new FileReader("Full-Time-Faculty.txt"));
		BufferedReader inTA = new BufferedReader (new FileReader("TAs.txt"));
		BufferedReader in = new BufferedReader( new FileReader("Part-Time-Faculty.txt"));
		String line;
		while((line=inTA.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrTA.add(line);
			
		}
		while((line=inFull.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrFull.add(line);
			
		}
		
		while((line=in.readLine())!=null){//do i need to parse so it becomes a p-t faculty?
			ArrL.add(line);
		
		}
	
		inStaff.close();
		in.close();
		inTA.close();
		inFull.close();
		Scanner keys = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileOutputStream("Part-Time-Faculty.txt",true));
	System.out.println("Enter your new records for part time, write -1 to finish");
	
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
			
			for(int i =0; i<ArrFull.size();i++){
				String ArrayLine=ArrFull.get(i);
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
		boolean doublerate=false;
		while(!doublerate){
		try{
			System.out.println("Enter hour rate");
		
		hourRateIn = keys.nextDouble();
		String blank3 = keys.nextLine();
		doublerate = true;
		}
		
		catch(InputMismatchException e){
			String blank = keys.nextLine();
			System.out.println("wrong input");
					
				}
		}
		//hours
		boolean totalhours=false;
		while(!totalhours){
			try{
		System.out.println("Enter amount of hours");
		 hoursIn = keys.nextInt();
		String blank4 = keys.nextLine();
		totalhours=true;
			}
			catch(InputMismatchException e){
				String blank = keys.nextLine();
				System.out.println("wrong input");

					}}
		//students
			boolean totalstudents=false;
			while(!totalstudents){
				try{
		System.out.println("enter how many students");
		 studentsIn = keys.nextInt();
		String blank5 = keys.nextLine();
		totalstudents=true;}
				
				catch(InputMismatchException e){
					String blank = keys.nextLine();
					System.out.println("wrong input");

						}
				}
		
		try{
			ArrL.add(new part_time(ID1, fname,lname,city,hireYear,hourRateIn,hoursIn,studentsIn).toString());
		}
		catch(NumberFormatException e){
			ArrL.add(new part_time(ID1, fname,lname,city,hireYear,hourRateIn,hoursIn,studentsIn).toString());
		}
		out.print("\r\n"+new part_time(ID1, fname,lname,city,hireYear,hourRateIn,hoursIn,studentsIn).toString());
	
		
	}
	

		}
	
	out.close();
	
	}
		catch (IOException e){
			System.out.println("Error");
		}
		
		
	
	
	
	
	}

}
