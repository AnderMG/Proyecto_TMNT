package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.BLACK);
		panel.setBounds(277, 133, 373, 292);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnIniciarSesion.setBounds(25, 243, 130, 29);
		panel.add(btnIniciarSesion);
		
		JButton btnRegistrate = new JButton("Registrate");
		btnRegistrate.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnRegistrate.setBounds(224, 245, 130, 29);
		panel.add(btnRegistrate);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		passwordField.setBounds(25, 178, 329, 26);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		textField.setBounds(25, 108, 329, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario: ");
		lblNombreDeUsuario.setBounds(25, 78, 152, 34);
		panel.add(lblNombreDeUsuario);
		lblNombreDeUsuario.setForeground(SystemColor.info);
		lblNombreDeUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(25, 147, 152, 34);
		panel.add(lblPassword);
		lblPassword.setForeground(SystemColor.info);
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		JLabel lblInicioDeSesion = new JLabel("INICIO DE SESION");
		lblInicioDeSesion.setBounds(25, 13, 300, 40);
		panel.add(lblInicioDeSesion);
		lblInicioDeSesion.setForeground(SystemColor.info);
		lblInicioDeSesion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 29));
		
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro registro = new Registro();
				registro.setVisible(true);
				dispose();
				
			}
		});
		
	}
}
