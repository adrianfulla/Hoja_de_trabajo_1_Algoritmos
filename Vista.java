/**********************************************************************
@File Vista.java
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 27/01/2022

Programa que mostrará a los usuarios el menú de opciones para un
simulador de radio.
**********************************************************************/

import java.util.Scanner;

public class Vista 
{
    //Propiedades
	private Scanner scan;
    Scanner entrada = new Scanner(System.in);
	
    //Métodos 
	
	//Constructor
	public Vista()
	{
		scan = new Scanner(System.in);
	}
	
	public void bienvenida()
	{
		System.out.println("\nBienvendi@ al simulador de radio");
	}
	
	public int MenuOpciones()
	{
		int op;
		String s = "\nQue desea hacer?\n" +
					"1. Encender o apagar radio\n" +
                    "2. Cambiar señal\n" +
					"3. Señal actual\n" +
                    "4. Subir emisora\n" +
                    "5. Bajar emisora\n" +
					"6. Emisora actual\n" +
                    "7. Guardar emisora\n" +
                    "8. Emisoras guardadas\n" +
					"9. Comprobar si la radio esta encendida\n" +
					"10. Salir\n";
		System.out.println(s);
		op = scan.nextInt();
		
		return op;
	}
	
	public void opcionInvalida()
	{
		System.out.println("\nHa elegido una opcin invalida.\n");
	}

    public void despedida()
	{
		System.out.println("\nAdios, que tenga feliz dia!\n");
	}
}
