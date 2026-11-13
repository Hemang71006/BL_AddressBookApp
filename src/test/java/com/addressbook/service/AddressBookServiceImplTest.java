
package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project Name : Address Book Application
 * Module       : Service Testing
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Tests the business logic of AddressBookServiceImpl.
 */
class AddressBookServiceImplTest {

    private AddressBookServiceImpl addressBookService;

    @BeforeEach
    void setUp() {
        addressBookService = new AddressBookServiceImpl();
    }

    // Test GET all contacts
    @Test
    void shouldReturnEmptyContactList() {
        List<AddressBook> contacts = addressBookService.getAllContacts();

        assertNotNull(contacts);
        assertTrue(contacts.isEmpty());
    }

    // Test GET contact by ID
    @Test
    void shouldReturnContactById() {
        AddressBook contact = addressBookService.getContactById(1);

        assertEquals(1, contact.getId());
        assertEquals("Hemang", contact.getFirstName());
        assertEquals("Sharma", contact.getLastName());
        assertEquals("9876543210", contact.getPhoneNumber());
    }

    // Test POST create contact
    @Test
    void shouldCreateContact() {
        AddressBookDTO dto = new AddressBookDTO(
                "Rahul", "Sharma", "9876543210"
        );

        AddressBook contact = addressBookService.createContact(dto);

        assertEquals(1, contact.getId());
        assertEquals("Rahul", contact.getFirstName());
        assertEquals("Sharma", contact.getLastName());
        assertEquals("9876543210", contact.getPhoneNumber());
    }

    // Test PUT update contact
    @Test
    void shouldUpdateContact() {
        AddressBookDTO dto = new AddressBookDTO(
                "Amit", "Kumar", "9123456780"
        );

        AddressBook contact = addressBookService.updateContact(2, dto);

        assertEquals(2, contact.getId());
        assertEquals("Amit", contact.getFirstName());
        assertEquals("Kumar", contact.getLastName());
        assertEquals("9123456780", contact.getPhoneNumber());
    }

    // Test DELETE contact
    @Test
    void shouldDeleteContact() {
        String result = addressBookService.deleteContact(1);

        assertEquals("Contact deleted with ID: 1", result);
    }
}
