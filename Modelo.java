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
    public String TipoSenal;
    public double AMactual;
    public double FMactual;
    public int NumBoton;
    public String NumEmisora;
    public double EmisoraRadio;
    ArrayList<String> EmisorasGuardadas = new ArrayList<String>();
    Scanner scan = new Scanner(System.in);
    
    //Métodos

    //Constructor
    public Modelo()
    {
        Encendido = false;
        TipoSenal = "AM";
        AMactual = 530;
        FMactual = 87.9;
        NumBoton = 1;
        NumEmisora = null;
        EmisoraRadio = 87.5;
    }

    public void setNumEmisora(String NumEmisora)
    {
        this.NumEmisora = NumEmisora;
    }

    public void setEmisoraRadio(Double EmisoraRadio)
    {
        this.EmisoraRadio = EmisoraRadio;
    }

    @Override
    public void EncenderApagar()
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
    public void GuardarEmisora()
    {
        System.out.println("Ingrese el numero de la emisora: (entre 82.5 y 107.5)");
        NumEmisora = scan.nextLine();

        setNumEmisora(NumEmisora);

        EmisorasGuardadas.add(NumEmisora);
    }

    @Override
    public void seleccionarEmisora()
    {
        System.out.println("Emisoras: "+ EmisorasGuardadas);
    }

    @Override
    public void cambiarSenal()
    {
        System.out.println("1. FM\n2. AM");
        int option = scan.nextInt();
        if(option == 1)
        {
            TipoSenal = "FM";
            EmisoraRadio = FMactual;
        }
        else if(option == 2)
        {
            TipoSenal = "AM";
            EmisoraRadio = AMactual;
        }
        if(TipoSenal =="FM")
        {
            System.out.println("Cambiaste a FM, Frecuencias: 300 Khz a 30 Khz");
        }
        else if(TipoSenal =="AM")
        {
            System.out.println("Cambiaste a AM, Frecuencias: 3.000 Khz a 300 Khz");
        }
    }

    @Override
    public void getTipoSenal()
    {
        System.out.println("La señal actual es: " + TipoSenal);
    }

    @Override
    public void SubirEmisora()
    {
        while(EmisoraRadio >= 82.5 && EmisoraRadio <= 107.5)
        {
            System.out.println("\n1. Subir emisora");
            System.out.println("2. Bajar emisora");
            int opcion = scan.nextInt();
            switch(opcion)
            {
                case 1:
                    EmisoraRadio = EmisoraRadio + 0.5;
                    setEmisoraRadio(EmisoraRadio);
                    System.out.println("Esta escuchando la emisora: " + EmisoraRadio);
                    break;
                case 2:
                    EmisoraRadio = EmisoraRadio - 0.5;
                    setEmisoraRadio(EmisoraRadio);
                    System.out.println("Esta escuchando la emisora: " + EmisoraRadio);
                    break;
                default:
                    System.out.println("ERROR: Escogio una opcion invalida\nIntente de nuevo");
            }
            break;
        }
    }

    @Override
    public void BajarEmisora()
    {
        while(EmisoraRadio >= 82.5 && EmisoraRadio <= 107.5)
        {
            System.out.println("\n1. Subir emisora");
            System.out.println("2. Bajar emisora");
            int opcion = scan.nextInt();
            switch(opcion)
            {
                case 1:
                    EmisoraRadio = EmisoraRadio + 0.5;
                    setEmisoraRadio(EmisoraRadio);
                    System.out.println("Esta escuchando la emisora: " + EmisoraRadio);
                    break;
                case 2:
                    EmisoraRadio = EmisoraRadio - 0.5;
                    setEmisoraRadio(EmisoraRadio);
                    System.out.println("Esta escuchando la emisora: " + EmisoraRadio);
                    break;
                default:
                    System.out.println("ERROR: Escogio una opcion invalida\nIntente de nuevo");
            }
            break;
        }
    }

    @Override
    public void getEmisoraActual()
    {
        
    }

    @Override
    public void comprobarEncendida()
    {
        
    }
}
