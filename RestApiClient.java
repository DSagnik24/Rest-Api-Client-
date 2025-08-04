package RestAPIClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiClient {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts/1";

    public static void main(String[] args) {
        try {
            // Create URL object
            URL url = new URL(API_URL);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("🔌 Sending GET request to URL: " + API_URL);
            System.out.println("📡 Response Code: " + responseCode);

            // If response is OK (200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder responseContent = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    responseContent.append(inputLine);
                }

                in.close();

                // Display the response
                System.out.println("📦 API Response:");
                System.out.println(responseContent.toString());
            } else {
                System.out.println("❌ GET request failed.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
