package net.edralzar.wargolem.model;

import java.util.List;

public class MapResource {

    private String resourceId;
    private String name;
    private String state;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapResource that = (MapResource) o;

        if (!resourceId.equals(that.resourceId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return resourceId.hashCode();
    }
}
