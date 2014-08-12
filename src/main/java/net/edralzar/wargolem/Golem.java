package net.edralzar.wargolem;

import net.edralzar.wargolem.model.MapResource;
import net.edralzar.wargolem.model.Player;
import net.edralzar.wargolem.model.Role;
import net.edralzar.wargolem.model.WarRoom;

public class Golem {

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

    public WarRoom getWarRoom() {
        return room;
    }
}
