package contactBook;

import java.io.FileWriter;

public class CsvWriter {
	public static void main(String s[])
	{
	try(FileWriter wr=new FileWriter("contacts.csv",true))
	{
		wr.append("bruce1").append(",").append("868976785879").append(",").append("gaj8fhjgj@hgm").append("\n");
		wr.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}

}
