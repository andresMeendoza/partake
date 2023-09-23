package info1.info2.Excepciones;

public class EquipoNotFoundExcepcion extends RuntimeException {

    public EquipoNotFoundExcepcion(Long equipoId) {
        super("Equipo no encontrado con ID: " + equipoId);
    }
}
