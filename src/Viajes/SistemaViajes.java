package Viajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class SistemaViajes {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Destino> destinos = new ArrayList<>();
    private final List<Hotel> hoteles = new ArrayList<>();
    private final List<Actividad> actividades = new ArrayList<>();
    private final Map<String, Reserva> reservas = new HashMap<>();
    private final Stack<String> historialReservas = new Stack<>();
    private final Queue<Usuario> usuariosEnEspera = new LinkedList<>();
    private final TreeSet<Destino> destinosPorPrecio = new TreeSet<>(
            Comparator.comparingDouble(Destino::getPrecioAproximado).thenComparing(Destino::getCodigoDestino));
    private final Map<String, Set<String>> conexiones = new HashMap<>();

    public void agregarUsuario(Usuario usuario) { usuarios.add(usuario); }
    public void agregarDestino(Destino destino) { destinos.add(destino); destinosPorPrecio.add(destino); conexiones.putIfAbsent(destino.getCiudad(), new HashSet<>()); }
    public void agregarHotel(Hotel hotel) { hoteles.add(hotel); }
    public void agregarActividad(Actividad actividad) { actividades.add(actividad); }

    public List<Destino> buscarDestinosPorPrecio(double precioMaximo) {
        List<Destino> resultado = new ArrayList<>();
        for (Destino destino : destinosPorPrecio) if (destino.getPrecioAproximado() <= precioMaximo) resultado.add(destino);
        return resultado;
    }

    public void conectarDestinos(Destino origen, Destino destino) {
        conexiones.putIfAbsent(origen.getCiudad(), new HashSet<>());
        conexiones.putIfAbsent(destino.getCiudad(), new HashSet<>());
        conexiones.get(origen.getCiudad()).add(destino.getCiudad());
        conexiones.get(destino.getCiudad()).add(origen.getCiudad());
    }

    public void conectarCiudades(String ciudadOrigen, String ciudadDestino) {
        Destino origen = destinos.stream().filter(d -> d.getCiudad().equals(ciudadOrigen)).findFirst().orElse(null);
        Destino destino = destinos.stream().filter(d -> d.getCiudad().equals(ciudadDestino)).findFirst().orElse(null);
        if (origen != null && destino != null) conectarDestinos(origen, destino);
    }

    public Reserva registrarReserva(String codigo, Usuario usuario, Destino destino, Hotel hotel,
            Actividad actividad, LocalDate fecha) {
        Reserva reserva = new Reserva(codigo, usuario, destino, hotel, actividad, fecha);
        reservas.put(codigo, reserva);
        historialReservas.push(codigo);
        return reserva;
    }

    public Reserva buscarReserva(String codigo) { return reservas.get(codigo); }
    public List<Reserva> getReservas() { return new ArrayList<>(reservas.values()); }
    public boolean eliminarDestino(String codigo) {
        Destino destino = destinos.stream().filter(item -> item.getCodigoDestino().equals(codigo)).findFirst().orElse(null);
        if (destino == null) return false;
        destinos.remove(destino);
        destinosPorPrecio.remove(destino);
        conexiones.remove(destino.getCiudad());
        return true;
    }
    public boolean eliminarHotel(String codigo) { return hoteles.removeIf(hotel -> hotel.getCodigoHotel().equals(codigo)); }
    public boolean eliminarActividad(String codigo) { return actividades.removeIf(actividad -> actividad.getIdActividad().equals(codigo)); }
    public String obtenerUltimaReserva() { return historialReservas.isEmpty() ? null : historialReservas.peek(); }
    public void agregarUsuarioEnEspera(Usuario usuario) { usuariosEnEspera.offer(usuario); }
    public Usuario atenderUsuarioEnEspera() { return usuariosEnEspera.poll(); }
    public List<Usuario> getUsuarios() { return new ArrayList<>(usuarios); }
    public List<Destino> getDestinos() { return new ArrayList<>(destinos); }
    public List<Hotel> getHoteles() { return new ArrayList<>(hoteles); }
    public List<Actividad> getActividades() { return new ArrayList<>(actividades); }
    public Map<String, Set<String>> getConexiones() { return new HashMap<>(conexiones); }
}