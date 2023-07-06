package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.TreeMap;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import datos.Chat;
import datos.Emprendedor;
import datos.Producto;
import datos.Texto;
import datos.Usuario;
import datos.Venta;
import logica.logica;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class principalEmprendedor {

	private JFrame frameEmprendedor;
	private JTextField textFieldNombre;
	private JTextField textFieldPeso;
	private JTextField textFieldPrecio;

	/**
	 * Launch the application.
	 */
	public static void activarEmprendedor(String emprendedor, ArrayList<Emprendedor> emprendedoresRegistrados, ArrayList<Usuario> usuariosRegistrados) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principalEmprendedor window = new principalEmprendedor(emprendedor, emprendedoresRegistrados, usuariosRegistrados);
					window.frameEmprendedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public principalEmprendedor(String emprendedor, ArrayList<Emprendedor> emprendedoresRegistrados, ArrayList<Usuario> usuariosRegistrados) {
		Emprendedor emprendedor1 =logica.buscarEmprendedor(emprendedor, emprendedoresRegistrados);
		initialize(emprendedor1, emprendedoresRegistrados, usuariosRegistrados);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Emprendedor emprendedor, ArrayList<Emprendedor> emprendedoresRegistrados, ArrayList<Usuario> usuariosRegistrados) {
		frameEmprendedor = new JFrame();
		frameEmprendedor.getContentPane().setBackground(SystemColor.window);
		frameEmprendedor.setBackground(Color.WHITE);
		frameEmprendedor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		frameEmprendedor.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\bin\\Imagenes\\Campo_logo_.png"));
		frameEmprendedor.setTitle("EL CAMPO\r\n");
		frameEmprendedor.setBounds(300, 100, 950, 600);
		frameEmprendedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEmprendedor.getContentPane().setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.window);
		panelPrincipal.setBounds(0, 0, 936, 563);
		frameEmprendedor.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new MigLayout("", "[936px,grow]", "[75px,grow][460px,grow][30px]"));
	
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.window);
		panelPrincipal.add(panelSuperior, "cell 0 0,grow");
		panelSuperior.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><body>Emprendedor:<br>"+emprendedor.getNombre()+"<body><html>");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.window);
		lblNewLabel.setBounds(10, 10, 190, 47);
		panelSuperior.add(lblNewLabel);
		
		JLabel logo = new JLabel("New label");
		logo.setBackground(SystemColor.window);
		logo.setBounds(572, 10, 45, 47);
		ImageIcon imagen = new ImageIcon(PrincipalUsuario.class.getResource("/Imagenes/Campo_logo_.png"));
		Icon logoImagen = new ImageIcon(imagen.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
		logo.setIcon(logoImagen);
		panelSuperior.add(logo);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesi\u00F3n   ");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEmprendedor.dispose();
				GUI_Proyecto.main(null);
			}
		});
		btnCerrarSesion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnCerrarSesion.setBounds(767, 10, 145, 47);
		ImageIcon cerrarSesion = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\565503.png");
		Icon logoCerrarSesion = new ImageIcon(cerrarSesion.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		btnCerrarSesion.setIcon(logoCerrarSesion);
		btnCerrarSesion.setVerticalTextPosition(AbstractButton.CENTER);
		btnCerrarSesion.setHorizontalTextPosition(AbstractButton.LEADING);
		panelSuperior.add(btnCerrarSesion);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(SystemColor.window);
		panelPrincipal.add(panelCentral, "cell 0 1,grow");
		panelCentral.setLayout(null);
		
		JPanel panelDerecho = new JPanel();
		panelDerecho.setBackground(SystemColor.window);
		panelDerecho.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Funciones", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDerecho.setBounds(576, 7, 339, 438);
		panelCentral.add(panelDerecho);
		panelDerecho.setLayout(new MigLayout("", "[400px]", "[][155px][155px][155px]"));
		
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setBackground(SystemColor.window);
		panelIzquierdo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Perfil", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelIzquierdo.setBounds(10, 7, 556, 435);
		panelCentral.add(panelIzquierdo);
		panelIzquierdo.setLayout(new MigLayout("", "[20px][500px][20px]", "[40px][43px][43px][43px][43px][43px][43px][43px][43px]"));
		
		JLabel lblPerfil = new JLabel("Vista usuario:");
		lblPerfil.setBackground(SystemColor.window);
		lblPerfil.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelIzquierdo.add(lblPerfil, "cell 1 0,alignx left,aligny center");
		
		JLabel lblInfo = new JLabel("<html><body>"+emprendedor.getNombre().toUpperCase()+"<br>Ubicacion: "+emprendedor.getUbicacion()+"<br>Descripcion: "+emprendedor.getDescripcionSituacion()+"<body><html>");
		lblInfo.setBackground(SystemColor.window);
		lblInfo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panelIzquierdo.add(lblInfo, "cell 1 1,alignx left,aligny center");
		
		TreeMap<String, Producto> productos = emprendedor.getProductos();
		JLabel[] lblInfoProducto = new JLabel[productos.values().size()];
		JButton[] btnEliminarProducto = new JButton[productos.values().size()];
		
		int indice1 = 0;
		for(Producto producto: productos.values()) {
			
			final int finalIndice1 = indice1;
			
			lblInfoProducto[indice1] = new JLabel("<html><body>"+producto.getNombre()+"("+producto.getSeccion()+")"+"<br>"+producto.getPeso()+" gramos/"+producto.getPrecioPeso()+"pesos<body><html>");
			lblInfoProducto[indice1].setBackground(SystemColor.window);
			lblInfoProducto[indice1].setFont(new Font("SansSerif", Font.PLAIN, 18));
			panelIzquierdo.add(lblInfoProducto[indice1], "growx, cell 1 "+(String.valueOf(indice1+2))+", grow,aligny center");
			
			btnEliminarProducto[indice1] = new JButton("Eliminar");
			btnEliminarProducto[indice1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] opciones = {"Eliminar", "Cancelar"};
					int confirmacion = JOptionPane.showOptionDialog(frameEmprendedor, "¿Está seguro de eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
					if (confirmacion == 0) {
						panelIzquierdo.remove(lblInfoProducto[finalIndice1]);
						panelIzquierdo.remove(btnEliminarProducto[finalIndice1]);
						emprendedor.getProductos().remove(producto.getNombre());
						panelIzquierdo.setVisible(false);
						panelIzquierdo.setVisible(true);
						
						logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
						
					}
				}
			});
			btnEliminarProducto[indice1].setFont(new Font("SansSerif", Font.PLAIN, 17));
			ImageIcon eliminar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\3484363.png");
			Icon logoEliminar = new ImageIcon(eliminar.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
			btnEliminarProducto[indice1].setIcon(logoEliminar);
			panelIzquierdo.add(btnEliminarProducto[indice1], "cell 1 "+(String.valueOf(indice1+2))+",alignx right,aligny center");
			btnEliminarProducto[indice1].setLayout(null);
			
			indice1 ++;
		}
		
		JPanel panelAgregar = new JPanel();
		panelAgregar.setBackground(SystemColor.window);
		panelAgregar.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Agregar", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAgregar.setLayout(new MigLayout("", "[][300px]", "[10px][][10px][][][10px][][][10px][][10px]"));
		panelAgregar.setBounds(576, 7, 339, 438);
		panelCentral.add(panelAgregar);
		panelAgregar.setVisible(false);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(SystemColor.window);
		panelRegistro.setBounds(576, 7, 339, 438);
		panelRegistro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Agregar", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRegistro.setLayout(new MigLayout("", "[5px][295px]", "[][]"));
		panelCentral.add(panelRegistro);
		panelRegistro.setVisible(false);
		
		JScrollPane scrollPane_1 = new JScrollPane(panelRegistro);
		scrollPane_1.setBounds(576, 7, 339, 438);
		panelCentral.add(scrollPane_1);
		scrollPane_1.setVisible(false);
		
		JPanel panelChat = new JPanel();
		panelChat.setBackground(SystemColor.window);
		panelChat.setBounds(576, 7, 339, 438);
		panelChat.setBorder(new LineBorder(new Color(153, 153, 153)));
		panelCentral.add(panelChat);
		panelChat.setVisible(false);

		JButton btnAgregar = new JButton(" Agregar productos");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDerecho.setVisible(false);
				panelAgregar.setVisible(true);
			}
		});
		btnAgregar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		ImageIcon buscar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\45156.png");
		Icon logoBuscar = new ImageIcon(buscar.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		btnAgregar.setIcon(logoBuscar);
		panelDerecho.add(btnAgregar, "cell 0 1,alignx center,aligny center");
		btnAgregar.setLayout(null);
		
		JButton btnAtrás = new JButton("");
		btnAtrás.setBorder(null);
		btnAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregar.setVisible(false);
				
				panelDerecho.setVisible(true);
			}
		});
		btnAtrás.setBackground(SystemColor.window);
		ImageIcon atras = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\318339.png");
		Icon logoAtras = new ImageIcon(atras.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		btnAtrás.setIcon(logoAtras);
		btnAtrás.setBounds(0, -7, 35, 35);
		panelAgregar.add(btnAtrás, "cell 0 0,alignx left,aligny top");
		
		JLabel lblAgregar = new JLabel("Agregar nuevos productos");
		lblAgregar.setBackground(SystemColor.window);
		lblAgregar.setFont(new Font("SansSerif", Font.PLAIN, 20));
		panelAgregar.add(lblAgregar, "cell 1 0,alignx left,aligny center");
		
		JLabel lblInstrucciones = new JLabel("<html><body>Rellene por favor<br>todos los espacios<body><html>");
		lblInstrucciones.setBackground(SystemColor.window);
		lblInstrucciones.setFont(new Font("SansSerif", Font.PLAIN, 17));
		panelAgregar.add(lblInstrucciones, "cell 1 1,alignx center,aligny center");
		
		JLabel lblNombre = new JLabel("Nombre del producto");
		lblNombre.setBackground(SystemColor.window);
		lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 17));
		panelAgregar.add(lblNombre, "cell 1 3,alignx left,aligny center");
		
		textFieldNombre = new JTextField();
		panelAgregar.add(textFieldNombre, "cell 1 4, grow");
		textFieldNombre.setFont(new Font("SansSerif", Font.PLAIN, 17));
		textFieldNombre.setColumns(5);
		
		JLabel lblPeso = new JLabel("Peso del producto (Gramos)");
		lblPeso.setBackground(SystemColor.window);
		lblPeso.setFont(new Font("SansSerif", Font.PLAIN, 17));
		panelAgregar.add(lblPeso, "cell 1 6,alignx left,aligny center");
		
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
		panelAgregar.add(textFieldPeso, "cell 1 7, grow");
		textFieldPeso.setColumns(5);
		
		JLabel lblPercio = new JLabel("<html><body>Precio del producto<br>de acuerdo a su peso (Pesos)<body><html>");
		lblPercio.setBackground(SystemColor.window);
		lblPercio.setFont(new Font("SansSerif", Font.PLAIN, 17));
		panelAgregar.add(lblPercio, "cell 1 9,alignx left,aligny center");
		
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
		panelAgregar.add(textFieldPrecio, "cell 1 10, grow");
		textFieldPrecio.setFont(new Font("SansSerif", Font.PLAIN, 17));
		textFieldPrecio.setColumns(5);
		
		JComboBox comboBoxSeccion = new JComboBox();
		comboBoxSeccion.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxSeccion.setModel(new DefaultComboBoxModel(new String[] {"Sección del producto","Vegetal", "Fruta", "Bebida", "Carnico", "Otro"}));
		comboBoxSeccion.setSelectedIndex(0);
		comboBoxSeccion.setFont(new Font("SansSerif", Font.PLAIN, 17));
		panelAgregar.add(comboBoxSeccion, "cell 1 12, grow");
		
		JButton btnAccionAgregar = new JButton();
		btnAccionAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(logica.validarAgregar(textFieldNombre.getText(),textFieldPeso.getText(), textFieldPrecio.getText(), comboBoxSeccion.getSelectedItem())) {
					logica.agregarProducto(emprendedor, textFieldNombre.getText(),textFieldPeso.getText(), textFieldPrecio.getText(), comboBoxSeccion.getSelectedItem());

					TreeMap<String, Producto> productosNuevo = emprendedor.getProductos();
					Producto productoNuevo = productosNuevo.get(textFieldNombre.getText());
					JLabel[] lblInfoProductoNuevo = new JLabel[productosNuevo.values().size()];
					JButton[] btnEliminarProductoNuevo = new JButton[productosNuevo.values().size()];
					
					int indice =productosNuevo.values().size()-1;
					System.out.print(indice);
					
					final int indiceFinal = indice;
					lblInfoProductoNuevo[indice] = new JLabel("<html><body>"+productoNuevo.getNombre()+"("+productoNuevo.getSeccion()+")"+"<br>"+productoNuevo.getPeso()+" gramos/"+productoNuevo.getPrecioPeso()+"pesos<body><html>");
					lblInfoProductoNuevo[indice].setBackground(SystemColor.window);
					lblInfoProductoNuevo[indice].setFont(new Font("SansSerif", Font.PLAIN, 18));
					panelIzquierdo.add(lblInfoProductoNuevo[indice], "growx, cell 1 "+(String.valueOf(indice+2))+", grow,aligny center");
						
					btnEliminarProductoNuevo[indice] = new JButton("Eliminar");
					btnEliminarProductoNuevo[indice].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String[] opciones = {"Eliminar", "Cancelar"};
							int confirmacion = JOptionPane.showOptionDialog(frameEmprendedor, "¿Está seguro de eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
							if (confirmacion == 0) {
								panelIzquierdo.remove(lblInfoProductoNuevo[indiceFinal]);
								panelIzquierdo.remove(btnEliminarProductoNuevo[indiceFinal]);
								emprendedor.getProductos().remove(productoNuevo.getNombre());
								panelIzquierdo.setVisible(false);
								panelIzquierdo.setVisible(true);
								
								logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
							}
						}
					});
					btnEliminarProductoNuevo[indice].setFont(new Font("SansSerif", Font.PLAIN, 17));
					ImageIcon eliminar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\3484363.png");
					Icon logoEliminar = new ImageIcon(eliminar.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
					btnEliminarProductoNuevo[indice].setIcon(logoEliminar);
					panelIzquierdo.add(btnEliminarProductoNuevo[indice], "cell 1 "+(String.valueOf(indice+2))+",alignx right,aligny center");
					btnEliminarProductoNuevo[indice].setLayout(null);
					
					logica.guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
					
					panelIzquierdo.setVisible(false);
					panelIzquierdo.setVisible(true);
					
					panelAgregar.setVisible(false);
					panelDerecho.setVisible(true);
				
				}else {
					JOptionPane.showMessageDialog(frameEmprendedor, "Revise los datos ingresados", "Falla agregacion", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		ImageIcon agregar = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\45156.png");
		Icon logoAgregar = new ImageIcon(agregar.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		btnAccionAgregar.setIcon(logoAgregar);
		btnAccionAgregar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		panelAgregar.add(btnAccionAgregar, "cell 1 14,alignx right,aligny center");
		
		JButton btnRegistro = new JButton("Registro de ventas");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDerecho.setVisible(false);
				panelRegistro.setVisible(true);
				scrollPane_1.setVisible(true);
			}
		});
		btnRegistro.setFont(new Font("SansSerif", Font.PLAIN, 17));
		ImageIcon registro = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\3534124.png");
		Icon logoRegistro = new ImageIcon(registro.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		btnRegistro.setIcon(logoRegistro);
		panelDerecho.add(btnRegistro, "cell 0 2,alignx center,aligny center");
		btnRegistro.setLayout(null);
		
		JButton btnAtrás1 = new JButton("");
		btnAtrás1.setBorder(null);
		btnAtrás1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistro.setVisible(false);
				panelDerecho.setVisible(true);
			}
		});
		btnAtrás1.setBackground(SystemColor.window);
		btnAtrás1.setIcon(logoAtras);
		btnAtrás1.setBounds(10, 10, 43, 36);
		panelRegistro.add(btnAtrás1, "cell 0 0, grow");
		
		ArrayList<Venta> registroVentas =emprendedor.getVentas();
		if(registroVentas!= null) {
			JLabel[] lblVentas = new JLabel[registroVentas.size()];
			for(int indice2=0;indice2<(registroVentas.size());indice2++) {
				
				Venta venta = registroVentas.get(indice2);
				
				lblVentas[indice2]= new JLabel("<html><body>Producto(cantidad): "+venta.getProductos().getNombre()+"("+String.valueOf(venta.getPrecio())+")<br>Vendedor: "+venta.getComprador().getNombre()+"<br>Fecha:"+venta.getFecha()+"<bod><html>");
				lblVentas[indice2].setFont(new Font("SansSerif", Font.PLAIN, 13));
				lblVentas[indice2].setBackground(SystemColor.window);
				lblVentas[indice2].setBorder(new LineBorder(new Color(153, 153, 153)));
				panelRegistro.add(lblVentas[indice2], "cell 1 "+(String.valueOf(indice2))+",grow");
			}
		}
		
		JButton btnChat = new JButton("Chat");
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDerecho.setVisible(false);
				panelChat.setVisible(true);
			}
		});
		btnChat.setFont(new Font("SansSerif", Font.PLAIN, 17));
		ImageIcon chat = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\Proyecto\\src\\Imagenes\\chat-2047240-1730135.png");
		Icon logoChat = new ImageIcon(chat.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		btnChat.setIcon(logoChat);
		panelDerecho.add(btnChat, "cell 0 3,alignx center,aligny center");
		btnChat.setLayout(null);
		
		JButton btnAtrás2 = new JButton("");
		btnAtrás2.setBorder(null);
		btnAtrás2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelChat.setVisible(false);
				panelDerecho.setVisible(true);
			}
		});
		btnAtrás2.setBackground(SystemColor.window);
		panelChat.setLayout(new MigLayout("", "[43px][295px]", "[36px]"));
		btnAtrás2.setIcon(logoAtras);
		panelChat.add(btnAtrás2, "cell 0 0, grow");
		
		JLabel lblChatsActivos = new JLabel("Chats activos");
		lblChatsActivos.setBorder(null);
		lblChatsActivos.setBackground(SystemColor.window);
		lblChatsActivos.setForeground(SystemColor.desktop);
		lblChatsActivos.setFont(new Font("SansSerif", Font.PLAIN, 17));
		panelChat.add(lblChatsActivos, "cell 1 0, aligny center, alignx center");
		
		Date fechaAdmin = new Date(121, 7, 21);
		Usuario admin = new Usuario("Juan Sarmiento", "admin1", "admin123", fechaAdmin, 12345678);
		
		Texto texto_1 = new Texto(emprendedor, "que pasa mijo", true);
		Texto texto_2 = new Texto(admin, "Nada mijo bien", true);
		ArrayList<Texto> textos = new ArrayList<>();
		textos.add(texto_1);
		textos.add(texto_2);
		Chat chat_1 = new Chat(emprendedor, admin, false, textos, fechaAdmin);
		ArrayList<Chat> chats1= new ArrayList<>();
		chats1.add(chat_1);
		emprendedor.setChats(chats1);
		
		ArrayList<Chat> chats = emprendedor.getChats();
		JButton btnMostrarChats[] = new JButton[chats.size()];
		JPanel panelChatIndividual[] = new JPanel[chats.size()];
		JScrollPane scrollPaneChat[] = new JScrollPane[chats.size()];
		JButton btnAtrás4[] = new JButton[chats.size()];
		JTextField textField[] = new JTextField[chats.size()];
		JButton btnEnviar[] = new JButton[chats.size()];
		for(int posicion3=0;posicion3<=(chats.size()-1);posicion3++) {
			final int finalPosicion3 = posicion3;
			Chat chatIndividual = chats.get(posicion3);
			btnMostrarChats[posicion3]= new JButton("<html><body>"+chatIndividual.getComprador().getNombre()+"<br>"+chatIndividual.getFecha()+"<body><html>");
			
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
			
			btnAtrás4[posicion3] = new JButton("");
			btnAtrás4[posicion3].setBorder(null);
			btnAtrás4[posicion3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelChatIndividual[finalPosicion3].setVisible(false);
					scrollPaneChat[finalPosicion3].setVisible(false);
					panelChat.setVisible(true);
				}
			});
			btnAtrás4[posicion3].setBackground(SystemColor.window);
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
						panelChatIndividual[finalPosicion3].add(lblTextoChat[posicion5], "cell 1 "+(String.valueOf(posicion5+1))+", alignx left, aligny center");
					}else {
						panelChatIndividual[finalPosicion3].add(lblTextoChat[posicion5], "cell 1 "+(String.valueOf(posicion5+1))+", alignx right, aligny center");
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
					
					logica.crearTextosChat(textField[finalPosicion3].getText(), emprendedor, chatIndividual.getVendedor(), finalPosicion3+(emprendedor.getChats().get(finalPosicion3).getTexto().size()));
					
					JLabel lblNuevoTexto = new JLabel(textField[finalPosicion3].getText());
					lblNuevoTexto.setBackground(SystemColor.window);
					lblNuevoTexto.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblNuevoTexto.setBounds(0, 0, 45, 13);
					panelChatIndividual[finalPosicion3].add(lblNuevoTexto, "cell 1 "+(String.valueOf(textoChat.size()+emprendedor.getChats().get(finalPosicion3).getTexto().size()-1)+",alignx right, aligny center"));
					panelChatIndividual[finalPosicion3].add(textField[finalPosicion3], "flowx, cell 1 "+(textoChat.size()+emprendedor.getChats().get(finalPosicion3).getTexto().size())+", growx, aligny center");
					panelChatIndividual[finalPosicion3].add(btnEnviar[finalPosicion3],"cell 1 "+(textoChat.size()+emprendedor.getChats().get(finalPosicion3).getTexto().size())+",alignx right,growy");
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
		
	}
}
