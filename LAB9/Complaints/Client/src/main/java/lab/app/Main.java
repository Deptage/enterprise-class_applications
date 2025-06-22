package lab.app;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;

public class Main {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String status =
                client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                                "api/complaints/201/status")
                        .request(MediaType.TEXT_PLAIN)
                        .get(String.class);

        System.out.println("Status: " + status);
        System.out.println("\n");

        // podpunkt 7a
        String queryAllComplaints = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println("All complaints: "+ queryAllComplaints);
        System.out.println("\n");

        //podpunkt 7b
        String queryOpenComplaint = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints/203")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("Example open complaint: "+ queryOpenComplaint);
        System.out.println("\n");

        //podnpunkt 7c
        String updateComplaint = queryOpenComplaint.replace("\"status\":\"open\"", "\"status\":\"closed\"");
        client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints/203").request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(updateComplaint, MediaType.APPLICATION_JSON));
        System.out.println("Changed the complaint status");
        System.out.println("\n");


        //podpunkt 7d
        String allOpenComplaints = client.target("http://localhost:8080/Server-1.0-SNAPSHOT/" +
                        "api/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("All open complaints: "+ allOpenComplaints );
        client.close();

    }
}
