package chat.room.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendServer implements Runnable
{
    private Socket socket;
    public ClientSendServer(Socket socket)
    {
        this.socket = socket;
    }
    @Override
    public void run()
    {
        try
        {
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while(true)
            {
                String msg = null;
                if(scanner.hasNext())
                {
                    msg = scanner.next();
                    printStream.println(msg);
                }
                if(msg.equals("exit"))
                {
                    scanner.close();
                    printStream.close();
                    break;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
