package net.edralzar.wargolem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.edralzar.wargolem.brains.BasicBrain;
import net.edralzar.wargolem.model.MapResource;
import net.edralzar.wargolem.model.Player;
import net.edralzar.wargolem.model.Role;
import net.edralzar.wargolem.model.WarRoom;

public class Golem {

    private static final Comparator<Player> ROLE_SINCE_COMPARATOR = new Comparator<Player>() {
        @Override
        public int compare(Player o1, Player o2) {
            return o1.getRoleSince().compareTo(o2.getRoleSince());
        }
    };

    private WarRoom room;
    private Brain brain;

    public Golem(WarRoom room) {
        this(new BasicBrain(), room);
    }

    public Golem(Brain brain, WarRoom newRoom) {
        if (newRoom == null)
            throw new NullPointerException("WarRoom cannot be null");
        if (brain == null)
            this.brain = new BasicBrain();
        else
            this.brain = brain;
        this.room = newRoom;
    }

    public Golem(Brain brain, String roomId, Player owner) {
        this.brain = brain == null ? new BasicBrain() : brain;
        this.room = brain.load(roomId, owner);
    }

    public void addPlayer(Player p) {
        room.getSquad().add(p);
        p.setRole(Role.SOLDIER);
        brain.save(room);
    }

    public void setScout(Player p, MapResource mr) {
        Player oldScout = room.getScouts().forcePut(mr, p);
        p.setRole(Role.SCOUT);
        if (oldScout != null)
            oldScout.setRole(Role.SOLDIER);
        brain.save(room);
    }

    public void replaceScout(Player oldScout, Player newScout) {
        MapResource scoutPoint = room.getScouts().inverse().get(oldScout);
        if (scoutPoint == null)
            return;

        setScout(newScout, scoutPoint);
    }

    public void removeScout(MapResource tower) {
        Player oldScout = room.getScouts().remove(tower);
        if (oldScout != null)
            oldScout.setRole(Role.SOLDIER);
        brain.save(room);
    }

    public List<Player> listScoutsByAge() {
        List<Player> scouts = new ArrayList<Player>(room.getScouts().values());
        Collections.sort(scouts, ROLE_SINCE_COMPARATOR);
        return scouts;
    }

    public WarRoom getWarRoom() {
        return room;
    }
}
