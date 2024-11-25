package conversorMoneda;
import java.time.LocalDateTime;

public class HistorialConversion {

    private final String monedaBase;
    private final String monedaObjetivo;
    private final double cantidadBase;
    private final double cantidadConvertida;
    private final LocalDateTime fechaHora;

    public HistorialConversion(String monedaBase, String monedaObjetivo, double cantidadBase, double cantidadConvertida) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.cantidadBase = cantidadBase;
        this.cantidadConvertida = cantidadConvertida;
        this.fechaHora = LocalDateTime.now(); // Captura la fecha y hora actuales
    }

    @Override
    public String toString() {
        return String.format("Conversión: %.2f %s -> %.2f %s | Fecha y hora: %s",
                cantidadBase, monedaBase, cantidadConvertida, monedaObjetivo, fechaHora);
    }
}
