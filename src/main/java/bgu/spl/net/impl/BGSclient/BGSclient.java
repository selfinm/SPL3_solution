package bgu.spl.net.impl.BGSclient;

import java.io.IOException;

import bgu.spl.net.impl.newsfeed.PublishNewsCommand;
import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.impl.rci.RCIClient;

public class BGSclient {

    public static int foo() {
        return 1;
    }

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            args = new String[]{"localhost", "hello"};
        }

        if (args.length < 2) {
            System.out.println("you must supply two arguments: host, message");
            System.exit(1);
        }

        //BufferedReader and BufferedWriter automatically using UTF-8 encoding
        try (RCIClient c = new RCIClient(args[0], 7777)) {
            System.out.println("sending message to server");

            Command<?> cmd = new PublishNewsCommand("channel", args[1]);
            c.send(cmd);
            
            System.out.println("awaiting response");
            Object line = c.receive();
            System.out.println("message from server: " + line);
        }
    }
}
