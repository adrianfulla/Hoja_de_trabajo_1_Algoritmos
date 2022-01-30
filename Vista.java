/**********************************************************************
@File Vista.java
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 27/01/2022

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
	
	public void bienvenida()
	{
		System.out.println("\nBienvendi@ al simulador de radio");
	}
	
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
	
	
	public void opcionInvalida()
	{
		System.out.println("\nHa elegido una opcin invalida.\n");
	}

    public void despedida()
	{
		System.out.println("\nAdios, que tenga feliz dia!\n");
	}
	
	public void mostrarEstado(boolean n){
		if (n == true){
			System.out.println("La radio se encuentra encendida");
		}
		else{
			System.out.println("La radio se encuentra apagada");
		}
	}
	public void mostrar(String s){
		System.out.println(s);
	}
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
	public void mostrarTipoSenal(boolean b){
		if(b == true){
			System.out.println("Actualmente la señal es AM");
		}
		else{
			System.out.println("Actualmente la señal es FM");
		}
	}
	public void mostrarEstacionActual(float f){
		System.out.println("La estacion actual es " + Float.toString(f));
	}
}
