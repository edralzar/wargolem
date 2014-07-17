package net.edralzar.wargolem.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class WarRoom {

    private String roomId;
    private String topic;
    private String serverId;

    private Player owner;
    private List<Player> squad;

    private List<String> chat;

    private BiMap<MapResource, Player> scouts;

    public WarRoom(String roomId, String topic, String serverId, Player owner) {
        this.roomId = roomId;
        this.topic = topic;
        this.serverId = serverId;
        this.owner = owner;
        this.squad = new ArrayList<Player>();
        this.chat = new ArrayList<String>();
        this.scouts = HashBiMap.create();
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {

        return topic;
    }

    public String getServerId() {
        return serverId;
    }

    public Player getOwner() {
        return owner;
    }

    public List<Player> getSquad() {
        return squad;
    }

    public List<String> getChat() {
        return chat;
    }

    public BiMap<MapResource, Player> getScouts() {
        return scouts;
    }
}
