package contactBook;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class StoreContact {
	public static void storing() {
	    try {
	        FileWriter fr = new FileWriter("contacts.csv");
	        BufferedWriter br = new BufferedWriter(fr);
	        for (Contact c : ContactBook.getInstance().getContacts()) {
	            br.write(c.getName() + "," + c.getPhnNo() + "," + c.getMail() + "\n");
	        }
	        br.close();
	        fr.close(); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public static void viewContacts()
	{
		for(Contact c:ContactBook.getInstance().getContacts())
		{
			System.out.println(c);
		}
	}
	public static void deleteContacts(String name)
	{
		try
		{
		if(searchContact(name)!=null)
		{
		Iterator<Contact> iter=ContactBook.getInstance().getContacts().iterator();
		while(iter.hasNext())
		{
			Contact c=iter.next();
			if(c.getName().equals(name))
			{
				iter.remove();
			}
		}
		}
		else
		{
			System.out.println("Contact doesnt exist");
		}
		}
		catch(Exception e) {System.out.println(e);}
	}
	public static void editContacts(String name,Scanner sc)
	{
		if(searchContact(name)!=null)
		{
		
		System.out.println("what do you want to edit 1.name 2.phnno 3.mailId");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			String newName;
			do
			{
			System.out.println("Name: ");
			newName=sc.next();
			 if (!InputValidation.validateName(newName)) {
	             System.out.println("Invalid name format. Please enter a valid name.");
	         } else if (StoreContact.searchContact(newName) != null) {
	             System.out.println("Name already exists. Please enter a unique name.");
	         }
			}while(!InputValidation.validateName(newName) || (StoreContact.searchContact(newName))!=null);
			update(name,1,newName);
			break;
		case 2:
			String phnNo;
			do
			{
			System.out.println("Number: ");
			phnNo=sc.next();
			if (!InputValidation.validatePhnNo(phnNo)) {
	            System.out.println("Invalid phone number format. Please enter a valid number.");
	        } else if (StoreContact.searchContact(phnNo) != null) {
	            System.out.println("Phone number already exists. Please enter a unique number.");
	        }
			}while(!InputValidation.validatePhnNo(phnNo)||(StoreContact.searchContact(phnNo))!=null);
			update(name,1,phnNo);
			break;
		case 3:
			String newMail;
			do {
				System.out.println("Mail: ");
				newMail=sc.next();
				if (!InputValidation.validateMail(newMail)) {
		            System.out.println("Invalid Mail format. Please enter a valid mail.");
				}
				}while(!InputValidation.validateMail(newMail));
			update(name,2,newMail);
			break;
			default:
				System.out.println("wrong choice");
		}
		}
		else
		{
			System.out.println("Contact doesnt exist");
		}
	}
		public static void update(String name,int index,String updateValue)
		{
			for(Contact c:ContactBook.getInstance().getContacts())
			{
				if(c.getName().equals(name))
				{
					if(index==0) c.setName(updateValue);
					if(index==1) c.setPhnNo(updateValue);
					if(index==2) c.setMail(updateValue);
				}
			}
			System.out.println("contact updated");
			
		}
		public static void sortContacts()
		{
			List<Contact> sortList=ContactBook.getInstance().getContacts();
			Collections.sort(sortList,Comparator.comparing(Contact::getName));
			for(Contact details:sortList)
			{
				System.out.println(details);
			}
		}
		public static Contact searchContact(String searchValue)
		{
			for(Contact c:ContactBook.getInstance().getContacts())
			{
				if(c.getName().equals(searchValue)||c.getPhnNo().equals(searchValue))
				{
					return c;
				}
			}
			return null;
		}
		

}
