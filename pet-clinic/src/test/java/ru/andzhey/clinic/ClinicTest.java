package ru.andzhey.clinic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Анджей on 14.05.2016.
 */
public class ClinicTest {
    @Test
    public void removeClientByName() throws Exception {
        Clinic clinic = new Clinic();
        Client client = new Client(1, "Boris", new Cat("Tom"));
        clinic.addClient(client);
        clinic.removeClientByName("Boris");
        Assert.assertEquals(true, clinic.getClients().isEmpty());

    }

}