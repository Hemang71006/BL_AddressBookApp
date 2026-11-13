
package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Name : Address Book Application
 * Module       : Service Implementation
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Implements the business logic for Address Book operations.
 */
@Service
public class AddressBookServiceImpl implements AddressBookService {

    // GET - Retrieve all contacts
    @Override
    public List<AddressBook> getAllContacts() {
        return List.of();
    }

    // GET - Retrieve contact by ID
    @Override
    public AddressBook getContactById(int id) {

        return new AddressBook(
                id,
                "Hemang",
                "Sharma",
                "9876543210"
        );
    }

    // POST - Create a contact
    @Override
    public AddressBook createContact(AddressBookDTO addressBookDTO) {

        return new AddressBook(
                1,
                addressBookDTO.getFirstName(),
                addressBookDTO.getLastName(),
                addressBookDTO.getPhoneNumber()
        );
    }

    // PUT - Update a contact
    @Override
    public AddressBook updateContact(int id, AddressBookDTO addressBookDTO) {

        return new AddressBook(
                id,
                addressBookDTO.getFirstName(),
                addressBookDTO.getLastName(),
                addressBookDTO.getPhoneNumber()
        );
    }

    // DELETE - Delete a contact
    @Override
    public String deleteContact(int id) {
        return "Contact deleted with ID: " + id;
    }
}
