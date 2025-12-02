package cl.profemariostomas.classicmodels.views.equipos;

import cl.profemariostomas.classicmodels.controllers.EquiposController;
import cl.profemariostomas.classicmodels.models.EquipoModel;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EquipoTableView extends JFrame {

    public EquipoTableView() {
        super("Lista de equipos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        buildTable();
        pack();
    }

    private void buildTable() {
        ArrayList<EquipoModel> equipos = EquiposController.select();
        String[] headers = {"ID", "Descripción", "Número de serie", "Aula asignada"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);

        if (equipos != null) {
            for (EquipoModel equipo : equipos) {
                model.addRow(new Object[]{
                    equipo.getEquipoId(),
                    equipo.getDescripcion(),
                    equipo.getNumeroSerie(),
                    equipo.getAulaAsignadaId()
                });
            }
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table));
    }
}
