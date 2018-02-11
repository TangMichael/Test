
public class Staff extends Employees {
	private int salary;
	private char code;
	
	
	public Staff(){
		super();
		
	}
	
	
	public Staff(long ID, String firstname, String familyname, String city, int hireYear, int salary, char code){
		super(ID, firstname, familyname, city,hireYear);
		this.code=code;
		this.salary=salary;
		
		
		
		
	}
	
	public String toString(){
		return super.toString()+"	"+ salary+ "	"+code;
	}

}
