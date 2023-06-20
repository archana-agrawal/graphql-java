// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.io.OutputStream;
// import java.net.HttpURLConnection;
// import java.net.URL;

// public class AnalyticsServiceSender {
//     public static void sendAccountIDToMySQL(String accountID) {
//         // MySQL database connection details
//         String mysqlURL = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your MySQL database URL
//         String mysqlUsername = "your_username"; // Replace with your MySQL username
//         String mysqlPassword = "your_password"; // Replace with your MySQL password

//         Connection mysqlConnection = null;
//         PreparedStatement mysqlStatement = null;

//         try {
//             // Create database connection
//             mysqlConnection = DriverManager.getConnection(mysqlURL, mysqlUsername, mysqlPassword);

//             // Create SQL query
//             String mysqlQuery = "INSERT INTO account_ids (account_id) VALUES (?)";

//             // Create prepared statement
//             mysqlStatement = mysqlConnection.prepareStatement(mysqlQuery);

//             // Set the account ID parameter for MySQL
//             mysqlStatement.setString(1, accountID);

//             // Execute the MySQL query
//             mysqlStatement.executeUpdate();

//             System.out.println("Account ID sent successfully to MySQL.");
//         } catch (SQLException e) {
//             System.out.println("An error occurred while sending account ID to MySQL: " + e.getMessage());
//         } finally {
//             // Close MySQL resources
//             try {
//                 if (mysqlStatement != null) {
//                     mysqlStatement.close();
//                 }
//                 if (mysqlConnection != null) {
//                     mysqlConnection.close();
//                 }
//             } catch (SQLException e) {
//                 System.out.println("Error closing MySQL database resources: " + e.getMessage());
//             }
//         }
//     }

//     public static void sendAccountIDToAmplitude(String accountID) {
//         try {
//             // Create the JSON payload with the account ID
//             String amplitudePayload = "{\"event_type\": \"AccountIDUpdate\", \"user_id\": \"YOUR_USER_ID\", \"event_properties\": {\"AccountID\": \"" + accountID + "\"}}";

//             // Set up the connection to the Amplitude API
//             URL amplitudeURL = new URL("https://api.amplitude.com/2/httpapi");
//             HttpURLConnection amplitudeConnection = (HttpURLConnection) amplitudeURL.openConnection();
//             amplitudeConnection.setRequestMethod("POST");
//             amplitudeConnection.setRequestProperty("Content-Type", "application/json");
//             amplitudeConnection.setDoOutput(true);

//             // Send the payload to the Amplitude API
//             OutputStream amplitudeOutputStream = amplitudeConnection.getOutputStream();
//             amplitudeOutputStream.write(amplitudePayload.getBytes());
//             amplitudeOutputStream.flush();
//             amplitudeOutputStream.close();

//             // Check the response code to ensure the request was successful
//             int amplitudeResponseCode = amplitudeConnection.getResponseCode();
//             if (amplitudeResponseCode == HttpURLConnection.HTTP_OK) {
//                 System.out.println("Account ID sent successfully to Amplitude.");
//             } else {
//                 System.out.println("Failed to send account ID to Amplitude. Response code: " + amplitudeResponseCode);
//             }

//             // Close the Amplitude connection
//             amplitudeConnection.disconnect();
//         } catch (Exception e) {
//             System.out.println("An error occurred while sending account ID to Amplitude: " + e.getMessage());
//         }
//     }

//     public static void main(String[] args) {
//         String accountID = "123456789";
//         sendAccountIDToMySQL(accountID);
//         sendAccountIDToAmplitude(accountID);
//     }
// }
