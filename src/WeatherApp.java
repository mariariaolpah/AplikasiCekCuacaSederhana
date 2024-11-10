import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherApp extends JFrame {
    private JTable weatherTable;
    private List<WeatherData> weatherDataList;

    public WeatherApp() {
        // Set title dan ukuran jendela
        setTitle("Aplikasi Cuaca");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load data cuaca dari file
        weatherDataList = loadWeatherDataFromFile("weatherData.txt");

        // Membuat dan menampilkan JTable dengan model data
        weatherTable = new JTable(new WeatherTableModel(weatherDataList));
        add(new JScrollPane(weatherTable), BorderLayout.CENTER);
    }

    // Metode untuk memuat data dari file
    public List<WeatherData> loadWeatherDataFromFile(String fileName) {
        List<WeatherData> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                WeatherData data = new WeatherData(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), parts[3]);
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi
        SwingUtilities.invokeLater(() -> {
            WeatherApp app = new WeatherApp();
            app.setVisible(true);
        });
    }
}
