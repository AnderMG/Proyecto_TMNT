package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;


	public Registro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setLocationRelativeTo( null );
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
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
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		textField.setBounds(25, 116, 329, 26);
		panel.add(textField);
		textField.setColumns(10);
		
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
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		textField_2.setBounds(25, 231, 329, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(25, 258, 152, 34);
		panel.add(lblEdad);
		lblEdad.setForeground(SystemColor.info);
		lblEdad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		textField_3.setBounds(25, 285, 329, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnRegistrar.setBounds(119, 324, 130, 29);
		panel.add(btnRegistrar);
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nombre = textField.getText();
					String contraseña =  passwordField.getText();
					String nombreCompleto = textField_2.getText();
					if (nombre.isEmpty() || contraseña.isEmpty() || nombreCompleto.isEmpty() || textField_3.getText().isEmpty()){
						JOptionPane jOptionPane = new JOptionPane();
						JOptionPane.showMessageDialog(jOptionPane, "Tienes que rellenar todos los huecos.");
					}
					else{
						int edad = Integer.parseInt(textField_3.getText());
						utils.EscribirFichero.agregarUsuario(textField.getText(), passwordField.getText(), textField_2.getText(), edad);
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
