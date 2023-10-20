package junit_MILESTONE;

import java.util.Map;
import java.util.Random;
import java.util.Vector;


import java.util.ArrayList;
import java.util.HashMap;

public class ContactService {


	   private Vector<Contact> contacts = new Vector<Contact>();
		private int contactCounts = 0;
		
		public int GetContactCount() {
			return contactCounts;
		}
		
		public Vector<Contact> GetContactList(){
			return contacts;
		}
		
		public void printConCheck() {				// in test doc, this is the easiest way to print all constructor details.
			for(Contact printList : contacts) {
				System.out.println("Contact ID -" + printList.getID() +
				"\nContact Name - " + printList.getFullName() +
				"\nContact Phone Number - " + printList.getPhoneNumber() +
				"\nContact Address -" + printList.getAddress());
			}
		}

		public void AddContact(String id, String firstName, String lastName, String phone, String address) {
			Contact newContact = new Contact(
					id,
					firstName,
					lastName,
					phone,
					address);
			
			contacts.add(newContact);
			contactCounts++;
		}
		
		public void AddContact(Contact contact) {
			contacts.add(contact);
			contactCounts++;
		}
		
		public void DeleteContact(String id) {
			if(id == null || id.length() > 10) {
				throw new IllegalArgumentException("Invalid ID");
				
			}
			
			if(contacts.isEmpty()) {
				throw new IllegalArgumentException("Contact does not exist");
			}
			
			int index = -1;
			for (Contact con : contacts) {
				if (con.getID() == id) {
					index = contacts.indexOf(con);
				}
				
			}
			if (index == -1) {
				System.out.println("Contact cannot be found.");
				return;
			}
			else{
				contacts.remove(index);
				contactCounts--;
				System.out.println("Contact removed");
			}
			
			
		}
		
		private void DeleteContact(Contact contact) {
			contacts.remove(contact);
			contactCounts--;
		}
		
		public void UpdateContact(String id, String update, int selection) {
			if(id == null || id.length() > 10 || update == null || selection < 0) {
				throw new IllegalArgumentException("Invalid ID");
			}
			
			if(contacts.isEmpty()) {
				throw new IllegalArgumentException("This contact does not exist");
			}
			
			int index = -1;
			for (Contact con : contacts) {
				if (con.getID() == id) {
					index = contacts.indexOf(con);
				}
				
			}
			if (index == -1) {
				System.out.println("Contact cannot be found");
				return;
			}
			
			Contact updateContact = contacts.get(index);
			// switch for indexing the different updates
			switch (selection){
			case 1:{
				updateContact.setFirstName(update);
				break;
			}
			case 2:{
				updateContact.setLastName(update);
				break;
			}
			case 3:{
				updateContact.setPhoneNumber(update);
				break;
			}
			case 4:{
				updateContact.setAddress(update);
				break;
			}
			default:{
				System.out.println("Change is invalid");
				break;
			}
			}
			
			DeleteContact(contacts.elementAt(index));
			AddContact(updateContact);
					
		}
		
		public void UpdateContact(String id, String firstName, String lastName, String phone, String address) {
			if(id == null || id.length() > 10) {
				throw new IllegalArgumentException("Invalid ID");
			}
			
			if(contacts.isEmpty()) {
				throw new IllegalArgumentException("That contact does not exist");
			}
			
			int index = -1;
			for (Contact con : contacts) {
				if (con.getID() == id) {
					index = contacts.indexOf(con);
				}
				
			}
			if (index == -1) {
				System.out.println("Contact invalid, not found");
				return;
			}
			
			Contact testContact = contacts.get(index);
			testContact.setFirstName(firstName);
			testContact.setLastName(lastName);
			testContact.setPhoneNumber(phone);
			testContact.setAddress(address);
			
			
			contacts.remove(index);
			contacts.add(testContact);
					
		}
		
		// creates random id numbers from the random module, if ID's need to be completely unique and safe instead of incremental.
		public String GenNewID() {
			int counter = 0;  // this also tests
			
			Random random = new Random();
			int nextID = random.nextInt(999999999);
			String uniqueIDGen = Integer.toString(nextID);
			
			Vector<String> conList = new Vector<String>();
			for (Contact App : contacts) {
				conList.add(App.getID());
			}
			// this makes sure the ID is unique, tested as well.
			while(conList.contains(uniqueIDGen) || uniqueIDGen.length() > 10) {
				nextID = random.nextInt(999999999);
				
				uniqueIDGen = Integer.toString(nextID);
				counter++;
				
				if (counter > 999999999) {
					System.out.print("No more ID's are left");
					break;
				}
			}
			conList = null;
			// returns the new ID!
			return uniqueIDGen;
		} 


	}