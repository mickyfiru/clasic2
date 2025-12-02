package cl.profemariostomas.classicmodels.views.equipos;

import cl.profemariostomas.classicmodels.ControllerResponse;
import cl.profemariostomas.classicmodels.controllers.EquiposController;
import cl.profemariostomas.classicmodels.models.EquipoModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EquipoAddView extends JFrame {

    private final JTextField txtId = new JTextField();
    private final JTextField txtDescripcion = new JTextField();
    private final JTextField txtNumeroSerie = new JTextField();
    private final JTextField txtAulaAsignada = new JTextField();

    public EquipoAddView() {
        super("Agregar equipo");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        buildLayout();
        pack();
    }

    private void buildLayout() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
        panel.add(new JLabel("ID Equipo"));
        panel.add(txtId);
        panel.add(new JLabel("Descripción"));
        panel.add(txtDescripcion);
        panel.add(new JLabel("Número de serie"));
        panel.add(txtNumeroSerie);
        panel.add(new JLabel("Aula asignada"));
        panel.add(txtAulaAsignada);

        JButton btnGuardar = new JButton("Insertar");
        btnGuardar.addActionListener(e -> save());
        panel.add(new JLabel());
        panel.add(btnGuardar);

        add(panel);
    }

    private void save() {
        if (txtId.getText().isBlank() || txtDescripcion.getText().isBlank() || txtNumeroSerie.getText().isBlank() || txtAulaAsignada.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(txtId.getText());
            int aulaAsignadaId = Integer.parseInt(txtAulaAsignada.getText());
            ControllerResponse response = EquiposController.insert(
                new EquipoModel(id, txtDescripcion.getText(), txtNumeroSerie.getText(), aulaAsignadaId)
            );

            if (response.getStatus()) {
                JOptionPane.showMessageDialog(this, response.getMessage());
            } else {
                JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID y el aula asignada deben ser numéricos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
