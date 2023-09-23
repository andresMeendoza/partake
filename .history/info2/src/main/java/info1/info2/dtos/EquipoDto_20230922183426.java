package info1.info2.dtos;

public class EquipoDto {
    private Long id;
    private String nombre;
    private String lugarJuego;
    private String directorTecnico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters y setters para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters para lugarJuego
    public String getLugarJuego() {
        return lugarJuego;
    }

    public void setLugarJuego(String lugarJuego) {
        this.lugarJuego = lugarJuego;
    }

    // Getters y setters para directorTecnico
    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }


    public EquipoDto() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public EquipoDto(Long id, String nombre, String lugarJuego, String directorTecnico) {
        this.id = id;
        this.nombre = nombre;
        this.lugarJuego = lugarJuego;
        this.directorTecnico = directorTecnico;
    }

}
