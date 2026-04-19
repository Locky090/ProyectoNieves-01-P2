package ProyectoNieves;

 class CamionAutonomo extends Vehiculo {

     public CamionAutonomo(String id) {
         super(id);
     }

     @Override
     public String patronMovimiento() {
         return "Patron detectado: lineal con aceleración progresiva";
     }
