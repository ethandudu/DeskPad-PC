import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DeskPadServer extends org.java_websocket.server.WebSocketServer {

    //authenticated connections
    public static ArrayList<WebSocket> connections = new ArrayList<WebSocket>();

    public DeskPadServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("New connection from " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Closed connection to " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        //check if the connection is authenticated
        if(!connections.contains(conn)){
            JSONObject data = new JSONObject(message);
            if (data.has("type") && data.getString("type").equals("auth")) {
                try {
                    if(DeskPad.authenticate(data.getString("password"))){
                        System.out.println("Authenticated connection from " + conn.getRemoteSocketAddress());

                        JSONObject response = new JSONObject();
                        response.put("type", "auth");
                        response.put("success", true);
                        conn.send(response.toString());
                        connections.add(conn);
                    } else {
                        System.out.println("Failed authentication from " + conn.getRemoteSocketAddress());
                        conn.close();
                        return;
                    }
                } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        JSONObject data;
        try {
            data = new JSONObject(message);
        } catch (Exception e) {
            System.out.println("Invalid JSON from " + conn.getRemoteSocketAddress());
            return;
        }

        if (data.has("type") && data.getString("type").equals("get") && data.has("message")) {
            if (data.getString("message").equals("runningProcs")) {
                JSONObject response = new JSONObject();
                response.put("type", "get");
                try {
                    response.put("message", Utils.runningSoftwares());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                conn.send(response.toString());
                return;
            }
        }

        DeskPad.onMessage(data);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.out.println("An error occurred on connection to " + conn.getRemoteSocketAddress());
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("Server started on " + getAddress());
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        DeskPadServer server = new DeskPadServer(new InetSocketAddress(port));
        server.start();
        System.out.println("Server started on port " + port);
    }
}
