package de.th_bingen.distsystems.microservices.datastorage.services;

import de.th_bingen.distsystems.microservices.datastorage.ports.in.rest.InPort;
import de.th_bingen.distsystems.microservices.datastorage.ports.out.OutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService implements InPort {

    final OutPort outPort;

    @Autowired
    public MyService(OutPort p) {
        this.outPort = p;
    }

    @Override
    public String hallo(String msg) {
        return outPort.hallo(msg);
    }
}
