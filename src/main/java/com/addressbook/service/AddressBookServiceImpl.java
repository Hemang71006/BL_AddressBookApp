
package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Address Book Application
 * Module       : Service Implementation
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Manages Address Book contacts using an in-memory ArrayList.
 */
@Service
public class AddressBookServiceImpl implements AddressBookService {

    // Stores all contacts in memory
    private final List<AddressBook> addressBookList = new ArrayList<>();

    // Generates unique IDs for contacts
    private int nextId = 1;

    // GET - Retrieve all contacts
    @Override
    public List<AddressBook> getAllContacts() {
        return new ArrayList<>(addressBookList);
    }

    // GET - Retrieve contact by ID
    @Override
    public AddressBook getContactById(int id) {

        return addressBookList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST - Create a new contact
    @Override
    public AddressBook createContact(AddressBookDTO addressBookDTO) {

        AddressBook contact = new AddressBook(
                nextId++,
                addressBookDTO.getFirstName(),
                addressBookDTO.getLastName(),
                addressBookDTO.getPhoneNumber()
        );

        addressBookList.add(contact);

        return contact;
    }

    // PUT - Update an existing contact
    @Override
    public AddressBook updateContact(int id, AddressBookDTO addressBookDTO) {

        AddressBook existingContact = getContactById(id);

        if (existingContact == null) {
            return null;
        }

        existingContact.setFirstName(addressBookDTO.getFirstName());
        existingContact.setLastName(addressBookDTO.getLastName());
        existingContact.setPhoneNumber(addressBookDTO.getPhoneNumber());

        return existingContact;
    }

    // DELETE - Delete contact by ID
    @Override
    public boolean deleteContact(int id) {

        return addressBookList.removeIf(contact -> contact.getId() == id);
    }
}
