package model;
import java.util.Date;

public class ChatRoom
{
    private int chat_room_id;
    private String chat_room_name;
    private Date create_time;
    private String create_by;//填邮箱
    public void setChat_room_id(int chat_room_id) {
        this.chat_room_id = chat_room_id;
    }

    public void setChat_room_name(String chat_room_name) {
        this.chat_room_name = chat_room_name;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public int getChat_room_id() {
        return chat_room_id;
    }

    public String getChat_room_name() {
        return chat_room_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public String getCreate_by() {
        return create_by;
    }




}
