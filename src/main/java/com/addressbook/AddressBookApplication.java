
package com.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Project Name : Address Book Application
 * Module       : Application Startup
 * Author       : Hemang
 * Date         : 03-11-2026
 *
 * Description:
 * Main entry point of the Address Book Spring Boot application.
 * Starts the Spring Boot application and initializes the Spring container.
 */

@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}
}
