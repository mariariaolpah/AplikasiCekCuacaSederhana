import javax.swing.table.AbstractTableModel;
import java.util.List;

public class WeatherTableModel extends AbstractTableModel {
    private List<WeatherData> weatherDataList;
    private String[] columnNames = { "Kota", "Suhu", "Kelembapan", "Deskripsi" };

    public WeatherTableModel(List<WeatherData> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    @Override
    public int getRowCount() {
        return weatherDataList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        WeatherData data = weatherDataList.get(rowIndex);
        switch (columnIndex) {
            case 0: return data.getCity();
            case 1: return data.getTemperature();
            case 2: return data.getHumidity();
            case 3: return data.getDescription();
            default: return null;
        }
    }
}
