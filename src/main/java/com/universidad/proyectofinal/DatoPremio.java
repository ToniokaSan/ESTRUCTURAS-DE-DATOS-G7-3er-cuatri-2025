package com.universidad.proyectofinal;

/**
 *Representa un premio dentro del juego, con su tipo de operación, número asociado
 * y una descripción detallada. Se utiliza para otorgar recompensas o beneficios a los jugadores.
 *Autores: Anthony Potoy Alemán, Natalie Barboza Garcia, Arianna Rodriguez Badilla, Sebastian Alvarez Murillo.
 */
public class DatoPremio {
    private char operacion;
    private int numero;
    private String descripcion;

    /**
     * Constructor de la clase DatoPremio. Crea un nuevo premio con su
     * operación, número y descripción.
     *
     * @param operacion Tipo de operación del premio (por ejemplo, '+' o '-').
     * @param numero Valor numérico del premio.
     * @param descripcion Texto descriptivo que explica el premio.
     */
    public DatoPremio(char operacion, int numero, String descripcion) {
        this.operacion = operacion;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el tipo de operación del premio.
     *
     * @return El carácter que representa la operación.
     */
    public char getOperacion() {
        return operacion;
    }

    /**
     * Obtiene el valor numerico del premio.
     *
     * @return El número del premio.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtiene la descripción del premio.
     *
     * @return Texto descriptivo del premio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica el tipo de operación del premio.
     *
     * @param operacion Nuevo carácter de operación.
     */
    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    /**
     * Modifica el valor numérico del premio.
     *
     * @param numero Nuevo valor del premio.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Modifica la descripción del premio.
     *
     * @param descripcion Nueva descripción del premio.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve una representación en texto del premio, incluyendo su operación,
     * número y descripción.
     *
     * @return Cadena con los datos del premio.
     */

    @Override
    public String toString() {
        return "Operación: " + operacion + ", Número: " + numero + " (" + descripcion + ")";
    }
}