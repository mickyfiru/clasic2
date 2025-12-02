package cl.profemariostomas.classicmodels.views;

import cl.profemariostomas.classicmodels.views.aulas.AulaAddView;
import cl.profemariostomas.classicmodels.views.aulas.AulaModifyView;
import cl.profemariostomas.classicmodels.views.aulas.AulaTableView;
import cl.profemariostomas.classicmodels.views.equipos.EquipoAddView;
import cl.profemariostomas.classicmodels.views.equipos.EquipoModifyView;
import cl.profemariostomas.classicmodels.views.equipos.EquipoTableView;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame {

    public MainWindow() {
        super("Gestión Universidad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildMenu();
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu mantenedoresMenu = new JMenu("Mantenedores");
        mantenedoresMenu.add(buildAulasMenu());
        mantenedoresMenu.add(buildEquiposMenu());

        menuBar.add(mantenedoresMenu);
        setJMenuBar(menuBar);
    }

    private JMenu buildAulasMenu() {
        JMenu aulasMenu = new JMenu("Aulas");

        JMenuItem add = new JMenuItem("Agregar");
        add.addActionListener(e -> new AulaAddView().setVisible(true));
        aulasMenu.add(add);

        JMenuItem modify = new JMenuItem("Modificar");
        modify.addActionListener(e -> new AulaModifyView().setVisible(true));
        aulasMenu.add(modify);

        JMenuItem view = new JMenuItem("Ver registros");
        view.addActionListener(e -> new AulaTableView().setVisible(true));
        aulasMenu.add(view);

        return aulasMenu;
    }

    private JMenu buildEquiposMenu() {
        JMenu equiposMenu = new JMenu("Equipos");

        JMenuItem add = new JMenuItem("Agregar");
        add.addActionListener(e -> new EquipoAddView().setVisible(true));
        equiposMenu.add(add);

        JMenuItem modify = new JMenuItem("Modificar");
        modify.addActionListener(e -> new EquipoModifyView().setVisible(true));
        equiposMenu.add(modify);

    }

    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu mantenedoresMenu = new JMenu("Mantenedores");
        mantenedoresMenu.add(buildAulasMenu());
        mantenedoresMenu.add(buildEquiposMenu());

        menuBar.add(mantenedoresMenu);
        setJMenuBar(menuBar);
    }

    private JMenu buildAulasMenu() {
        JMenu aulasMenu = new JMenu("Aulas");

        JMenuItem add = new JMenuItem("Agregar");
        add.addActionListener(e -> new AulaAddView().setVisible(true));
        aulasMenu.add(add);

        JMenuItem modify = new JMenuItem("Modificar");
        modify.addActionListener(e -> new AulaModifyView().setVisible(true));
        aulasMenu.add(modify);

        JMenuItem view = new JMenuItem("Ver registros");
        view.addActionListener(e -> new AulaTableView().setVisible(true));
        aulasMenu.add(view);

        return aulasMenu;
    }

    private JMenu buildEquiposMenu() {
        JMenu equiposMenu = new JMenu("Equipos");

        JMenuItem add = new JMenuItem("Agregar");
        add.addActionListener(e -> new EquipoAddView().setVisible(true));
        equiposMenu.add(add);

        JMenuItem modify = new JMenuItem("Modificar");
        modify.addActionListener(e -> new EquipoModifyView().setVisible(true));
        equiposMenu.add(modify);

        JMenuItem view = new JMenuItem("Ver registros");
        view.addActionListener(e -> new EquipoTableView().setVisible(true));
        equiposMenu.add(view);

        return equiposMenu;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
