package net.edralzar.wargolem;

import static org.junit.Assert.assertEquals;

import java.time.Instant;

import org.junit.Before;

import net.edralzar.wargolem.model.Gw2Class;
import net.edralzar.wargolem.model.Player;
import net.edralzar.wargolem.model.Role;
import net.edralzar.wargolem.model.WarRoom;


import org.junit.Before;

import net.edralzar.wargolem.model.Gw2Class;
import net.edralzar.wargolem.model.Player;
import net.edralzar.wargolem.model.Role;
import net.edralzar.wargolem.model.WarRoom;

public class GolemTest {

    private Golem golem;

    @Before
    public void setUp() throws Exception {
        Player owner = new Player("testLead", Gw2Class.GUARDIAN);
        WarRoom room = new WarRoom("test", "testTopic", "someServer", owner);

        golem = new Golem(room);
    }

    @org.junit.Test
    public void testAddPlayer() throws Exception {
        Player p = new Player("toto", Gw2Class.THIEF);
        //TODO replace with AssertJ
        assertEquals(Role.SOLDIER, p.getRole());
        assertEquals(Instant.EPOCH, p.getRoleSince());

        golem.addPlayer(p);
        //TODO
    }

    @org.junit.Test
    public void testSetScout() throws Exception {
        //TODO
    }
}