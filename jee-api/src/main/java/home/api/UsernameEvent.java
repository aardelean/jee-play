package home.api;

/**
 * Created by alex on 6/27/2015.
 */
public class UsernameEvent {
    private String value;

    public UsernameEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
