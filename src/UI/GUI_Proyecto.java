package UI;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import datos.Emprendedor;
import datos.Persona;
import datos.Producto;
import datos.Usuario;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import javax.swing.DropMode;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFormattedTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import logica.logica;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;

public class GUI_Proyecto {

	private JFrame frmElCampo;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField;
	private JTextField textFieldUbicacion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JTextField textFieldOtro;
	private JTextField textFieldNombre;
	private JTextField textFieldPeso;
	private JTextField textFieldPrecio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Proyecto window = new GUI_Proyecto();
					window.frmElCampo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Proyecto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ArrayList<Usuario> usuarioRegistrado = new ArrayList<>();
		ArrayList<Persona> personasRegistradas = new ArrayList<>();
		ArrayList<Emprendedor> emprendedoresRegistrados = new ArrayList<>();
		
		try {
			
//			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Informacion.obj"));
//			
//			logica.guardarInfoDefault(escribir);
//			
//			escribir.close();
			
			ObjectInputStream leer = new ObjectInputStream(new FileInputStream("Informacion.obj"));

			Object aux = leer.readObject();
			
			while(aux!=null) {
				if (aux instanceof Usuario) {
					usuarioRegistrado.add((Usuario)aux);
					personasRegistradas.add((Persona)aux);
				}else if(aux instanceof Emprendedor){
					emprendedoresRegistrados.add((Emprendedor)aux);
					personasRegistradas.add((Persona)aux);
				}
				aux=leer.readObject();
				
			}
			leer.close();
			
		}catch(Exception f) {
		}
		
		for (Persona personal : personasRegistradas) {
			System.out.print(personal.getUsuario()+"//");
		}
				
