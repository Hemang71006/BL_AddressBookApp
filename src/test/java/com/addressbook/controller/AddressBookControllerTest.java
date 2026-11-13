
package com.addressbook.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Project Name : Address Book Application
 * Module       : Controller Testing
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Tests AddressBook REST APIs using MockMvc.
 */
@WebMvcTest(AddressBookController.class)
class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Test welcome API
    @Test
    void shouldReturnWelcomeMessage() throws Exception {
        mockMvc.perform(get("/addressbook/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "Welcome to Address Book Application!"
                ));
    }

    // Test GET all contacts
    @Test
    void shouldGetAllContacts() throws Exception {
        mockMvc.perform(get("/addressbook"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    // Test GET contact by ID
    @Test
    void shouldGetContactById() throws Exception {
        mockMvc.perform(get("/addressbook/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Hemang"))
                .andExpect(jsonPath("$.lastName").value("Sharma"))
                .andExpect(jsonPath("$.phoneNumber").value("9876543210"));
    }

    // Test POST - Create contact using DTO
    @Test
    void shouldCreateContact() throws Exception {
        mockMvc.perform(post("/addressbook/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Rahul",
                                    "lastName": "Sharma",
                                    "phoneNumber": "9876543210"
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Rahul"))
                .andExpect(jsonPath("$.lastName").value("Sharma"))
                .andExpect(jsonPath("$.phoneNumber").value("9876543210"));
    }

    // Test PUT - Update contact using DTO
    @Test
    void shouldUpdateContact() throws Exception {
        mockMvc.perform(put("/addressbook/update/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "firstName": "Amit",
                                    "lastName": "Kumar",
                                    "phoneNumber": "9123456780"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.firstName").value("Amit"))
                .andExpect(jsonPath("$.lastName").value("Kumar"))
                .andExpect(jsonPath("$.phoneNumber").value("9123456780"));
    }

    // Test DELETE contact
    @Test
    void shouldDeleteContact() throws Exception {
        mockMvc.perform(delete("/addressbook/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Contact deleted with ID: 1"));
    }
}
