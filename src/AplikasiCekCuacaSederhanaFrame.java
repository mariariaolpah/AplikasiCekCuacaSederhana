import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class AplikasiCekCuacaSederhanaFrame extends javax.swing.JFrame {
private String getWeatherData(String city) {
        try {
            String apiKey = "fb2bd2b06926c93515571d299f56a31c"; // Ganti dengan API key Anda
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String extractJsonValue(String jsonData, String key) {
        int index = jsonData.indexOf(key);
        if (index == -1) return "";
        int startIndex = jsonData.indexOf(":", index) + 1;
        int endIndex = jsonData.indexOf(",", startIndex);
        if (endIndex == -1) endIndex = jsonData.indexOf("}", startIndex);
        return jsonData.substring(startIndex, endIndex).replaceAll("\"", "").trim();
    }
    public AplikasiCekCuacaSederhanaFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JPanel();
        labelJudul = new javax.swing.JLabel();
        textFieldCuaca = new javax.swing.JTextField();
        comboBoxKota = new javax.swing.JComboBox<>();
        buttonCekCuaca = new javax.swing.JButton();
        buttonKeluar = new javax.swing.JButton();
        labelKota = new javax.swing.JLabel();
        labelCuaca = new javax.swing.JLabel();
        labelGambarCuaca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelUtama.setBackground(new java.awt.Color(255, 153, 0));

        labelJudul.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelJudul.setText("Aplikasi Cek Cuaca Sederhana");

        comboBoxKota.setBackground(new java.awt.Color(255, 204, 153));
        comboBoxKota.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboBoxKota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banjarmasin", "Banjarbaru", "Palangkaraya", "Jakarta", "Sukamara" }));
        comboBoxKota.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxKotaItemStateChanged(evt);
            }
        });

        buttonCekCuaca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonCekCuaca.setText("Cek Cuaca");
        buttonCekCuaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCekCuacaActionPerformed(evt);
            }
        });

        buttonKeluar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonKeluar.setText("Keluar");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });

        labelKota.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelKota.setText("Pilih Kota");

        labelCuaca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelCuaca.setText("Menampilan Cuaca");

        labelGambarCuaca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelGambarCuaca.setText("Kondisi Cuaca");

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelCuaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelKota)
                            .addComponent(labelGambarCuaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(121, 121, 121)
                        .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelUtamaLayout.createSequentialGroup()
                                .addComponent(comboBoxKota, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonCekCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelUtamaLayout.createSequentialGroup()
                                .addComponent(textFieldCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelJudul)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelJudul)
                .addGap(43, 43, 43)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxKota, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCekCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKota))
                .addGap(14, 14, 14)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCuaca, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldCuaca, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(labelGambarCuaca)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCekCuacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCekCuacaActionPerformed
    String city = comboBoxKota.getSelectedItem().toString();
    String jsonData = getWeatherData(city);

    if (jsonData != null) {
        try {
            // Debugging: tampilkan data JSON yang diterima
            System.out.println("Data JSON: " + jsonData);

            // Mengambil suhu dari data JSON
            String temperature = extractJsonValue(jsonData, "\"temp\":");
            textFieldCuaca.setText(temperature + "°C");

            // Mengambil ikon cuaca dari data JSON
            String weatherIcon = extractJsonValue(jsonData, "\"icon\":\"");
            System.out.println("Icon cuaca: " + weatherIcon); // Debugging

            // Hapus karakter yang tidak perlu jika ada
            if (weatherIcon.endsWith("}]")) {
                weatherIcon = weatherIcon.substring(0, weatherIcon.length() - 2);
            }

            // Tentukan URL gambar berdasarkan ikon cuaca
            String imageUrl = "";
            switch (weatherIcon) {
                case "01d":
                    imageUrl = "http://openweathermap.org/img/wn/01d@2x.png"; // Cerah (Siang)
                    break;
                case "01n":
                    imageUrl = "http://openweathermap.org/img/wn/01n@2x.png"; // Cerah (Malam)
                    break;
                case "02d":
                case "02n":
                case "03d":
                case "03n":
                    imageUrl = "http://openweathermap.org/img/wn/03d@2x.png"; // Berawan
                    break;
                case "09d":
                case "09n":
                case "10d":
                case "10n":
                    imageUrl = "http://openweathermap.org/img/wn/09d@2x.png"; // Hujan
                    break;
                case "13d":
                case "13n":
                    imageUrl = "http://openweathermap.org/img/wn/13d@2x.png"; // Salju
                    break;
                case "50d":
                case "50n":
                    imageUrl = "http://openweathermap.org/img/wn/50d@2x.png"; // Kabut
                    break;
                default:
                    imageUrl = "http://openweathermap.org/img/wn/01d@2x.png"; // Default (Cerah)
                    break;
            }

            System.out.println("URL Gambar: " + imageUrl); // Debugging

            // Mengunduh gambar cuaca
            try {
                URL url = new URL(imageUrl);
                Image img = ImageIO.read(url); // Mengunduh gambar cuaca
                ImageIcon icon = new ImageIcon(img);
                labelGambarCuaca.setIcon(icon); // Menampilkan gambar di JLabel
                labelGambarCuaca.setText(""); // Hapus teks jika ada gambar yang ditampilkan
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal mengunduh gambar cuaca", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mengambil data cuaca", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        textFieldCuaca.setText("Data cuaca tidak ditemukan.");
        labelGambarCuaca.setIcon(null); // Hapus gambar jika data tidak ditemukan
        labelGambarCuaca.setText("Gambar tidak tersedia"); // Menampilkan pesan jika gambar tidak ada
    }
    }//GEN-LAST:event_buttonCekCuacaActionPerformed

    private void comboBoxKotaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxKotaItemStateChanged
        // Bisa digunakan untuk event saat memilih kota, jika perlu.
    // Misalnya, update teks atau elemen lain jika diperlukan.
    }//GEN-LAST:event_comboBoxKotaItemStateChanged

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
         System.exit(0); // Menutup aplikasi
    }//GEN-LAST:event_buttonKeluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhanaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhanaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhanaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhanaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiCekCuacaSederhanaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCekCuaca;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JComboBox<String> comboBoxKota;
    private javax.swing.JLabel labelCuaca;
    private javax.swing.JLabel labelGambarCuaca;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JLabel labelKota;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JTextField textFieldCuaca;
    // End of variables declaration//GEN-END:variables

}