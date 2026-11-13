
package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;

import java.util.List;

/**
 * Project Name : Address Book Application
 * Module       : Service Interface
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Defines the business operations for Address Book contacts.
 */
public interface AddressBookService {

    List<AddressBook> getAllContacts();

    AddressBook getContactById(int id);

    AddressBook createContact(AddressBookDTO addressBookDTO);

    AddressBook updateContact(int id, AddressBookDTO addressBookDTO);

    String deleteContact(int id);
}
