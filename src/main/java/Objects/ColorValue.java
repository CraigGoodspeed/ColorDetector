package Objects;

public class ColorValue {

    boolean present;
    String name;
    long value;

    public ColorValue() {
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public ColorValue(boolean present, String name, long value) {
        this.present = present;
        this.name = name;
        this.value = value;
    }
}
