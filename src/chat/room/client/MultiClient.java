package chat.room.client;

import java.io.IOException;
import java.net.Socket;

public class MultiClient
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("127.0.0.1", 7777);
        Thread read=new Thread(new ClientReadServer(socket));
        Thread send=new Thread(new ClientSendServer(socket));
        read.start();
        send.start();
    }
}
