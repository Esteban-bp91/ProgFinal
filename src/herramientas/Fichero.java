package herramientas;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import clases.Bebida;
import clases.Cliente;
import clases.Comida;
import clases.Pedido;

/**
 * Clase Fichero de la práctica final de Programación de 1º DAW - Curso 2022/2023
 * 
 * @author Esteban Baeza Pérez
 * @version 0.1 
 * @since 25/04/2023
 * 
 */

public class Fichero {
	
	private String rutaFicheros = "C:/Users/EstebanBP/eclipse-workspace/ProgFinal/Ficheros";
	private String rutaPedidos = "C:/Users/EstebanBP/eclipse-workspace/ProgFinal/Pedidos";
	
	/*public void crearCliente(Cliente cliente) {
		   try {
		      File nuevoCliente = new File(rutaClientes+"/CL"+cliente.getTelefono()+".txt");		      
		      if (nuevoCliente.createNewFile()) {		    	  
		        System.out.println("Cliente creado correctamente: " + nuevoCliente.getName());		        
		      } else {		    	  
		        System.out.println("Este archivo ya existe.");	        
		      }	      
		    } catch (IOException e) {		    	
		      System.out.println("An error occurred.");		      
		      e.printStackTrace();		      
		    }
		   
			FileWriter fichero = null;
			PrintWriter pw = null;
			try {
				// Añadir flag a true para no machacar contenido del fichero de escritura
				fichero = new FileWriter(rutaClientes+"/CL"+cliente.getTelefono()+".txt", true);
				pw = new PrintWriter(fichero);
				pw.println(cliente.getNombre()+"; "+cliente.getApellidos()+"; "+cliente.getFechaDeAlta()+"; "+cliente.getTelefono()+"; "+cliente.getDireccion());

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// Nuevamente aprovechamos el finally para asegurarnos que se cierra el fichero.
					if (null != fichero) {
						fichero.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	}

	public void crearBebida(Bebida bebida) {
		
		   try {
		      File nuevaBebida = new File(rutaBebidas+"/PR"+bebida.getCodigo()+".txt");      
		      if (nuevaBebida.createNewFile()) {	    	  
		        System.out.println("Archivo creado: " + nuevaBebida.getName());	        
		      } else {	    	  
		        System.out.println("Este archivo/producto ya existe.");	        
		      }	      
		    } catch (IOException e) {	    	
		      System.out.println("An error occurred.");	      
		      e.printStackTrace();	      
		    }
		   
			FileWriter fichero = null;
			PrintWriter pw = null;
			try {
				// Añadir flag a true para no machacar contenido del fichero de escritura
				fichero = new FileWriter(rutaBebidas+"/PR"+bebida.getCodigo()+".txt", true);
				
				String precio = bebida.getPrecio()+"";
				if(precio.contains(".")) {			
					precio = precio.replace(".",",");
				}
				pw = new PrintWriter(fichero);
				pw.println(bebida.getCodigo()+"; "+bebida.getNombre()+"; "+precio);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// Nuevamente aprovechamos el finally para asegurarnos que se cierra el fichero.
					if (null != fichero) {
						fichero.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

	}
	
	public void crearComida(Comida comida) {
		   try {
		      File nuevaComida = new File(rutaComidas+"/PR"+comida.getCodigo()+".txt");      
		      if (nuevaComida.createNewFile()) {	    	  
		        System.out.println("Archivo creado: " + nuevaComida.getName());	        
		      } else {	    	  
		        System.out.println("Este archivo/producto ya existe.");	        
		      }	      
		    } catch (IOException e) {	    	
		      System.out.println("An error occurred.");	      
		      e.printStackTrace();	      
		    }
		   
			FileWriter fichero = null;
			PrintWriter pw = null;
			try {
				// Añadir flag a true para no machacar contenido del fichero de escritura
				fichero = new FileWriter(rutaComidas+"/PR"+comida.getCodigo()+".txt", true);
				
				String precio = comida.getPrecio()+"";
				if(precio.contains(".")) {			
					precio = precio.replace(".",",");
				}
				pw = new PrintWriter(fichero);
				pw.println(comida.getCodigo()+"; "+comida.getNombre()+"; "+precio);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// Nuevamente aprovechamos el finally para asegurarnos que se cierra el fichero.
					if (null != fichero) {
						fichero.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

	}*/
	
