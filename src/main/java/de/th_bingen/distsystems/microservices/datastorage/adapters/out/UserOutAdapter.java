package de.th_bingen.distsystems.microservices.datastorage.adapters.out;

import de.th_bingen.distsystems.microservices.datastorage.ports.out.OutUserPort;
import de.th_bingen.distsystems.microservices.datastorage.services.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class UserOutAdapter implements OutUserPort {
    final HashMap<UUID, User> userHashMap = new HashMap<>();

    @Override
    public UUID saveUser(User user) {
        UUID uuid = UUID.randomUUID();
        userHashMap.put(uuid, user);
        System.out.printf("UserOutAdapter::saveUser(User user) = (%s) ---> %s\n", user, uuid);
        return uuid;
    }

    @Override
    public User getUser(UUID uuid) {
        User user = userHashMap.get(uuid);
        System.out.printf("UserOutAdapter::getUser(UUID uuid) = (%s) ---> %s\n", uuid, user);
        return user;
    }

    @Override
    public boolean deleteUser(UUID uuid) {
        boolean result = userHashMap.containsKey(uuid);
        userHashMap.remove(uuid);
        System.out.printf("UserOutAdapter::deleteUser(UUID uuid) = (%s) ---> %s\n", uuid, result);
        return result;
    }
}
