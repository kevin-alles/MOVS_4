package de.th_bingen.distsystems.microservices.datastorage.ports.out;

import de.th_bingen.distsystems.microservices.datastorage.services.User;

import java.util.UUID;

public interface OutUserPort {
    UUID saveUser(User user);
    User getUser(UUID uuid);
    boolean deleteUser(UUID uuid);
}
