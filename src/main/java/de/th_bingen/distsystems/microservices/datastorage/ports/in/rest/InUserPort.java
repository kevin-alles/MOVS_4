package de.th_bingen.distsystems.microservices.datastorage.ports.in.rest;

import de.th_bingen.distsystems.microservices.datastorage.adapters.in.rest.UserDTO;

import java.util.UUID;

public interface InUserPort {
    UserDTO getUser(UUID uuid);
    UUID postUser(String firstName, String lastName);
    boolean deleteUser(UUID uuid);
}
