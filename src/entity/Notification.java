package entity;

public class Notification {

    private int notification_id;
    private String type;
    private String name;
    private String text;
    private int user_id;

    public Notification(String type, String name, String text, int user_id) {
        this.type = type;
        this.name = name;
        this.text = text;
        this.user_id = user_id;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notification_id=" + notification_id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
