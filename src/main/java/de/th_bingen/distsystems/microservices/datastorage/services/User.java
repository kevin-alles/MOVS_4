package de.th_bingen.distsystems.microservices.datastorage.services;

import java.util.UUID;

public record User(UUID uuid, String firstName, String lastName) {
}
