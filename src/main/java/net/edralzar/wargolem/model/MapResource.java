package net.edralzar.wargolem.model;

public class MapResource {

    private String resourceId;
    private String name;
    private String state;

    public MapResource(String resourceId, String name) {
        this.resourceId = resourceId;
        this.name = name;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapResource that = (MapResource) o;

        return resourceId.equals(that.resourceId);

    }

    @Override
    public int hashCode() {
        return resourceId.hashCode();
    }
}
