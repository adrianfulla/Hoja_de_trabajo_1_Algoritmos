/***************************************************************************
@File Radio.java
@Autor: Adrian Fulladolsa
        Sebastián José Solorzano Pérez
@Version: 1.0
Última modificación: 27/01/2022

Interfaz que tendra los metodos de la clase Radio.
***************************************************************************/

public interface Radio 
{
    public void encenderApagar();
    public String guardarEmisoraActual();
    public String seleccionarEmisora(int i);
    public String cambiarSenal(boolean b);
    public boolean getTipoSenal();
    public void SubirEmisora();
    public void BajarEmisora();
    public float getEmisoraActual();
    public boolean comprobarEncendida();
}
