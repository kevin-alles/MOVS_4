package de.th_bingen.distsystems.microservices.datastorage.adapters.in.rest;

import de.th_bingen.distsystems.microservices.datastorage.ports.in.rest.InUserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserInAdapter{

    final InUserPort inUserPort;

    @Autowired
    public UserInAdapter(InUserPort inUserPort) {
        this.inUserPort = inUserPort;
    }

    @GetMapping("/{uuid}")
    ResponseEntity<Object> getUser(@PathVariable UUID uuid){
        UserDTO result = inUserPort.getUser(uuid);
        if (result != null){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    ResponseEntity<Object> putUser(@RequestBody UserDTO userDTO){
        UUID uuid = inUserPort.postUser(userDTO.firstName(), userDTO.lastName());
        if (uuid != null){
            return ResponseEntity.created(URI.create("/users/" + uuid)).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<Object> deleteUser(@PathVariable UUID uuid){
        boolean result = inUserPort.deleteUser(uuid);
        if (result){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
