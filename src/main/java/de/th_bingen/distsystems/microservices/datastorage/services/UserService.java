package de.th_bingen.distsystems.microservices.datastorage.services;

import de.th_bingen.distsystems.microservices.datastorage.adapters.in.rest.UserDTO;
import de.th_bingen.distsystems.microservices.datastorage.adapters.in.websocket.WebSocketAdapter;
import de.th_bingen.distsystems.microservices.datastorage.ports.in.rest.InUserPort;
import de.th_bingen.distsystems.microservices.datastorage.ports.out.OutUserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements InUserPort {
    final OutUserPort outUserPort;
    final WebSocketAdapter webSocketAdapter;

    @Autowired
    public UserService(OutUserPort outUserPort, WebSocketAdapter webSocketAdapter) {
        this.outUserPort = outUserPort;
        this.webSocketAdapter = webSocketAdapter;
    }

    @Override
    public UserDTO getUser(UUID uuid) {
        User user = outUserPort.getUser(uuid);
        if (user == null)
            return null;
        UserDTO userDTO = new UserDTO(user.firstName(), user.lastName());
        webSocketAdapter.notify("GET USER: " +  userDTO);
        return userDTO;
    }

    @Override
    public UUID postUser(String firstName, String lastName) {
        webSocketAdapter.notify("POST USER: " + firstName + " " + lastName);
        return outUserPort.saveUser(new User(UUID.randomUUID(), firstName, lastName));
    }

    @Override
    public boolean deleteUser(UUID uuid) {
        webSocketAdapter.notify("DELETE USER: " + uuid);
        return outUserPort.deleteUser(uuid);
    }
}
