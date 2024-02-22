package contactBook;

public class InputValidation {
	static boolean validateName(String name)
	{
		String regex="^[A-Za-z\\s]*$";
		if(name.matches(regex)) return true;
		return false;
	}
	static boolean validatePhnNo(String name)
	{
		String regex="^[6-9]\\d{9}$";
		if(name.matches(regex)) return true;
		return false;
	}
	static boolean validateMail(String name)
	{
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if(name.matches(regex)) return true;
		return false;
	}

}
