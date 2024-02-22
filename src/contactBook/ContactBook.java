package contactBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactBook {
	private static ContactBook cb;
	private List<Contact> book=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	public void loadContactBook()
	{
		try
		{
			FileReader fr=new FileReader("contacts.csv");
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)
			{
				String 	[]array=line.split(",");
				if(array.length>=3)
				{
				String name=array[0].trim();
				String phnno=array[1].trim();
				String mail=array[2].trim();
				Contact c=new Contact(name,phnno,mail);
				book.add(c);
			}
			}
			br.close();
			fr.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static ContactBook getInstance()
	{
		if(cb==null) return cb= new ContactBook();
		return cb;
	}
	public void saveContacts()
	{
		try {
		String name,phnNo,mail;
		do
		{
		System.out.println("Name: ");
		name=sc.next();
		 if (!InputValidation.validateName(name)) {
             System.out.println("Invalid name format. Please enter a valid name.");
         } else if (StoreContact.searchContact(name) != null) {
             System.out.println("Name already exists. Please enter a unique name.");
         }
		}while(!InputValidation.validateName(name) || (StoreContact.searchContact(name))!=null);
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
		do {
		System.out.println("Mail: ");
		mail=sc.next();
		if (!InputValidation.validateMail(mail)) {
            System.out.println("Invalid Mail format. Please enter a valid mail.");
		}
		}while(!InputValidation.validateMail(mail));
		Contact c=new Contact(name,phnNo,mail);
		book.add(c);
		System.out.println("Saved....");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<Contact> getContacts()
	{
		return book;
	}
}
