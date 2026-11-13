
package com.addressbook.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Project Name : Address Book Application
 * Module       : Controller Testing
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Tests all REST API endpoints of AddressBookController
 * using MockMvc without starting the actual web server.
 */

@WebMvcTest(AddressBookController.class)
class AddressBookControllerTest {

    // Injects MockMvc to perform HTTP requests and test responses
    @Autowired
    private MockMvc mockMvc;

    // Test GET API - Checks whether the welcome message is returned
    @Test
    void shouldReturnWelcomeMessage() throws Exception {

        mockMvc.perform(get("/addressbook/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "Welcome to Address Book Application!"));
    }

    // Test GET API - Checks whether all contacts endpoint responds successfully
    @Test
    void shouldGetAllContacts() throws Exception {

        mockMvc.perform(get("/addressbook"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fetching all contacts"));
    }

    // Test GET API - Checks whether a contact ID is correctly received
    @Test
    void shouldGetContactById() throws Exception {

        mockMvc.perform(get("/addressbook/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fetching contact with ID: 1"));
    }

    // Test POST API - Checks whether a new contact JSON is accepted and returned
    @Test
    void shouldCreateContact() throws Exception {

        mockMvc.perform(post("/addressbook/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Hemang",
                                    "lastName": "Sharma",
                                    "phoneNumber": "9876543210"
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Hemang"))
                .andExpect(jsonPath("$.lastName").value("Sharma"));
    }

    // Test PUT API - Checks whether contact details are updated with the given ID
    @Test
    void shouldUpdateContact() throws Exception {

        mockMvc.perform(put("/addressbook/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Rahul",
                                    "lastName": "Sharma",
                                    "phoneNumber": "9876543210"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Rahul"));
    }

    // Test DELETE API - Checks whether the delete endpoint responds successfully
    @Test
    void shouldDeleteContact() throws Exception {

        mockMvc.perform(delete("/addressbook/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Contact deleted with ID: 1"));
    }
}
