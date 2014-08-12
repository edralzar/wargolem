package net.edralzar.wargolem;

import net.edralzar.wargolem.model.Player;
import net.edralzar.wargolem.model.WarRoom;

public interface Brain {

    /**
     * Use this brain to save the state of the golem's WarRoom, ie in a file or a database
     * @param room
     */
    public void save(WarRoom room);

    /**
     * Use this brain to load a previously persisted WarRoom state, allowing the golem to reload it
     * @param roomId
     * @param owner
     * @return the loaded WarRoom
     */
    public WarRoom load(String roomId, Player owner);
}
