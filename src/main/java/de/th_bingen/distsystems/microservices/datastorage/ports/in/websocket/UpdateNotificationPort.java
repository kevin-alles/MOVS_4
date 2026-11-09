package de.th_bingen.distsystems.microservices.datastorage.ports.in.websocket;

import de.th_bingen.distsystems.microservices.datastorage.adapters.in.rest.UserDTO;

public interface UpdateNotificationPort {
    void notify(String message);
}
