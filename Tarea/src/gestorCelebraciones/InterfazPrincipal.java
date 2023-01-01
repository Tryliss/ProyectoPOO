package gestorCelebraciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;

public class InterfazPrincipal extends JFrame {

	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal frame = new InterfazPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
		);
		
		JButton Add = new JButton("Añadir");
		
		JButton Remove = new JButton("Eliminar");
		
		JButton edit = new JButton("Editar");
		
		JButton editTable = new JButton("Editar");
		
		JButton save = new JButton("Guardar");
		
		JButton asign = new JButton("Asignar");
		
		JList mesas = new JList();
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(256)
					.addComponent(mesas, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(900)
					.addComponent(edit, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(900)
					.addComponent(editTable, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(112)
					.addComponent(asign, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(900)
					.addComponent(save, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(725)
					.addComponent(Add, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(810)
					.addComponent(Remove, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(378)
					.addComponent(mesas, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(49)
					.addComponent(edit, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(382)
					.addComponent(editTable, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(437)
					.addComponent(asign, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(457)
					.addComponent(save, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(48)
					.addComponent(Add, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_layeredPane.createSequentialGroup()
					.addGap(49)
					.addComponent(Remove, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
		);
		layeredPane.setLayout(gl_layeredPane);
		contentPane.setLayout(gl_contentPane);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
