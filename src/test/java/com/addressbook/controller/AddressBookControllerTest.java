
package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import com.addressbook.service.AddressBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Project Name : Address Book Application
 * Module       : Controller Testing
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Tests REST Controller endpoints using MockMvc and a mocked Service.
 */
@WebMvcTest(AddressBookController.class)
class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AddressBookService addressBookService;

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
        when(addressBookService.getAllContacts()).thenReturn(List.of());

        mockMvc.perform(get("/addressbook"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    // Test GET contact by ID
    @Test
    void shouldGetContactById() throws Exception {
        when(addressBookService.getContactById(1))
                .thenReturn(new AddressBook(
                        1, "Hemang", "Sharma", "9876543210"
                ));

        mockMvc.perform(get("/addressbook/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Hemang"))
                .andExpect(jsonPath("$.lastName").value("Sharma"))
                .andExpect(jsonPath("$.phoneNumber").value("9876543210"));
    }

    // Test POST create contact
    @Test
    void shouldCreateContact() throws Exception {
        when(addressBookService.createContact(any(AddressBookDTO.class)))
                .thenReturn(new AddressBook(
                        1, "Rahul", "Sharma", "9876543210"
                ));

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

    // Test PUT update contact
    @Test
    void shouldUpdateContact() throws Exception {
        when(addressBookService.updateContact(
                eq(2), any(AddressBookDTO.class)))
                .thenReturn(new AddressBook(
                        2, "Amit", "Kumar", "9123456780"
                ));

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
        when(addressBookService.deleteContact(1))
                .thenReturn("Contact deleted with ID: 1");

        mockMvc.perform(delete("/addressbook/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "Contact deleted with ID: 1"
                ));
    }
}
