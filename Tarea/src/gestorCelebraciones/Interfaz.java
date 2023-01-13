package gestorCelebraciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Interfaz {
	LeerFichero inv;
	Evento evento;
	DefaultListModel<Comensal> model = new DefaultListModel<Comensal>();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1015, 837);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, "name_23859060990900");
		
		//Mesas
		//Panel contenedor
		JPanel panel_mesas = new JPanel();
		panel_mesas.setBounds(254, 367, 628, 148);
		layeredPane.add(panel_mesas);
		panel_mesas.setLayout(new CardLayout(0, 0));
		
		//Lo hacemos scrolleable
		JScrollPane scroll_mesas = new JScrollPane();
		panel_mesas.add(scroll_mesas, "name_1537297494920100");
		
		//Creamos y añadimos la Jlist
		JList Mesas = new JList();
		scroll_mesas.setViewportView(Mesas);
		
		//Invitados
		//Panel contenedor
		JPanel panel_invitados = new JPanel();
		panel_invitados.setBounds(21, 136, 958, 189);
		layeredPane.add(panel_invitados);
		panel_invitados.setLayout(new CardLayout(0, 0));
		
		//Lo hacemos scrolleable
		JScrollPane scroll_invitados = new JScrollPane();
		panel_invitados.add(scroll_invitados, "name_1537261665385400");
		
		//Creamos lista
		//Creamos y añadimos la JList
		JList<Comensal> Invitados = new JList<Comensal>(model);
		scroll_invitados.setViewportView(Invitados);
		
		
		
		//Comensales por mesa
		//Panel contenedor
		JPanel panel_comensalesMesa = new JPanel();
		panel_comensalesMesa.setBounds(21, 563, 958, 113);
		layeredPane.add(panel_comensalesMesa);
		panel_comensalesMesa.setLayout(new CardLayout(0, 0));
		
		//Lo hacemos scrolleable
		JScrollPane scrollPane_comensalesMesa = new JScrollPane();
		panel_comensalesMesa.add(scrollPane_comensalesMesa, "name_1537393592468800");
		
		//Creamos y añadimos la JList
		JList ComensalesMesa = new JList();
		scrollPane_comensalesMesa.setViewportView(ComensalesMesa);
		
		//Selection Listeners
		//Mesas
		Mesas.addListSelectionListener(new ListSelectionListener(){
		    public void valueChanged(ListSelectionEvent e) {
		        if (e.getValueIsAdjusting()) {
		            return;
		        }
		        Mesa selectedMesa = (Mesa) Mesas.getSelectedValue();
		        if(selectedMesa == null) {
		            return;
		        }
		        ArrayList<Comensal> comensales = new ArrayList<Comensal>(selectedMesa.getComensalesMesa());
		        DefaultListModel<Comensal> modeloComensales = new DefaultListModel<Comensal>();
		        for(Comensal c: comensales) {
		            modeloComensales.addElement(c);
		        }
		        ComensalesMesa.setModel(modeloComensales);
		    }
		});
		
		//Botones
		//Abre una nueva pestaña que permite editar las propiedades un invitado TODO
		JButton editar_invitados = new JButton(" Editar Invitado");
		editar_invitados.setIcon(new ImageIcon("C:\\Users\\oiram\\git\\ProyectoPOO\\Tarea\\icons8-editar-32.png"));
		editar_invitados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editar_invitados.setBounds(727, 33, 77, 76);
		layeredPane.add(editar_invitados);
		
		//Elimina un invitado de la lista TODO
		JButton borrar_invitados = new JButton("Borrar");
		borrar_invitados.setBounds(814, 33, 77, 76);
		layeredPane.add(borrar_invitados);
			//Funcionalidad
		borrar_invitados.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the selected index in the JList
		        int selectedIndex = Invitados.getSelectedIndex();
		        // If an item is selected
		        if (Invitados.getModel().getSize() > 0 && selectedIndex != -1) {
		            // Get the ListModel of the JList
		            DefaultListModel model = (DefaultListModel) Invitados.getModel();
		            // Remove the item at the selected index
		            model.remove(selectedIndex);
		            inv.getComensales().remove(selectedIndex);
		           
		        }  
		    }
		});
		
		//Abre nueva pestaña que permite añadir nuevos invitados y los añade al csv TODO
		JButton add_invitados = new JButton("Añadir");
		add_invitados.setBounds(901, 33, 77, 76);
		layeredPane.add(add_invitados);
		
		//Abre nueva pestaña que permite cambiar el nombre de las mesas TODO
		JButton editar_mesa = new JButton("Editar Mesa");
		editar_mesa.setBounds(902, 408, 77, 76);
		layeredPane.add(editar_mesa);
		
		
		//Asigna los comensales a las mesas
		JButton asignar = new JButton("Asignar");
		asignar.setBounds(110, 435, 127, 23);
		layeredPane.add(asignar);

		asignar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		            evento=new Evento(inv.getComensales());
		            ArrayList<Mesa> asignados=evento.Asigna();
		            DefaultListModel<Mesa> model = new DefaultListModel<Mesa>();
		            for(Mesa m:asignados) {
		                model.addElement(m);
		            Mesas.setModel(model);
		        }
		    }
		});

		
		//Carga un fichero csv
		JButton cargar_fichero = new JButton("Cargar");
		cargar_fichero.setBounds(21, 33, 77, 76);
		layeredPane.add(cargar_fichero);
			//Funcionalidad
		cargar_fichero.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if(inv==null) {
		            inv=new LeerFichero();
		            try {
		                inv.formalizar();
		            } catch (IOException e1) {
		                // TODO Auto-generated catch block
		                e1.printStackTrace();
		            }
		            ArrayList<Comensal> invitados=inv.getComensales();
		            DefaultListModel<Comensal> model = new DefaultListModel<Comensal>();
		            for(Comensal c:invitados) {
		                model.addElement(c);
		            }
		            Invitados.setModel(model);
		        }
		    }
		});
		
		//Genera un fichero .pdf TODO
		JButton generar_pdf = new JButton("Generar PDF");
		generar_pdf.setBounds(901, 714, 77, 76);
		layeredPane.add(generar_pdf);
		
		//Contadores TODO
		
		JPanel contador_comensales = new JPanel();
		contador_comensales.setBounds(24, 712, 174, 23);
		layeredPane.add(contador_comensales);
		
		JPanel contador_sillas = new JPanel();
		contador_sillas.setBounds(220, 712, 174, 23);
		layeredPane.add(contador_sillas);
		
		//Separadores (Esteticos)
		
		JSeparator separador_superior = new JSeparator();
		separador_superior.setBounds(10, 543, 973, 220);
		layeredPane.add(separador_superior);
		
		JSeparator separador_inferior = new JSeparator();
		separador_inferior.setBounds(21, 336, 968, 189);
		layeredPane.add(separador_inferior);
		
		
		
	}
	
}
