/********************************************************************
@File Driver.java 
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 30/01/2022

Driver program que servira como controlador e implementa el menú 
de opciones para simulador de radio. 
********************************************************************/

public class Driver 
{
    public static void main(String[] args)
    {
        //Propiedades//
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		vista.bienvenida();
		int opcion = 0;
		while (true){
			if (modelo.comprobarEncendida() == true){
				while (opcion != 10)
				{
					opcion = vista.MenuOpcionesOn();
					
					if (opcion == 1)
					{
						//Encender o apagar la radio
						modelo.encenderApagar();
						if (modelo.comprobarEncendida() == true){
							continue;
						}
						else{
							break;
						}
					}

					else if (opcion == 2)
					{
						//Cambiar Señal
						vista.mostrar(modelo.cambiarSenal(vista.seleccionarTipoSenal()));
					}
					
					else if (opcion == 3)
					{
						//Señal Actual
						vista.mostrarTipoSenal(modelo.getTipoSenal());
					}

					else if (opcion == 4)
					{
						//Subir Emisora
						modelo.subirEmisora();
					}

					else if (opcion == 5)
					{
						//Bajar Emisora
						modelo.bajarEmisora();
					}
					
					else if (opcion == 6)
					{
						//Emisoras Actual
						 vista.mostrarEstacionActual(modelo.getEmisoraActual());
					}

					else if (opcion == 7)
					{
						//Emisoras Guardadas
						vista.mostrar(modelo.guardarEmisoraActual(1)); 
					}

					else if (opcion == 8)
					{
						//Emisoras Guardadas
						vista.mostrar(modelo.seleccionarEmisoraGuardada(vista.seleccionarEstacion(modelo.getEmisorasGuardadas()))); 
					}

					else if (opcion == 9)
					{
						//Comprobar encendida
						 vista.mostrarEstado(modelo.comprobarEncendida());
					}

					else if (opcion == 10)
					{
						//Salir
						vista.despedida();
						System.exit(0);
					}

					else
					{
						vista.opcionInvalida();
					}	
				}
			}
			else{
				while (opcion != 3){
					
					opcion = vista.MenuOpcionesOff();
					
					if (opcion == 1)
						{
							//Encender o apagar la radio
							modelo.encenderApagar();
						}

						else if (opcion == 2)
						{
							//Comprobar si esta apagado
							vista.mostrarEstado(modelo.comprobarEncendida());
						}
						
						else if (opcion == 3)
						{
							//Salir
							vista.despedida();
							System.exit(0);
						}

						else
						{
							vista.opcionInvalida();
						}
					if (modelo.comprobarEncendida() == true){
						break;
					}
				}
				
			}
		}
	}
}
