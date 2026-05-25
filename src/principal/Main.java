package principal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPlanetas ventana = new VentanaPlanetas();
            ventana.setVisible(true);
        });
    }
}