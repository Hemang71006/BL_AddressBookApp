
package com.addressbook.dto;

/**
 * Project Name : Address Book Application
 * Module       : Address Book DTO
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Transfers contact details between the client and controller.
 */
public class AddressBookDTO {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Default constructor
    public AddressBookDTO() {
    }

    // Parameterized constructor
    public AddressBookDTO(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
