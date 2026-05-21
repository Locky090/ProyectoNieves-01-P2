public class main {
    public static void main(String[] args) {

        CentroControl centro = new CentroControl();

        Vehiculo v1 = new DronTransporte("D1");
        Vehiculo v2 = new CamionAutonomo("C1");

        // CREATE
        centro.crearVehiculo(v1);
        centro.crearVehiculo(v2);

        // READ
        centro.listarVehiculos();

        // STREAMS
        System.out.println("\nConectables:");
        centro.filtrarConectables().forEach(v ->
                System.out.println(v.getId())
        );

        // COUNT
        System.out.println("\nCantidad: " + centro.contarVehiculos());

        // ORDER
        System.out.println("\nOrdenados:");
        centro.ordenarPorId().forEach(v ->
                System.out.println(v.getId())
        );

        // DELETE
        centro.eliminarVehiculo("C1");

        System.out.println("\nDespués de eliminar:");
        centro.listarVehiculos();
    }
}
