package contactBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class LoadC {
	List<Contact> book=new ArrayList<>();
	public void loadContacts()
	{
		try
		{
			FileReader fr=new FileReader("contacts1.csv");
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)
			{
				String 	[]array=line.split(",");
				String name=array[0].trim();
				String phnno=array[1].trim();
				String mail=array[2].trim();
				Contact c=new Contact(name,phnno,mail);
				book.add(c);
			}
			br.close();
			fr.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		for(Contact c:book)
		{
			System.out.println(c);
		}
	}
	public static void storing()
	{
		try
		{
			FileWriter fr=new FileWriter("contacts1.csv");
			for(Contact c:ContactBook.getInstance().getContacts()) {
			fr.append(c.getName()).append(",").append(c.getPhnNo()).append(",").append(c.getMail()).append("\n");
			}
			fr.close();
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String s[])
	{
		storing();
		LoadC l=new LoadC();
		l.loadContacts();
	}
	

}
