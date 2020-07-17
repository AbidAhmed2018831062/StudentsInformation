package Students;
import java.util.*;
public class StudentAccount {
private String name;
private String id;
private String pin;
private int balance=0;
Scanner sc=new Scanner(System.in);
public StudentAccount(String name,String id,String first_name,String pin)throws InputMismatchException
{
	this.name=name;
	this.id=name+"_"+id;
	this.pin=pin;
	System.out.println("A University Bank Was Created.Your Bank Id is "+this.id +" Bank's password is also the same password as School's account.\nIf you want to change it, type 1");
	System.out.print("Enter Your Choice: ");
	int c=0;
	while(true) {
	try {
	 c=sc.nextInt();
	}
	catch(InputMismatchException e)
	{
		System.out.println("Please enter (1-9)");
	}
	if(c>=0&&c<=9)
		break;
	c=sc.nextInt();
	if(c>=0&&c<=9)
		break;
	}
	
	if(c==1)
	{
		System.out.print("Enter Your Passowrd: ");
		 sc.nextLine();
		this.pin=sc.nextLine();
		
	}
}
public StudentAccount(String name,String id,String first_name,String pin,String memo)
{
	this.name=name;
	this.id=name+"_"+id;
	this.pin=pin;
	System.out.println("You New Bank Account's id is "+this.id);
	
}
public void logIntoBankAccount(StudentInformation students,int i) {
	System.out.print("Welcome "+students.getfirst_name()+",");
	while(true) {
	  System.out.print("What would you like to do??\n");
	    System.out.println("1.Deposit");
	    System.out.println("2.Transfer");
	    System.out.println("3.Withdraw");
	    System.out.println("4.Change Password");
	    System.out.println("5.Quit");
	    System.out.print("Enter Your choice: ");
	    //sc.nextLine();
	    int c=sc.nextInt();
	    if(c==1)
	    {
	    //	System.out.print("How much would you like to deposit,sir?? $");
	    	int to=0,p=1;
	    	   while(true) {
	    		   System.out.print("Enter Your Account Name in Which You Want to Deposit: ");
	    		 //  sc.nextLine();
	    		   String string=sc.nextLine();;
	    		   string=string.toLowerCase();
	        for(int j=0;j<students.getaccountsize();j++)
	        {
	        	String s=students.getAccountName(j);
	        	s=s.toLowerCase();
	        	if(s.equals(string))
	        	{
	        		to=j+1;
	        		p=0;
	        		break;
	        	}
	        	
	        }
	        if(p==0)
	        	break;
	        else
	        	System.out.println("You don't have any account with this name.Try Again");
	        	 
	           }
	    	   System.out.print("Enter Amount to deposit: $");
	    	   int c2=sc.nextInt();
	    	  students.addAccountBalnce(c2,to-1);
	    	   System.out.println("\nYou have $"+students.getAccountBalance(to-1)+" in your "+students.getAccountName(to-1)+" account\n");
	        	
	    	   
	    }
	    else if(c==2)
	    {
	    	if(students.getaccountsize()==1)
	    	{
	    		System.out.println("You can't transfer money because you have just 1 account.Would you like to create a new Bank Account??.\nIf yes ,then type 1");
	         System.out.print("Enter Your Choice: ");
	    		int c1=sc.nextInt();
	           if(c1==1)
	           {
	        	  System.out.print("Enter Your Account Name: ");
	        	  sc.nextLine();
	        	  String name1=sc.nextLine();
	        	  System.out.print("Enter Your Id: ");
	        	 // sc.nextLine();
	        	  String id1=sc.nextLine();
	        	  
	        	  System.out.print("Enter Your Pin: ");
	        	  String first_name=students.get_name();
	        	  String pin1=sc.nextLine();
	        	  String memo="New Account";
	        	  StudentAccount account=new StudentAccount(name1,id1,first_name,pin1,memo);
	        	  students.addnewAccount(account);
	        	  
	        	  
	           }
	    	}
	           else {
	        	   int from=0,to=0;
	        	   while(true) {
	        	  // System.out.print("Enter account number from which you want to transfer money from: ");
	        	   int p=1;
		    		   System.out.print("Enter Your Account Name From which You Want To Transfer Money: ");
		    		   sc.nextLine();
		    		   String string=sc.nextLine();;
		    		   string=string.toLowerCase();
		        for(int j=0;j<students.getaccountsize();j++)
		        {
		        	String s=students.getAccountName(j);
		        	s=s.toLowerCase();
		        	if(s.equals(string))
		        	{
		        		from=j+1;
		        		p=0;
		        		break;
		        	}
		        	
		        }
		        if(p==0)
		        	break;
		        else
		        	System.out.println("You don't have any account with this name.Try Again");
		        	 
		           }
	        	   while(true) {
	 	        	  // System.out.print("Enter account number from which you want to transfer money from: ");
	 	        	   int p=1;
	 		    		   System.out.print("Enter Your Account Name in which You Want To Transfer Money: ");
	 		    		 // sc.nextLine();
	 		    		   String string=sc.nextLine();;
	 		    		   string=string.toLowerCase();
	 		        for(int j=0;j<students.getaccountsize();j++)
	 		        {
	 		        	String s=students.getAccountName(j);
	 		        	s=s.toLowerCase();
	 		        	if(s.equals(string))
	 		        	{
	 		        		to=j+1;
	 		        		p=0;
	 		        		break;
	 		        	}
	 		        	
	 		        }
	 		        if(p==0)
	 		        	break;
	 		        else
	 		        	System.out.println("You don't have any account with this name.Try Again");
	 		        	 
	 		           }
	        	   while(true) {
		        	   System.out.print("Enter amount you want(max $"+students.getAccountBalance(from-1)+") to transfer: $");
		        	   int c2=sc.nextInt();
		        	   if(c2>0&&c2<=students.getAccountBalance(from-1))
		        	   {
		        		   students.addAccountBalnce(c2,to-1);
		        		   students.deductBalance(c2,from-1);
		        		   break;
		        	   }
		        	   else
		        	   {
		        		   System.out.println("Invalid Amount.Try Again");
		        	   }
		        		   
		        	 
		           }
	        	   System.out.println("You have $"+students.getAccountBalance(from-1)+" in your "+students.getAccountName(from-1)+" account");
	        	   System.out.println("You have $"+students.getAccountBalance(to-1)+" in your "+students.getAccountName(to-1)+" account");
	    	}
	    }
	    else if(c==3)
	    {
	    	int to=0;
	    	  while(true) {
	        	  // System.out.print("Enter account number from which you want to transfer money from: ");
	        	   int p=1;
		    		   System.out.print("Enter Your Account Name From which You Want To Withdraw Money: ");
		    		//  sc.nextLine();
		    		   String string=sc.nextLine();;
		    		   string=string.toLowerCase();
		        for(int j=0;j<students.getaccountsize();j++)
		        {
		        	String s=students.getAccountName(j);
		        	s=s.toLowerCase();
		        	if(s.equals(string))
		        	{
		        		to=j+1;
		        		p=0;
		        		break;
		        	}
		        	
		        }
		        if(p==0)
		        	break;
		        else
		        	System.out.println("You don't have any account with this name.Try Again");
		        	 
		           }
	    	   int c2;
	    	   c2=students.getAccountBalance(to-1);
	    	   if(c2==0)
	    	   {
	    		   System.out.println("Sorry!!!You Have No Money To Withdraw.");
	    		   continue;
	    	   }
	    	   while(true) {
	        	   System.out.print("Enter amount you want(max $"+students.getAccountBalance(to-1)+") to withdraw: ");
	        	    c2=sc.nextInt();
	        	   if(c2>0&&c2<=students.getAccountBalance(to-1))
	        	   {
	        		//   students.addAccountBalnce(c2,to);
	        		   students.deductBalance(c2,to-1);
	        		   break;
	        	   }
	        	   else
	        	   {
	        		   System.out.println("Invalid Amount.Try Again");
	        	   }
	        		   
	        	 
	           }
        	   System.out.println("You have withdrawn $"+c2+" from your "+students.getAccountName(to-1)+" account.You  now have $"+students.getAccountBalance(to-1)+" in your "+students.getAccountName(to-1)+" account");
        	
   	    }
	    else if(c==5)
	    {
	    	System.out.println("Thank You For Using Our Service");
	    	break;
	    }
	    else if(c==4)
	    {
	    	int to=0;
	    	  while(true) {
	        	  // System.out.print("Enter account number from which you want to transfer money from: ");
	        	   int p=1;
		    		   System.out.print("Enter The Name Of Account Whose Password You Want To Change: ");
		    		   sc.nextLine();
		    		   String string=sc.nextLine();;
		    		   string=string.toLowerCase();
		        for(int j=0;j<students.getaccountsize();j++)
		        {
		        	String s=students.getAccountName(j);
		        	s=s.toLowerCase();
		        	if(s.equals(string))
		        	{
		        		to=j+1;
		        		p=0;
		        		break;
		        	}
		        	
		        }
		        if(p==0)
		        	break;
		        else
		        	System.out.println("You don't have any account with this name.Try Again");
		        	 
		           }
	    	students.chnageAccountPassword(to-1);
	    	System.out.println("Your Password Was Changed .Log In again to continue");
	    	students.logIntoBankAccount();
	    	}
	    else
	    	System.out.println("Invalid Command!!Please choose (1-5)");
}
}
public int getAccountBalance() {
	// TODO Auto-generated method stub
	return balance;
}
public void addBalance(int c2)
{
	balance+=c2;
}
public void deductBalcne(int c2) {
	balance-=c2;
	
}
public String getName()
{
	return name;
}
public String getId() {
	// TODO Auto-generated method stub
	return id;
}
public String getPin() {
	// TODO Auto-generated method stub
	return pin;
}
public String getfirst_name() {
	// TODO Auto-generated method stub
	return name;
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
}
