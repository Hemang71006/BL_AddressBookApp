
package com.addressbook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Project Name : Address Book Application
 * Module       : REST Controller
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Handles REST API requests for the Address Book application.
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
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("Fetching all contacts");
    }

    // GET - Retrieve contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable int id) {
        return ResponseEntity.ok("Fetching contact with ID: " + id);
    }

    // POST - Create a new contact
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createContact(
            @RequestBody Map<String, Object> contact) {

        return ResponseEntity.status(201).body(contact);
    }

    // PUT - Update contact by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateContact(
            @PathVariable int id,
            @RequestBody Map<String, Object> contact) {

        contact.put("id", id);
        return ResponseEntity.ok(contact);
    }

    // DELETE - Delete contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return ResponseEntity.ok("Contact deleted with ID: " + id);
    }
}
