package de.th_bingen.distsystems.microservices.datastorage.adapters.out;

import de.th_bingen.distsystems.microservices.datastorage.ports.out.OutPort;
import org.springframework.stereotype.Repository;

@Repository
public class MyOutAdapter implements OutPort {

    @Override
    public String hallo(String msg) {
        System.out.println("Hallo aus dem OutAdapter: " + msg);
        return msg;
    }
}
