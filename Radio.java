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
    public void EncenderApagar();
    public void GuardarEmisora();
    public void seleccionarEmisora();
    public void cambiarSenal();
    public void getTipoSenal();
    public void SubirEmisora();
    public void BajarEmisora();
    public void getEmisoraActual();
    public void comprobarEncendida();
}
