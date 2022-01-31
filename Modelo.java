/***************************************************************************
@File Modelo.java
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 30/01/2022

Programa que tendra los metodos y las propiedades de la clase modelo.
***************************************************************************/

import java.util.Scanner;
import java.util.ArrayList;

public class Modelo implements Radio
{
    //Propiedades
    public boolean encendido;
    public boolean tipoSenal;
    public float AMactual;
    public float FMactual;
    public int NumBoton;
    public String NumEmisora;
    public float emisoraRadio;
    ArrayList<String> emisorasGuardadas = new ArrayList<String>();
    Scanner scan = new Scanner(System.in);
    
    //Métodos

    //Constructor
    public Modelo()
    {
        encendido = false;
        tipoSenal = true;
        AMactual = 530f;
        FMactual = 87.9f;
        NumBoton = 1;
        NumEmisora = null;
        emisoraRadio = 530f;
    }

    public void setNumEmisora(float f)
    {
        this.NumEmisora = Float.toString(f);
    }

    public void setEmisoraRadio(float f)
    {
        this.emisoraRadio = f;
		if(tipoSenal == true){
			this.AMactual = f;
		}
		else{
			this.FMactual = f;
		}
    }

    @Override
    public void encenderApagar()
    {
        if(encendido == false)
        {
            System.out.println("¿Deseas encender la radio?\n 1. Si\n2. No");
            int opcion = scan.nextInt();
            if(opcion == 1)
            {
                System.out.println("Se ha encendido la radio");
                encendido = true;
            }
            else if (opcion == 2)
            {
                System.out.println("No se ha encendido la radio");
                encendido = false;
            }
            else
            {
                System.out.println("Error, intentalo de nuevo");
            }   
        }
        else if(encendido == true)
        {
            System.out.println("¿Deseas apagar la radio?\n1. Si\n2. No");
            int opcion2 = scan.nextInt();
            if(opcion2 == 1)
            {
                System.out.println("Se ha apagado la radio");
                encendido = false;
            }
            else if(opcion2 == 2)
            {
                System.out.println("La radio sigue encendida");
            }
        }
    }

    @Override
    public String guardarEmisoraActual(int numBoton)
    {
		setNumEmisora(emisoraRadio);
        emisorasGuardadas.add(NumEmisora);
		
		String m = ("Se ha guardado la emisora " + NumEmisora);
		return m;
    }

    @Override
    public String seleccionarEmisoraGuardada(int i)
    {
		if(i != 0){
			setEmisoraRadio(Float.parseFloat(emisorasGuardadas.get((i-1))));
			if(emisoraRadio <=107.9f){
				tipoSenal = false;
			}
			else{
				tipoSenal = true;
			}
			return ("Emisoras seleccionada: "+ Float.toString(emisoraRadio));
		}
		return ("No se ha podido seleccionar ninguna estacion");
	}

    @Override
    public String cambiarSenal(boolean b)
    {
        String est = "";
        boolean option = b;
        if(option == true)
        {
            tipoSenal = true;
            emisoraRadio = AMactual;
			est = ("Cambiaste a AM, Frecuencias: 530 a 1610");
			
        }
        else if(option == false)
        {
            tipoSenal = false;
            emisoraRadio = FMactual;
			est = ("Cambiaste a FM, Frecuencias: 87.9 a 107.9");
        }
		return est;
    }

    @Override
    public boolean getTipoSenal()
    {
        return tipoSenal;
    }

    @Override
    public void subirEmisora()
    {
		if(tipoSenal == true){
			emisoraRadio = emisoraRadio + 10f;
			setEmisoraRadio(emisoraRadio);
			if(emisoraRadio > 1610f) {
				 setEmisoraRadio(530f);
			}
			System.out.println("Esta escuchando la emisora: " + Float.toString(emisoraRadio));
		}
		else if(tipoSenal == false){
			emisoraRadio = emisoraRadio + 0.5f;
			setEmisoraRadio(emisoraRadio);
			if(emisoraRadio > 107.9f) {
				 setEmisoraRadio(87.9f);
			}
			System.out.println("Esta escuchando la emisora: " + Float.toString(emisoraRadio));
		}
		else{
			System.out.println("Se ha causado un error");
		}
    }

    @Override
    public void bajarEmisora()
    {
        if(tipoSenal == true){
			emisoraRadio = emisoraRadio - 10f;
			setEmisoraRadio(emisoraRadio);
			if(emisoraRadio < 530f) {
				 setEmisoraRadio(1610f);
			}
			System.out.println("Esta escuchando la emisora: " + Float.toString(emisoraRadio));
		}
		else if(tipoSenal == false){
			emisoraRadio = emisoraRadio - 0.5f;
			setEmisoraRadio(emisoraRadio);
			if(emisoraRadio < 87.9f) {
				 setEmisoraRadio(107.9f);
			}
			System.out.println("Esta escuchando la emisora: " + Float.toString(emisoraRadio));
		}
		else{
			System.out.println("Se ha causado un error");
		}
    }

    @Override
    public float getEmisoraActual()
    {
        return emisoraRadio;
    }

    @Override
    public boolean comprobarEncendida()
    {
        return encendido;
    }
	
	public ArrayList<String> getEmisorasGuardadas(){
		return emisorasGuardadas;
	}
}
