/**********************************************************************
@File Vista.java
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 30/1/2022

Programa que mostrará a los usuarios el menú de opciones para un
simulador de radio.
**********************************************************************/

import java.util.*;

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
	
	/**
     * Metodo que le da la bienvenida al usaurio
     * 
     */
	public void bienvenida()
	{
		System.out.println("\nBienvendi@ al simulador de radio");
	}
	
	/**
     * Metodo que le muestra al usuario las opciones de menu cuando radio se encuentra encendido
     * 
	 * @int de la opcion del menu escogida por el usuario
     */
	public int MenuOpcionesOn()
	{
		int op = 0;
		String s = "\nQue desea hacer?\n" +
					"1. Encender o apagar radio\n" +
                    "2. Cambiar señal\n" +
					"3. Señal actual\n" +
                    "4. Subir emisora\n" +
                    "5. Bajar emisora\n" +
					"6. Emisora actual\n" +
                    "7. Guardar emisora\n" +
                    "8. Seleccionar Emisoras guardadas\n" +
					"9. Comprobar si la radio esta encendida\n" +
					"10. Salir\n";
		System.out.println(s);
		boolean wenttocath;
		do{
			try{
				wenttocath = false;
				op = scan.nextInt();
			}
			catch (InputMismatchException e){
				scan.next();
				wenttocath = true;
				System.out.println("Opcion no valida, vuelva a intentar");
			}
		}	while (wenttocath == true);
		return op;
	}
	
	/**
     * Metodo que le muestra al usuario las opciones de menu cuando radio se encuentra apagado
     * 
	 * @int de la opcion del menu escogida por el usuario
     */
	public int MenuOpcionesOff()
	{
		int op = 0;
		String s = "\nQue desea hacer?\n" +
					"1. Encender o apagar radio\n" +
                    "2. Comprobar si la radio esta encendida\n" +
					"3. Salir\n";
		System.out.println(s);
		boolean wenttocath;
		do{
			try{
				wenttocath = false;
				op = scan.nextInt();
				return op;
			}
			catch (InputMismatchException e){
				scan.next();
				wenttocath = true;
				System.out.println("Opcion no valida, vuelva a intentar");
			}
		}	while (wenttocath == true);
		
		return op;
	}
	
	/**
     * Metodo cuando el usuario escoge una opcion invalida
     * 
     */
	public void opcionInvalida()
	{
		System.out.println("\nHa elegido una opcin invalida.\n");
	}

	/**
     * Metodo que le da la despedida al usuario
     * 
     */
    public void despedida()
	{
		System.out.println("\nAdios, que tenga feliz dia!\n");
	}
	
	/**
     * Metodo que muestra el estado del radio
     * 
     * @param boolean que representa el estado del radio.
     */
	public void mostrarEstado(boolean n){
		if (n == true){
			System.out.println("La radio se encuentra encendida");
		}
		else{
			System.out.println("La radio se encuentra apagada");
		}
	}
	/**
     * Metodo que muestra al usuario un mensaje
     * 
     * @param String que sera mostrado al usuario
     */
	public void mostrar(String s){
		System.out.println(s);
	}
	
	/**
     * Metodo que permite que el usuario seleccione una estacion
     * 
     * @param ArrayList de Strings donde se encuentras las estaciones guardadas
	 * @return Integer que representa el lugar en la lista de la estacion guardada, se suma 1 a la opcion como una verificación 
     */
	public Integer seleccionarEstacion(ArrayList<String> ests){
		System.out.println("Que estacion guardada desea seleccionar?");
		if(ests.size() > 0){
			for(int i = 0; i < ests.size();i++){
				System.out.println((i+1) + ". " + ests.get(i));
			}
			int op = 0;
			boolean wenttocath;
			do{
				try{
					wenttocath = false;
					op = scan.nextInt();
					return op;
				}
				catch (InputMismatchException e){
					scan.next();
					wenttocath = true;
					System.out.println("Opcion no valida, vuelva a intentar");
				}
			}	while (wenttocath == true);
			
			return(op+1);
		}
		else{
			System.out.println("No hay estaciones guardadaes");
			return 0;
		}
	}

	/**
     * Metodo que permite que el usuario escoger que tipo de señal desea escuchar
     * 
	 * @return boolean que representa el tipo de señal escogido por el usuario
     */
	public boolean seleccionarTipoSenal(){
		System.out.println("Que tipo de senal desea escuchar?");
		System.out.println("1. AM");
		System.out.println("2. FM");
		int op = 0;
		boolean wenttocath;
		boolean est = true;
		do{
			try{
				wenttocath = false;
				op = scan.nextInt();
				if(op == 1){
					est = true;
				}
				else{
					est = false;
				}
			}
			catch (InputMismatchException e){
				scan.next();
				wenttocath = true;
				System.out.println("Opcion no valida, vuelva a intentar");
			}
		}	while (wenttocath == true);
		
		return est;
		
		
	}
	
	/**
     * Metodo que le muestra al usuario el tipo de señal del radio
     * 
	 * @param boolean que representa el tipo de señal 
     */
	public void mostrarTipoSenal(boolean b){
		if(b == true){
			System.out.println("Actualmente la señal es AM");
		}
		else{
			System.out.println("Actualmente la señal es FM");
		}
	}
	
	/**
     * Metodo que le muestra al usuario la estacion que esta siendo mostrada por el radio
     * 
	 * @param float que representa la estacion en la que se encuentra el radio
     */
	public void mostrarEstacionActual(float f){
		System.out.println("La estacion actual es " + Float.toString(f));
	}
}
