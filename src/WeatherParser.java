import javax.swing.*;
import java.net.*;
import java.io.*;

public class WeatherParser {

    // Mendapatkan suhu dari JSON
    public static String getTemperature(String jsonData) {
        int tempIndex = jsonData.indexOf("\"temp\":");
        if (tempIndex == -1) {
            return "Data suhu tidak ditemukan.";
        }

        String tempSubString = jsonData.substring(tempIndex + 7); // 7 adalah panjang kata "temp:"
        String temperature = tempSubString.split(",")[0];

        return temperature;
    }

    // Mendapatkan ikon cuaca dari JSON
    public static String getWeatherIcon(String jsonData) {
        int iconIndex = jsonData.indexOf("\"icon\":");
        if (iconIndex == -1) {
            return "Icon tidak ditemukan.";
        }

        String iconSubString = jsonData.substring(iconIndex + 8); // 8 adalah panjang kata "icon:"
        String weatherIcon = iconSubString.split("\"")[0];

        return weatherIcon;
    }

    // Membentuk URL gambar berdasarkan ikon cuaca
    public static String getWeatherImageUrl(String icon) {
        return "http://openweathermap.org/img/wn/" + icon + "@2x.png";
    }

    // Menampilkan gambar cuaca di GUI
    public static void displayWeatherImage(String icon) {
        String imageUrl = getWeatherImageUrl(icon);
        try {
            URL url = new URL(imageUrl);
            ImageIcon iconImage = new ImageIcon(url);
            JLabel label = new JLabel(iconImage);
            JFrame frame = new JFrame("Cuaca");
            frame.add(label);
            frame.setSize(200, 200);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Gagal menampilkan gambar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Contoh JSON data yang diterima dari API cuaca
        String jsonData = "{ \"main\": { \"temp\": 30.0 }, \"weather\": [ { \"icon\": \"01d\" } ] }";

        // Parsing suhu
        String temperature = getTemperature(jsonData);
        System.out.println("Suhu: " + temperature + "°C");

        // Parsing ikon cuaca
        String icon = getWeatherIcon(jsonData);
        System.out.println("Icon Cuaca: " + icon);

        // Menampilkan gambar cuaca
        displayWeatherImage(icon);
    }
}