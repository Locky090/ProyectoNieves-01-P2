import java.util.*;
import java.util.stream.Collectors;

public class CentroControl {

    private Map<String, Vehiculo> flota;

    public CentroControl() {
        flota = new HashMap<>();
    }

    // CREATE
    public void crearVehiculo(Vehiculo v) {
        flota.put(v.getId(), v);
    }

    // READ
    public void listarVehiculos() {
        flota.values().forEach(v -> {
            System.out.println(v.patronMovimiento());
        });
    }

    public Vehiculo buscarVehiculo(String id) {
        return flota.get(id);
    }

    // UPDATE
    public void modificarVehiculo(String id, Vehiculo nuevo) {
        if (flota.containsKey(id)) {
            flota.put(id, nuevo);
        }
    }

    // DELETE
    public void eliminarVehiculo(String id) {
        flota.remove(id);
    }

    // ===== LAMBDA =====
    public void monitorearFlota() {
        flota.values().forEach(v -> {
            System.out.println(v.patronMovimiento());

            if (v instanceof IConectable c) {
                c.sincronizarGPS();
            }
        });
    }

    // ===== STREAMS =====

    // Filtrar conectables
    public List<Vehiculo> filtrarConectables() {
        return flota.values()
                .stream()
                .filter(v -> v instanceof IConectable)
                .collect(Collectors.toList());
    }

    // Obtener IDs
    public List<String> obtenerIds() {
        return flota.values()
                .stream()
                .map(Vehiculo::getId)
                .collect(Collectors.toList());
    }

    // Contar
    public long contarVehiculos() {
        return flota.size();
    }

    // Buscar por tipo (por clase)
    public List<Vehiculo> buscarPorTipo(Class<?> tipo) {
        return flota.values()
                .stream()
                .filter(v -> v.getClass().equals(tipo))
                .collect(Collectors.toList());
    }

    // ===== ORDENAMIENTO =====

    public List<Vehiculo> ordenarPorId() {
        return flota.values()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getId))
                .collect(Collectors.toList());
    }
}
