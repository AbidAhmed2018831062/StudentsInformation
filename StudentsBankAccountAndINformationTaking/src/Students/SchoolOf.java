package Students;
import java.util.*;

import BankingApplication.StudentInformation;
public class SchoolOf {
	ArrayList<StudentInformation> students=new ArrayList<StudentInformation>();
	String id;
	 Scanner sc=new Scanner(System.in);
public void studentsInfromationTaking()
{
	 final  String name="Border Guard Public School and Collge,Sylhet";
	 System.out.print("Enter The Number Of Students: ");
	 int numOfS=sc.nextInt();
	 sc.nextLine();
	 StudentInformation[] student=new StudentInformation[numOfS+1];
	 for(int i=0;i<numOfS;i++)
	 {
		// System.out.print(students.size());
		 System.out.print("Enter Your First Name: ");
		 
		 String first_name=sc.nextLine();
		 System.out.print("Enter Your Last Name: ");
		 String last_name=sc.nextLine();
		 String pin;
		 while(true) {
		 System.out.print("Enter Your Pin(6 characters): ");
		 pin=sc.nextLine();
		 if(pin.length()!=6)
		 {
			 System.out.println("Invalid Password!!!! Please Enter 6 characters!!");
			 continue;
		 }
		 else
			 break;
		 }
		 char a[]=new char[10];
		 int p=0;
		 String string;
		 while(true)
		 {
			 String s="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
				char[] Password=new char[6];
				for(int j=0;j<6;j++)
				{
					int r=(int)(Math.random()*s.length());
					Password[j]=s.charAt(r);
				}
			string = "BGPSC"+new String(Password);
		//System.out.print(string);
			if(students.size()==0)
			{
				id=string;
				break;
			}
			 for(int j=0;j<students.size();j++) {
				 
			 String f=students.get(j).getId();
				 if(f.equals(string))
					 continue;
				 else			 {
				 id=string;			
				 p=1;				
				 break;		
				 }
			 }
			 if(p==1||students.size()==0)
				 break;
		 }
		 student[i]=new StudentInformation(first_name,last_name,pin,id);
		 students.add(student[i]);
		 }
	studentsLogIn();
}
public int studentsLogIn()
{
	Scanner sc=new Scanner(System.in);
	int p=1;
	while(true)
	{
		System.out.print("\nEnter Your User Id: ");
		String id=sc.nextLine();
		System.out.print("Enter Your Pin: ");
		String pin =sc.nextLine();
		System.out.println();
		for(int i=0;i<students.size();i++)
		{
//			System.out.print(students.get(i).getId());
//			System.out.print(students.get(i).getPin());
			if(students.get(i).getId().equals(id)&&students.get(i).getPin().equals(pin))
			{
				System.out.println("Welcome "+students.get(i).getfirst_name());
				p=0;
				
				userMenuPrompt(i);
				
			
			}
		}
		if(p!=0)
			System.out.println("You have entered worng paassword/userid.Please try again!!!!\n");		
	}
}
private void userMenuPrompt(int i) {
	while(true) {
    System.out.println("\nWhat would you like to do??\n");
    System.out.println("1.Pay Fees");
    System.out.println("2.Watch Your Reamining payable fees");
    System.out.println("3.Wacth Your MarkSheet");
    System.out.println("4.Log In To Your (Default) Bank Account");
    System.out.println("5.Change Password");
    System.out.println("6.Show Personal Information");
    System.out.println("7.Quit");
    System.out.print("Enter Your choice: ");
    int c=sc.nextInt();
    if(c==1)
    {
    	students.get(i).payFees();
    }
    else if(c==2)
    {
    	System.out.println("\nYou have $"+students.get(i).remainingFees()+" to pay\n");
    }
    else if(c==3)
    {
    	System.out.println(students.get(i).showMarksheet());
    }
    else if(c==7) {
    	sc.nextLine();
    	break;
    }
    else if(c==4)
    {
    	int back=students.get(i).logIntoBankAccount();
    }
    else if(c==5)
    {
    	students.get(i).changePin();
    	System.out.println("Your Password Was Changed .Log In again to continue");
    	studentsLogIn();
    }
    else if(c==6)
    {
    	students.get(i).personalInfo();
    }
    else
    	System.out.println("Invalid Command!!");
    }
	
}
}
