import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeskPad {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java DeskPad <port> <password>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        String password = args[1];

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("DeskPad server is running on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        JSONObject json;
                        try {
                            json = new JSONObject(inputLine);
                        } catch (Exception e) {
                            System.out.println("Invalid JSON received");
                            break;
                        }

                        if (!json.has("password") || !json.getString("password").equals(Utils.getSHA256(password))) {
                            System.out.println("Invalid password");
                            break;
                        }

                        if (json.has("type") && json.getString("type").equals("run") && json.has("message")) {
                            Utils.runCommand(json.getString("message"));
                        }
                        if (json.has("type") && json.getString("type").equals("key") && json.has("message")) {
                            Utils.pressKey(json.getString("message"));
                        } else if (json.has("type") && json.getString("type").equals("keys") && json.has("message")) {
                            JSONArray keys = json.getJSONArray("message");
                            for (int i = 0; i < keys.length(); i++) {
                                Utils.pressKey(keys.getString(i));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("DeskPad server error: " + e.getMessage());
        }
    }
}
