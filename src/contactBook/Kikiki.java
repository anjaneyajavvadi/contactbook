package contactBook;

public class Kikiki {
	public static void main(String s[])
	{
		ContactBook ki=new ContactBook();
		int i=0;
		while(i<1)
		{
			ki.saveContacts();
			i++;
		}
		for(Contact c:ki.getContacts())
		{
			System.out.println(c);		}
	}

}
