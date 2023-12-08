package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.FondoEnVentana;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import utils.DaoUsuario;
import clases.Usuario;
public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfNombreCompleto;
	private JTextField tfEdad;
	private JPasswordField passwordField;
	DaoUsuario dao = new DaoUsuario();

	public Registro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setLocationRelativeTo( null );
		contentPane = FondoEnVentana.panelConFondo("SI_NDS_InazumaEleven.jpg");
//		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(218, 63, 373, 373);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setBounds(25, 25, 300, 40);
		panel.add(lblRegistro);
		lblRegistro.setForeground(SystemColor.info);
		lblRegistro.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 29));
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario: ");
		lblNombreDeUsuario.setBounds(25, 88, 152, 34);
		panel.add(lblNombreDeUsuario);
		lblNombreDeUsuario.setForeground(SystemColor.info);
		lblNombreDeUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		tfNombre.setBounds(25, 116, 329, 26);
		panel.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña: ");
		lblPassword.setBounds(25, 144, 152, 34);
		panel.add(lblPassword);
		lblPassword.setForeground(SystemColor.info);
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		passwordField.setBounds(25, 173, 329, 29);
		panel.add(passwordField);
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo: ");
		lblNombreCompleto.setBounds(25, 202, 152, 34);
		panel.add(lblNombreCompleto);
		lblNombreCompleto.setForeground(SystemColor.info);
		lblNombreCompleto.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		tfNombreCompleto = new JTextField();
		tfNombreCompleto.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		tfNombreCompleto.setBounds(25, 231, 329, 26);
		panel.add(tfNombreCompleto);
		tfNombreCompleto.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(25, 258, 152, 34);
		panel.add(lblEdad);
		lblEdad.setForeground(SystemColor.info);
		lblEdad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		tfEdad = new JTextField();
		tfEdad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		tfEdad.setBounds(25, 285, 329, 26);
		panel.add(tfEdad);
		tfEdad.setColumns(10);
		
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnRegistrar.setBounds(119, 324, 130, 29);
		panel.add(btnRegistrar);
		
		btnRegistrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nombre = tfNombre.getText();
					String contraseña =  passwordField.getText();
					String nombreCompleto = tfNombreCompleto.getText();
					int edad = Integer.parseInt(tfEdad.getText());
					if (nombre.isEmpty() || contraseña.isEmpty() || nombreCompleto.isEmpty() || tfEdad.getText().isEmpty()){
						JOptionPane jOptionPane = new JOptionPane();
						JOptionPane.showMessageDialog(jOptionPane, "Tienes que rellenar todos los huecos.");
					}
					else{	
						Usuario usuario = new Usuario();
						usuario.setNombreUsuario(tfNombre.getText());
						usuario.setPassword(passwordField.getText());
						usuario.setNombreReal(tfNombreCompleto.getText());
						usuario.setEdad(Integer.parseInt(tfEdad.getText()));
						utils.EscribirFichero.agregarUsuario(tfNombre.getText(), passwordField.getText(), tfNombreCompleto.getText(), edad);
						if(dao.insertarUsuario(usuario)) {
							System.out.println("Se ha añadido correctamente a la base de datos");
						}
						else {
							System.out.println("No se ha añadido a la base de datos");
						}
						JOptionPane jOptionPane = new JOptionPane();
						JOptionPane.showMessageDialog(jOptionPane, "Resgistro completado");
						Login login = new Login();
						login.setVisible(true);
						dispose();
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				};
				
			}
		});
		
		
	}

}
