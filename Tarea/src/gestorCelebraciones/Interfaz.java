package gestorCelebraciones;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Interfaz {
	LeerFichero inv;
	Evento evento;
	ArrayList<Mesa> asignados;
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oiram\\git\\ProyectoPOO\\Tarea\\Img\\celebracion.png"));
		frame.getContentPane().setBackground(new Color(241, 237, 222));
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
		JList<Mesa> Mesas = new JList();
		Mesas.setFont(new Font("Bookman Old Style", Font.ITALIC, 14));
		Mesas.setBackground(new Color(255, 255, 255));
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
		Invitados.setFont(new Font("Bookman Old Style", Font.ITALIC, 14));
		Invitados.setBackground(new Color(255, 255, 255));
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
		ComensalesMesa.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		ComensalesMesa.setBackground(new Color(255, 255, 255));
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
		
		
		
		//Elimina un invitado de la lista 
		JButton borrar_invitados = new JButton("");
		borrar_invitados.setIcon(new ImageIcon("Img/eliminar.png"));
		borrar_invitados.setBackground(new Color(211, 150, 88));
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
		            Invitados.updateUI();
		            inv.getComensales().remove(selectedIndex);
		           
		        }  
		    }
		});
		
		
		//Abre nueva pestaña que permite añadir nuevos invitados  
		JButton add_invitados = new JButton("");
		add_invitados.setIcon(new ImageIcon("Img/agregar-usuario.png"));
		add_invitados.setBackground(new Color(211, 150, 88));
		add_invitados.setBounds(901, 33, 77, 76);
		layeredPane.add(add_invitados);
		
		add_invitados.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    if(inv!=null) {
		        // Crear una nueva ventana para editar mesas
		        JFrame add_invitados = new JFrame("Editar Mesas");
		        add_invitados.setSize(300, 600);
		        add_invitados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        add_invitados.setLayout(new FlowLayout());
		        
		        // Crear un campo de texto para el número de mesa

		        JLabel nombrel= new JLabel("Introduce el nombre\r\n");
		        add_invitados.add(nombrel);
		        JTextField nombre = new JTextField();
		        nombre.setColumns(10);
		        add_invitados.add(nombre);
		        
		        JLabel apellidosl = new JLabel("Introduce los apellidos\r\n");
		        add_invitados.add(apellidosl);
		        JTextField apellidos = new JTextField();
		        apellidos.setColumns(10);
		        add_invitados.add(apellidos);
		        
		        
		        JLabel edadl = new JLabel("Introduce la edad\r\n");
		        add_invitados.add(edadl);
		        JTextField edad = new JTextField();
		        edad.setColumns(10);

		        add_invitados.add(edad);
		       
		        
		        JLabel alergiasl = new JLabel("Introduce las alergias\r\n");
		        add_invitados.add(alergiasl);
		        JTextField alergias = new JTextField();
		        alergias.setColumns(10);
		        add_invitados.add(alergias);
		        

		       JRadioButton Novio =new JRadioButton("Invitante 1");
		       Novio.setActionCommand("Novio");
		       JRadioButton Novia =new JRadioButton("Invitante 2");
		       Novia.setActionCommand("Novia");
		       ButtonGroup genero = new ButtonGroup();
		       genero.add(Novio);
		       genero.add(Novia);
		       add_invitados.add(Novio);
		       add_invitados.add(Novia);
		       
		       
		       JScrollPane scrollpane_acompannantes = new JScrollPane();
		       JLabel acompannantesl = new JLabel("Selecciona los acompañantes\r\n");
		       add_invitados.add(acompannantesl);
		       JList  acompannantes = new JList();
		       scrollpane_acompannantes.setViewportView(acompannantes);
		       add_invitados.add(scrollpane_acompannantes);
		       ArrayList<Integer> acompannantesList=  new ArrayList<Integer>();
		       for(int aux:acompannantes.getSelectedIndices()) {
		    	   acompannantesList.add(aux);
		       }
		       
		       JScrollPane scrollpane_vetados = new JScrollPane();
		       JLabel vetadosl = new JLabel("Selecciona los vetados\r\n");
		       add_invitados.add(vetadosl);
		       JList  vetados = new JList();
		       scrollpane_vetados.setViewportView(vetados);
		       add_invitados.add(scrollpane_vetados);
		       ArrayList<Integer> vetadosList=  new ArrayList<Integer>();
		       for(int aux:vetados.getSelectedIndices()) {
		    	   vetadosList.add(aux);
		       }
		       
		       ArrayList<Comensal> invitados=inv.getComensales();
		       DefaultListModel<Comensal> model = new DefaultListModel<Comensal>();
	            for(Comensal c:invitados) {
	                model.addElement(c);
	            }
	            acompannantes.setModel(model);
	            vetados.setModel(model);
	            
		        
		        // Crear un botón para guardar los cambios
	            JLabel botonGuardar = new JLabel("Pulsa para guardar\r\n");
	            add_invitados.add(botonGuardar);
		        JButton btnGuardar = new JButton("Guardar");
		       
		        add_invitados.add(btnGuardar);
		        
		        // Mostrar la ventana de edición
		        add_invitados.setVisible(true);
		        
		        btnGuardar.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        try {
					        Comensal aux=new Comensal(nombre.getText(),apellidos.getText(),Integer.parseInt(edad.getText()),alergias.getText(),genero.getSelection().getActionCommand(),acompannantesList,vetadosList);
				    
					        inv.getComensales().add(aux);
					        model.addElement(aux);
					        Invitados.setModel(model);
					        Invitados.updateUI();
				        }catch(NullPointerException npe){
				        	JOptionPane.showMessageDialog(frame, "No se ha rellenado todos los campos", "Error",JOptionPane.ERROR_MESSAGE);
				        }catch(NumberFormatException nfe) {
				        	JOptionPane.showMessageDialog(frame, "Edad no es un numero", "Error",JOptionPane.ERROR_MESSAGE);
				        
				        }
				    }		    
				    });
		    	}else{
		    		JOptionPane.showMessageDialog(frame, "No se pueden añadir comensales manualmente hasta importar la lista", "Error",JOptionPane.ERROR_MESSAGE);
		    		
		    	}
		    }
		});
		
		
		//Abre nueva pestaña que permite cambiar el nombre de las mesas 
		JButton editar_mesa = new JButton("");
		editar_mesa.setIcon(new ImageIcon("Img/lapiz.png"));
		editar_mesa.setBackground(new Color(211, 150, 88));
		editar_mesa.setBounds(902, 408, 77, 76);
		layeredPane.add(editar_mesa);
		editar_mesa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(Mesas.getSelectedValue()!=null) {
		    		
		        // Crear una nueva ventana para editar mesas
		        JFrame editarMesasFrame = new JFrame("Editar Mesas");
		        editarMesasFrame.setSize(300, 75);
		        editarMesasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        editarMesasFrame.getContentPane().setLayout(new FlowLayout());
		        
		        // Crear un campo de texto para el número de mesa
		        JTextField txtNumMesa = new JTextField();
		        txtNumMesa.setColumns(10);
		        editarMesasFrame.getContentPane().add(txtNumMesa);
		        
		        // Crear un botón para guardar los cambios
		        JButton btnGuardar = new JButton("Guardar");
		        btnGuardar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	((Mesa)Mesas.getSelectedValue()).setLlaveMesa(txtNumMesa.getText());
		            	Mesas.updateUI();
		                editarMesasFrame.dispose();
		            }
		        });
		        editarMesasFrame.getContentPane().add(btnGuardar);
		        
		        // Mostrar la ventana de edición
		        editarMesasFrame.setVisible(true);
		    }
		    }
		});
		



		
		
		//Asigna los comensales a las mesas
		JButton asignar = new JButton("Asignar");
		asignar.setForeground(new Color(0, 0, 0));
		asignar.setFont(new Font("Edwardian Script ITC", Font.BOLD, 30));
		asignar.setBackground(new Color(211, 150, 88));
		asignar.setBounds(76, 417, 127, 51);
		layeredPane.add(asignar);

		asignar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
		            evento=new Evento(inv.getComensales());
		            asignados=evento.Asigna();
		            DefaultListModel<Mesa> model = new DefaultListModel<Mesa>();
		            for(Mesa m:asignados) {
		                model.addElement(m);
		            Mesas.setModel(model);
		        }
		    
		    }catch(NullPointerException npe){
	        	JOptionPane.showMessageDialog(frame, "No hay invitados", "Error",JOptionPane.ERROR_MESSAGE);}
		    }
		});

		
		//Carga un fichero csv
		JButton cargar_fichero = new JButton("");
		cargar_fichero.setIcon(new ImageIcon("Img/carga-de-archivos.png"));
		cargar_fichero.setForeground(new Color(0, 0, 0));
		cargar_fichero.setBackground(new Color(211, 150, 88));
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
		
		//Genera un fichero .pdf (Prettyfy)
		JButton generar_pdf = new JButton("");
		generar_pdf.setIcon(new ImageIcon("img/pdf.png"));
		generar_pdf.setBackground(new Color(211, 150, 88));
		generar_pdf.setBounds(901, 714, 77, 76);
		layeredPane.add(generar_pdf);
		generar_pdf.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
					PDFGenerator.generatePDF(asignados);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} catch(NullPointerException npe){
		        	JOptionPane.showMessageDialog(frame, "No se ha asignado", "Error",JOptionPane.ERROR_MESSAGE);		    
				}
		    	}
		    });
		
		//Separadores (Esteticos)
		
		JSeparator separador_superior = new JSeparator();
		separador_superior.setForeground(new Color(255, 255, 255));
		separador_superior.setBounds(21, 526, 958, 246);
		layeredPane.add(separador_superior);
		
		JSeparator separador_inferior = new JSeparator();
		separador_inferior.setForeground(new Color(236, 236, 232));
		separador_inferior.setBounds(21, 331, 958, 194);
		layeredPane.add(separador_inferior);
		
		JTextPane contador_comensal = new JTextPane();
		contador_comensal.setFont(new Font("Bookman Old Style", Font.ITALIC, 11));
		contador_comensal.setBackground(new Color(255, 255, 255));
		contador_comensal.setBounds(21, 715, 177, 20);
		layeredPane.add(contador_comensal);
		Mesas.addListSelectionListener(new ListSelectionListener(){
		    public void valueChanged(ListSelectionEvent e) {
		   Mesa index =(Mesa) Mesas.getSelectedValue();
		   contador_comensal.setText(Integer.toString(index.comensalesMesa.size()));
		    
		    }
		});
		
		JTextPane contador_mesas = new JTextPane();
		contador_mesas.setFont(new Font("Bookman Old Style", Font.ITALIC, 11));
		contador_mesas.setBackground(new Color(255, 255, 255));
		contador_mesas.setBounds(220, 715, 174, 20);
		layeredPane.add(contador_mesas);
		
		JLabel lblNewLabel = new JLabel("Lista de comensales en la mesa\r\n");
		lblNewLabel.setBackground(new Color(241, 237, 222));
		lblNewLabel.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 25));
		lblNewLabel.setForeground(new Color(182, 135, 104));
		lblNewLabel.setBounds(21, 690, 177, 20);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo Mesa");
		lblNewLabel_1.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(new Color(182, 135, 104));
		lblNewLabel_1.setBounds(220, 690, 177, 20);
		layeredPane.add(lblNewLabel_1);
		
		JLabel Comensales_por_mesa_label = new JLabel("Lista de comensales por mesa");
		Comensales_por_mesa_label.setHorizontalAlignment(SwingConstants.CENTER);
		Comensales_por_mesa_label.setForeground(new Color(182, 135, 104));
		Comensales_por_mesa_label.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 25));
		Comensales_por_mesa_label.setBounds(21, 536, 958, 20);
		layeredPane.add(Comensales_por_mesa_label);
		
		JLabel Comensales_por_mesa_label_1 = new JLabel("Lista de mesas");
		Comensales_por_mesa_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		Comensales_por_mesa_label_1.setForeground(new Color(182, 135, 104));
		Comensales_por_mesa_label_1.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 25));
		Comensales_por_mesa_label_1.setBounds(254, 336, 628, 20);
		layeredPane.add(Comensales_por_mesa_label_1);
		
		JLabel Comensales_por_mesa_label_2 = new JLabel("Lista de comensales");
		Comensales_por_mesa_label_2.setHorizontalAlignment(SwingConstants.CENTER);
		Comensales_por_mesa_label_2.setForeground(new Color(182, 135, 104));
		Comensales_por_mesa_label_2.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 25));
		Comensales_por_mesa_label_2.setBounds(21, 105, 958, 20);
		layeredPane.add(Comensales_por_mesa_label_2);
		Mesas.addListSelectionListener(new ListSelectionListener(){
		    public void valueChanged(ListSelectionEvent e) {
		   Mesa index =(Mesa) Mesas.getSelectedValue();
		   contador_mesas.setText(index.getClass().getSimpleName());
		    
		    }
		});
		
		
	}
}
