package dominio;

public class Pet {
	private int id;
	private String nombre;
	private String sexo;
	private String edad;
	
	public Pet()
	{
	}

	public Pet(int id, String nombre, String sexo, String edad) {
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + "]";
	}
	
}
