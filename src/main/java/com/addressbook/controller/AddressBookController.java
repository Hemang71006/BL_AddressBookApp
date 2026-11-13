
package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import com.addressbook.service.AddressBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project Name : Address Book Application
 * Module       : REST Controller
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Handles REST requests and delegates contact operations to the Service.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;

    // Constructor Injection
    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    // GET - Welcome message
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Welcome to Address Book Application!");
    }

    // GET - Retrieve all contacts
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {

        List<AddressBook> contacts = addressBookService.getAllContacts();

        return ResponseEntity.ok(contacts);
    }

    // GET - Retrieve contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable int id) {

        AddressBook contact = addressBookService.getContactById(id);

        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }

    // POST - Create a new contact
    @PostMapping("/create")
    public ResponseEntity<AddressBook> createContact(
            @RequestBody AddressBookDTO addressBookDTO) {

        AddressBook contact = addressBookService.createContact(addressBookDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    // PUT - Update contact by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBook> updateContact(
            @PathVariable int id,
            @RequestBody AddressBookDTO addressBookDTO) {

        AddressBook contact = addressBookService.updateContact(id, addressBookDTO);

        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }

    // DELETE - Delete contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {

        boolean deleted = addressBookService.deleteContact(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Contact not found with ID: " + id);
        }

        return ResponseEntity.ok("Contact deleted successfully with ID: " + id);
    }
}
