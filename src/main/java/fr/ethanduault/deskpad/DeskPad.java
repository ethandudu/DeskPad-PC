package fr.ethanduault.deskpad;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;

import org.json.JSONArray;
import org.json.JSONObject;

public class DeskPad {
    static DeskPadServer server;
    static String password;
    public static void main(String[] args) {

        //OS Check
        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            System.out.println("Only Windows is supported");
            System.exit(1);
        }

        String ip = "0.0.0.0";
        int port = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-port":
                    port = Integer.parseInt(args[++i]);
                    break;
                case "-ip":
                    ip = args[++i];
                    break;
                case "-password":
                    password = args[++i];
                    break;
                default:
                    System.out.println("Invalid argument: " + args[i] + "\nUsage: -port [port] -ip [ip] -password <password>");
                    System.exit(1);
            }
        }

        if (password == null || port == 0) {
            System.out.println("Usage: -port [port] -ip [ip] -password <password>");
            System.exit(1);
        }

        InetSocketAddress address = new InetSocketAddress(ip, port);

        System.out.println("Starting server on " + address.getPort());

        server = new DeskPadServer(address);

        server.start();
    }

    public static void onMessage(JSONObject message) {
        try {
            if (message.has("type") && message.getString("type").equals("run") && message.has("message")) {
                Utils.runCommand(message.getString("message"));
            }
            if (message.has("type") && message.getString("type").equals("key") && message.has("message")) {
                Utils.pressKey(message.getString("message"));
            } else if (message.has("type") && message.getString("type").equals("keys") && message.has("message")) {
                JSONArray keys = message.getJSONArray("message");
                for (int i = 0; i < keys.length(); i++) {
                    Utils.pressKey(keys.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean authenticate(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return password.equals(Utils.getSHA256(DeskPad.password));
    }
}
