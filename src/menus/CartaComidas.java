package menus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import clases.Comida;

/**
 * Clase CartaComidas de la práctica final de Programación de 1º DAW - Curso 2022/2023
 * 
 * @author Esteban Baeza Pérez
 * @version 0.1 
 * @since 25/04/2023
 * 
 */

public class CartaComidas{

	public void mostrar(ArrayList<Comida> comidas) {
		Scanner sc = new Scanner(System.in);
		Comida comida = null;
		LocalDate fechaHoy = LocalDate.now();
		System.out.println("\nCarta de comidas:");
		for (int i = 0; i < comidas.size(); i++) {	
			if(comidas.get(i).calcularCaducidad().isBefore(fechaHoy)) {
				comidas.get(i).setEstado("Caducado");
				//Si la comida está caducada, no se muestra en la carta
			} else if (comidas.get(i).calcularCaducidad().minusDays(5).isBefore(fechaHoy)) {  //Si quedan menos de 5 días para la fecha de caducidad, se muestra la oferta en el precio
				comidas.get(i).setPrecio(comidas.get(i).getPrecio()*0.7);
				System.out.println(i+") "+ comidas.get(i).getNombre() + "		Precio OFERTA: "+ comidas.get(i).getPrecio());			
			} else {
			System.out.println(i+") "+ comidas.get(i).getNombre() + "		Precio: "+ comidas.get(i).getPrecio());			
			}
		}		
	}

}
