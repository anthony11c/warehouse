package com.example.partsUnlimited.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/security")
public class SecurityController {

    // Method to serve the guest page!
    @GetMapping(value= "/warehouse")
    public ResponseEntity<String> warehouse() {
        System.out.println("Showing warehouse page.");
        return new ResponseEntity<String>("Hello from the warehouse!", HttpStatus.OK);
    }

    // Method to serve the secure/administration page!
    @GetMapping(value= "/sales")
    public ResponseEntity<String> sales() {
        System.out.println("Showing sales page.");
        return new ResponseEntity<String>("Hello from sale!", HttpStatus.OK);
    }
}
