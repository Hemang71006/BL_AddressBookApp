
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
 * Tests CRUD operations performed by AddressBookServiceImpl.
 */
class AddressBookServiceImplTest {

    private AddressBookServiceImpl addressBookService;

    @BeforeEach
    void setUp() {
        addressBookService = new AddressBookServiceImpl();
    }

    // Test GET all contacts
    @Test
    void shouldReturnAllContacts() {

        addressBookService.createContact(
                new AddressBookDTO("Hemang", "Sharma", "9876543210")
        );

        addressBookService.createContact(
                new AddressBookDTO("Rahul", "Kumar", "9123456780")
        );

        List<AddressBook> contacts = addressBookService.getAllContacts();

        assertEquals(2, contacts.size());
        assertEquals("Hemang", contacts.get(0).getFirstName());
        assertEquals("Rahul", contacts.get(1).getFirstName());
    }

    // Test GET contact by ID
    @Test
    void shouldReturnContactById() {

        AddressBook createdContact = addressBookService.createContact(
                new AddressBookDTO("Hemang", "Sharma", "9876543210")
        );

        AddressBook contact =
                addressBookService.getContactById(createdContact.getId());

        assertNotNull(contact);
        assertEquals("Hemang", contact.getFirstName());
        assertEquals("Sharma", contact.getLastName());
    }

    // Test GET contact with invalid ID
    @Test
    void shouldReturnNullForInvalidId() {

        AddressBook contact = addressBookService.getContactById(100);

        assertNull(contact);
    }

    // Test POST - Create contact
    @Test
    void shouldCreateContact() {

        AddressBook contact = addressBookService.createContact(
                new AddressBookDTO("Rahul", "Sharma", "9876543210")
        );

        assertEquals(1, contact.getId());
        assertEquals("Rahul", contact.getFirstName());
        assertEquals("Sharma", contact.getLastName());
        assertEquals("9876543210", contact.getPhoneNumber());
        assertEquals(1, addressBookService.getAllContacts().size());
    }

    // Test automatic ID generation
    @Test
    void shouldGenerateUniqueIds() {

        AddressBook first = addressBookService.createContact(
                new AddressBookDTO("First", "User", "1111111111")
        );

        AddressBook second = addressBookService.createContact(
                new AddressBookDTO("Second", "User", "2222222222")
        );

        assertEquals(1, first.getId());
        assertEquals(2, second.getId());
    }

    // Test PUT - Update contact
    @Test
    void shouldUpdateContact() {

        AddressBook createdContact = addressBookService.createContact(
                new AddressBookDTO("Rahul", "Sharma", "9876543210")
        );

        AddressBook updatedContact = addressBookService.updateContact(
                createdContact.getId(),
                new AddressBookDTO("Amit", "Kumar", "9123456780")
        );

        assertNotNull(updatedContact);
        assertEquals("Amit", updatedContact.getFirstName());
        assertEquals("Kumar", updatedContact.getLastName());
        assertEquals("9123456780", updatedContact.getPhoneNumber());
    }

    // Test PUT - Update contact with invalid ID
    @Test
    void shouldReturnNullWhenUpdatingInvalidId() {

        AddressBook updatedContact = addressBookService.updateContact(
                100,
                new AddressBookDTO("Amit", "Kumar", "9123456780")
        );

        assertNull(updatedContact);
    }

    // Test DELETE - Delete contact
    @Test
    void shouldDeleteContact() {

        AddressBook contact = addressBookService.createContact(
                new AddressBookDTO("Rahul", "Sharma", "9876543210")
        );

        boolean deleted = addressBookService.deleteContact(contact.getId());

        assertTrue(deleted);
        assertTrue(addressBookService.getAllContacts().isEmpty());
    }

    // Test DELETE - Invalid contact ID
    @Test
    void shouldReturnFalseWhenDeletingInvalidId() {

        boolean deleted = addressBookService.deleteContact(100);

        assertFalse(deleted);
    }
}
