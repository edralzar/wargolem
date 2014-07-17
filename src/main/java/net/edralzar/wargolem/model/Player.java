package net.edralzar.wargolem.model;

import java.time.Instant;

public class Player {

    private String nickname;
    private Gw2Class currentClass;
    private Role role;
    private Instant roleSince;

    public Player(String nickname, Gw2Class currentClass) {
        this.nickname = nickname;
        this.currentClass = currentClass;
        this.role = Role.SOLDIER;
        this.roleSince = Instant.EPOCH;
    }

    public String getNickname() {
        return nickname;
    }

    public Gw2Class getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(Gw2Class currentClass) {
        this.currentClass = currentClass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if (this.role != role || roleSince == Instant.EPOCH) {
            this.role = role;
            this.roleSince = Instant.now();
        }
    }

    public Instant getRoleSince() {
        return roleSince;
    }
}
