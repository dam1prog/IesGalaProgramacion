package edu.beans;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Clase de tipo Bean JavaFx. Se usa para instanciarla y mostrar sus propieades
 * @author Rafa
 * @version 1.0
 */
public class Persona {
	private final ReadOnlyIntegerWrapper id = new ReadOnlyIntegerWrapper(this, "id", 1);
	private final StringProperty nombre = new SimpleStringProperty(this, "nombre", "?");
	private final ObjectProperty<LocalDate> fecha = new ReadOnlyObjectWrapper<>(this, "fecha");

	public final int getId() {
		return id.get();
	}

	public ReadOnlyIntegerProperty idProperty() {
		return id.getReadOnlyProperty();
	}

	public String getNombre() {
		return nombre.get();
	}

	public final void setNombre(String value) {
		nombre.set(value);
	}

	public final StringProperty nombreProperty() {
		return nombre;
	}


	public final LocalDate getFecha() {
		return fecha.get();
	}

	public final void setFecha(LocalDate value) {
		fecha.set(value);
	}

	public ObjectProperty<LocalDate> fechaProperty() {
		return fecha;
	}
}