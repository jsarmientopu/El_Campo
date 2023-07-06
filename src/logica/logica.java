package logica;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TreeMap;
import javax.swing.JButton;
import datos.Persona;
import datos.Producto;
import datos.Recompensa;
import datos.Texto;
import datos.Usuario;
import datos.Chat;
import datos.Emprendedor;
import datos.Producto;
import datos.Venta;

public class logica {
	
	public static Usuario buscarUsuario(String usuario, ArrayList<Usuario> usuariosRegistrados) {
		
		for(Usuario usuarioRegistrado :usuariosRegistrados) {
			if(usuarioRegistrado.getUsuario().equals(usuario)){
				return usuarioRegistrado;
			}
			
		}
		return null;
	}
	
	public static Emprendedor buscarEmprendedor(String usuario, ArrayList<Emprendedor> emprendedoresRegistrados) {
		
		for(Emprendedor emprendedorRegistrado:emprendedoresRegistrados) {
			if(emprendedorRegistrado.getUsuario().equals(usuario)){
				return emprendedorRegistrado;
			}
		}
		return null;
	}
	
	public static ArrayList<Persona> datosInicioSesion(){
		ArrayList<Persona> personas = new ArrayList<>();
		Date fechaAdmin = new Date(121, 7, 21);
		Usuario admin = new Usuario("Juan Sarmiento", "admin1", "admin123", fechaAdmin, 12345678);
		personas.add(admin);
		
		Date fechaJuan = new Date(121, 4, 6);
		Emprendedor Juan = new Emprendedor("Juan Cardenas", "juan1", "juan123",fechaJuan, 313326954, "Tunja", "Famila de campesionos cultivadores de papa", null);
		Date vencimientoManzana = new Date(121, 4, 6);
		Producto Manzana = new Producto("Manzana", Juan, 2500, 150, "Fruta");
		Date vencimientoLechuga = new Date(121, 4, 10);
		Producto Lechuga = new Producto("Lechuga", Juan, 300, 50, "Vegetal");
		Date vencimientoBanano = new Date(121,3,30);
		Producto Banano = new Producto("Banano", Juan, 950, 100, "Fruta");
		Producto Zanahoria = new Producto("Zanahoria", Juan, 950, 100, "Vegetal");
		Producto Pepino = new Producto("Zanahoria", Juan, 950,  100, "Vegetal");
		Producto Pera = new Producto("Zanahoria",Juan , 950, 100, "Vegetal");
		TreeMap<String,Producto> productosJuan = new TreeMap<>();
		productosJuan.put(Manzana.getNombre(), Manzana);
		productosJuan.put(Lechuga.getNombre(), Lechuga);
		productosJuan.put(Banano.getNombre(), Banano);
		productosJuan.put(Zanahoria.getNombre(), Zanahoria);
		productosJuan.put(Pepino.getNombre(), Pepino);
		productosJuan.put(Pera.getNombre(), Pera);
		Juan.setProductos(productosJuan);
		personas.add(Juan);
		
		return personas;
	}
	
	public static ArrayList<Usuario> datosRegistroUsuario(){
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Date fechaAdmin = new Date(121, 7, 21);
		Usuario admin = new Usuario("Juan Sarmiento", "Admin1", "admin123", fechaAdmin, 12345678);
		usuarios.add(admin);
		 return usuarios;
	}
	
	public static ArrayList<Emprendedor> datosRegistroEmprendedor(){
		 ArrayList<Emprendedor> emprendedores = new ArrayList<>();
		 return emprendedores;
	}

	public static boolean inicioSesion(String usuario, char[] contrasenia, ArrayList<Persona> personasRegistradas){
		
		String password = "";
		for (char contra : contrasenia) {
			password += contra;
		}
		boolean validez = false;
		for (Persona personaRegistrada : personasRegistradas) {
			if(personaRegistrada.getUsuario().equals(usuario) && personaRegistrada.getContrasenia().equals(password)) {
				validez = true;
				break;
			}
		}
		for (Persona personal : personasRegistradas) {
			System.out.print(personal.getUsuario());
		}
		return validez;
	}

