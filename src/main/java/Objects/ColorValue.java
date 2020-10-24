package Objects;

public class ColorValue {

    boolean present;
    String name;
    long value;
    String hexValue;

    public ColorValue() {
    }

    public ColorValue(boolean present, String name, long value) {
        this.present = present;
        this.name = name;
        this.value = value;
    }

    public ColorValue(boolean present, String name, String hexValue) {
        this.present = present;
        this.name = name;
        this.hexValue = hexValue;
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

    private long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getLongValue() {
        if(value == 0 && getHexValue() != null) {
            setHexValue(getHexValue().indexOf("#") == 0 ? getHexValue().substring(1) : getHexValue());
            return Long.parseLong(getHexValue(), 16);
        }
        return getValue();
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }


}
