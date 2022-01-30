/***************************************************************************
@File Modelo.java
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 27/01/2022

Programa que tendra los metodos y las propiedades de la clase modelo.
***************************************************************************/

import java.util.Scanner;
import java.util.ArrayList;

public class Modelo implements Radio
{
    //Propiedades
    public boolean Encendido;
    public boolean TipoSenal;
    public float AMactual;
    public float FMactual;
    public int NumBoton;
    public String NumEmisora;
    public float EmisoraRadio;
    ArrayList<String> EmisorasGuardadas = new ArrayList<String>();
    Scanner scan = new Scanner(System.in);
    
    //Métodos

    //Constructor
    public Modelo()
    {
        Encendido = false;
        TipoSenal = true;
        AMactual = 530f;
        FMactual = 87.9f;
        NumBoton = 1;
        NumEmisora = null;
        EmisoraRadio = 530f;
    }

    public void setNumEmisora(float f)
    {
        this.NumEmisora = Float.toString(f);
    }

    public void setEmisoraRadio(float f)
    {
        this.EmisoraRadio = f;
		if(TipoSenal == true){
			this.AMactual = f;
		}
		else{
			this.FMactual = f;
		}
    }

    @Override
    public void encenderApagar()
    {
        if(Encendido == false)
        {
            System.out.println("¿Deseas encender la radio?\n 1. Si\n2. No");
            int opcion = scan.nextInt();
            if(opcion == 1)
            {
                System.out.println("Se ha encendido la radio");
                Encendido = true;
            }
            else if (opcion == 2)
            {
                System.out.println("No se ha encendido la radio");
                Encendido = false;
            }
            else
            {
                System.out.println("Error, intentalo de nuevo");
            }   
        }
        else if(Encendido == true)
        {
            System.out.println("¿Deseas apagar la radio?\n1. Si\n2. No");
            int opcion2 = scan.nextInt();
            if(opcion2 == 1)
            {
                System.out.println("Se ha apagado la radio");
                Encendido = false;
            }
            else if(opcion2 == 2)
            {
                System.out.println("La radio sigue encendida");
            }
        }
    }

    @Override
    public String guardarEmisoraActual()
    {
		setNumEmisora(EmisoraRadio);
        EmisorasGuardadas.add(NumEmisora);
		
		String m = ("Se ha guardado la emisora " + NumEmisora);
		return m;
    }

    @Override
    public String seleccionarEmisora(int i)
    {
		if(i != 0){
			setEmisoraRadio(Float.parseFloat(EmisorasGuardadas.get((i-1))));
			if(EmisoraRadio <=107.9f){
				TipoSenal = false;
			}
			else{
				TipoSenal = true;
			}
			return ("Emisoras seleccionada: "+ Float.toString(EmisoraRadio));
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
            TipoSenal = true;
            EmisoraRadio = AMactual;
			est = ("Cambiaste a AM, Frecuencias: 530 a 1610");
			
        }
        else if(option == false)
        {
            TipoSenal = false;
            EmisoraRadio = FMactual;
			est = ("Cambiaste a FM, Frecuencias: 87.9 a 107.9");
        }
		return est;
    }

    @Override
    public boolean getTipoSenal()
    {
        return TipoSenal;
    }

    @Override
    public void SubirEmisora()
    {
		if(TipoSenal == true){
			EmisoraRadio = EmisoraRadio + 10f;
			setEmisoraRadio(EmisoraRadio);
			if(EmisoraRadio > 1610f) {
				 setEmisoraRadio(530f);
			}
			System.out.println("Esta escuchando la emisora: " + Float.toString(EmisoraRadio));
		}
		else if(TipoSenal == false){
			EmisoraRadio = EmisoraRadio + 0.5f;
			setEmisoraRadio(EmisoraRadio);
			if(EmisoraRadio > 107.9f) {
				 setEmisoraRadio(87.9f);
			}
			System.out.println("Esta escuchando la emisora: " + Float.toString(EmisoraRadio));
		}
		else{
			System.out.println("Se ha causado un error");
		}
    }

    @Override
    public void BajarEmisora()
    {
        if(TipoSenal == true){
			EmisoraRadio = EmisoraRadio - 10f;
			setEmisoraRadio(EmisoraRadio);
			if(EmisoraRadio < 530f) {
				 setEmisoraRadio(1610f);
			}
			System.out.println("Esta escuchando la emisora: " + Float.toString(EmisoraRadio));
		}
		else if(TipoSenal == false){
			EmisoraRadio = EmisoraRadio - 0.5f;
			setEmisoraRadio(EmisoraRadio);
			if(EmisoraRadio < 87.9f) {
				 setEmisoraRadio(107.9f);
			}
			System.out.println("Esta escuchando la emisora: " + Float.toString(EmisoraRadio));
		}
		else{
			System.out.println("Se ha causado un error");
		}
    }

    @Override
    public float getEmisoraActual()
    {
        return EmisoraRadio;
    }

    @Override
    public boolean comprobarEncendida()
    {
        return Encendido;
    }
	
	public ArrayList<String> getEmisorasGuardadas(){
		return EmisorasGuardadas;
	}
}
