package chat.room.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientReadServer implements Runnable
{
    private Socket socket;
    public ClientReadServer(Socket socket)
    {
        this.socket = socket;
    }
    @Override
    public void run()
    {
        try
        {
            Scanner scanner = new Scanner(socket.getInputStream());
            while(scanner.hasNext())
            {
                System.out.println(scanner.next());
            }
            scanner.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
