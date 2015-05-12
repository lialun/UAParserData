package li.allan.domain;

public class DeviceType {
    private int id;
    private String name;

    public DeviceType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DeviceType(int id) {
        this.id = id;
    }

    public DeviceType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof DeviceType))
            return false;

        DeviceType that = (DeviceType) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
