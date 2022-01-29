/********************************************************************
@File Driver.java 
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 27/01/2022

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

        while (opcion != 10)
		{
			opcion = vista.MenuOpciones();
			
			if (opcion == 1)
			{
				//Encender o apagar la radio
				modelo.EncenderApagar();
			}

			else if (opcion == 2)
			{
				//Cambiar Señal
				modelo.cambiarSenal();
			}
            
            else if (opcion == 3)
			{
				//Señal Actual
				modelo.getTipoSenal();
			}

            else if (opcion == 4)
			{
				//Subir Emisora
				modelo.SubirEmisora();
			}

            else if (opcion == 5)
			{
				//Bajar Emisora
				modelo.BajarEmisora();
			}
			
            else if (opcion == 6)
			{
				//Emisoras Actual
				 
			}

			else if (opcion == 7)
			{
				//Emisoras Guardadas
				modelo.GuardarEmisora(); 
			}

			else if (opcion == 8)
			{
				//Emisoras Guardadas
				modelo.seleccionarEmisora(); 
			}

			else if (opcion == 9)
			{
				//Comprobar encendida
				 
			}

            else if (opcion == 10)
			{
				//Salir
				vista.despedida();
			}

			else
			{
				vista.opcionInvalida();
			}	
		}
    }
}
