package gestorCelebraciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
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
		
		JPanel panel = new JPanel();
		panel.setBounds(254, 367, 628, 148);
		layeredPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JList<Mesa> Mesas = new JList();
		panel.add(Mesas, "name_27373302580800");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 136, 958, 189);
		layeredPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JList Invitados = new JList();
		panel_1.add(Invitados, "name_27378543164600");
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(21, 563, 958, 113);
		layeredPane.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JList<?> ComensalesPorMesa = new JList();
		panel_2.add(ComensalesPorMesa, "name_27381419497300");
		
		JButton btnNewButton = new JButton(" Editar Invitado");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\oiram\\git\\ProyectoPOO\\Tarea\\icons8-editar-32.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(727, 33, 77, 76);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.setBounds(814, 33, 77, 76);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Guardar");
		btnNewButton_1_1.setBounds(901, 33, 77, 76);
		layeredPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Editar Mesa");
		btnNewButton_1_2.setBounds(902, 408, 77, 76);
		layeredPane.add(btnNewButton_1_2);
		
		JButton Asignar = new JButton("Asignar");
		Asignar.setBounds(110, 435, 127, 23);
		
		
		
		layeredPane.add(Asignar);
		Asignar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       Evento evento=Evento.getInstance(inv.getComensales());
		        
					ArrayList<Mesa> asignados=evento.Asigna();
					ListModel<Mesa> modeloAsignados = new AbstractListModel<Mesa>() {
					    /**
						 * 
						 */
						private static final long serialVersionUID = 1L;
						public int getSize() { return asignados.size(); }
					    public Mesa getElementAt(int i) { return asignados.get(i); }
					};
					Mesas.removeAll();
					Mesas.setModel(modeloAsignados);
				
		    }
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(24, 712, 174, 23);
		layeredPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(220, 712, 174, 23);
		layeredPane.add(panel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 11, 977, 516);
		layeredPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 543, 973, 220);
		layeredPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(21, 336, 968, 189);
		layeredPane.add(separator_2);
		
		JButton btnNewButton_1_3_1 = new JButton("Generar PDF");
		btnNewButton_1_3_1.setBounds(902, 687, 77, 76);
		layeredPane.add(btnNewButton_1_3_1);
		
		JList list_3 = new JList();
		list_3.setBounds(73, 378, 1, 1);
		layeredPane.add(list_3);
		
		JButton CargarFichero = new JButton("Cargar");
		CargarFichero.setBounds(21, 33, 77, 76);
		layeredPane.add(CargarFichero);
		CargarFichero.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        inv=new LeerFichero();
		        try {
					inv.formalizar();
					ListModel<Comensal> modeloInvitados = new AbstractListModel<Comensal>() {
					    public int getSize() { return inv.getComensales().size(); }
					    public Comensal getElementAt(int i) { return inv.getComensales().get(i); }
					};
					Invitados.setModel(modeloInvitados);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }
		});
		Mesas.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	Object selected = (Mesa)Mesas.getSelectedValue(); 
		    	ComensalesPorMesa.setModel( new AbstractListModel() {
		    	    /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					public int getSize() { return ((Mesa)selected).comensalesMesa.size();}
		    	    public Object getElementAt(int i) { return ((Mesa)selected).comensalesMesa.get(i); }
		    	});
		    	
		    }

			
		});
		
	}
	
}
