package de.th_bingen.distsystems.microservices.datastorage.adapters.in.rest;

import de.th_bingen.distsystems.microservices.datastorage.ports.in.rest.InPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyInAdapter {

    @Autowired
    public MyInAdapter(InPort i) {
        this.inPort = i;
    }

    final InPort inPort;

    @GetMapping
    String hallo(String msg) {
        return inPort.hallo(msg);
    }


}
