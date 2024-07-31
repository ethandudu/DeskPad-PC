import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;

import org.json.JSONArray;
import org.json.JSONObject;

public class DeskPad {
    static DeskPadServer server;
    static String password;
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java DeskPad <port> <password>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        password = args[1];

        server = new DeskPadServer(new InetSocketAddress(port));

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
        System.out.println(password);
        System.out.println((DeskPad.password));
        return password.equals(Utils.getSHA256(DeskPad.password));
    }
}
