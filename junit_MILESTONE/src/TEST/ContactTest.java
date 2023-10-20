package TEST;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit_MILESTONE.Contact;

class ContactTest {
	
	void testGetters() {
		Contact con = new Contact("02345678", "Will", "McLaughlin", "3838838332", "762 Dake St");
		
		Assertions.assertEquals(con.getID(), "123456789");
		
		Assertions.assertEquals(con.getFullName(), "William McLau");
		
		Assertions.assertEquals(con.getPhoneNumber(), "7046345345");
		
		Assertions.assertEquals(con.getAddress(), "762 Fake St");
	}

	@Test
	void testContactNull() {
	
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("999999999999999", null, null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567891", "Will", null, null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1838448484", "Will", "MClaughlin", null, null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234567899", "Will", "McLaughlin", "2223334543", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
	}
	
	@Test
	void testContactInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234563333", "Nameeeeeeeeeeeee", "Will", "7047627508", "333 FAKEST");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234555555", "wILL", "MCLAAAAAAAAAAAAA", "7033333333", "333 FAKEST");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("5555555555", "William", "McL", "777777777777777777777777777", "333 FAKEST");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("5555555555", "Will", "M", "sssss", "333 FAKEST");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("4444444444", "Will", "Mmmmm", "3333333333", "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		});
	}
	

	    @Test
	    void testFirstNameMax() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1234567890", "FirstNameIsTooLong", "Doe", "7333333333", "123 fake");
	        });
	    }

	    @Test
	    void testLastNameMax() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("123452222", "Will", "LastNameIsTooLong", "7333333333", "123 fake");
	        });
	    }

	    @Test
	    void testPhoneNumberFormat() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1234567890", "Will", "M", "702", "123 Fake");
	        });
	    }

	    @Test
	    void testAddressMaxLength() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1234567822", "Will", "McLaugh", "7222222222", "failllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
	        });
	    }

	}

	