	public void guardarBebidas(ArrayList<Bebida> bebidas) throws Exception {
		FileOutputStream fc = null;
		ObjectOutputStream oc = null;
		try {
			fc = new FileOutputStream(rutaFicheros+"/Bebidas.dat");
			oc = new ObjectOutputStream(fc);
			oc.writeObject(bebidas);
			oc.flush();
		} catch (EOFException eof) {
		} catch (FileNotFoundException f){
			f.printStackTrace();
			System.out.println("Clientes no encontrados");
		} finally {
			if (oc != null) {
		        oc.close();
		    }
		    if (fc != null) {
		        fc.close();
		    }
		}
	}
	
	public void guardarBebida(Bebida bebida, ArrayList<Bebida> bebidas) throws Exception {
		bebidas.add(bebida);
		FileOutputStream fc = null;
		ObjectOutputStream oc = null;
		try {
			fc = new FileOutputStream(rutaFicheros+"/Bebidas.dat");
			oc = new ObjectOutputStream(fc);
			oc.writeObject(bebidas);
			oc.flush();
		} catch (EOFException eof) {
		} catch (FileNotFoundException f){
			f.printStackTrace();
			System.out.println("Clientes no encontrados");
		} finally {
			if (oc != null) {
		        oc.close();
		    }
		    if (fc != null) {
		        fc.close();
		    }
		}
	}
	
	public ArrayList<Bebida> cargarBebidastxt(ArrayList<Bebida> bebidas) throws FileNotFoundException, IOException, ParseException {

		//Creamos un array con los archivos txt con los datos de los productos y así saber la cantidad de productos que hay 
		File carpetaBebidas = new File("C:\\Users\\EstebanBP\\eclipse-workspace\\ProgFinal\\Bebidas"); 
		File[] listaBebidas = carpetaBebidas.listFiles();  

		// Rellenamos los datos de los productos con el método rellenarProducto (nombre, precio, stock)		
		for (int i = 0; i < listaBebidas.length; i++) {   // Bucle for para crear tantos productos como archivos tenga la carpeta Productos y asignar la ruta de su respectivo archivo		
			bebidas.add(new Bebida(0, null, 0, null, null, 0, false, false, null));										 
			bebidas.get(i).rellenarBebidatxt(listaBebidas[i], bebidas.get(i));		 		
		}
		return bebidas;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Bebida> cargarBebidas(ArrayList<Bebida> bebidas) throws FileNotFoundException, IOException, ParseException, ClassNotFoundException {
		FileInputStream fc = null;
		ObjectInputStream oc = null;
		try {
			fc = new FileInputStream(rutaFicheros+"/Bebidas.dat");
			oc = new ObjectInputStream(fc);
			bebidas = (ArrayList<Bebida>)oc.readObject(); 
		} catch (EOFException eof) {
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			System.out.println("Error en la carga de las bebidas");
		} catch (FileNotFoundException f){
			f.printStackTrace();
			System.out.println("Bebidas no encontradas");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oc != null) {
		        oc.close();
		    }
		    if (fc != null) {
		        fc.close();
		    }
		}
		return bebidas;
	}
	
	public void guardarComidas(ArrayList<Comida> comidas) throws Exception {
		FileOutputStream fc = null;
		ObjectOutputStream oc = null;
		try {
			fc = new FileOutputStream(rutaFicheros+"/Comidas.dat");
			oc = new ObjectOutputStream(fc);
			oc.writeObject(comidas);
			oc.flush();
		} catch (EOFException eof) {
		} catch (FileNotFoundException f){
			f.printStackTrace();
			System.out.println("Comidas no encontrados");
		} finally {
			if (oc != null) {
		        oc.close();
		    }
		    if (fc != null) {
		        fc.close();
		    }
		}
	}
	
	public void guardarComida(Comida comida, ArrayList<Comida> comidas) throws Exception {
		comidas.add(comida);
		FileOutputStream fc = null;
		ObjectOutputStream oc = null;
		try {
			fc = new FileOutputStream(rutaFicheros+"/Comidas.dat");
			oc = new ObjectOutputStream(fc);
			oc.writeObject(comidas);
			oc.flush();
		} catch (EOFException eof) {
		} catch (FileNotFoundException f){
			f.printStackTrace();
			System.out.println("Comidas no encontrados");
		} finally {
			if (oc != null) {
		        oc.close();
		    }
		    if (fc != null) {
		        fc.close();
		    }
		}
	}
	
