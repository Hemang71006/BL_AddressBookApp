
package com.addressbook.model;

/**
 * Project Name : Address Book Application
 * Module       : Address Book Model
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Represents a contact in the Address Book application.
 */
public class AddressBook {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Default constructor
    public AddressBook() {
    }

    // Parameterized constructor
    public AddressBook(int id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