	public static void registroUsuario(String nombre, String nombreCompleto, String usuario, char[] contrasenia, Date fechaNacimiento, long numeroContacto, ArrayList<Usuario> usuariosRegistrados, ArrayList<Persona> personasRegistradas, ArrayList<Emprendedor> emprendedoresRegistrados){
		String password = "";
		int identificador = usuariosRegistrados.size();
		for (char contraChar : contrasenia) {
			password += contraChar;
		}
		Usuario[] usuarios = new Usuario[identificador+1];
		usuarios[identificador] = new Usuario(nombreCompleto, usuario, password, fechaNacimiento, numeroContacto);
		usuarios[identificador].setPuntos(0);
		usuariosRegistrados.add(usuarios[identificador]);
		personasRegistradas.add(usuarios[identificador]);
		
		guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
	}
	
	public static void registroEmprendedor(String nombre, String nombreCompleto, String usuario, char[] contrasenia, Date fechaNacimiento, long numeroContacto,
			String ubicacion, String descripcionSituacion,  ArrayList<String> contactoAdicional, ArrayList<Emprendedor> emprendedoresRegistrados, ArrayList<Persona> personasRegistradas, ArrayList<Usuario> usuariosRegistrados) {
		String password = "";
		int identificador = emprendedoresRegistrados.size();
		for (char contraChar : contrasenia) {
			password += contraChar;
		}
		Emprendedor[] emprendedores = new Emprendedor[identificador+1];
		emprendedores[identificador] = new Emprendedor(nombreCompleto, usuario, password, fechaNacimiento, numeroContacto, ubicacion, descripcionSituacion, contactoAdicional);
		emprendedoresRegistrados.add(emprendedores[identificador]);
		personasRegistradas.add(emprendedores[identificador]);
		
		guardarInfo(usuariosRegistrados, emprendedoresRegistrados);
	}
	
	public  static ArrayList<Emprendedor> buscar(ArrayList<String> tipoBusqueda,String deseo, ArrayList<Emprendedor> emprendedoresRegistrados) {
		
		
		System.out.print(tipoBusqueda);
		ArrayList<Emprendedor> emprendedoresBuscados = new ArrayList<>();
		for(Emprendedor emprendedor: emprendedoresRegistrados) {
			String nombre = emprendedor.getNombre().toLowerCase();
			String ubicacion= emprendedor.getUbicacion().toLowerCase();
			if(emprendedoresBuscados.contains(emprendedor)!=true) {
				if(tipoBusqueda.isEmpty()) {
					if(nombre.contains(deseo.toLowerCase())||ubicacion.contains(deseo.toLowerCase())) {
						emprendedoresBuscados.add(emprendedor);
					}else {
						for(Producto producto: emprendedor.getProductos().values()) {
							String seccion= producto.getSeccion().toLowerCase();
							String nombreProducto = producto.getNombre().toLowerCase();
							if(deseo.toLowerCase().equals(seccion)||deseo.toLowerCase().equals(nombreProducto)) {
								emprendedoresBuscados.add(emprendedor);
							}
						}
					}
				}else {
					boolean bandera = false;
					for(String busqueda:tipoBusqueda) {
						if(bandera) {
							break;
						}else if(busqueda.equals("Emprendedor")) {
							if(nombre.contains(deseo.toLowerCase())) {
								emprendedoresBuscados.add(emprendedor);
								bandera = true;
							}
						}else if(busqueda.equals("Ubicación")){
							if(ubicacion.contains(deseo.toLowerCase())) {
								emprendedoresBuscados.add(emprendedor);
								bandera = true;
							}
						}else {
							for(Producto producto : emprendedor.getProductos().values()) {
								String productoBien = producto.getNombre().toLowerCase();
								if(productoBien.contains(deseo.toLowerCase())||producto.getSeccion().equals(deseo)) {
									emprendedoresBuscados.add(emprendedor);
									bandera = true;
									break;
								}
							}
						}
					}
				}
			}
		}
		
		
		
		return emprendedoresBuscados;
	}
	
