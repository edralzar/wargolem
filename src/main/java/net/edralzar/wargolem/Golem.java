package net.edralzar.wargolem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public Golem(WarRoom room) {
        if (room == null)
            throw new NullPointerException();
        this.room = room;
    }

    public void addPlayer(Player p) {
        room.getSquad().add(p);
        p.setRole(Role.SOLDIER);
    }

    public void setScout(Player p, MapResource mr) {
        Player oldScout = room.getScouts().forcePut(mr, p);
        p.setRole(Role.SCOUT);
        if (oldScout != null)
            oldScout.setRole(Role.SOLDIER);
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