		frmElCampo = new JFrame();
		frmElCampo.setBackground(Color.WHITE);
		frmElCampo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		frmElCampo.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_Proyecto.class.getResource("/Imagenes/Campo_logo_.png")));
		frmElCampo.setTitle("EL CAMPO\r\n");
		frmElCampo.setBounds(500, 50, 500, 700);
		frmElCampo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElCampo.getContentPane().setLayout(null);
		
		JPanel inicioSesion = new JPanel();
		inicioSesion.setBackground(Color.WHITE);
		inicioSesion.setBounds(0, 0, 486, 663);
		frmElCampo.getContentPane().add(inicioSesion);
		
		JLabel imagenLogo = new JLabel();
		imagenLogo.setBackground(Color.WHITE);
		imagenLogo.setBounds(25, 3, 434, 282);
		ImageIcon imagen = new ImageIcon(PrincipalUsuario.class.getResource("/Imagenes/Campo_logo_.png"));
		Icon logo = new ImageIcon(imagen.getImage().getScaledInstance(imagenLogo.getWidth(), imagenLogo.getHeight(), Image.SCALE_DEFAULT));
		inicioSesion.setLayout(null);
		imagenLogo.setIcon(logo);
		inicioSesion.add(imagenLogo);
		
		txtUsuario = new JTextField("Usuario",20);
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setBorder(new LineBorder(new Color(153, 153, 153)));
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsuario.getText().equals("Usuario")) {
					txtUsuario.setText(null);
					txtUsuario.setForeground(new Color(SystemColor.DESKTOP));
				}
				txtUsuario.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Usuario", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				txtUsuario.setBorder(new LineBorder(new Color(153, 153, 153)));
				if (txtUsuario.getText().length()==0) {
					txtUsuario.setText("Usuario");
					txtUsuario.setForeground(new Color(153, 153, 153));
				}
			}
		});
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 25));
		txtUsuario.setSelectedTextColor(SystemColor.window);
		txtUsuario.setSelectionColor(SystemColor.textHighlight);
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBounds(78, 324, 330, 48);
		inicioSesion.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField("Contraseña", 15);
		passwordField.setBounds(78, 446, 335, 48);
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 25));
		passwordField.setBorder(new LineBorder(new Color(153, 153, 153)));
		passwordField.setForeground(new Color(153, 153, 153));
		passwordField.setEchoChar((char)0);
		
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setForeground(new Color(SystemColor.DESKTOP));
				String password = "";
				for(char contra : passwordField.getPassword()) {
					password += contra;
				}
				if (password.equals("Contraseña")) {
					passwordField.setText(null);
				}
				passwordField.setEchoChar('*');
				passwordField.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Contraseña", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordField.setBorder(new LineBorder(new Color(153, 153, 153)));
				passwordField.setEchoChar((char)0);
				if (passwordField.getPassword().length==0) {
					passwordField.setForeground(new Color(153, 153, 153));
					passwordField.setText("Contraseña");
				}else {
					passwordField.setEchoChar('*');
				}
			}
		});
		passwordField.setSelectedTextColor(SystemColor.window);
		passwordField.setSelectionColor(SystemColor.textHighlight);
		passwordField.setBackground(Color.WHITE);
		inicioSesion.add(passwordField);
		
		JLabel labelRegistrarse = new JLabel("\u00BFNo tienes cuenta a\u00FAn? ");
		labelRegistrarse.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelRegistrarse.setBounds(78, 504, 173, 13);
		inicioSesion.add(labelRegistrarse);
		
		JPanel registro = new JPanel();
		registro.setBackground(SystemColor.window);
		registro.setBounds(0, 0, 486, 653);
		frmElCampo.getContentPane().add(registro);
		
		JButton botonRegistro = new JButton("Registrarse ahora\r\n");
		botonRegistro.setForeground(SystemColor.textHighlight);
		botonRegistro.setBorder(null);
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicioSesion.setVisible(false);
				registro.setVisible(true);
			}
		});
		botonRegistro.setBackground(Color.WHITE);
		botonRegistro.setFont(new Font("SansSerif", Font.PLAIN, 15));
		botonRegistro.setBounds(235, 500, 126, 21);
		inicioSesion.add(botonRegistro);
		
		JButton btnValidar = new JButton("Continuar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validez = logica.inicioSesion(txtUsuario.getText(), passwordField.getPassword(), personasRegistradas);
				if (validez) {
					if(logica.buscarEmprendedor(txtUsuario.getText(), emprendedoresRegistrados)== null){
						PrincipalUsuario.activar(txtUsuario.getText(), usuarioRegistrado, emprendedoresRegistrados);
					}else {
						principalEmprendedor.activarEmprendedor(txtUsuario.getText(), emprendedoresRegistrados, usuarioRegistrado);
					}
					frmElCampo.dispose();
				}else {
					JOptionPane.showMessageDialog(frmElCampo,"Verifique los datos ingresados e intentelo de nuevo", "Fallo inicio sesion", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnValidar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnValidar.setBounds(315, 594, 141, 38);
		inicioSesion.add(btnValidar);
		
		JLabel lblregistro = new JLabel("Rellene todos los espacios");
		lblregistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblregistro.setFont(new Font("SansSerif", Font.PLAIN, 27));
		lblregistro.setBounds(66, 10, 340, 40);
		registro.add(lblregistro);

		JLabel espacios = new JLabel("Espacios(min. 4- max. 15)");
		espacios.setFont(new Font("SansSerif", Font.PLAIN, 15));
		espacios.setBounds(66, 98, 181, 26);
		registro.add(espacios);
		
		textField = new JTextField("Usuario", 15);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField.getText().length() >= 15) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		textField.setForeground(new Color(153, 153, 153));
		textField.setBounds(66, 62, 340, 40);
		textField.setBorder(new LineBorder(new Color(153, 153, 153)));
		textField.addFocusListener(new FocusAdapter() {	
			@Override
			public void focusGained(FocusEvent e) {
				textField.setForeground(new Color(SystemColor.DESKTOP));
				if (textField.getText().equals("Usuario")) {
					textField.setText(null);
				}
				textField.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Usuario", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				textField.setBorder(new LineBorder(new Color(153, 153, 153)));
				if (textField.getText().length()==0) {
					textField.setText("Usuario");
					textField.setForeground(new Color(153, 153, 153));
				}
			}
			
		});
		registro.setLayout(null);
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textField.setSelectedTextColor(SystemColor.window);
		textField.setSelectionColor(SystemColor.textHighlight);
		textField.setBackground(Color.WHITE);
		registro.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("Nombres", 20);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int validar = e.getKeyChar();
				if (!Character.isLetter(validar)) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					}
			}
		});
		textField_1.setForeground(new Color(153, 153, 153));
		textField_1.setBounds(66, 126, 340, 40);
		textField_1.setBorder(new LineBorder(new Color(153, 153, 153)));
		textField_1.addFocusListener(new FocusAdapter() {	
			@Override
			public void focusGained(FocusEvent e) {
				textField_1.setForeground(new Color(SystemColor.DESKTOP));
				if (textField_1.getText().equals("Nombres")) {
					textField_1.setText(null);
				}
				textField_1.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Nombres", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				textField_1.setBorder(new LineBorder(new Color(153, 153, 153)));
				if (textField_1.getText().length()==0) {
					textField_1.setText("Nombres");
					textField_1.setForeground(new Color(153, 153, 153));
				}
			}
		});
		registro.setLayout(null);
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textField_1.setSelectedTextColor(SystemColor.window);
		textField_1.setSelectionColor(SystemColor.textHighlight);
		textField_1.setBackground(Color.WHITE);
		registro.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("Apellidos", 25);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int validar = e.getKeyChar();
				if (!Character.isLetter(validar)) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					}
			}
		});
		textField_2.setForeground(new Color(153, 153, 153));
		textField_2.setBounds(66, 176, 340, 40);
		textField_2.setBorder(new LineBorder(new Color(153, 153, 153)));
		textField_2.addFocusListener(new FocusAdapter() {	
			@Override
			public void focusGained(FocusEvent e) {
				textField_2.setForeground(new Color(SystemColor.DESKTOP));
				if (textField_2.getText().equals("Apellidos")) {
					textField_2.setText(null);
				}
				textField_2.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Apellidos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				textField_2.setBorder(new LineBorder(new Color(153, 153, 153)));
				if (textField_2.getText().length()==0) {
					textField_2.setText("Apellidos");
					textField_2.setForeground(new Color(153, 153, 153));
				}
			}
		});
		
		textField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textField_2.setSelectedTextColor(SystemColor.window);
		textField_2.setSelectionColor(SystemColor.textHighlight);
		textField_2.setBackground(Color.WHITE);
		textField_2.setColumns(10);
		registro.add(textField_2);
		
		passwordField_1 = new JPasswordField("Contraseña",15);
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(passwordField_1.getPassword().length >= 15) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		passwordField_1.setForeground(new Color(153, 153, 153));
		passwordField_1.setBounds(66, 235, 340, 40);
		passwordField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		passwordField_1.setBorder(new LineBorder(new Color(153, 153, 153)));
		passwordField_1.setEchoChar((char)0);
		
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField_1.setForeground(new Color(SystemColor.DESKTOP));
				String password = "";
				for(char contra : passwordField_1.getPassword()) {
					password += contra;
				}
				if (password.equals("Contraseña")) {
					passwordField_1.setText(null);
				}
				passwordField_1.setEchoChar('*');
				passwordField_1.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Contraseña", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordField_1.setBorder(new LineBorder(new Color(153, 153, 153)));
				passwordField_1.setEchoChar((char)0);
				if (passwordField_1.getPassword().length==0) {
					passwordField_1.setForeground(new Color(153, 153, 153));
					passwordField_1.setText("Contraseña");
				}else {
					passwordField_1.setEchoChar('*');
				}
			}
		});
		passwordField_1.setSelectedTextColor(SystemColor.window);
		passwordField_1.setSelectionColor(SystemColor.textHighlight);
		passwordField_1.setBackground(Color.WHITE);
		registro.add(passwordField_1);
		
		JLabel espacios_1 = new JLabel("Espacios(min. 5- max. 15)");
		espacios_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		espacios_1.setBounds(66, 272, 181, 26);
		registro.add(espacios_1);
		
		passwordField_2 = new JPasswordField("Verificar contraseña");
		passwordField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(passwordField_2.getPassword().length >= 15) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		passwordField_2.setForeground(new Color(153, 153, 153));
		passwordField_2.setBounds(66, 302, 340, 40);
		passwordField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		passwordField_2.setBorder(new LineBorder(new Color(153, 153, 153)));
		passwordField_2.setEchoChar((char)0);
		
		passwordField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField_2.setForeground(new Color(SystemColor.DESKTOP));
				String password = "";
				for(char contra : passwordField_2.getPassword()) {
					password += contra;
				}
				if (password.equals("Verificar contraseña")) {
					passwordField_2.setText(null);
				}
				passwordField_2.setEchoChar('*');
				passwordField_2.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Contraseña", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordField_2.setBorder(new LineBorder(new Color(153, 153, 153)));
				passwordField_2.setEchoChar((char)0);
				if (passwordField_2.getPassword().length==0) {
					passwordField_2.setText("Verificar contraseña");
					passwordField_2.setForeground(new Color(153, 153, 153));
				}else {
					passwordField_2.setEchoChar('*');
				}
			}
		});
		passwordField_2.setSelectedTextColor(SystemColor.window);
		passwordField_2.setSelectionColor(SystemColor.textHighlight);
		passwordField_2.setBackground(Color.WHITE);
		registro.add(passwordField_2);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:\r\n");
		lblFechaDeNacimiento.setBounds(66, 352, 340, 40);
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		registro.add(lblFechaDeNacimiento);
		
		JSpinner dia = new JSpinner();
		SpinnerNumberModel dias= new SpinnerNumberModel (1,1,31,1);
		dia.setModel(dias);
		dia.setBounds(66, 395, 104, 35);
		registro.add(dia);
		
		JSpinner mes = new JSpinner();
		String[] mesesLista = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		SpinnerListModel meses = new SpinnerListModel(mesesLista);
		mes.setModel(meses);
		mes.setBounds(187, 395, 104, 35);
		registro.add(mes);
		
		JSpinner anio = new JSpinner();
		anio.setAutoscrolls(true);
		SpinnerNumberModel anios= new SpinnerNumberModel (2018,1925,2018,1);
		anio.setModel(anios);
		anio.setBounds(304, 395, 104, 35);
		registro.add(anio);
		registro.setVisible(false);
		
		JFormattedTextField contacto = new JFormattedTextField("Número contacto");
		contacto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		contacto.setForeground(new Color(153, 153, 153));
		contacto.setBounds(66, 445, 340, 40);
		contacto.setBorder(new LineBorder(new Color(153, 153, 153)));
		contacto.addFocusListener(new FocusAdapter() {	
			@Override
			public void focusGained(FocusEvent e) {
				contacto.setForeground(new Color(SystemColor.DESKTOP));
				if (contacto.getText().equals("Número contacto")) {
					contacto.setText(null);
				}
				contacto.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Número contacto", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				contacto.setBorder(new LineBorder(new Color(153, 153, 153)));
				if (contacto.getText().length()==0) {
					contacto.setText("Número contacto");
					contacto.setForeground(new Color(153, 153, 153));
				}
			}
		});
		contacto.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		contacto.setSelectedTextColor(SystemColor.window);
		contacto.setSelectionColor(SystemColor.textHighlight);
		contacto.setBackground(Color.WHITE);
		contacto.setColumns(10);
		registro.add(contacto);
		
		JLabel labelRol = new JLabel("Seleccione el rol con el cual desea registrarse:");
		labelRol.setHorizontalAlignment(SwingConstants.CENTER);
		labelRol.setFont(new Font("SansSerif", Font.PLAIN, 20));
		labelRol.setBounds(36, 495, 420, 40);
		registro.add(labelRol);
		
		JComboBox eleccionRegistroRol = new JComboBox();
		eleccionRegistroRol.setBorder(new LineBorder(new Color(0, 0, 0)));
		eleccionRegistroRol.setFont(new Font("SansSerif", Font.PLAIN, 20));
		eleccionRegistroRol.setModel(new DefaultComboBoxModel(new String[] {"Seleccione","Usuario", "Emprendedor"}));
		eleccionRegistroRol.setSelectedIndex(0);
		eleccionRegistroRol.setBounds(161, 545, 175, 35);
		registro.add(eleccionRegistroRol);
		
		JPanel registroEmprendedor = new JPanel();
		registroEmprendedor.setBackground(SystemColor.window);
		registroEmprendedor.setBounds(0, 0, 486, 663);
		frmElCampo.getContentPane().add(registroEmprendedor);
		registroEmprendedor.setVisible(false);
		
		JButton btnValidarRegistro = new JButton("Continuar");
		btnValidarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validar = logica.validarInfo(textField.getText(), textField_1.getText(), textField_2.getText(), passwordField_1.getPassword(), passwordField_2.getPassword(), contacto.getValue().toString(), usuarioRegistrado);
				if(validar) {
					if (eleccionRegistroRol.getSelectedItem()=="Usuario"){
						int anio1 = Integer.parseInt(anio.getValue().toString());
						int dia1 = Integer.parseInt(dia.getValue().toString());
						Date fecha = new Date(anio1-1900,Arrays.asList(mesesLista).indexOf(mes.getValue().toString()), dia1);
						long contactoValido = Long.parseLong(contacto.getText());
						logica.registroUsuario(textField_1.getText(), textField_1.getText()+" "+textField_2.getText(), textField.getText(), passwordField_1.getPassword(), fecha, contactoValido, usuarioRegistrado, personasRegistradas, emprendedoresRegistrados);
						
						PrincipalUsuario.activar(textField.getText(), usuarioRegistrado, emprendedoresRegistrados);
						frmElCampo.dispose();
					}else if(eleccionRegistroRol.getSelectedItem()=="Emprendedor") {
						registro.setVisible(false);
						registroEmprendedor.setVisible(true);
					}
				}else {
					JOptionPane.showMessageDialog(frmElCampo, "Rellene todos los espacios correctamente", "Fallo registro", JOptionPane.ERROR_MESSAGE);	
				}
		}
		});
		btnValidarRegistro.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnValidarRegistro.setBounds(304, 593, 140, 35);
		registro.add(btnValidarRegistro);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro.setVisible(false);
				inicioSesion.setVisible(true);
			}
		});
		btnAtras.setBounds(78, 594, 141, 38);
		btnAtras.setFont(new Font("SansSerif", Font.PLAIN, 16));
		registro.add(btnAtras);
		registroEmprendedor.setLayout(new MigLayout("", "[100px][400px]", "[15px][40px][20px][200px][20px][][10px][45px][10px][45px][10px][45px][30px][40px]"));
		
		JLabel lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblUbicacion.setBounds(109, 58, 45, 13);
		registroEmprendedor.add(lblUbicacion, "cell 0 1,alignx left,aligny top");
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int validar = e.getKeyChar();
				if (!Character.isLetter(validar)) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					}
			}
		});
		textFieldUbicacion.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textFieldUbicacion.setBounds(25, 65, 96, 19);
		registroEmprendedor.add(textFieldUbicacion, "cell 1 1,grow");
		textFieldUbicacion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("<html><body>Descripcion<br>Situación:<html><body>");
		lblDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblDescripcion.setBounds(10, 121, 90, 26);
		registroEmprendedor.add(lblDescripcion, "cell 0 3,alignx left,aligny top");
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBackground(Color.LIGHT_GRAY);
		textAreaDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textAreaDescripcion.setBounds(46, 132, 5, 22);
		registroEmprendedor.add(textAreaDescripcion, "cell 1 3,grow");
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblContacto.setBounds(10, 121, 90, 26);
		registroEmprendedor.add(lblContacto, "cell 0 5,alignx left,aligny bottom");
		
		JLabel lblAclaracion = new JLabel("(No es obliatorio rellenar todo)");
		lblAclaracion.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblAclaracion.setBounds(10, 121, 90, 26);
		registroEmprendedor.add(lblAclaracion, "cell 1 5,alignx left,aligny bottom");
		
		JLabel lblContacto_2 = new JLabel("adicional:");
		lblContacto_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblContacto_2.setBounds(10, 121, 90, 26);
		registroEmprendedor.add(lblContacto_2, "cell 0 6,alignx left,aligny top");
		
		textFieldTelefono = new JTextField("Telefono");
		textFieldTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		textFieldTelefono.setBounds(343, 402, 96, 19);
		textFieldTelefono.setForeground(new Color(153, 153, 153));
		textFieldTelefono.setBorder(new LineBorder(new Color(153, 153, 153)));
		textFieldTelefono.addFocusListener(new FocusAdapter() {	
			@Override
			public void focusGained(FocusEvent e) {
				textFieldTelefono.setForeground(new Color(SystemColor.DESKTOP));
				if (textFieldTelefono.getText().equals("Telefono")) {
					textFieldTelefono.setText(null);
				}
				textFieldTelefono.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Telefono", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				textFieldTelefono.setBorder(new LineBorder(new Color(153, 153, 153)));
				if (textFieldTelefono.getText().length()==0) {
					textFieldTelefono.setText("Telefono");
					textFieldTelefono.setForeground(new Color(153, 153, 153));
				}
			}
		});
		textFieldTelefono.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textFieldTelefono.setSelectedTextColor(SystemColor.window);
		textFieldTelefono.setSelectionColor(SystemColor.textHighlight);
		textFieldTelefono.setBackground(Color.WHITE);
		registroEmprendedor.add(textFieldTelefono, "cell 1 7,grow");
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField("Correo");
		textFieldCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int validar = e.getKeyChar();
				if (!Character.isLetter(validar)) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					}
			}
		});
		textFieldCorreo.setBounds(142, 381, 96, 19);
		textFieldCorreo.setForeground(new Color(153, 153, 153));
		textFieldCorreo.setBorder(new LineBorder(new Color(153, 153, 153)));
		textFieldCorreo.addFocusListener(new FocusAdapter() {	
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCorreo.setForeground(new Color(SystemColor.DESKTOP));
				if (textFieldCorreo.getText().equals("Correo")) {
					textFieldCorreo.setText(null);
				}
				textFieldCorreo.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Correo", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				textFieldCorreo.setBorder(new LineBorder(new Color(153, 153, 153)));
				if (textFieldCorreo.getText().length()==0) {
					textFieldCorreo.setText("Correo");
					textFieldCorreo.setForeground(new Color(153, 153, 153));
				}
			}
		});
		textFieldCorreo.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textFieldCorreo.setSelectedTextColor(SystemColor.window);
		textFieldCorreo.setSelectionColor(SystemColor.textHighlight);
		textFieldCorreo.setBackground(Color.WHITE);
		registroEmprendedor.add(textFieldCorreo, "cell 1 9,grow");
		textFieldCorreo.setColumns(10);
		
		textFieldOtro = new JTextField("Página web/otro");
		textFieldOtro.setBounds(25, 416, 96, 19);
		textFieldOtro.setForeground(new Color(153, 153, 153));
		textFieldOtro.setBorder(new LineBorder(new Color(153, 153, 153)));
		textFieldOtro.addFocusListener(new FocusAdapter() {	
			@Override
			public void focusGained(FocusEvent e) {
				textFieldOtro.setForeground(new Color(SystemColor.DESKTOP));
				if (textFieldOtro.getText().equals("Página web/otro")) {
					textFieldOtro.setText(null);
				}
				textFieldOtro.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Página web/otro", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				textFieldOtro.setBorder(new LineBorder(new Color(153, 153, 153)));
				if (textFieldOtro.getText().length()==0) {
					textFieldOtro.setText("Página web/otro");
					textFieldOtro.setForeground(new Color(153, 153, 153));
				}
			}
		});
		textFieldOtro.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textFieldOtro.setSelectedTextColor(SystemColor.window);
		textFieldOtro.setSelectionColor(SystemColor.textHighlight);
		textFieldOtro.setBackground(Color.WHITE);
		registroEmprendedor.add(textFieldOtro, "cell 1 11,grow");
		textFieldOtro.setColumns(10);
		
		JPanel panelProductos = new JPanel();
		panelProductos.setBounds(0, 0, 486, 663);
		panelProductos.setBackground(Color.WHITE);
		frmElCampo.getContentPane().add(panelProductos);
		panelProductos.setVisible(false);
		
		JButton btnRegistroEmprendedor = new JButton("Continuar");
		btnRegistroEmprendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validez = logica.validarInfoEmprendedor(textFieldUbicacion.getText(), textAreaDescripcion.getText(), textFieldTelefono.getText(), textFieldCorreo.getText());
				if(validez) {
					ArrayList<String> adicional = new ArrayList<String>();
					if(textFieldTelefono.getText().compareTo("Telefono")!=0){
						adicional.add(textFieldTelefono.getText());
					} else if(textFieldCorreo.getText().compareTo("Correo")!=0) {
						adicional.add(textFieldCorreo.getText());
					}else if(textFieldOtro.getText().compareTo("Página web/otro")!=0){
						adicional.add(textFieldOtro.getText());
					}
					int anio1 = Integer.parseInt(anio.getValue().toString());
					int dia1 = Integer.parseInt(dia.getValue().toString());
					Date fecha = new Date(anio1-1900,Arrays.asList(mesesLista).indexOf(mes.getValue().toString()), dia1);
					long contactoValido = Long.parseLong(contacto.getText());
					logica.registroEmprendedor(textField_1.getText(), textField_1.getText()+" "+textField_2.getText(), textField.getText(), passwordField_1.getPassword(), fecha, contactoValido, textFieldUbicacion.getText(), textAreaDescripcion.getText(), adicional, emprendedoresRegistrados, personasRegistradas, usuarioRegistrado);
					registroEmprendedor.setVisible(false);
					panelProductos.setVisible(true);
					
					JButton btnAtrasRegistro = new JButton("Atrás");
					btnAtrasRegistro.setFont(new Font("SansSerif", Font.PLAIN, 16));
					btnAtrasRegistro.setBounds(315, 594, 141, 38);
					registroEmprendedor.add(btnAtrasRegistro, "cell 0 13,grow");
					panelProductos.setLayout(null);
					
					JLabel lblInstruccionesProductos = new JLabel("<html><body>Seleccione + para agregar los productos que quiere desea ofrecer<body><html>");
					lblInstruccionesProductos.setFont(new Font("SansSerif", Font.PLAIN, 20));
					lblInstruccionesProductos.setBackground(SystemColor.window);
					lblInstruccionesProductos.setBounds(27, 28, 430, 52);
					panelProductos.add(lblInstruccionesProductos);
					
					JPanel panelProductosAgregados = new JPanel();
					panelProductosAgregados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Productos", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
					panelProductosAgregados.setLayout(new MigLayout("", "[20px][350px][20px]", "[]"));
					panelProductosAgregados.setBounds(27, 106, 391, 492);
					panelProductosAgregados.setBackground(Color.WHITE);
					panelProductos.add(panelProductosAgregados);
					
					Emprendedor emprendedor = logica.buscarEmprendedor(textField.getText(), emprendedoresRegistrados);
					if(emprendedor.getProductos()!= null) {
						System.out.print("loko");
						JLabel[] lblProductos = new JLabel[emprendedor.getProductos().size()];
						int indice = 0;
						for(Producto producto: emprendedor.getProductos().values()) {
							lblProductos[indice] = new JLabel("<html><body>"+producto.getNombre()+"("+producto.getSeccion()+")"+"<br>"+producto.getPeso()+" gramos/"+producto.getPrecioPeso()+"pesos<body><html>");
							lblProductos[indice].setBorder(new LineBorder(new Color(0, 0, 0)));
							lblProductos[indice].setFont(new Font("SansSerif", Font.PLAIN, 18));
							panelProductosAgregados.add(lblProductos[indice], "cell 1 "+(String.valueOf(indice))+", grow");
							indice += 1;
						}
					}
					
					JScrollPane scrollPane = new JScrollPane(panelProductosAgregados);
					scrollPane.setBorder(null);
					scrollPane.setBounds(27, 106, 430, 492);
					panelProductos.add(scrollPane);
					
					JPanel panelAgregar = new JPanel();
					panelAgregar.setBounds(0, 0, 486, 663);
					panelAgregar.setBackground(Color.WHITE);
					frmElCampo.getContentPane().add(panelAgregar);
					panelAgregar.setVisible(false);
					panelAgregar.setLayout(new MigLayout("", "[25px][2000px][25px]", "[25px][40px][40px][40px][40px][40px][15px][40px][40px][15px][40px][40px][15px][40px][40px][15px][40px]"));
					
					JButton btnAgregar = new JButton();
					btnAgregar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panelProductos.setVisible(false);
							panelAgregar.setVisible(true);
						}
					});
					btnAgregar.setBounds(27, 623, 57, 33);
					ImageIcon agregar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\45156.png");
					Icon logoAgregar = new ImageIcon(agregar.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
					btnAgregar.setIcon(logoAgregar);
					panelProductos.add(btnAgregar);
					
					JButton btnAtrás2 = new JButton("");
					btnAtrás2.setBorder(null);
					btnAtrás2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panelAgregar.setVisible(false);
							
							panelProductos.setVisible(true);
						}
					});
					btnAtrás2.setBackground(SystemColor.window);
					ImageIcon atras = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\318339.png");
					Icon logoAtras = new ImageIcon(atras.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
					btnAtrás2.setIcon(logoAtras);
					btnAtrás2.setBounds(0, -7, 35, 35);
					panelAgregar.add(btnAtrás2, "cell 0 0,alignx left,aligny center");
					
					JLabel lblAgregar = new JLabel("Agregar nuevos productos");
					lblAgregar.setBackground(SystemColor.window);
					lblAgregar.setFont(new Font("SansSerif", Font.PLAIN, 20));
					panelAgregar.add(lblAgregar, "cell 1 1 ,alignx left,aligny center");
					
					JLabel lblInstrucciones = new JLabel("<html><body>Rellene por favor<br>todos los espacios<body><html>");
					lblInstrucciones.setBackground(SystemColor.window);
					lblInstrucciones.setFont(new Font("SansSerif", Font.PLAIN, 17));
					panelAgregar.add(lblInstrucciones, "cell 1 2 ,alignx left,aligny top");
					
					JLabel lblNombre = new JLabel("Nombre del producto");
					lblNombre.setBackground(SystemColor.window);
					lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 17));
					panelAgregar.add(lblNombre, "cell 1 4,alignx left,aligny top");
					
					textFieldNombre = new JTextField();
					panelAgregar.add(textFieldNombre, "cell 1 5, grow");
					textFieldNombre.setFont(new Font("SansSerif", Font.PLAIN, 17));
					textFieldNombre.setColumns(5);
					
					JLabel lblPeso = new JLabel("Peso del producto (Gramos)");
					lblPeso.setBackground(SystemColor.window);
					lblPeso.setFont(new Font("SansSerif", Font.PLAIN, 17));
					panelAgregar.add(lblPeso, "cell 1 7 ,alignx left,aligny top");
					
					textFieldPeso = new JTextField();
					textFieldPeso.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
							char validar = e.getKeyChar();
							if (Character.isLetter(validar)) {
								e.consume();
								Toolkit.getDefaultToolkit().beep();
							}
						}
					});
					textFieldPeso.setFont(new Font("SansSerif", Font.PLAIN, 17));
					panelAgregar.add(textFieldPeso, "cell 1 8, grow");
					textFieldPeso.setColumns(5);
					
					JLabel lblPercio = new JLabel("<html><body>Precio del producto<br>de acuerdo a su peso (Pesos)<body><html>");
					lblPercio.setBackground(SystemColor.window);
					lblPercio.setFont(new Font("SansSerif", Font.PLAIN, 17));
					panelAgregar.add(lblPercio, "cell 1 10,alignx left,aligny top");
					
					textFieldPrecio = new JTextField();
					textFieldPrecio.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent e) {
							char validar = e.getKeyChar();
							if (Character.isLetter(validar)) {
								e.consume();
								Toolkit.getDefaultToolkit().beep();
							}
						}
					});
					panelAgregar.add(textFieldPrecio, "cell 1 11, grow");
					textFieldPrecio.setFont(new Font("SansSerif", Font.PLAIN, 17));
					textFieldPrecio.setColumns(5);
					
					JLabel lblSeccion = new JLabel("<html><body>Sección a la cual el producto pertenece<body><html>");
					lblSeccion.setBackground(SystemColor.window);
					lblSeccion.setFont(new Font("SansSerif", Font.PLAIN, 17));
					panelAgregar.add(lblSeccion, "cell 1 13,alignx left,aligny top");
					
					JComboBox comboBoxSeccion = new JComboBox();
					comboBoxSeccion.setBorder(new LineBorder(new Color(0, 0, 0)));
					comboBoxSeccion.setModel(new DefaultComboBoxModel(new String[] {"Seleccione","Vegetal", "Fruta", "Bebida", "Carnico", "Otro"}));
					comboBoxSeccion.setSelectedIndex(0);
					comboBoxSeccion.setFont(new Font("SansSerif", Font.PLAIN, 17));
					panelAgregar.add(comboBoxSeccion, "cell 1 14, grow");
					
					JButton btnAccionAgregar = new JButton("Agregar");
					btnAccionAgregar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(logica.validarAgregar(textFieldNombre.getText(),textFieldPeso.getText(), textFieldPrecio.getText(), comboBoxSeccion.getSelectedItem())) {
								logica.agregarProductoRegistro(emprendedor, textFieldNombre.getText(),textFieldPeso.getText(), textFieldPrecio.getText(), comboBoxSeccion.getSelectedItem());
							}else {
								JOptionPane.showMessageDialog(frmElCampo, "Revise los datos ingresados", "Falla agregacion", JOptionPane.ERROR_MESSAGE);
							}
							JLabel lblProductosNuevos[] = new JLabel[emprendedor.getProductos().size()+1];
							Producto productoNuevo = emprendedor.getProductos().get(textFieldNombre.getText());
							lblProductosNuevos[emprendedor.getProductos().size()] = new JLabel("<html><body>"+productoNuevo.getNombre()+"("+productoNuevo.getSeccion()+")"+"<br>"+productoNuevo.getPeso()+" gramos/"+productoNuevo.getPrecioPeso()+"pesos<body><html>");
							lblProductosNuevos[emprendedor.getProductos().size()].setBorder(new LineBorder(new Color(0, 0, 0)));
							lblProductosNuevos[emprendedor.getProductos().size()].setFont(new Font("SansSerif", Font.PLAIN, 18));
							panelProductosAgregados.add(lblProductosNuevos[emprendedor.getProductos().size()], "cell 1 "+(String.valueOf(emprendedor.getProductos().size()))+", grow");
							panelAgregar.setVisible(false);
							panelProductos.setVisible(true);
						}
					});
					btnAccionAgregar.setFont(new Font("SansSerif", Font.PLAIN, 17));
					panelAgregar.add(btnAccionAgregar, "cell 1 16,alignx right,aligny center");
					
					JButton btnContinuar = new JButton();
					btnContinuar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(logica.buscarEmprendedor(textField.getText(), emprendedoresRegistrados).getProductos() == null) {
								JOptionPane.showMessageDialog(frmElCampo, "Ingrese los productos", "Falla registro", JOptionPane.ERROR_MESSAGE);
							}else {
								principalEmprendedor.activarEmprendedor(textField.getText(), emprendedoresRegistrados, usuarioRegistrado);
								frmElCampo.dispose();
							}
						}
					});
					btnContinuar.setBounds(401, 623, 75, 33);
					ImageIcon continuar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\unnamed.png");
					Icon logoContinuar = new ImageIcon(continuar.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
					btnContinuar.setIcon(logoContinuar);
					panelProductos.add(btnContinuar, "cell 1 16, alignx right, aligny center");
					
					
				}else {
					JOptionPane.showMessageDialog(frmElCampo, "Rellene todos los espacios correctamente", "Fallo registro", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		btnRegistroEmprendedor.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnRegistroEmprendedor.setBounds(315, 594, 141, 38);
		registroEmprendedor.add(btnRegistroEmprendedor, "cell 1 13,alignx right,growy");
		
		JButton btnAtrás1 = new JButton("Atrás");
		btnAtrás1.setBorder(null);
		btnAtrás1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroEmprendedor.setVisible(false);
				registro.setVisible(true);
			}
		});
		btnAtrás1.setBackground(SystemColor.window);
		btnAtrás1.setBounds(0, -7, 35, 35);
		registroEmprendedor.add(btnAtrás1, "cell 0 13, grow");
		

		}
}
