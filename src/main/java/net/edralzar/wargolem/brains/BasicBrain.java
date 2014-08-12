package net.edralzar.wargolem.brains;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.edralzar.wargolem.Brain;
import net.edralzar.wargolem.model.Player;
import net.edralzar.wargolem.model.WarRoom;

public class BasicBrain implements Brain {

    private final ObjectMapper jsonMapper = new ObjectMapper();

    @Override
    public void save(WarRoom room) {
        //NO-OP
        try {
            System.out.println(jsonMapper.writeValueAsString(room));
            System.out.println();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public WarRoom load(String roomId, Player owner) {
        //NO-OP
        return new WarRoom(roomId, "defaultTopic", "", owner);
    }
}
