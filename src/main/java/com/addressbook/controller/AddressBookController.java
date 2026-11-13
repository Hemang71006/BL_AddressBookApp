
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
 * Handles REST requests and delegates operations to the Service layer.
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
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    // GET - Retrieve contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getContactById(id));
    }

    // POST - Create a contact
    @PostMapping("/create")
    public ResponseEntity<AddressBook> createContact(
            @RequestBody AddressBookDTO addressBookDTO) {

        AddressBook contact = addressBookService.createContact(addressBookDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    // PUT - Update a contact
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBook> updateContact(
            @PathVariable int id,
            @RequestBody AddressBookDTO addressBookDTO) {

        AddressBook contact = addressBookService.updateContact(id, addressBookDTO);

        return ResponseEntity.ok(contact);
    }

    // DELETE - Delete a contact
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.deleteContact(id));
    }
}
