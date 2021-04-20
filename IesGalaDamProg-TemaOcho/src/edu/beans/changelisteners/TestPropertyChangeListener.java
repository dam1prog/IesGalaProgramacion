package edu.beans.changelisteners;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
/**
 * Clase para detectar los cambios de valor en una propiedad de un Bean
 * @author Rafa
 * @version 1.0
 *
 */
public class TestPropertyChangeListener {
	/**
	 * Método de la interfaz ChangeListener
	 * @param prop Propiedad sobre la que se observa el cambio de valor
	 * @param oldValue Valor anterior
	 * @param newValue Nuevo valor
	 */
	public static void changed(ObservableValue<? extends Number> prop,
            Number oldValue, Number newValue) {

        System.out.print("Propiedad cambiada (" + prop.getClass().getName()+"):");
        System.out.println("Antes = " + oldValue + ", Después = " + newValue);
    }

    public static void main(String[] args) {
    	//se crea una nueva propiedad de tipo IntegerProperty
        IntegerProperty age = new SimpleIntegerProperty(100);
        //se añade la clase actual como clase de evento para el cambio de valor
        age.addListener(TestPropertyChangeListener::changed);
        //se realizan cambios de valor en la propiedad
        age.set(101);
        age.set(102);
        
        age.setValue(103);
        age.setValue(104);
    }

}
