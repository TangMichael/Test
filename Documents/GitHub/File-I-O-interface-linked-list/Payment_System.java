import java.io.BufferedReader;
import java.io.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class Payment_System {
	
	public static void findTermSalary(){
		EmployeeList partlist = new EmployeeList();
		EmployeeList TAlist = new EmployeeList();
		try{
			BufferedReader partTimeFile = new BufferedReader(new FileReader("Part-Time-Faculty.txt"));
			BufferedReader TAfile = new BufferedReader(new FileReader("TAs.txt"));
			String line;
			while((line=partTimeFile.readLine())!=null){
			
				String parts []= line.split("\\s+");
				Long Id = Long.parseLong(parts[0]);
				int year = Integer.parseInt(parts[4]);
				double rate = Double.parseDouble(parts[5]);
				int hours = Integer.parseInt(parts[6]);
				int students = Integer.parseInt(parts[7]);
				
				partlist.add(new part_time(Id, parts[1],parts[2],parts[3],year,rate,hours,students));
				
			}
			
			while((line=TAfile.readLine())!=null){
				String parts[]=line.split("\\s+");
				Long Id = Long.parseLong(parts[0]);
				int year = Integer.parseInt(parts[4]);
				int classes = Integer.parseInt(parts[6]);
				int hours  =Integer.parseInt(parts[7]);
				
				if(parts[5].equals("Alum")){
					
				}
				else
					TAlist.add(new Student(Id,parts[1],parts[2],parts[3],year,parts[5],classes,hours));
			}
			
		double totalTA=0;
			for(int i=1;i<TAlist.Size()+1;i++){
				String parts[]=TAlist.getList(i).split("\\s+");
				Long Id = Long.parseLong(parts[0]);
				int year = Integer.parseInt(parts[4]);
				int classes = Integer.parseInt(parts[6]);
				int hours  =Integer.parseInt(parts[7]);
				double totalSalary=new Student(Id,parts[1],parts[2],parts[3],year,parts[5],classes,hours).salary();
			totalTA+=totalSalary;	
			}
			double totalPart=0;
			for(int i=1;i<partlist.Size()+1;i++){
				String parts []= partlist.getList(i).split("\\s+");
				Long Id = Long.parseLong(parts[0]);
				int year = Integer.parseInt(parts[4]);
				double rate = Double.parseDouble(parts[5]);
				int hours = Integer.parseInt(parts[6]);
				int students = Integer.parseInt(parts[7]);
				double totalSalary=new part_time(Id, parts[1],parts[2],parts[3],year,rate,hours,students).salary();
			
				totalPart+=totalSalary;
			}
			System.out.println("The total salary for this term is "+(totalPart+totalTA));
			
		partTimeFile.close();
		TAfile.close();
		}
		catch (IOException o){
			System.out.println("error");
		}
		
	}
	
	public static void findHighest_and_Lowest_FT_Salary(){
		EmployeeList fullList = new EmployeeList();
	try{
		
		BufferedReader in = new BufferedReader(new FileReader("Full-Time-Faculty.txt"));
		String line="";
		while((line=in.readLine())!=null){//add to the list

			String parts []= line.split("\\s+");
			Long Id = Long.parseLong(parts[0]);
			int year = Integer.parseInt(parts[4]);
			int salary = Integer.parseInt(parts[5]);
			fullList.add(new full_time(Id,parts[1],parts[2],parts[3],year,salary));
		
		}
		
		
	
		
		String fullparts="";
		fullparts=fullList.getList(1);
		String parts []= fullparts.split("\\s+");
		Long Id = Long.parseLong(parts[0]);
		int year = Integer.parseInt(parts[4]);
		int salary = Integer.parseInt(parts[5]);
		
		
		full_time max=new full_time(Id,parts[1],parts[2],parts[3],year,salary);
		full_time min=new full_time(Id,parts[1],parts[2],parts[3],year,salary);

		
	for(int i=2;i<fullList.Size()+1;i++){
		fullparts=fullList.getList(i);
		String []parts2= fullparts.split("\\s+");
		Long Id1 = Long.parseLong(parts2[0]);
		int year1 = Integer.parseInt(parts2[4]);
		int salary1 = Integer.parseInt(parts2[5]);
		full_time compare=new full_time(Id1,parts2[1],parts2[2],parts[3],year1,salary1);
		
			if(compare.getSalary()>max.getSalary()){
				max=compare;
			
			}
			else if(compare.getSalary()<max.getSalary()){
				min=compare;
			
			}
			else {
			
			}
		
			
	}
	for(int i=1;i<fullList.Size()+1;i++){
		fullparts=fullList.getList(i);
		String []parts2= fullparts.split("\\s+");
		
		int salary1 = Integer.parseInt(parts2[5]);
		if(max.getSalary()==salary1){
			System.out.println(fullparts);
		}
		else if(min.getSalary()==salary1){
			System.out.println(fullparts);
		}
		
	
	}
	
	
	in.close();
	}
		catch(IOException e){
			System.out.println("error");
		}
	}
	
	public static void Increase_Staff_Salary(){
		EmployeeList staffList = new EmployeeList();
		EmployeeList updatedList = new EmployeeList();
		try{
		
			BufferedReader staffFile = new BufferedReader(new FileReader("Staff.txt"));
		String line;
		while((line=staffFile.readLine())!=null){
		
			String parts []= line.split("\\s+");
			Long Id = Long.parseLong(parts[0]);
			int year = Integer.parseInt(parts[4]);
			int salary = Integer.parseInt(parts[5]);
			char performance = parts[6].charAt(0);
		
			staffList.add(new Staff(Id, parts[1],parts[2],parts[3],year, salary,performance));
		}
		
		for(int i =1; i<staffList.Size()+1;i++){
			String record=staffList.getList(i);
	
			String parts []= record.split("\\s+");
			Long Id = Long.parseLong(parts[0]);
			int year = Integer.parseInt(parts[4]);
			int salary = Integer.parseInt(parts[5]);
			char performance = parts[6].charAt(0);
			
			if(performance=='A'){
				salary=(int)(salary*1.08);
				performance='E';
			}
			else if (performance =='B'){
				salary=(int)(salary*1.06);
				performance='E';
				}
			else if(performance=='C'){
				salary=(int)(salary*1.03);
				performance='E';
				}
			else if(performance=='D'){
				salary=(int)(salary*1.01);
				performance='E';
				}
			else {
				}
			updatedList.add(new Staff(Id, parts[1],parts[2],parts[3],year , salary,performance));
			
			
		}
		PrintWriter out = new PrintWriter(new FileOutputStream("Staff.txt"));
		for(int k=1;k<updatedList.Size()+1;k++){
			out.print(updatedList.getList(k)+"\r\n");
			
		}
		staffFile.close();
		out.close();
	}
		catch(IOException o){
			System.out.println("error");
		}
	}
	
	public static void main(String args[]){
		
		findTermSalary();
		
		//part_time ok=new part_time();
		//ok.addPTRecords();
		//Student michael = new Student();
		//michael.addTARecords();
		//full_time lao = new full_time();
		//lao.addFTRecords();
		findHighest_and_Lowest_FT_Salary();
		//Increase_Staff_Salary();
		
		
	}
	
	

}
