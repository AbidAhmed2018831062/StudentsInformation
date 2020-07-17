package Students;

import java.util.*;

public class StudentInformation {
	private static int  k=0;
	private String fathers_name;
	private String mothers_name;
	private String religion ;
	private String dept_name;
	private String first_name;
	private String last_name;
	private String id;
	private String idLastPart;
	private String pin;
	private int fees;
	private double grade;
	private  static final  int totalfees=10000;
	private int remainingfees=10000;
	private double[] marksheet=new double[8];
	private String mobile_number;
	private String email_id;
	
	
	Scanner sc=new Scanner(System.in);
	
	 ArrayList<StudentAccount> accounts=new ArrayList<StudentAccount>();
	public StudentInformation(String first_name,String last_name,String pin,String id)
	{
		k++;
		this.first_name=first_name;
		this.last_name=last_name;
		this.pin=pin;
		this.id=id;
		 String s="1234567890";
		 System.out.print("Enter Your Father's Name: ");
		fathers_name=sc.nextLine();
		 System.out.print("Enter Your Mother's Name: ");
			mothers_name=sc.nextLine();
			 System.out.print("Enter Your Mobile Number: ");
				mobile_number=sc.nextLine();
				 System.out.print("Enter Your Religion: ");
					religion=sc.nextLine();
					 System.out.print("Enter Your Department Name: ");
						dept_name=sc.nextLine();
		
			 email_id = first_name+last_name+dept_name+"@gmail.sust.id";
	System.out.println("\nDear "+first_name+" "+last_name+" your account is created.\nYour id is "+this.id);
	System.out.println();
	grade=makeMarksheet();
	StudentAccount account=new StudentAccount("Savings",id,first_name,pin);
	this.addnewAccount(account);
		
	}
	public String getId()
	{//System.out.println(id);
		return id;
	}
	public String getPin() {
		//System.out.println(pin);
		return pin;
	}
	public String getfirst_name() {
		// TODO Auto-generated method stub
		return first_name;
	}
	public void payFees() {
	System.out.print("\nYou have "+remainingfees+" to pay.\nHow much would you like to pay?: $");
	int pay=0;
	while(true) {
	 pay=sc.nextInt();
	 if(pay>remainingfees)
	 {
		 System.out.println("You have less remaining fees to pay!!!.\nPlease Enter valid amount!!! ");
		 System.out.print("Enter Your choice: ");
		 continue;
	 }
	 else
		 break;
	}
	remainingfees-=pay;
	System.out.println("\nYou have paid $"+pay+".You have now $"+remainingfees+" to pay\n");
		
	}
	public int remainingFees() {
		return remainingfees;
	}
	public double makeMarksheet() {
		Random ran=new Random();
     	double math=ran.nextDouble()*4.0;
     	double eng=ran.nextDouble()*4.0;
     	double phy=ran.nextDouble()*4.0;
     	double che=ran.nextDouble()*4.0;
     	double cse=ran.nextDouble()*4.0;
     	double cprog=ran.nextDouble()*4.0;
     	double eee=ran.nextDouble()*4.0;
     	double plab=ran.nextDouble()*4.0;
	    marksheet[0]=math;
	    marksheet[1]=eng;
	    marksheet[2]=phy;
	    marksheet[3]=che;
	    marksheet[4]=cse;
	    marksheet[5]=cprog;
	    marksheet[6]=eee;
	    marksheet[7]=plab;
	    return (math+eng+phy+che+cse+cprog+eee+plab)/8;
	}
	public String showMarksheet()
	{
		return ("You Have got "+grade+"\nYou have got "+marksheet[0]+" in Mathematics.\nYou have got "+marksheet[1]+" in English.You have got "	+ marksheet[2]+" in Physics.\nYou have got "+marksheet[3]+" in Chemistry.\nYou have got "+marksheet[4]+" in Computer Science."+
				"\n.You have got "+marksheet[5]+" in C Programming.\nYou haave got "+marksheet[6]+" in Electrical and Electronical Engineering.\nYou have got "+marksheet[7]+" in Physics Lab");
	}
	public void logIn(int i) {
		System.out.println("In which account you want to log in??");
		int c=sc.nextInt();
		accounts.get(c-1).logIntoBankAccount(this,c-1);
		
	}
	public int getaccountsize() {
		// TODO Auto-generated method stub
		return accounts.size();
	}
	public void addnewAccount(StudentAccount account) {
	accounts.add(account);
		
	}
	public int getAccountBalance(int from) {
		// TODO Auto-generated method stub
	return 	accounts.get(from).getAccountBalance();
	}
	public void addAccountBalnce(int c2,int to) {
		accounts.get(to).addBalance(c2);
		
		
	}
	public void deductBalance(int c2, int from) {
accounts.get(from).deductBalcne(c2);
		
	}
	public String getAccountName(int from) {
		// TODO Auto-generated method stub
		return accounts.get(from).getName();
	}
	public int logIntoBankAccount()
	{
		int p=1;
		sc.nextLine();
		while(true)
		{
			System.out.print("\nEnter Your Bank User Id: ");
			String id=sc.nextLine();
			System.out.print("Enter Your Pin: ");
			String pin =sc.nextLine();
			System.out.println();
			for(int i=0;i<accounts.size();i++)
			{			
//				System.out.print(accounts.get(i).getId());
//			System.out.print(accounts.get(i).getPin());
				if(accounts.get(i).getId().equals(id)&&accounts.get(i).getPin().equals(pin))
				{
					System.out.println("Welcome to your  "+accounts.get(i).getfirst_name()+" account");
					p=0;
					
					//userMenuPrompt(i);
					accounts.get(i).logIntoBankAccount(this,i);
					
					break;
				}
			}
			if(p!=0)
			System.out.println("You have entered worng paassword/userid.Please try again!!!!\n");
			if(p==0)
				return 12;
			
		}
		//return 12;
	}
	public String get_name() {
		// TODO Auto-generated method stub
		return first_name+last_name;
	}
	public void changePin() {
		while(true)
		{
			System.out.print("Enter Current Pasword: ");
			String s=sc.nextLine();
			if(s.equals(pin))
			{
				break;
			}
			else
				System.out.println("Wrong Password");
		}
		while(true) {
		System.out.print("Enter New Password: ");
		String s=sc.nextLine();
		if(s.equals(pin))
		{
			System.out.println("Your Password Is Same as Previous One!!.Try Using A New One");
			continue;
		}
		System.out.print("Retype New Password: ");
		String s1=sc.nextLine();
		if(s.equals(s1)){
			this.pin=s;
			break;
		}
		else
			System.out.println("Passwords do not match");
		
		}
		
		
	}
	public void chnageAccountPassword(int i) {
		accounts.get(i).changePin();
		
	}
	public void personalInfo()
	{
		System.out.printf("\nName : %s %s\nFather's Name: %s\nMothers Name: %s\nDepartment Name: %s\nReligion: %s\nMobile Number: %s\nEmail Id: %s\n",first_name,last_name,fathers_name,mothers_name,dept_name,religion,mobile_number,email_id);
	
	System.out.println();
	}
	
}