	public ArrayList<Comida> cargarComidastxt(ArrayList<Comida> comidas) throws FileNotFoundException, IOException, ParseException {
		
		//Creamos un array con los archivos txt con los datos de los productos y así saber la cantidad de productos que hay 
		File carpetaComidas = new File("C:\\Users\\EstebanBP\\eclipse-workspace\\ProgFinal\\Comidas"); 
		File[] listaComidas = carpetaComidas.listFiles();  

		// Rellenamos los datos de los productos con el método rellenarProducto (nombre, precio, stock)	
		for (int i = 0; i < listaComidas.length; i++) {   // Bucle for para crear tantos productos como archivos tenga la carpeta Productos y asignar la ruta de su respectivo archivo		
				comidas.add(new Comida(0,null,0,null,null,0,false,0,0,null));										 
				comidas.get(i).rellenarComida(listaComidas[i], comidas.get(i));		 		
		}
		return comidas;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Comida> cargarComidas(ArrayList<Comida> comidas) throws FileNotFoundException, IOException, ParseException, ClassNotFoundException {
		FileInputStream fc = null;
		ObjectInputStream oc = null;
		try {
			fc = new FileInputStream(rutaFicheros+"/Comidas.dat");
			oc = new ObjectInputStream(fc);
			comidas = (ArrayList<Comida>)oc.readObject(); 
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			System.out.println("Error en la carga de las comidas");
		} catch (FileNotFoundException f){
			f.printStackTrace();
			System.out.println("Comidas no encontradas");
		} finally {
			if (oc != null) {
		        oc.close();
		    }
		    if (fc != null) {
		        fc.close();
		    }
		}
		return comidas;
	}
	
	public void imprimirPedido(Pedido pedido) {
		
		String ruta = rutaPedidos+"/" +pedido.getCodigoPago()+ ".txt";
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta);
			pw = new PrintWriter(fichero);
			pw.println(pedido.imprimir());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void guardarClientes(ArrayList<Cliente> clientes) throws Exception {
		FileOutputStream fc = null;
		ObjectOutputStream oc = null;
		try {
			fc = new FileOutputStream(rutaFicheros+"/Clientes.dat");
			oc = new ObjectOutputStream(fc);
			oc.writeObject(clientes);
			oc.flush();
		} catch (EOFException eof) {
		} catch (FileNotFoundException f){
			f.printStackTrace();
			System.out.println("Clientes no encontrados");
		} finally {
			if (oc != null) {
		        oc.close();
		    }
		    if (fc != null) {
		        fc.close();
		    }
		}
	}
	
	public void guardarCliente(Cliente cli,ArrayList<Cliente> clientes) throws Exception {
		clientes.add(cli);
		FileOutputStream fc = null;
		ObjectOutputStream oc = null;
		try {
			fc = new FileOutputStream(rutaFicheros+"/Clientes.dat");
			oc = new ObjectOutputStream(fc);
			oc.writeObject(clientes);
			oc.flush();
		} catch (EOFException eof) {
		} catch (FileNotFoundException f){
			f.printStackTrace();
			System.out.println("Clientes no encontrados");
		} finally {
			if (oc != null) {
		        oc.close();
		    }
		    if (fc != null) {
		        fc.close();
		    }
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> cargarClientes(ArrayList<Cliente> clientes) throws FileNotFoundException, IOException, ParseException, ClassNotFoundException {
			FileInputStream fc = null;
			ObjectInputStream oc = null;
			try {
				fc = new FileInputStream(rutaFicheros+"/Clientes.dat");
				oc = new ObjectInputStream(fc);
				clientes = (ArrayList<Cliente>)oc.readObject(); 
			} catch (ClassNotFoundException c) {
				c.printStackTrace();
				System.out.println("Error en la carga de los clientes");
			} catch (FileNotFoundException f){
				f.printStackTrace();
				System.out.println("Clientes no encontrados");
			} finally {
				if (oc != null) {
			        oc.close();
			    }
			    if (fc != null) {
			        fc.close();
			    }
			}
		return clientes;
	}

}
