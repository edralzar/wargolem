package net.edralzar.wargolem.brains;

import net.edralzar.wargolem.Brain;
import net.edralzar.wargolem.model.Player;
import net.edralzar.wargolem.model.WarRoom;

public class BasicBrain implements Brain {

    @Override
    public void save(WarRoom room) {
        //NO-OP
    }

    @Override
    public WarRoom load(String roomId, Player owner) {
        //NO-OP
        return new WarRoom(roomId, "defaultTopic", "", owner);
    }
}
