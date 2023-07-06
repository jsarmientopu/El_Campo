package UI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.logica;
import datos.Persona;
import datos.Producto;
import datos.Recompensa;
import datos.Texto;
import datos.Usuario;
import datos.Venta;
import datos.Chat;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import datos.Emprendedor;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class PrincipalUsuario {

	private JFrame framePrincipal;
	private JTextField textFieldBuscar;
	private JTextField textField;
	private JTextField textFieldChat;
	private JTextField textField_1;
	private JPanel panelChatIndividual;
	/**
	 * Launch the application.
	 */
	public static void activar(String persona, ArrayList<Usuario> usuariosRegistrados, ArrayList<Emprendedor> emprendedoresRegistrados) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUsuario window = new PrincipalUsuario(persona,usuariosRegistrados, emprendedoresRegistrados);
					window.framePrincipal.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalUsuario(String persona, ArrayList<Usuario> usuariosRegistrados, ArrayList<Emprendedor> emprendedoresRegistrados) {
		Usuario usuario = logica.buscarUsuario(persona, usuariosRegistrados);
		initialize(usuario, emprendedoresRegistrados, usuariosRegistrados);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Usuario usuario, ArrayList<Emprendedor> emprendedoresRegistrados, ArrayList<Usuario> usuariosRegistrados) {
		framePrincipal = new JFrame();
		framePrincipal.getContentPane().setBackground(SystemColor.window);
		framePrincipal.setBackground(Color.WHITE);
		framePrincipal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalUsuario.class.getResource("/Imagenes/Campo_logo_.png")));
		framePrincipal.setTitle("EL CAMPO\r\n");
		framePrincipal.setBounds(300, 100, 950, 600);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.getContentPane().setLayout(null);
		
		JPanel panelRecompensas = new JPanel();
		panelRecompensas.setBounds(587, 63, 157, 120);
		framePrincipal.getContentPane().add(panelRecompensas);
		panelRecompensas.setVisible(false);
		
		JScrollPane scrollPaneRecompensa = new JScrollPane(panelRecompensas);
		scrollPaneRecompensa.setBounds(587, 63, 157, 120);
		framePrincipal.getContentPane().add(scrollPaneRecompensa);
		panelRecompensas.setLayout(new MigLayout("", "[120px]", "[40px]"));
		scrollPaneRecompensa.setVisible(false);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelRecompensas.setVisible(false);
				scrollPaneRecompensa.setVisible(false);
			}
		});
		panelPrincipal.setBackground(SystemColor.window);
		panelPrincipal.setBounds(0, 0, 936, 563);
		framePrincipal.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new MigLayout("", "[936px,grow]", "[75px,grow][460px,grow][30px]"));
	
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.window);
		panelPrincipal.add(panelSuperior, "cell 0 0,grow");
		panelSuperior.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><body>Usuario:<br>"+usuario.getNombre()+"<body><html>");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setBounds(10, 10, 190, 47);
		panelSuperior.add(lblNewLabel);
		
		JLabel logo = new JLabel("New label");
		logo.setBackground(SystemColor.window);
		logo.setBounds(318, 14, 45, 47);
		ImageIcon imagen = new ImageIcon(PrincipalUsuario.class.getResource("/Imagenes/Campo_logo_.png"));
		Icon logoImagen = new ImageIcon(imagen.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
		logo.setIcon(logoImagen);
		panelSuperior.add(logo);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesi\u00F3n  ");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePrincipal.dispose();
				GUI_Proyecto.main(null);
			}
		});
		btnCerrarSesion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnCerrarSesion.setBounds(747, 10, 145, 47);
		ImageIcon cerrarSesion = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\565503.png");
		Icon logoCerrarSesion = new ImageIcon(cerrarSesion.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		btnCerrarSesion.setIcon(logoCerrarSesion);
		btnCerrarSesion.setVerticalTextPosition(AbstractButton.CENTER);
		btnCerrarSesion.setHorizontalTextPosition(AbstractButton.LEADING);
		panelSuperior.add(btnCerrarSesion);
		
		ImageIcon logoRecompensa = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\686428.png");
		Icon logoRecompensaIcon = new ImageIcon(logoRecompensa.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		logica.generarRecompensas(usuario);
		
		JButton[] btnRecompensasDadas = new JButton[usuario.getRecompensa().size()];
		
		ArrayList<Recompensa> recompensasReal= new ArrayList<>(); 
		for(Recompensa recompensa : usuario.getRecompensa()) {
			if(recompensa.isUsado()==false) {
				recompensasReal.add(recompensa);
			}
		}
		if(recompensasReal.isEmpty()) {
			panelRecompensas.setBounds(587, 63, 157, 45);
			scrollPaneRecompensa.setBounds(587, 63, 157, 45);
			JLabel lblNoRecompensas = new JLabel("<html><body>No hay recompensas<br> disponibles<body><html>");
			lblNoRecompensas.setFont(new Font("SansSerif", Font.PLAIN, 12));
			panelRecompensas.add(lblNoRecompensas, "cell 0 0, grow");
		}else {
			for(int indiceRecompensa = 0; indiceRecompensa<recompensasReal.size() ; indiceRecompensa++) {
				Recompensa recompensa = recompensasReal.get(indiceRecompensa);
				if(recompensa.isUsado()==false) {
					final int indiceRecompensaFinal = indiceRecompensa;
					panelRecompensas.setBounds(587, 63, 157, 120);
					scrollPaneRecompensa.setBounds(587, 63, 157, 120);
					btnRecompensasDadas[indiceRecompensa] = new JButton("<html><body>"+recompensa.getProducto().getNombre().toUpperCase()+"<br>"+recompensa.getProducto().getPeso()+"gramos / Sección: "+recompensa.getProducto().getSeccion()+"<body><html>");
					btnRecompensasDadas[indiceRecompensa].setBounds(0, 0, 85, 21);
					btnRecompensasDadas[indiceRecompensa].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String[] opciones = {"Si", "No"};
							int confirmacion = JOptionPane.showOptionDialog(framePrincipal, "¿Desea reclamar su recompensa?Een el caso que si, lo contactaremos para enviar su producto", "Reclamación recompensa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
							if (confirmacion == 0) {
								panelRecompensas.remove(btnRecompensasDadas[indiceRecompensaFinal]);
								panelRecompensas.setVisible(false);
								panelRecompensas.setVisible(true);
								logica.cambiarAUsado(usuario, recompensasReal.get(indiceRecompensaFinal));
								logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
							}
						}
					});
					btnRecompensasDadas[indiceRecompensa].setFont(new Font("SansSerif", Font.PLAIN, 12));
					panelRecompensas.add(btnRecompensasDadas[indiceRecompensa], "cell 0 "+String.valueOf(indiceRecompensa)+",grow");
					System.out.print("mal1");
				}
			}
		}
		
		
		
		JButton btnRecompensa = new JButton(" Recompensas", logoRecompensaIcon);
		btnRecompensa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelRecompensas.setVisible(true);
				scrollPaneRecompensa.setVisible(true);
			}
		});
		btnRecompensa.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnRecompensa.setBounds(579, 10, 158, 47);
		btnRecompensa.setMnemonic(KeyEvent.VK_E);
		panelSuperior.add(btnRecompensa);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(SystemColor.window);
		panelPrincipal.add(panelCentral, "cell 0 1,grow");
		panelCentral.setLayout(null);
		
		JPanel panelDerecho = new JPanel();
		panelDerecho.setBackground(SystemColor.window);
		panelDerecho.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Funciones", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDerecho.setBounds(576, 7, 339, 438);
		panelCentral.add(panelDerecho);
		panelDerecho.setLayout(new MigLayout("", "[400px]", "[][115px][115px][115px][115px]"));
		
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBackground(SystemColor.window);
		panelIzquierdo.setBounds(10, 7, 556, 435);
		panelCentral.add(panelIzquierdo);
		panelIzquierdo.setLayout(new MigLayout("", "[20px][500px][20px]", "[40px][43px][43px][43px][43px][43px][43px][43px][43px]"));
		
		JLabel lblSugerencias = new JLabel("Sugerencias:");
		lblSugerencias.setBackground(SystemColor.window);
		lblSugerencias.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelIzquierdo.add(lblSugerencias, "cell 1 0,alignx left,aligny center");
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBackground(SystemColor.window);
		panelBuscar.setBounds(576, 7, 339, 438);
		panelCentral.add(panelBuscar);
		panelBuscar.setVisible(false);

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(SystemColor.window);
		panelRegistro.setBounds(576, 7, 339, 438);
		panelCentral.add(panelRegistro);
		panelRegistro.setVisible(false);

		JPanel panelPuntos = new JPanel();
		panelPuntos.setBackground(SystemColor.window);
		panelPuntos.setBounds(576, 7, 339, 438);
		panelCentral.add(panelPuntos);
		panelPuntos.setVisible(false);
		
		JPanel panelChat = new JPanel();
		panelChat.setBackground(SystemColor.window);
		panelChat.setBounds(576, 7, 339, 438);
		panelChat.setBorder(new LineBorder(new Color(153, 153, 153)));
		panelCentral.add(panelChat);
		panelChat.setVisible(false);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDerecho.setVisible(false);
				panelBuscar.setVisible(true);
			}
		});
		btnBuscar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		ImageIcon buscar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\if_magnifying-glass_226571.png");
		Icon logoBuscar = new ImageIcon(buscar.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		btnBuscar.setIcon(logoBuscar);
		panelDerecho.add(btnBuscar, "cell 0 1,alignx center,aligny center");
		panelBuscar.setLayout(null);
		
		JButton btnAtrás = new JButton("");
		btnAtrás.setBorder(null);
		btnAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBuscar.setVisible(false);
				
				panelDerecho.setVisible(true);
			}
		});
		btnAtrás.setBackground(SystemColor.window);
		ImageIcon atras = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\318339.png");
		Icon logoAtras = new ImageIcon(atras.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		btnAtrás.setIcon(logoAtras);
		btnAtrás.setBounds(0, -7, 35, 35);
		panelBuscar.add(btnAtrás);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textFieldBuscar.setBackground(SystemColor.window);
		textFieldBuscar.addFocusListener(new FocusAdapter() {	
			@Override
			public void focusGained(FocusEvent e) {
				textFieldBuscar.setBounds(10, 24, 285, 40);
				textFieldBuscar.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "Buscar", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(30, 144, 255)));
			}
			public void focusLost(FocusEvent e) {
				textFieldBuscar.setBorder(new LineBorder(new Color(153, 153, 153)));
				textFieldBuscar.setBounds(10, 32, 285, 30);
			}
		});
		textFieldBuscar.setBounds(10, 32, 285, 30);
		panelBuscar.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBackground(SystemColor.window);
		panelBusqueda.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Criterios de busqueda", TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.windowText));
		panelBusqueda.setBounds(10, 76, 319, 95);
		panelBuscar.add(panelBusqueda);
		panelBusqueda.setLayout(new MigLayout("", "[200px][200px][200px]", "[100px][100px]"));
		
		ArrayList<String> tipoBusqueda= new ArrayList<>();

		JToggleButton tglbtnEmprendedor = new JToggleButton("Emprendedor");
		tglbtnEmprendedor.setBackground(SystemColor.window);
		tglbtnEmprendedor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tglbtnEmprendedor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tglbtnEmprendedor.isSelected()) {
					tipoBusqueda.add(tglbtnEmprendedor.getText());
				}else {
					tipoBusqueda.remove(tglbtnEmprendedor);
				}
			}
		});
		tglbtnEmprendedor.setBounds(10, 31, 100, 21);
		panelBusqueda.add(tglbtnEmprendedor, "cell 0 0,alignx center,aligny center");

		JToggleButton tglbtnProducto = new JToggleButton("Producto");
		tglbtnProducto.setBackground(SystemColor.window);
		tglbtnProducto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tglbtnProducto.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tglbtnProducto.isSelected()) {
					tipoBusqueda.add(tglbtnProducto.getText());
				}else {
					tipoBusqueda.remove(tglbtnProducto);
				}
			}
		});
		tglbtnProducto.setBounds(120, 30, 100, 21);
		panelBusqueda.add(tglbtnProducto, "cell 1 0,alignx center,aligny center");

		JToggleButton tglbtnUbicacion = new JToggleButton("Ubicación");
		tglbtnUbicacion.setBackground(SystemColor.window);
		tglbtnUbicacion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tglbtnUbicacion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tglbtnUbicacion.isSelected()) {
					tipoBusqueda.add(tglbtnUbicacion.getText());
				}else {
					tipoBusqueda.remove(tglbtnUbicacion);
				}
			}
		});
		tglbtnUbicacion.setBounds(229, 31, 100, 31);
		panelBusqueda.add(tglbtnUbicacion, "cell 2 0,alignx center,aligny center");
		
		JComboBox comboBoxSeccion = new JComboBox();
		comboBoxSeccion.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxSeccion.setModel(new DefaultComboBoxModel(new String[] {"Sección","Vegetal", "Fruta", "Bebida", "Carnico", "Otro"}));
		comboBoxSeccion.setSelectedIndex(0);
		comboBoxSeccion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		panelBusqueda.add(comboBoxSeccion, "cell 1 1, alignx center,aligny center");
		if(comboBoxSeccion.getSelectedItem().toString().compareTo("Sección")!=0) {
			tipoBusqueda.add(comboBoxSeccion.getSelectedItem().toString());
		}
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBackground(SystemColor.window);
		panelResultados.setBounds(10, 126, 319, 302);
		panelBuscar.add(panelResultados);
		panelResultados.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane(panelResultados);
		panelResultados.setLayout(new MigLayout("", "[285px]", "[][]"));
		scrollPane.setBounds(10, 178, 319, 250);
		panelBuscar.add(scrollPane);
		
		JButton btnRegistro = new JButton("Registro de compras");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDerecho.setVisible(false);
				panelRegistro.setVisible(true);
			}
		});
		btnRegistro.setFont(new Font("SansSerif", Font.PLAIN, 17));
		ImageIcon registro = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\3534124.png");
		Icon logoRegistro = new ImageIcon(registro.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		btnRegistro.setIcon(logoRegistro);
		panelDerecho.add(btnRegistro, "cell 0 2,alignx center,aligny center");

		JButton btnAtrás1 = new JButton("");
		btnAtrás1.setBorder(null);
		btnAtrás1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistro.setVisible(false);
				
				panelDerecho.setVisible(true);
			}
		});
		panelRegistro.setLayout(null);
		btnAtrás1.setBackground(SystemColor.window);
		btnAtrás1.setIcon(logoAtras);
		btnAtrás1.setBounds(10, 10, 43, 36);
		panelRegistro.add(btnAtrás1);
		
		JPanel panelRegistroCompra = new JPanel();
		panelRegistroCompra.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Registro de compras", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelRegistroCompra.setBounds(0, 47, 339, 381);
		panelRegistro.add(panelRegistroCompra);
		
		JScrollPane scrollPane_1 = new JScrollPane(panelRegistroCompra);
		panelRegistroCompra.setLayout(new MigLayout("", "[5px][295px]", "[][]"));
		scrollPane_1.setBounds(0, 47, 339, 381);
		panelRegistro.add(scrollPane_1);
		
		ArrayList<Venta> registroCompras =logica.registro(usuario);
		if(registroCompras!= null) {
			JLabel[] lblCompras = new JLabel[registroCompras.size()];
			for(int posicion2=0;posicion2<=(registroCompras.size()-1);posicion2++) {
				lblCompras[posicion2]= new JLabel("<html><body>Producto(cantidad): "+registroCompras.get(posicion2).getProductos().getNombre()+"("+String.valueOf(registroCompras.get(posicion2).getPrecio())+")<br>Vendedor: "+registroCompras.get(posicion2).getVendedor().getNombre()+"<br>Fecha:"+registroCompras.get(posicion2).getFecha()+"<bod><html>");
				lblCompras[posicion2].setFont(new Font("SansSerif", Font.PLAIN, 13));
				lblCompras[posicion2].setBackground(SystemColor.window);
				lblCompras[posicion2].setBorder(new LineBorder(new Color(153, 153, 153)));
				panelRegistroCompra.add(lblCompras[posicion2], "cell 1 "+(String.valueOf(posicion2))+",grow");
			}
		}
		
		JButton btnPuntos = new JButton("Puntos");
		btnPuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDerecho.setVisible(false);
				panelPuntos.setVisible(true);
			}
		});
		btnPuntos.setFont(new Font("SansSerif", Font.PLAIN, 17));
		ImageIcon puntos = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\magnet-icon (1).png");
		Icon logoPuntos = new ImageIcon(puntos.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		btnPuntos.setIcon(logoPuntos);
		panelDerecho.add(btnPuntos, "cell 0 3,alignx center,aligny center");

		JButton btnAtrás2 = new JButton("");
		btnAtrás2.setBorder(null);
		btnAtrás2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPuntos.setVisible(false);
				
				panelDerecho.setVisible(true);
			}
		});
		panelPuntos.setLayout(null);
		btnAtrás2.setBackground(SystemColor.window);
		btnAtrás2.setIcon(logoAtras);
		btnAtrás2.setBounds(10, 10, 43, 36);
		panelPuntos.add(btnAtrás2);
		
		ImageIcon puntosPequeno = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\magnet-icon (1).png");
		Icon puntosPequenoIcon = new ImageIcon(puntos.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
		JLabel tituloPuntos = new JLabel(" Puntos", puntosPequenoIcon, JLabel.RIGHT);
		tituloPuntos.setFont(new Font("SansSerif", Font.BOLD, 20));
		tituloPuntos.setBounds(119, 10, 101, 36);
		panelPuntos.add(tituloPuntos);
		
		JLabel puntosObtenidos = new JLabel("<html><body> En este momento has obtenido "+String.valueOf(logica.puntos(usuario))+" puntos ElCampo<body><html>");
		puntosObtenidos.setFont(new Font("SansSerif", Font.PLAIN, 15));
		puntosObtenidos.setBounds(20, 78, 295, 36);
		panelPuntos.add(puntosObtenidos);
		
		JLabel funcionPuntos = new JLabel("<html><body>Los puntos el campo son una forma de <br>recompensarle a todos nuestros <br>compradores todas sus compras, las cuales ayudan con el desarrollo de los emprendimientos, especialmente el<br>de los emprendimientos del campo.<br>Usted puede usar estos puntos en nuestra pestaña de recompensas, en la cual tendra lagunas opciones dependiendo su número de puntos.<br> DISFRUTA DE ELCAMPO");
		funcionPuntos.setFont(new Font("SansSerif", Font.PLAIN, 15));
		funcionPuntos.setBounds(20, 140, 295, 274);
		panelPuntos.add(funcionPuntos);
		
		JButton btnChats = new JButton("Chats\r\n");
		btnChats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDerecho.setVisible(false);
				panelChat.setVisible(true);
				
			}
		});
		btnChats.setFont(new Font("SansSerif", Font.PLAIN, 17));
		ImageIcon chat = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\chat-2047240-1730135.png");
		Icon logoChat = new ImageIcon(chat.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		btnChats.setIcon(logoChat);
		panelDerecho.add(btnChats, "cell 0 4,alignx center,aligny center");

		JButton btnAtrás3 = new JButton("");
		btnAtrás3.setBorder(null);
		btnAtrás3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelChat.setVisible(false);
				panelDerecho.setVisible(true);
			}
		});
		panelChat.setLayout(new MigLayout("", "[43px][295px]", "[36px]"));
		btnAtrás3.setBackground(SystemColor.window);
		btnAtrás3.setIcon(logoAtras);
		panelChat.add(btnAtrás3, "cell 0 0,grow");
		
		JLabel lblChatsActivos = new JLabel("Chats activos");
		lblChatsActivos.setBorder(null);
		lblChatsActivos.setBackground(SystemColor.window);
		lblChatsActivos.setForeground(SystemColor.desktop);
		lblChatsActivos.setFont(new Font("SansSerif", Font.PLAIN, 17));
		panelChat.add(lblChatsActivos, "cell 1 0, aligny center, alignx center");
		
		Date fechaYolanda= new Date(121, 4, 6);
		Emprendedor Yolanda = new Emprendedor("Yolanda Castro", "YolandaCastro", "SPO563",fechaYolanda, 305324589, "Tunja", "Famila de campesionos cultivadores de papa", null);
		Date fechaAdmin = new Date(121, 7, 21);
		
		Texto texto_1 = new Texto(usuario, "que pasa mijo", true);
		Texto texto_2 = new Texto(Yolanda, "Nada mijo bien", true);
		ArrayList<Texto> textos = new ArrayList<>();
		textos.add(texto_1);
		textos.add(texto_2);
		Chat chat_1 = new Chat(Yolanda, usuario, false, textos, fechaAdmin);
		ArrayList<Chat> chats1= new ArrayList<>();
		chats1.add(chat_1);
		usuario.setChats(chats1);
		
		ArrayList<Chat> chats = usuario.getChats();
		JButton btnMostrarChats[] = new JButton[chats.size()];
		JPanel panelChatIndividual[] = new JPanel[chats.size()];
		JScrollPane scrollPaneChat[] = new JScrollPane[chats.size()];
		JButton btnAtrás4[] = new JButton[chats.size()];
		JTextField textField[] = new JTextField[chats.size()];
		JButton btnEnviar[] = new JButton[chats.size()];
		JLabel lblNombreChat[] = new JLabel[chats.size()];
		for(int posicion3=0;posicion3<=(chats.size()-1);posicion3++) {
			final int finalPosicion3 = posicion3;
			Chat chatIndividual = chats.get(posicion3);
			btnMostrarChats[posicion3]= new JButton("<html><body>"+chatIndividual.getVendedor().getNombre()+"<br>"+chatIndividual.getFecha()+"<body><html>");
			
			panelChatIndividual[posicion3] = new JPanel();
			panelChatIndividual[posicion3].setBackground(SystemColor.window);
			panelChatIndividual[posicion3].setBounds(576, 7, 339, 438);
			panelCentral.add(panelChatIndividual[posicion3]);
			panelChatIndividual[posicion3].setVisible(false);
			
			scrollPaneChat[posicion3] = new JScrollPane(panelChatIndividual[posicion3]);
			panelChatIndividual[posicion3].setLayout(new MigLayout("", "[5px][290px]", "[][]"));
			scrollPaneChat[posicion3].setBounds(576, 7, 339, 438);
			panelCentral.add(scrollPaneChat[posicion3]);
			scrollPaneChat[posicion3].setVisible(false);
			
			lblNombreChat[posicion3]= new JLabel(chatIndividual.getVendedor().getNombre().toUpperCase());
			lblNombreChat[posicion3].setFont(new Font("SansSerif", Font.PLAIN, 15));
			lblNombreChat[posicion3].setBackground(SystemColor.window);
			lblNombreChat[posicion3].setBorder(new LineBorder(new Color(153, 153, 153)));
			panelChatIndividual[posicion3].add(lblNombreChat[posicion3], "cell 1 0,grow");
			
			btnAtrás4[posicion3] = new JButton("");
			btnAtrás4[posicion3].setBorder(null);
			btnAtrás4[posicion3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelChatIndividual[finalPosicion3].setVisible(false);
					scrollPaneChat[finalPosicion3].setVisible(false);
					panelChat.setVisible(true);
				}
			});
			btnAtrás4[posicion3].setIcon(logoAtras);
			btnAtrás4[posicion3].setBounds(10, 10, 43, 36);
			panelChatIndividual[posicion3].add(btnAtrás4[posicion3], "cell 0 0, grow");
			
			ArrayList<Texto> textoChat =chatIndividual.getTexto();
			if(chatIndividual!=null) {
				Collections.reverse(textoChat);
				JLabel[] lblTextoChat = new JLabel[textoChat.size()];
				for(int posicion5=0;posicion5<=(textoChat.size()-1);posicion5++) {
					
					lblTextoChat[posicion5] = new JLabel(textoChat.get(posicion5).getTexto());
					lblTextoChat[posicion5].setBackground(SystemColor.window);
					lblTextoChat[posicion5].setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblTextoChat[posicion5].setBounds(0, 0, 45, 13);
					if(textoChat.get(posicion5).getPersona().getClass()==Usuario.class) {
						panelChatIndividual[finalPosicion3].add(lblTextoChat[posicion5], "cell 1 "+(String.valueOf(posicion5+1))+", alignx right, aligny center");
					}else {
						panelChatIndividual[finalPosicion3].add(lblTextoChat[posicion5], "cell 1 "+(String.valueOf(posicion5+1))+", alignx left, aligny center");
					}
				}
			}
			
			textField[posicion3] = new JTextField();
			textField[posicion3].addFocusListener(new FocusAdapter() {	
				@Override
				public void focusGained(FocusEvent e) {
					textField[finalPosicion3].setBorder(new LineBorder(new Color(30, 144, 255)));
				}
				public void focusLost(FocusEvent e) {
					textField[finalPosicion3].setBorder(new LineBorder(new Color(153, 153, 153)));
				}
			});
			panelChatIndividual[finalPosicion3].add(textField[posicion3], "flowx, cell 1 "+(textoChat.size()+1)+", growx ,aligny center");
			textField[posicion3].setBackground(SystemColor.window);
			textField[posicion3].setFont(new Font("SansSerif", Font.PLAIN, 15));
			textField[posicion3].setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255))));
			textField[posicion3].setColumns(20);
			
			btnEnviar[posicion3] = new JButton();
			btnEnviar[posicion3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					logica.crearTextosChat(textField[finalPosicion3].getText(), usuario, chatIndividual.getVendedor(), finalPosicion3+(usuario.getChats().get(finalPosicion3).getTexto().size()));
					
					JLabel lblNuevoTexto = new JLabel(textField[finalPosicion3].getText());
					lblNuevoTexto.setBackground(SystemColor.window);
					lblNuevoTexto.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblNuevoTexto.setBounds(0, 0, 45, 13);
					panelChatIndividual[finalPosicion3].add(lblNuevoTexto, "cell 1 "+(String.valueOf(textoChat.size()+usuario.getChats().get(finalPosicion3).getTexto().size()-1)+",alignx right, aligny center"));
					panelChatIndividual[finalPosicion3].add(textField[finalPosicion3], "flowx, cell 1 "+(textoChat.size()+usuario.getChats().get(finalPosicion3).getTexto().size())+", growx, aligny center");
					panelChatIndividual[finalPosicion3].add(btnEnviar[finalPosicion3],"cell 1 "+(textoChat.size()+usuario.getChats().get(finalPosicion3).getTexto().size())+",alignx right,growy");
					textField[finalPosicion3].setText(null);
					panelChatIndividual[finalPosicion3].setVisible(false);
					panelChatIndividual[finalPosicion3].setVisible(true);
					
					logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
					
				}
			});
			ImageIcon enviar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\310193.png");
			Icon logoEnviar = new ImageIcon(chat.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
			btnEnviar[posicion3].setIcon(logoEnviar);
			panelChatIndividual[finalPosicion3].add(btnEnviar[posicion3], "cell 1 "+(textoChat.size()+1)+",alignx right,growy");
			
			btnMostrarChats[posicion3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelChat.setVisible(false);
					panelChatIndividual[finalPosicion3].setVisible(true);
					scrollPaneChat[finalPosicion3].setVisible(true);
					
					System.out.print(panelChatIndividual[finalPosicion3].getComponentCount());
					
					
				}
			});
			btnMostrarChats[posicion3].setFont(new Font("SansSerif", Font.PLAIN, 13));
			btnMostrarChats[posicion3].setBackground(SystemColor.window);
			btnMostrarChats[posicion3].setBorder(new LineBorder(new Color(153, 153, 153)));
			panelChat.add(btnMostrarChats[posicion3], "cell 1 "+(String.valueOf(posicion3+1))+",grow");
		}

		ArrayList<Emprendedor> sugeridos =logica.definirSugerencias(emprendedoresRegistrados);
		JButton[] btnSugeridos = new JButton[sugeridos.size()];
		JPanel[] panelEmprendedor = new JPanel[sugeridos.size()];
		JScrollPane[] scrollPaneEmprendedor = new JScrollPane[sugeridos.size()];
		JLabel[] lblNombre = new JLabel[sugeridos.size()];
		JLabel[] lblinfoEmprendedor = new JLabel[sugeridos.size()];
		JButton[] btnAtrás5 = new JButton[sugeridos.size()];
		
		for(int posicion=0;posicion<=(sugeridos.size()-1);posicion++) {
			btnSugeridos[posicion]= new JButton(logica.infoEmprendedor(sugeridos.get(posicion)));
			
			final int finalPosicion = posicion;
			
			panelEmprendedor[posicion] = new JPanel();
			panelEmprendedor[posicion].setBounds(10, 7, 556, 435);
			panelCentral.add(panelEmprendedor[posicion]);
			panelEmprendedor[posicion].setVisible(false);
			
			scrollPaneEmprendedor[posicion] = new JScrollPane(panelEmprendedor[posicion]);
			panelEmprendedor[posicion].setLayout(new MigLayout("", "[5px][340px][30px]", "[][]"));
			scrollPaneEmprendedor[posicion].setBounds(10, 7, 556, 435);
			panelCentral.add(scrollPaneEmprendedor[posicion]);
			scrollPaneEmprendedor[posicion].setVisible(false);
			
			lblNombre[posicion] = new JLabel(sugeridos.get(posicion).getNombre().toUpperCase());
			panelEmprendedor[posicion].add(lblNombre[posicion], "cell 1 1, alignx left, aligny center");
			lblNombre[posicion].setFont(new Font("SansSerif", Font.BOLD, 25));
			
			lblinfoEmprendedor[posicion] = new JLabel("<html><body>UBICACIÓN: "+sugeridos.get(posicion).getUbicacion()+"<br>DESCRIPCIÓN: "+sugeridos.get(posicion).getDescripcionSituacion()+"<br>CONTACTO:<br>"+sugeridos.get(posicion).getNumeroContacto()+logica.contactoAdicional(sugeridos.get(posicion)));
			panelEmprendedor[posicion].add(lblinfoEmprendedor[posicion], "cell 1 2, alignx left, aligny center");
			lblinfoEmprendedor[posicion].setFont(new Font("SansSerif", Font.PLAIN, 17));
			
			btnAtrás5[posicion] = new JButton();
			btnAtrás5[posicion].setBorder(null);
			btnAtrás5[posicion].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelEmprendedor[finalPosicion].setVisible(false);
					scrollPaneEmprendedor[finalPosicion].setVisible(false);
					panelIzquierdo.setVisible(true);
				}
			});
			btnAtrás5[posicion].setBackground(SystemColor.window);
			btnAtrás5[posicion].setIcon(logoAtras);
			btnAtrás5[posicion].setBounds(10, 10, 43, 36);
			panelEmprendedor[posicion].add(btnAtrás5[posicion], "cell 0 0, grow");
			
			TreeMap<String,Producto> textoEmprendedores =sugeridos.get(posicion).getProductos();
			JLabel[] lblTextoEmprendedores = new JLabel[textoEmprendedores.values().size()];
			JButton[] btnComprar = new JButton[textoEmprendedores.values().size()];
			JButton[] btnNegociar = new JButton[textoEmprendedores.values().size()];
			int indice =0;
			for(Producto producto : textoEmprendedores.values()) {
				lblTextoEmprendedores[indice]= new JLabel("<html><body>Producto(cantidad): "+producto.getNombre()+"<br>"+producto.getPrecioPeso()+"/ $"+producto.getPeso()+"<bod><html>");
				lblTextoEmprendedores[indice].setFont(new Font("SansSerif", Font.PLAIN, 13));
				lblTextoEmprendedores[indice].setBackground(SystemColor.window);
				lblTextoEmprendedores[indice].setBorder(new LineBorder(new Color(153, 153, 153)));
				panelEmprendedor[posicion].add(lblTextoEmprendedores[indice], "cell 1 "+(String.valueOf(indice+3))+",grow");		
				
				btnComprar[indice] = new JButton("Comprar");
				btnComprar[indice].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(framePrincipal, "Gracias por su compra, mantegase en contacto con su vendedor", "Compra exitosa", JOptionPane.INFORMATION_MESSAGE);
						logica.nuevaVenta(producto, producto.getVendedor(), usuario, producto.getPrecioPeso(), new Date());
						
						Venta compra = usuario.getRegistroCompras().get(usuario.getRegistroCompras().size()-1); 
						
						JLabel lblComprasNueva[] = new JLabel[usuario.getRegistroCompras().size()+1];
						lblComprasNueva[usuario.getRegistroCompras().size()]= new JLabel("<html><body>Producto(precio): "+compra.getProductos().getNombre()+"("+String.valueOf(compra.getPrecio())+"/"+compra.getProductos().getPeso()+")<br>Vendedor: "+compra.getVendedor().getNombre()+"<br>Fecha:"+compra.getFecha()+"<bod><html>");
						lblComprasNueva[usuario.getRegistroCompras().size()].setFont(new Font("SansSerif", Font.PLAIN, 13));
						lblComprasNueva[usuario.getRegistroCompras().size()].setBackground(SystemColor.window);
						lblComprasNueva[usuario.getRegistroCompras().size()].setBorder(new LineBorder(new Color(153, 153, 153)));
						panelRegistroCompra.add(lblComprasNueva[usuario.getRegistroCompras().size()], "cell 1 "+(String.valueOf(usuario.getRegistroCompras().size()))+",grow");
						
						logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
						
					}
				});
				btnComprar[indice].setFont(new Font("SansSerif", Font.PLAIN, 15));
				panelEmprendedor[posicion].add(btnComprar[indice], "cell 2 "+(String.valueOf(indice+3))+", grow");
				
				btnNegociar[indice] = new JButton("Negociar");
				btnNegociar[indice].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(panelDerecho.isVisible() == false) {
							if(panelChat.isVisible() == false) {
								for(int posicion7 = 0;posicion7< panelChatIndividual.length;posicion7++) {
									System.out.print("loko");
									if(panelChatIndividual[posicion7].isVisible()) {

										System.out.print("loko");
										panelChatIndividual[posicion7].setVisible(false);
										scrollPaneChat[posicion7].setVisible(false);
									}
								}
								
							}else {
								panelChat.setVisible(false);
							}
						}else {
							panelDerecho.setVisible(false);
						}
						
						logica.crearChat(sugeridos.get(finalPosicion), usuario, false, finalPosicion);
						
						Chat chatNuevo = usuario.getChats().get(usuario.getChats().size()-1);
						
						JPanel panelChatIndividualNuevo = new JPanel();
						panelChatIndividualNuevo.setBackground(SystemColor.window);
						panelChatIndividualNuevo.setBounds(576, 7, 339, 438);
						panelCentral.add(panelChatIndividualNuevo);
						
						JScrollPane scrollPaneChatNuevo = new JScrollPane(panelChatIndividualNuevo);
						panelChatIndividualNuevo.setLayout(new MigLayout("", "[5px][290px]", "[][]"));
						scrollPaneChatNuevo.setBounds(576, 7, 339, 438);
						panelCentral.add(scrollPaneChatNuevo);
						
						JLabel lblNombreChatNuevo= new JLabel(chatNuevo.getVendedor().getNombre().toUpperCase());
						lblNombreChatNuevo.setFont(new Font("SansSerif", Font.PLAIN, 15));
						lblNombreChatNuevo.setBackground(SystemColor.window);
						lblNombreChatNuevo.setBorder(new LineBorder(new Color(153, 153, 153)));
						panelChatIndividualNuevo.add(lblNombreChatNuevo, "cell 1 0,grow");
						
						JButton btnAtrás7 = new JButton("");
						btnAtrás7.setBorder(null);
						btnAtrás7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelChatIndividualNuevo.setVisible(false);
								scrollPaneChatNuevo.setVisible(false);
								panelChat.setVisible(true);
							}
						});
						btnAtrás7.setBackground(SystemColor.window);
						ImageIcon cerrar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\318339.png");
						Icon logoCerrar = new ImageIcon(cerrar.getImage().getScaledInstance(32, 25, Image.SCALE_DEFAULT));
						btnAtrás7.setIcon(logoCerrar);
						btnAtrás7.setBounds(10, 10, 43, 36);
						panelChatIndividualNuevo.add(btnAtrás7, "cell 0 0, grow");
						
						ArrayList<Texto> textoChatNuevo =chatNuevo.getTexto();
						int tamanoTextos = 0;
						if(textoChatNuevo != null) {
							 tamanoTextos = textoChatNuevo.size();
						}
						JTextField textFieldChat = new JTextField();
						textFieldChat.addFocusListener(new FocusAdapter() {	
							@Override
							public void focusGained(FocusEvent e) {
								textFieldChat.setBorder(new LineBorder(new Color(30, 144, 255)));
							}
							public void focusLost(FocusEvent e) {
								textFieldChat.setBorder(new LineBorder(new Color(153, 153, 153)));
							}
						});
						panelChatIndividualNuevo.add(textFieldChat, "flowx, cell 1 "+(tamanoTextos+1)+", growx ,aligny center");
						textFieldChat.setBackground(SystemColor.window);
						textFieldChat.setFont(new Font("SansSerif", Font.PLAIN, 15));
						textFieldChat.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255))));
						textFieldChat.setColumns(20);
						
						final int finalTamano = tamanoTextos;
						
						JButton btnEnviarPrimero = new JButton();
						btnEnviarPrimero.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								logica.crearTextosChat(textFieldChat.getText(), usuario, chatNuevo.getVendedor(), finalTamano);
								if(textFieldChat.getText() != null) {
									
									JLabel lblNuevoTexto = new JLabel(textFieldChat.getText());
									lblNuevoTexto.setBackground(SystemColor.window);
									lblNuevoTexto.setFont(new Font("SansSerif", Font.PLAIN, 15));
									lblNuevoTexto.setBounds(0, 0, 45, 13);
									panelChatIndividualNuevo.add(lblNuevoTexto, "cell 1 "+(String.valueOf(finalTamano+chatNuevo.getTexto().size()-1)+",alignx right, aligny center"));
									panelChatIndividualNuevo.add(textFieldChat, "flowx, cell 1 "+(finalTamano+chatNuevo.getTexto().size())+", growx, aligny center");
									panelChatIndividualNuevo.add(btnEnviarPrimero,"cell 1 "+(finalTamano+chatNuevo.getTexto().size())+",alignx right,growy");
									textFieldChat.setText(null);
									panelChatIndividualNuevo.setVisible(false);
									panelChatIndividualNuevo.setVisible(true);	
									
								}
							}
						});
						ImageIcon enviar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\bin\\Imagenes\\Campo_logo_.png");
						Icon logoEnviar = new ImageIcon(chat.getImage().getScaledInstance(10, 1, Image.SCALE_DEFAULT));
						btnEnviarPrimero.setIcon(logoEnviar);
						panelChatIndividualNuevo.add(btnEnviarPrimero, "cell 1 "+(tamanoTextos+1)+",alignx right,growy");
						
						logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
						
					}
				});
				btnNegociar[indice].setFont(new Font("SansSerif", Font.PLAIN, 15));
				panelEmprendedor[posicion].add(btnNegociar[indice], "cell 3 "+(String.valueOf(indice+3))+", grow");
				
				indice += 1;
			}
			
			btnSugeridos[posicion].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelIzquierdo.setVisible(false);
					panelEmprendedor[finalPosicion].setVisible(true);
					scrollPaneEmprendedor[finalPosicion].setVisible(true);
				}
			});
			panelIzquierdo.add(btnSugeridos[posicion], "cell 1 "+(String.valueOf(posicion+1))+",grow");
			btnSugeridos[posicion].setFont(new Font("SansSerif", Font.PLAIN, 16));
			
		}
		
		
		JButton btnAccionBuscar = new JButton();
		btnAccionBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResultados.setVisible(false);
				panelResultados.removeAll();
				ArrayList<Emprendedor> buscados =logica.buscar(tipoBusqueda, textFieldBuscar.getText(), emprendedoresRegistrados);
				JButton[] btnBuscados = new JButton[buscados.size()];
				JPanel[] panelEmprendedorBuscado = new JPanel[buscados.size()];
				JScrollPane[] scrollPaneEmprendedorBuscado = new JScrollPane[buscados.size()];
				JLabel[] lblNombreBuscado = new JLabel[buscados.size()];
				JLabel[] lblinfoEmprendedorBuscado = new JLabel[buscados.size()];
				JButton[] btnAtrás5Buscado = new JButton[buscados.size()];
				
				for(int posicion1=0;posicion1<=(buscados.size()-1);posicion1++) {
					
					final int finalPosicion1 = posicion1;
	
					
					panelEmprendedorBuscado[posicion1] = new JPanel();
					panelEmprendedorBuscado[posicion1].setBounds(10, 7, 556, 435);
					panelCentral.add(panelEmprendedorBuscado[posicion1]);
					panelEmprendedorBuscado[posicion1].setVisible(false);
					
					scrollPaneEmprendedorBuscado[posicion1] = new JScrollPane(panelEmprendedorBuscado[posicion1]);
					panelEmprendedorBuscado[posicion1].setLayout(new MigLayout("", "[5px][340px][30px]", "[][]"));
					scrollPaneEmprendedorBuscado[posicion1].setBounds(10, 7, 556, 435);
					panelCentral.add(scrollPaneEmprendedorBuscado[posicion1]);
					scrollPaneEmprendedorBuscado[posicion1].setVisible(false);
					
					lblNombreBuscado[posicion1] = new JLabel(buscados.get(posicion1).getNombre().toUpperCase());
					panelEmprendedorBuscado[posicion1].add(lblNombreBuscado[posicion1], "cell 1 1, alignx left, aligny center");
					lblNombreBuscado[posicion1].setFont(new Font("SansSerif", Font.BOLD, 25));
					
					lblinfoEmprendedorBuscado[posicion1] = new JLabel("<html><body>UBICACIÓN: "+buscados.get(posicion1).getUbicacion()+"<br>DESCRIPCIÓN: "+buscados.get(posicion1).getDescripcionSituacion()+"<br>CONTACTO:<br>"+buscados.get(posicion1).getNumeroContacto()+logica.contactoAdicional(buscados.get(posicion1)));
					panelEmprendedorBuscado[posicion1].add(lblinfoEmprendedorBuscado[posicion1], "cell 1 2, alignx left, aligny center");
					lblinfoEmprendedorBuscado[posicion1].setFont(new Font("SansSerif", Font.PLAIN, 17));
					
					btnAtrás5Buscado[posicion1] = new JButton();
					btnAtrás5Buscado[posicion1].setBorder(null);
					btnAtrás5Buscado[posicion1].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panelEmprendedorBuscado[finalPosicion1].setVisible(false);
							scrollPaneEmprendedorBuscado[finalPosicion1].setVisible(false);
							panelIzquierdo.setVisible(true);
						}
					});
					btnAtrás5Buscado[posicion1].setBackground(SystemColor.window);
					btnAtrás5Buscado[posicion1].setIcon(logoAtras);
					btnAtrás5Buscado[posicion1].setBounds(10, 10, 43, 36);
					panelEmprendedorBuscado[posicion1].add(btnAtrás5Buscado[posicion1], "cell 0 0, grow");
					
					TreeMap<String,Producto> textoEmprendedores =buscados.get(posicion1).getProductos();
					JLabel[] lblTextoEmprendedoresBuscado = new JLabel[textoEmprendedores.values().size()];
					JButton[] btnComprarBuscado = new JButton[textoEmprendedores.values().size()];
					JButton[] btnNegociarBuscado = new JButton[textoEmprendedores.values().size()];
					int indice1 =0;
					for(Producto producto : textoEmprendedores.values()) {
						lblTextoEmprendedoresBuscado[indice1]= new JLabel("<html><body>Producto(cantidad): "+producto.getNombre()+"<br>"+producto.getPrecioPeso()+"/ $"+producto.getPeso()+"<bod><html>");
						lblTextoEmprendedoresBuscado[indice1].setFont(new Font("SansSerif", Font.PLAIN, 13));
						lblTextoEmprendedoresBuscado[indice1].setBackground(SystemColor.window);
						lblTextoEmprendedoresBuscado[indice1].setBorder(new LineBorder(new Color(153, 153, 153)));
						panelEmprendedorBuscado[posicion1].add(lblTextoEmprendedoresBuscado[indice1], "cell 1 "+(String.valueOf(indice1+3))+",grow");		
						
						btnComprarBuscado[indice1] = new JButton("Comprar");
						btnComprarBuscado[indice1].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JOptionPane.showMessageDialog(framePrincipal, "Gracias por su compra, mantegase en contacto con su vendedor", "Compra exitosa", JOptionPane.INFORMATION_MESSAGE);
								logica.nuevaVenta(producto, producto.getVendedor(), usuario, producto.getPrecioPeso(), new Date());
								
								Venta compra = usuario.getRegistroCompras().get(usuario.getRegistroCompras().size()-1); 
								
								JLabel lblComprasNuevaBuscado[] = new JLabel[usuario.getRegistroCompras().size()+1];
								lblComprasNuevaBuscado[usuario.getRegistroCompras().size()]= new JLabel("<html><body>Producto(precio): "+compra.getProductos().getNombre()+"("+String.valueOf(compra.getPrecio())+"/"+compra.getProductos().getPeso()+")<br>Vendedor: "+compra.getVendedor().getNombre()+"<br>Fecha:"+compra.getFecha()+"<bod><html>");
								lblComprasNuevaBuscado[usuario.getRegistroCompras().size()].setFont(new Font("SansSerif", Font.PLAIN, 13));
								lblComprasNuevaBuscado[usuario.getRegistroCompras().size()].setBackground(SystemColor.window);
								lblComprasNuevaBuscado[usuario.getRegistroCompras().size()].setBorder(new LineBorder(new Color(153, 153, 153)));
								panelRegistroCompra.add(lblComprasNuevaBuscado[usuario.getRegistroCompras().size()], "cell 1 "+(String.valueOf(usuario.getRegistroCompras().size()))+",grow");
								
								logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
								
							}
						});
						btnComprarBuscado[indice1].setFont(new Font("SansSerif", Font.PLAIN, 15));
						panelEmprendedorBuscado[posicion1].add(btnComprarBuscado[indice1], "cell 2 "+(String.valueOf(indice1+3))+", grow");
						
						btnNegociarBuscado[indice1] = new JButton("Negociar");
						btnNegociarBuscado[indice1].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								panelBuscar.setVisible(false);
								
								logica.crearChat(buscados.get(finalPosicion1), usuario, false, finalPosicion1);
								
								Chat chatNuevoBuscado = usuario.getChats().get(usuario.getChats().size()-1);
								
								JPanel panelChatIndividualBuscado = new JPanel();
								panelChatIndividualBuscado.setBackground(SystemColor.window);
								panelChatIndividualBuscado.setBounds(576, 7, 339, 438);
								panelCentral.add(panelChatIndividualBuscado);
								
								JScrollPane scrollPaneChatBuscado = new JScrollPane(panelChatIndividualBuscado);
								panelChatIndividualBuscado.setLayout(new MigLayout("", "[5px][290px]", "[][]"));
								scrollPaneChatBuscado.setBounds(576, 7, 339, 438);
								panelCentral.add(scrollPaneChatBuscado);
								
								JLabel lblNombreChatBuscado= new JLabel(chatNuevoBuscado.getVendedor().getNombre().toUpperCase());
								lblNombreChatBuscado.setFont(new Font("SansSerif", Font.PLAIN, 15));
								lblNombreChatBuscado.setBackground(SystemColor.window);
								lblNombreChatBuscado.setBorder(new LineBorder(new Color(153, 153, 153)));
								panelChatIndividualBuscado.add(lblNombreChatBuscado, "cell 1 0,grow");
								
								JButton btnAtrás8 = new JButton("");
								btnAtrás8.setBorder(null);
								btnAtrás8.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panelChatIndividualBuscado.setVisible(false);
										scrollPaneChatBuscado.setVisible(false);
										panelDerecho.setVisible(true);
									}
								});
								btnAtrás8.setBackground(SystemColor.window);
								ImageIcon cerrar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\318339.png");
								Icon logoCerrar = new ImageIcon(cerrar.getImage().getScaledInstance(32, 25, Image.SCALE_DEFAULT));
								btnAtrás8.setIcon(logoCerrar);
								btnAtrás8.setBounds(10, 10, 43, 36);
								panelChatIndividualBuscado.add(btnAtrás8, "cell 0 0, grow");
								
								ArrayList<Texto> textoChatNuevo =chatNuevoBuscado.getTexto();
								int tamanoTextos = 0;
								if(textoChatNuevo != null) {
									 tamanoTextos = textoChatNuevo.size();
								}
								JTextField textFieldChatBuscado = new JTextField();
								textFieldChatBuscado.addFocusListener(new FocusAdapter() {	
									@Override
									public void focusGained(FocusEvent e) {
										textFieldChatBuscado.setBorder(new LineBorder(new Color(30, 144, 255)));
									}
									public void focusLost(FocusEvent e) {
										textFieldChatBuscado.setBorder(new LineBorder(new Color(153, 153, 153)));
									}
								});
								panelChatIndividualBuscado.add(textFieldChatBuscado, "flowx, cell 1 "+(tamanoTextos+1)+", growx ,aligny center");
								textFieldChatBuscado.setBackground(SystemColor.window);
								textFieldChatBuscado.setFont(new Font("SansSerif", Font.PLAIN, 15));
								textFieldChatBuscado.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255))));
								textFieldChatBuscado.setColumns(20);
								
								final int finalTamano = tamanoTextos;
								
								JButton btnEnviarBuscado = new JButton();
								btnEnviarBuscado.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										logica.crearTextosChat(textFieldChat.getText(), usuario, chatNuevoBuscado.getVendedor(), finalTamano);
										if(textFieldChat.getText() != null) {
											
											JLabel lblNuevoTexto = new JLabel(textFieldChat.getText());
											lblNuevoTexto.setBackground(SystemColor.window);
											lblNuevoTexto.setFont(new Font("SansSerif", Font.PLAIN, 15));
											lblNuevoTexto.setBounds(0, 0, 45, 13);
											panelChatIndividualBuscado.add(lblNuevoTexto, "cell 1 "+(String.valueOf(finalTamano+chatNuevoBuscado.getTexto().size()-1)+",alignx right, aligny center"));
											panelChatIndividualBuscado.add(textFieldChat, "flowx, cell 1 "+(finalTamano+chatNuevoBuscado.getTexto().size())+", growx, aligny center");
											panelChatIndividualBuscado.add(btnEnviarBuscado,"cell 1 "+(finalTamano+chatNuevoBuscado.getTexto().size())+",alignx right,growy");
											textFieldChat.setText(null);
											panelChatIndividualBuscado.setVisible(false);
											panelChatIndividualBuscado.setVisible(true);	
											
										}
									}
								});
								ImageIcon enviar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\bin\\Imagenes\\Campo_logo_.png");
								Icon logoEnviar = new ImageIcon(chat.getImage().getScaledInstance(10, 1, Image.SCALE_DEFAULT));
								btnEnviarBuscado.setIcon(logoEnviar);
								panelChatIndividualBuscado.add(btnEnviarBuscado, "cell 1 "+(tamanoTextos+1)+",alignx right,growy");
								
								logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
								
							}
						});
						btnNegociarBuscado[indice1].setFont(new Font("SansSerif", Font.PLAIN, 15));
						panelEmprendedorBuscado[posicion1].add(btnNegociarBuscado[indice1], "cell 3 "+(String.valueOf(indice1+3))+", grow");
						
						indice1 += 1;
					}
					btnBuscados[posicion1]= new JButton(logica.infoEmprendedor(buscados.get(posicion1)));
					btnBuscados[posicion1].setFont(new Font("SansSerif", Font.PLAIN, 13));
					btnBuscados[posicion1].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							panelIzquierdo.setVisible(false);
							panelEmprendedorBuscado[finalPosicion1].setVisible(true);
							scrollPaneEmprendedorBuscado[finalPosicion1].setVisible(true);	
								
						}
					});
					panelResultados.add(btnBuscados[posicion1], "cell 0 "+(String.valueOf(posicion1))+",grow");
				}
				panelResultados.setVisible(true);
			}
		});
		Icon logoAccionBusqueda = new ImageIcon(buscar.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT));
		btnAccionBuscar.setIcon(logoAccionBusqueda);
		btnAccionBuscar.setBounds(296, 32, 33, 30);
		panelBuscar.add(btnAccionBuscar);
		
		
		JLabel lblMarca = new JLabel("Juan Sebastian Sarmiento- Daniel Alejandro Acosta");
		lblMarca.setBackground(SystemColor.window);
		lblMarca.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelPrincipal.add(lblMarca, "flowx,cell 0 2,alignx left,aligny center");
			
	}
}

