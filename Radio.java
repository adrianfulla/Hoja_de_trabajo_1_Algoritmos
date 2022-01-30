/***************************************************************************
@File Radio.java
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 30/01/2022

Interfaz que tendra los metodos de la clase Radio.
***************************************************************************/

public interface Radio 
{
    public void encenderApagar();
    public String guardarEmisoraActual(int numBoton);
    public String seleccionarEmisoraGuardada(int i);
    public String cambiarSenal(boolean b);
    public boolean getTipoSenal();
    public void subirEmisora();
    public void bajarEmisora();
    public float getEmisoraActual();
    public boolean comprobarEncendida();
}
