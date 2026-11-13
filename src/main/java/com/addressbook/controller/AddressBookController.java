
package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
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
 * Handles REST API requests using DTO and Model classes.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // GET - Welcome message
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Welcome to Address Book Application!");
    }

    // GET - Retrieve all contacts
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(List.of());
    }

    // GET - Retrieve contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable int id) {

        AddressBook contact = new AddressBook(
                id,
                "Hemang",
                "Sharma",
                "9876543210"
        );

        return ResponseEntity.ok(contact);
    }

    // POST - Create a contact using DTO
    @PostMapping("/create")
    public ResponseEntity<AddressBook> createContact(
            @RequestBody AddressBookDTO addressBookDTO) {

        AddressBook contact = new AddressBook(
                1,
                addressBookDTO.getFirstName(),
                addressBookDTO.getLastName(),
                addressBookDTO.getPhoneNumber()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    // PUT - Update contact using DTO
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBook> updateContact(
            @PathVariable int id,
            @RequestBody AddressBookDTO addressBookDTO) {

        AddressBook contact = new AddressBook(
                id,
                addressBookDTO.getFirstName(),
                addressBookDTO.getLastName(),
                addressBookDTO.getPhoneNumber()
        );

        return ResponseEntity.ok(contact);
    }

    // DELETE - Delete contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return ResponseEntity.ok("Contact deleted with ID: " + id);
    }
}
