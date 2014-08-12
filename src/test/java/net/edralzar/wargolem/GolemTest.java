package net.edralzar.wargolem;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.junit.Before;

import net.edralzar.wargolem.model.Gw2Class;
import net.edralzar.wargolem.model.MapResource;
import net.edralzar.wargolem.model.Player;
import net.edralzar.wargolem.model.Role;
import net.edralzar.wargolem.model.WarRoom;

public class GolemTest {

    private Golem golem;
    private Player soldier1;
    private Player scout1;
    private Player scout2;

    @Before
    public void setUp() throws Exception {
        Player owner = new Player("testLead", Gw2Class.GUARDIAN);
        WarRoom room = new WarRoom("test", "testTopic", "someServer", owner);
        soldier1 = new Player("soldier1", Gw2Class.ELEMENTALIST);
        scout1 = new Player("scout1", Gw2Class.THIEF);
        scout2 = new Player("scout2", Gw2Class.ENGINEER);

        golem = new Golem(room);
        golem.addPlayer(soldier1);
        golem.addPlayer(scout1);
        golem.addPlayer(scout2);
    }

    @org.junit.Test
    public void testAddPlayer() throws Exception {
        Player p = new Player("toto", Gw2Class.THIEF);
        assertThat(p.getRole()).isEqualTo(Role.SOLDIER);
        assertThat(p.getRoleSince()).isEqualTo(Instant.EPOCH);

        assertThat(golem.getWarRoom().getSquad().size()).isEqualTo(3);
        golem.addPlayer(p);
        assertThat(golem.getWarRoom().getSquad().size()).isEqualTo(4);
        assertThat(golem.getWarRoom().getSquad()).contains(p);
    }

    @org.junit.Test
    public void testSetScout() throws Exception {
        MapResource tower = new MapResource("blueLakeTower", "Blue Lake Tower");
        Instant beforeScout = scout1.getRoleSince();
        assertThat(scout1.getRole()).isEqualTo(Role.SOLDIER);

        golem.setScout(scout1, tower);
        assertThat(golem.getWarRoom().getScouts().get(tower)).isEqualTo(scout1);
        assertThat(scout1.getRole()).isEqualTo(Role.SCOUT);
        assertThat(scout1.getRoleSince().isAfter(beforeScout)).isTrue();
    }

    @org.junit.Test
    public void testScoutReplaces() throws Exception {
        MapResource tower = new MapResource("redLakeTower", "Red Lake Tower");
        golem.setScout(scout1, tower);
        golem.setScout(scout2, tower);
        assertThat(golem.getWarRoom().getScouts().get(tower)).isEqualTo(scout2);
        assertThat(scout1.getRole()).isEqualTo(Role.SOLDIER);
        assertThat(golem.getWarRoom().getScouts().inverse().get(scout1)).isNull();
    }
}