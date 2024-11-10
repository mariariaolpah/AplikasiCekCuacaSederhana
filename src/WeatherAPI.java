import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class WeatherAPI {
    public static String getWeatherData(String city) {
        try {
            String apiKey = "fb2bd2b06926c93515571d299f56a31c"; // Ganti dengan API key Anda
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=Banjarmasin&appid=fb2bd2b06926c93515571d299f56a31c&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Memeriksa status HTTP
            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                return "Terjadi kesalahan dengan status HTTP: " + status;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String jsonResponse = response.toString();

            // Memeriksa JSON respons untuk memastikan format yang benar
            System.out.println("Response JSON: " + jsonResponse); // Debug: Memeriksa respons JSON
            if (jsonResponse.contains("weather") && jsonResponse.contains("main")) {
                JSONObject jsonObject = new JSONObject(jsonResponse);
                double temperature = jsonObject.getJSONObject("main").getDouble("temp");
                String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

                return "Suhu: " + temperature + "°C\nDeskripsi: " + description;
            } else {
                return "Data cuaca tidak ditemukan!";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Terjadi kesalahan dalam mengambil data cuaca: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Mengambil data cuaca untuk kota tertentu
        String city = "Banjarmasin"; // Ganti dengan kota yang diinginkan
        String weatherInfo = getWeatherData(city);
        System.out.println(weatherInfo);
    }
}
