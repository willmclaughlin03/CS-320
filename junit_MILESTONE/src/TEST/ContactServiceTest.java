package TEST;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import junit_MILESTONE.Contact;
import junit_MILESTONE.ContactService;			//Imported classes, after research, these allowed the tests to actually run, as they were under different packages


public class ContactServiceTest {

	@Test
	public void testAddCon() {
		// create contact
		ContactService contactService = new ContactService();
		String newID = contactService.GenNewID();
		Contact contact = new Contact(newID, "Will", "McLaughlin", "7046543245", "275 Fake st");
		// add contact
		contactService.AddContact(contact);
		
		assertTrue(!contactService.GetContactList().isEmpty());
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getID()
				.equals(newID));
		assertTrue(contactService.GetContactCount() > 0);
	}
	
	@Test
	public void testContactMethod() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("123222", "Will", "McL", "7022222220", "234 Fake Lane");
		contactService.AddContact(contact);
		assertTrue(!contactService.GetContactList().isEmpty());
		
		// updates first name
		contactService.UpdateContact("122226", "William", 1);
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getFullName()
				.equals("Will McLaughlin"));
		// updates last name
		contactService.UpdateContact("122226", "Willliam", 2);
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getFullName()
				.equals("William McLaug"));
		// updates phone number
		contactService.UpdateContact("122222", "2222222222", 3);
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getPhoneNumber()
				.equals("2222222222"));
		// updates address
		contactService.UpdateContact("123222", "234 Fake Lane", 4);
		assertTrue(contactService
				.GetContactList()
				.elementAt(0)
				.getAddress()
				.equals("234 Fake Lane"));
		
		// updates name too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("122222", "FakeNameFake", 1);
		});
				
		// finall check that list is updated
		assertTrue(contactService.GetContactCount() == 1);
		assertTrue(contactService.GetContactList().elementAt(0)
				.getFullName().equals("Will McLaughlin"));
				
	}
	
	
	@Test
	public void testContactError() {
		ContactService contactService = new ContactService();
		// empties con list
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("123456", "William", 1);
		});
		
		// creates new contact
		Contact contact = new Contact("123456", "William", "Mcl", "7045678983", "275 London RD");
		contactService.AddContact(contact);
		// check that contact was added
		assertTrue(!contactService.GetContactList().isEmpty());
		
		// id long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("2222222222222222222", "Will McL", 1);
		});
		// null ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact(null, "Will Mcl", 1);
		});
		// null update
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("122222", null, 1);
		});
		// con value less than possible
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("122222", "William", -1);
		});
		
		// prints error message
		contactService.UpdateContact("122222", "William", 1);
		
		// prints error message
		contactService.UpdateContact("122222", "William", 9);
		
	}
	
	@Test
	public void testDelContact() {
		ContactService contactService = new ContactService();
		// newcontact
		Contact contact = new Contact("19876534", "Will", "CML", "9807654321", "876 Imagine Lane");
		// remove w null id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact(null);
		});
		// temoves with an ID too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact("1234234455555555");
		});
		// removes from empty list
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact("12345622222");
		});
		// adds a contact
		contactService.AddContact(contact);
		// remove con that doesnt exist
		contactService.DeleteContact("1344392");
	
		assertTrue(!contactService.GetContactList().isEmpty());
		assertTrue(contactService.GetContactCount() != 0);
		// remove contact
		contactService.DeleteContact("876543");
		// list is e pty
		assertTrue(contactService.GetContactCount() == 0);
		assertTrue(contactService.GetContactList().isEmpty());
		
	}

}