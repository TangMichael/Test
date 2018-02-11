
public class Employees implements Ordered {
	private long ID;
	private String firstname;
	private String familyname;
	private String city;
	private int hireYear;
	
	
	
	public Employees(){
		
	}
	
	public Employees(long ID, String firstname, String familyname, String city, int hireYear){
		this.ID=ID;
		this.firstname=firstname;
		this.familyname=familyname;
		this.city=city;
		this.hireYear=hireYear;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getHireYear() {
		return hireYear;
	}

	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
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
	
	
	public String toString(){
		String newcity=String.format("%0$-10s", city);
		return ID+ " "+ firstname+"	" + familyname+"		"+newcity + "	"+hireYear;
		
	}
	



	

}
