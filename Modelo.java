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
	
	/**
     * Setter de la clase NumEmisora
     * 
     * @param float representativo de la Emisora
     */
    public void setNumEmisora(float f)
    {
        this.NumEmisora = Float.toString(f);
    }

	/**
     * Setter de la clase emisoraRadio
     * 
     * @param float representativo de la Emisora
     */
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

	/**
     * Metodo que enciende o apaga el programa
     * 
     */
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

	/**
     * Metodo que guarda la Emisora Actual
     * 
     * @param int representativo del boton
	 * @return String que indica que se ha guardado la emisora
     */
    @Override
    public String guardarEmisoraActual(int numBoton)
    {
		setNumEmisora(emisoraRadio);
        emisorasGuardadas.add(NumEmisora);
		
		String m = ("Se ha guardado la emisora " + NumEmisora);
		return m;
    }

	/**
     * Metodo que permite que el usuario escoga una emisora guardada
     * 
     * @param int representativo del indice de la emisora guardada
	 * @return String que indica la emisora que ha sido escogida
     */
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
	
	/**
     * Metodo que cambia el tipo de señal 
     * 
     * @param boolean que identifica si se cambia a AM o a FM siendo AM true y FM false
	 * @return String que indica que se cambiado el tipo de señal
     */
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

	/**
     * Getter del tipo de señal 
     * 
	 * @return boolean representativo del tipo de señal, true si es AM y false si es FM
     */
    @Override
    public boolean getTipoSenal()
    {
        return tipoSenal;
    }

	/**
     * Metodo que aumenta la frecuencia de la radio, si llega al maximo de frecuencias permitido 
     * para el tipo de señal se procede a cambiar al minimo de frecuencias 
	 *
     */
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
	/**
     * Metodo que disminuye la frecuencia de la radio, si llega al minimo de frecuencias permitido 
     * para el tipo de señal se procede a cambiar al maximo de frecuencias 
	 *
     */	
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
	
	/**
     * Getter de la emisora actual
     * 
	 * @return float representativo de la emisora
     */
    @Override
    public float getEmisoraActual()
    {
        return emisoraRadio;
    }

	/**
     * Metodo que comprueba si el radio se encuentra apagado o encendido
     * 
	 * @return boolean que reprenta si el radio se encuentra apagado si es false y encendido si es true
     */
    @Override
    public boolean comprobarEncendida()
    {
        return encendido;
    }
	
	/**
     * Getter de las emisoras guardadas
     * 
	 * @return ArrayList de String de las emisoras que han sido guardadas
     */
	public ArrayList<String> getEmisorasGuardadas(){
		return emisorasGuardadas;
	}
}
