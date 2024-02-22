package contactBook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean authenticated = false;
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
        	StoreContact.storing();
        	
        }));

        while (!authenticated ) {
            System.out.println("Enter PassCode");
            String pc = sc.next();
            if (pc.equals("9099")) {
                authenticated = true;
            } else {
                System.out.println("Wrong passcode. Try again.");
            }
        }
        System.out.println("Hello Boss !!");
        ContactBook.getInstance().loadContactBook();
		do
        {
        System.out.println(" 1. Save new contact \n 2. Edit Contact\n 3. Delete Contact \n 4. view contacts \n 5. sort contacts \n 6. search contact \n 7. Exit");
        
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                String ch;
                do {
                    ContactBook.getInstance().saveContacts();
                    System.out.println("do you want to save more contacts (y/n)?");
                    ch = sc.next();
                } while (ch.equalsIgnoreCase("y"));
                break;
            case 2:
                String ch1;
                do {
                    System.out.println("enter name of the contact");
                    String name = sc.next();
                    StoreContact.editContacts(name.trim(),sc);
                    System.out.println("do you want to edit more contacts (y/n)?");
                    ch1=sc.next();
                } while (ch1.trim().equalsIgnoreCase("y"));
                System.out.println();
                break;
            case 3:
                String ch2;
                do {
                    System.out.println("enter name of the contact");
                    String name = sc.next();
                    StoreContact.deleteContacts(name);
                    System.out.println("do you want to delete more contacts (y/n)?");
                    ch2 = sc.next();
                } while (ch2.equalsIgnoreCase("y"));
                System.out.println();
                break;
            case 4:
                StoreContact.viewContacts();
                System.out.println();
                break;
            case 5:
                StoreContact.sortContacts();
                System.out.println();
                break;
            case 6:
                String searchKey;
                do {
                    System.out.println("enter name or number");
                    searchKey = sc.next();
                    Contact c=StoreContact.searchContact(searchKey);
                    System.out.println(c.toString());
                    System.out.println("do you want to search more contacts (y/n)?");
                    ch2 = sc.next();
                } while (ch2.equalsIgnoreCase("y"));
                System.out.println();
                break;
            case 7:
            	StoreContact.storing();
            	return;
        }
    }while(true);
		
    }
}
