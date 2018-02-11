
public class EmployeeList{
	
	
	private EmployeesNode list;
	private int size;
	
	public EmployeeList(){
		list=null;
	}
	
	
	public String getList(int j){
		String result ="";
		EmployeesNode current =list;
		
		if(list==null){
			return "no object";
		}
		else{
			current=list;
		
		for(int i=0;i<j;i++){
		if(current!=null){
			result= current.employee+"";
			current=current.next;
		}
		else 
			return "no object";
		}
			
		return result;}
			
		}
		
		
	public void remove(int j){
		String result ="";
		EmployeesNode current =list;
		
		if(list==null){
			
		}
		else{
			current=list;
		
		for(int i=0;i<j;i++){
		if(current!=null){
			result= current.employee+"";
			current=current.next;
			
		}
		}	
		current.employee=null;
	}
		
	}
	
	
	
	public void add (Employees employee){
		EmployeesNode node =new EmployeesNode(employee);
		EmployeesNode current;
		if(list==null){
			list=node;
		}
		else{
			current=list;
			while(current.next!=null)
				current=current.next;
			current.next=node;
			
		}
		size++;
	}
	public int Size(){
		return size;
	}
	public String toString(){//can i make it return the object instead of string
		String result="";
		EmployeesNode current =list;
		while(current!=null){
			result+= current.employee+"\n";
			current=current.next;
		}
		return result;
	}
	
	private class EmployeesNode{
		public Employees employee;
		public EmployeesNode next;
		
		public EmployeesNode (Employees part){
			employee=part;
			next = null;
		}
	}
	
	

}