	public static boolean validarInfo(String usuario, String nombre, String apellido, char[] contra, char[] contra1, String contacto, ArrayList<Usuario> usuariosRegistrados) {
		
		String password = "";
		for (char contraChar : contra) {
			password += contraChar;
		}
		String password2 = "";
		for (char contraChar : contra1) {
			password2 += contraChar;
		}
		if(password.compareTo(password2)!=0||password.length()<5||usuario.equals("Usuario")||usuario.length()<4||nombre.equals("Nombres")||apellido.equals("Apellidos")||contacto.equals("Contacto")||contacto.length()<7) {
			return false;
		}	
		for(Usuario usuarioRegistrado:usuariosRegistrados) {
			if (usuarioRegistrado.getUsuario().equals(usuario)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean validarInfoEmprendedor(String ubicacion, String descripcion, String telefono, String correo) {
		if(ubicacion.length()<3||descripcion.length()<=5||telefono.length()<7||(correo.length()<15&&correo.compareTo("Correo")!=0)) {
			return false;
		}
		return true;
		
	}
	
	public static ArrayList<Emprendedor> definirSugerencias(ArrayList<Emprendedor> emprendedoresRegistrados){
		
		ArrayList<Emprendedor> sugeridos = new ArrayList<Emprendedor>();
		Random generadorRandom =  new Random();
		
		for(int posicion=0;posicion<=6;posicion++) {
			int posicionEmprendedor = generadorRandom.nextInt(emprendedoresRegistrados.size());
			if(sugeridos.contains(emprendedoresRegistrados.get(posicionEmprendedor))) {
				posicion = posicion-1;
			}else {
				sugeridos.add(emprendedoresRegistrados.get(posicionEmprendedor));
			}
		}
		return sugeridos;
	}
	
	public static String infoEmprendedor(Emprendedor sugerido) {
		String info ="<html><body>";
		info+=sugerido.getNombre()+" / "+sugerido.getUbicacion()+"<br>Productos: ";
		int limite = 0;
		for(Producto producto:sugerido.getProductos().values()) {
			limite += 1;
			if (limite >6) {
				break;
			}
			info+=producto.getNombre()+"-";
		}
		info+="<body><html>";
		return info;
	}
	
	public static ArrayList<Venta> registro(Usuario usuario){
		ArrayList<Emprendedor> emprendedores = new ArrayList<>();
		
		Date fechaJuan = new Date(121, 4, 6);
		Emprendedor Juan = new Emprendedor("Juan Cardenas", "JuanCardenas123", "PKS896",fechaJuan, 313326954, "Tunja", "Famila de campesionos cultivadores de papa", null);
		Date fechaPedro = new Date(121, 4, 6);
		Emprendedor Pedro = new Emprendedor("Pedro Guio", "PedroGuio987", "MLS522",fechaPedro, 305259862, "Guaduas", "Famila de campesionos cultivadores de yuca", null);
		Date fechaAntonio = new Date(121, 4, 6);
		Emprendedor Antonio= new Emprendedor("Antonio Acosta", "AntonioACosta635", "QWE118",fechaAntonio, 314698653, "Neiva", "Famila de campesionos cultivadores de cafe", null);
		Date fechaArturo = new Date(121, 4, 6);
		Emprendedor Arturo= new Emprendedor("Arturo Hernandez", "ArturoHernandez777", "ASD995",fechaArturo, 315665244, "San Gil", "Famila de campesionos cultivadores de platano", null);
		Date fechaHerminda = new Date(121, 4, 6);
		Emprendedor Herminda = new Emprendedor("Herminda Avila", "HermindaAvila986", "XFO571",fechaHerminda, 313554862, "Girardod", "Famila de campesionos cultivadores de cafe", null);
		Date fechaMaria = new Date(121, 4, 6);
		Emprendedor Maria = new Emprendedor("Maria del Carmen", "MariaCarmen442", "PGV210",fechaMaria, 315036549, "Albania", "Famila de campesionos cultivadores de mango", null);
		Date fechaEstela = new Date(121, 4, 6);
		Emprendedor Estela = new Emprendedor("Estela Pinzon", "EstelaPinzon888", "AJR009",fechaEstela, 305365125, "San Jose Del Fragua", "Famila de campesionos cultivadores de guayaba", null);
		Date fechaYaneth = new Date(121, 4, 6);
		Emprendedor Yaneth = new Emprendedor("Yaneth Gonzales", "YanethGonzales712", "LCF457",fechaYaneth, 314124736, "Morelia", "Famila de campesionos cultivadores de banano", null);
		Date fechaYolanda= new Date(121, 4, 6);
		Emprendedor Yolanda = new Emprendedor("Yolanda Castro", "YolandaCastro", "SPO563",fechaYolanda, 305324589, "Tunja", "Famila de campesionos cultivadores de papa", null);
		
		
		Date vencimientoManzana = new Date(121, 4, 6);
		Producto Manzana = new Producto("Manzana", Yaneth, 2500, 150, "Fruta");
		Date vencimientoLechuga = new Date(121, 4, 10);
		Producto Lechuga = new Producto("Lechuga", Estela, 300, 50, "Vegetal");
		Date vencimientoBanano = new Date(121,3,30);
		Producto Banano = new Producto("Banano", Antonio, 950, 100, "Fruta");
		Producto Zanahoria = new Producto("Zanahoria", Maria, 950, 100, "Vegetal");
		Producto Pepino = new Producto("Zanahoria", Herminda, 950,  100, "Vegetal");
		Producto Pera = new Producto("Zanahoria",Arturo , 950, 100, "Vegetal");
		
		emprendedores.add(Yaneth);
		emprendedores.add(Estela);
		emprendedores.add(Herminda);
		emprendedores.add(Pedro);
		emprendedores.add(Antonio);
		emprendedores.add(Arturo);
		emprendedores.add(Maria);
		emprendedores.add(Juan);
		emprendedores.add(Yolanda);
		
		Date fechaAdmin = new Date(121, 7, 21);
		Usuario admin = new Usuario("Juan Sarmiento", "admin1", "admin123", fechaAdmin, 12345678);
	
		Venta venta_1 = new Venta(Manzana,Yaneth, admin,5, fechaAdmin);
		Venta venta_2 = new Venta(Pepino,Arturo, admin,10, fechaAdmin);
		Venta venta_3 = new Venta(Pera,Maria, admin,15, fechaAdmin);
		ArrayList<Venta> ventas = new ArrayList<>();
		ventas.add(venta_1);
		ventas.add(venta_2);
		ventas.add(venta_3);
		
		admin.setRegistroCompras(ventas);
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(admin);
		return usuario.getRegistroCompras();
	}
	
	public static int puntos(Usuario usuario) {
		
		return usuario.getPuntos();
		
	}
	
	public static String contactoAdicional(Emprendedor emprendedor) {
		String info = "";
		if (emprendedor.getContactoAdicional()!= null) {
			for(String contacto : emprendedor.getContactoAdicional()) {
				if(contacto!= null) {
					info += "<br>"+contacto;
				}
			}
		}
		return info;
	}
	
	public static void nuevaVenta(Producto producto, Emprendedor vendedor, Usuario comprador, int precio, Date fecha) {
		
		Venta venta_1 = new Venta(producto, vendedor, comprador, precio, fecha);
		if(comprador.getRegistroCompras()==null) {
			ArrayList<Venta> ventas_1 = new ArrayList<>();
			ventas_1.add(venta_1);
			comprador.setRegistroCompras(ventas_1);
		}else {
			comprador.getRegistroCompras().add(venta_1);
		}
		
		int puntos = (precio*30)/100;
		comprador.setPuntos(puntos+comprador.getPuntos());
		
	}

	public static ArrayList<Chat> hacerChats(Usuario usuario, Emprendedor vendedor) {
		
		Date fechaAdmin = new Date(121, 7, 21);
		Usuario admin = new Usuario("Juan Sarmiento", "admin1", "admin123", fechaAdmin, 12345678);
		Date fechaYolanda= new Date(121, 4, 6);
		Emprendedor Yolanda = new Emprendedor("Yolanda Castro", "YolandaCastro", "SPO563",fechaYolanda, 305324589, "Tunja", "Famila de campesionos cultivadores de papa", null);
		Date vencimientoManzana = new Date(121, 4, 6);
		Producto Manzana = new Producto("Manzana", Yolanda, 2500, 150, "Fruta");
		Texto texto_1 = new Texto(admin, "que pasa mijo", true);
		Texto texto_2 = new Texto(Yolanda, "Nada mijo bien", true);
		ArrayList<Texto> textos = new ArrayList<>();
		textos.add(texto_1);
		textos.add(texto_2);
		Chat chat_1 = new Chat(vendedor, usuario, false, textos, fechaAdmin);
		ArrayList<Chat> chats= new ArrayList<>();
		chats.add(chat_1);
		usuario.setChats(chats);
		vendedor.setChats(chats);
		
		return usuario.getChats();
	}
	
	public static void crearTextosChat(String texto, Persona persona, Emprendedor vendedor, int identificador) {
		
		Texto[] texto_5 = new Texto[identificador+1];
		texto_5[identificador] = new Texto(persona,texto);
		for(Chat chat:persona.getChats()) {
			if(chat.getVendedor() == vendedor&&texto!=null) {
				if(chat.getTexto()==null) {
					ArrayList<Texto>[] textos = new ArrayList[identificador+1];
					textos[identificador] = new ArrayList<>();
					textos[identificador].add(texto_5[identificador]);
					chat.setTexto(textos[identificador]);
				}else {
					chat.getTexto().add(texto_5[identificador]);
				}		
			}
		}
		
		
	}
	
	public static void crearChat(Emprendedor vendedor, Usuario usuario, boolean acuerdo, int identificador) {
		
		Chat[] chat = new Chat[identificador+1];
		chat[identificador] = new Chat(vendedor, usuario, acuerdo, null);
		usuario.getChats().add(chat[identificador]);
		
	}
	
	public static boolean validarAgregar(String nombre, String peso, String precio, Object seccion) {
		
		if(nombre!= null && nombre.length()>= 3 && peso!= null && precio != null && precio.length()>= 3 && seccion!="Sección del producto" ) {
			return true;
		}
		return false;
	}
	
	public static void agregarProducto(Emprendedor emprendedor, String nombre, String peso, String precio, Object seccion) {
		
		long pesoLong = Long.parseLong(peso);
		int precioInt = Integer.parseInt(precio);
		Producto holi = new Producto(nombre, emprendedor, pesoLong, precioInt, seccion.toString());
		emprendedor.getProductos().put(holi.getNombre(), holi);
		
	}
	
	public static void agregarProductoRegistro(Emprendedor emprendedor, String nombre, String peso, String precio, Object seccion) {

		long pesoLong = Long.parseLong(peso);
		int precioInt = Integer.parseInt(precio);
		Producto holi = new Producto(nombre, emprendedor, pesoLong, precioInt, seccion.toString());
		emprendedor.getProductos().put(holi.getNombre(), holi);

	}
	
	public static void guardarInfoDefault(ObjectOutputStream escribir) {
		
		try{
			
			Date fechaAdmin = new Date(121, 7, 21);
			Usuario admin = new Usuario("Juan Sarmiento", "admin1", "admin123", fechaAdmin, 12345678);
			escribir.writeObject(admin);
			
			
			
			Date fechaJuan = new Date(121, 4, 6);
			Emprendedor Juan = new Emprendedor("Juan Cardenas", "JuanCardenas123", "PKS896",fechaJuan, 313326954, "Tunja", "Famila de campesionos cultivadores de papa", null);
			Emprendedor Juan1 = new Emprendedor("Juan Cardenas", "juan1", "juan123",fechaJuan, 313326954, "Tunja", "Famila de campesionos cultivadores de papa", null);
			Date fechaPedro = new Date(121, 4, 6);
			Emprendedor Pedro = new Emprendedor("Pedro Guio", "PedroGuio987", "MLS522",fechaPedro, 305259862, "Guaduas", "Famila de campesionos cultivadores de yuca", null);
			Date fechaAntonio = new Date(121, 4, 6);
			Emprendedor Antonio= new Emprendedor("Antonio Acosta", "AntonioACosta635", "QWE118",fechaAntonio, 314698653, "Neiva", "Famila de campesionos cultivadores de cafe", null);
			Date fechaArturo = new Date(121, 4, 6);
			Emprendedor Arturo= new Emprendedor("Arturo Hernandez", "ArturoHernandez777", "ASD995",fechaArturo, 315665244, "San Gil", "Famila de campesionos cultivadores de platano", null);
			Date fechaHerminda = new Date(121, 4, 6);
			Emprendedor Herminda = new Emprendedor("Herminda Avila", "HermindaAvila986", "XFO571",fechaHerminda, 313554862, "Girardod", "Famila de campesionos cultivadores de cafe", null);
			Date fechaMaria = new Date(121, 4, 6);
			Emprendedor Maria = new Emprendedor("Maria del Carmen", "MariaCarmen442", "PGV210",fechaMaria, 315036549, "Albania", "Famila de campesionos cultivadores de mango", null);
			Date fechaEstela = new Date(121, 4, 6);
			Emprendedor Estela = new Emprendedor("Estela Pinzon", "EstelaPinzon888", "AJR009",fechaEstela, 305365125, "San Jose Del Fragua", "Famila de campesionos cultivadores de guayaba", null);
			Date fechaYaneth = new Date(121, 4, 6);
			Emprendedor Yaneth = new Emprendedor("Yaneth Gonzales", "YanethGonzales712", "LCF457",fechaYaneth, 314124736, "Morelia", "Famila de campesionos cultivadores de banano", null);
			Date fechaYolanda= new Date(121, 4, 6);
			Emprendedor Yolanda = new Emprendedor("Yolanda Castro", "YolandaCastro", "SPO563",fechaYolanda, 305324589, "Tunja", "Famila de campesionos cultivadores de papa", null);
			
			
			Date vencimientoManzana = new Date(121, 4, 6);
			Producto Manzana = new Producto("Manzana", Yaneth, 2500, 150, "Fruta");
			Date vencimientoLechuga = new Date(121, 4, 10);
			Producto Lechuga = new Producto("Lechuga", Estela, 300, 50, "Vegetal");
			Date vencimientoBanano = new Date(121,3,30);
			Producto Banano = new Producto("Banano", Antonio, 950, 100, "Fruta");
			Producto Zanahoria = new Producto("Zanahoria", Maria, 950, 100, "Vegetal");
			Producto Pepino = new Producto("Pepino", Herminda, 950,  100, "Vegetal");
			Producto Pera = new Producto("Pera",Arturo , 950, 100, "Vegetal");
			
			TreeMap<String, Producto> productos1= new TreeMap<>();
			productos1.put(Manzana.getNombre(), Manzana);
			productos1.put(Pera.getNombre(), Pera);
			productos1.put(Banano.getNombre(), Banano);
			
			TreeMap<String, Producto> productos2= new TreeMap<>();
			productos2.put(Lechuga.getNombre(), Lechuga);
			productos2.put(Pepino.getNombre(), Pepino);
			productos2.put(Zanahoria.getNombre(), Zanahoria);
			
			TreeMap<String, Producto> productos3= new TreeMap<>();
			productos3.put(Manzana.getNombre(), Manzana);
			productos3.put(Pepino.getNombre(), Pepino);
			productos3.put(Banano.getNombre(), Banano);
			
			TreeMap<String, Producto> productos4= new TreeMap<>();
			productos4.put(Manzana.getNombre(), Manzana);
			productos4.put(Lechuga.getNombre(), Lechuga);
			productos4.put(Banano.getNombre(), Banano);
			
			TreeMap<String, Producto> productos5= new TreeMap<>();
			productos5.put(Lechuga.getNombre(), Lechuga);
			productos5.put(Pera.getNombre(), Pera);
			productos5.put(Pepino.getNombre(), Pepino);
			
			TreeMap<String,Producto> productosJuan = new TreeMap<>();
			productosJuan.put(Lechuga.getNombre(), Lechuga);
			productosJuan.put(Pera.getNombre(), Pera);
			productosJuan.put(Pepino.getNombre(), Pepino);
			
			Juan.setProductos(productos1);
			Pedro.setProductos(productos2);
			Antonio.setProductos(productos3);
			Arturo.setProductos(productos4);
			Herminda.setProductos(productos5);
			Maria.setProductos(productos1);
			Estela.setProductos(productos2);
			Yaneth.setProductos(productos3);
			Yolanda.setProductos(productos4);
			Juan1.setProductos(productosJuan);
			
			escribir.writeObject(Juan1);
			escribir.writeObject(Pedro);
			escribir.writeObject(Antonio);
			escribir.writeObject(Arturo);
			escribir.writeObject(Herminda);
			escribir.writeObject(Maria);
			escribir.writeObject(Estela);
			escribir.writeObject(Yaneth);
			escribir.writeObject(Yolanda);
			escribir.writeObject(Juan1);
			
			Usuario admin2 = new Usuario("Sebastian Pulido", "admin2", "admin123", fechaAdmin, 12345678, 40);
			ArrayList<Recompensa> recompensasAdmin2 = new ArrayList<>();
			recompensasAdmin2.add(new Recompensa(Manzana, false, admin2));
			recompensasAdmin2.add(new Recompensa(Pera, false, admin2));
			admin2.setRecompensa(recompensasAdmin2);
			escribir.writeObject(admin2);
			
			
		}catch(Exception e) {
			
		}
		
		
	}
	
	public static void guardarInfo( ArrayList<Usuario> usuarios, ArrayList<Emprendedor> emprendedores) {
			
		try {
			ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("Informacion.obj"));
			for(Usuario usuario: usuarios) {
				escribir.writeObject(usuario);
			}
			for(Emprendedor emprendedor : emprendedores) {
				escribir.writeObject(emprendedor);
			}
			escribir.close();
		}catch(Exception e) {
			System.out.print("mal");
		}
		
	}
	
	public static void generarRecompensas(Usuario usuario) {
		
		ArrayList<String> contacto = new ArrayList<>();
		contacto.add("Nada");
		Emprendedor nadie = new Emprendedor("Nadie", "Nada", "Nada", new Date(192, 3, 6), 123456789, "Ningun", "Nada", contacto);
		
		ArrayList<Producto> posiblesRecompensas = new ArrayList<>();
		Producto Arroz = new Producto("Arroz", nadie, 350, 0, "Verdura");
		Producto Leche = new Producto("Leche", nadie, 500, 0, "Bebida");
		Producto Queso = new Producto("Queso", nadie, 750, 0, "Otro");
		Producto Arveja = new Producto("Arveja", nadie, 600, 0, "Verdura");
		Producto Frijol = new Producto("Frijol", nadie, 200, 0, "Verdura");
		Producto Pasta = new Producto("Pasta", nadie, 3550, 0, "Otro");
		Producto Huevos = new Producto("Huevos", nadie, 950, 0, "Otro");
		posiblesRecompensas.add(Arroz);
		posiblesRecompensas.add(Leche);
		posiblesRecompensas.add(Queso);
		posiblesRecompensas.add(Arveja);
		posiblesRecompensas.add(Frijol);
		posiblesRecompensas.add(Pasta);
		posiblesRecompensas.add(Huevos);
		
		int puntosDisponibles = usuario.getPuntos();
		if(usuario.getRecompensa()== null) {
			ArrayList<Recompensa> productos = new ArrayList<>();
			usuario.setRecompensa(productos);
		}else if(usuario.getRecompensa().isEmpty()==false){
			for (Recompensa recompensa : usuario.getRecompensa()) {
				if(recompensa.isUsado()==true) {
					puntosDisponibles -= 10;
				}
			}
			if(puntosDisponibles > 10 && puntosDisponibles%10 == 0) {
				int cantidadRecompensas = puntosDisponibles/10;
				Random generadorRandom =  new Random();
				for(int indice = 0; indice<cantidadRecompensas; indice++) {
					int posicionRecompensa = generadorRandom.nextInt(posiblesRecompensas.size());
					if(usuario.getRecompensa().contains(posiblesRecompensas.get(posicionRecompensa))) {
						indice = indice -1;
					}else {
						usuario.getRecompensa().add(new Recompensa(posiblesRecompensas.get(posicionRecompensa), false, usuario));
					}
				}
			}
		}
	}
	
	public static void cambiarAUsado(Usuario usuario, Recompensa recompensa) {
		
		for(Recompensa recompensasUsuario : usuario.getRecompensa()) {
			if(recompensasUsuario.getProducto().getNombre().equals(recompensa.getProducto().getNombre()) && recompensasUsuario.isUsado()==recompensa.isUsado()) {
				recompensasUsuario.setUsado(true);
			}
		}
		
	}
		
	
}
