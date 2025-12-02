package cl.profemariostomas.classicmodels.views.aulas;

import cl.profemariostomas.classicmodels.controllers.AulasController;
import cl.profemariostomas.classicmodels.models.AulaModel;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AulaTableView extends JFrame {

    public AulaTableView() {
        super("Lista de aulas");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        buildTable();
        pack();
    }

    private void buildTable() {
        ArrayList<AulaModel> aulas = AulasController.select();
        String[] headers = {"ID", "Nombre", "Capacidad"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);

        if (aulas != null) {
            for (AulaModel aula : aulas) {
                model.addRow(new Object[]{
                    aula.getAulaId(),
                    aula.getNombre(),
                    aula.getCapacidad()
                });
            }
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table));
    }
}
