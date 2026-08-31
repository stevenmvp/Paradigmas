package ProgramaTuristas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Viajes.Actividad;
import Viajes.Destino;
import Viajes.Excursion;
import Viajes.EstadoReserva;
import Viajes.Hotel;
import Viajes.Museo;
import Viajes.Parque;
import Viajes.Reserva;
import Viajes.Restaurante;
import Viajes.Rol;
import Viajes.SistemaViajes;
import Viajes.Tour;
import Viajes.Usuario;

public class PersistenciaJson {
    private static final Path CARPETA = Paths.get("datos");

    public void cargar(SistemaViajes sistema) {
        try {
            Files.createDirectories(CARPETA);
            cargarUsuarios(sistema);
            cargarDestinos(sistema);
            cargarHoteles(sistema);
            cargarActividades(sistema);
            cargarReservas(sistema);
            cargarConexiones(sistema);
        } catch (IOException error) {
            throw new IllegalStateException("No se pudieron leer los archivos JSON.", error);
        }
    }

    public void guardar(SistemaViajes sistema) {
        try {
            Files.createDirectories(CARPETA);
            escribir("usuarios.json", usuariosJson(sistema));
            escribir("destinos.json", destinosJson(sistema));
            escribir("hoteles.json", hotelesJson(sistema));
            escribir("actividades.json", actividadesJson(sistema));
            escribir("reservas.json", reservasJson(sistema));
            escribir("conexiones.json", conexionesJson(sistema));
        } catch (IOException error) {
            throw new IllegalStateException("No se pudieron guardar los archivos JSON.", error);
        }
    }

    private void cargarUsuarios(SistemaViajes sistema) throws IOException {
        for (String objeto : objetos("usuarios.json")) {
            sistema.agregarUsuario(new Usuario(cadena(objeto, "documento"), cadena(objeto, "nombre"),
                    cadena(objeto, "correo"), cadena(objeto, "telefono"), cadena(objeto, "contrasena"),
                    Rol.valueOf(cadena(objeto, "rol"))));
        }
    }

    private void cargarDestinos(SistemaViajes sistema) throws IOException {
        for (String objeto : objetos("destinos.json")) {
            sistema.agregarDestino(new Destino(cadena(objeto, "codigo"), cadena(objeto, "ciudad"),
                    cadena(objeto, "pais"), numero(objeto, "precio"), cadena(objeto, "tipo"),
                    booleano(objeto, "disponible")));
        }
    }

    private void cargarHoteles(SistemaViajes sistema) throws IOException {
        for (String objeto : objetos("hoteles.json")) {
            Destino destino = destino(sistema, cadena(objeto, "destino"));
                if (destino != null) {
                Hotel hotel = new Hotel(cadena(objeto, "codigo"), cadena(objeto, "nombre"), destino,
                    cadena(objeto, "habitacion"), numero(objeto, "precio"), entero(objeto, "disponibles"));
                sistema.agregarHotel(hotel);
                }
        }
    }

    private void cargarActividades(SistemaViajes sistema) throws IOException {
        for (String objeto : objetos("actividades.json")) {
            Destino destino = destino(sistema, cadena(objeto, "destino"));
            if (destino == null) continue;
            String tipo = cadena(objeto, "tipo");
            String id = cadena(objeto, "id");
            String nombre = cadena(objeto, "nombre");
            double precio = numero(objeto, "precio");
            String horario = cadena(objeto, "horario");
            int cupos = entero(objeto, "cupos");
            Actividad actividad;
            switch (tipo) {
                case "Tour": actividad = new Tour(id, nombre, destino, precio, horario, cupos, cadena(objeto, "guia"), cadena(objeto, "encuentro")); break;
                case "Restaurante": actividad = new Restaurante(id, nombre, destino, precio, horario, cupos, cadena(objeto, "comida"), booleano(objeto, "vestimenta")); break;
                case "Museo": actividad = new Museo(id, nombre, destino, precio, horario, cupos, cadena(objeto, "tematica"), cadena(objeto, "exposicion")); break;
                case "Parque": actividad = new Parque(id, nombre, destino, precio, horario, cupos, booleano(objeto, "natural")); break;
                default: actividad = new Excursion(id, nombre, destino, precio, horario, cupos, cadena(objeto, "dificultad"), cadena(objeto, "equipo"));
            }
            actividad.restaurarCuposDisponibles(entero(objeto, "disponibles"));
            sistema.agregarActividad(actividad);
        }
    }

    private void cargarConexiones(SistemaViajes sistema) throws IOException {
        for (String objeto : objetos("conexiones.json")) sistema.conectarCiudades(cadena(objeto, "origen"), cadena(objeto, "destino"));
    }

    private void cargarReservas(SistemaViajes sistema) throws IOException {
        for (String objeto : objetos("reservas.json")) {
            Usuario usuario = usuario(sistema, cadena(objeto, "usuario"));
            Destino destino = destino(sistema, cadena(objeto, "destino"));
            Hotel hotel = hotel(sistema, cadena(objeto, "hotel"));
            Actividad actividad = actividad(sistema, cadena(objeto, "actividad"));
            if (usuario != null && destino != null) {
                Reserva reserva = sistema.registrarReserva(cadena(objeto, "codigo"), usuario, destino, hotel, actividad,
                        LocalDate.parse(cadena(objeto, "fecha")));
                reserva.restaurarEstado(EstadoReserva.valueOf(cadena(objeto, "estado")));
            }
        }
    }

    private String usuariosJson(SistemaViajes s) {
        List<String> datos = new ArrayList<>();
        for (Usuario u : s.getUsuarios()) datos.add(objeto("documento", u.getDocumento(), "nombre", u.getNombre(), "correo", u.getCorreo(), "telefono", u.getTelefono(), "contrasena", u.getContrasena(), "rol", u.getRol().name()));
        return arreglo(datos);
    }
    private String destinosJson(SistemaViajes s) {
        List<String> datos = new ArrayList<>();
        for (Destino d : s.getDestinos()) datos.add("{\"codigo\":\"" + escapar(d.getCodigoDestino()) + "\",\"ciudad\":\"" + escapar(d.getCiudad()) + "\",\"pais\":\"" + escapar(d.getPais()) + "\",\"precio\":" + d.getPrecioAproximado() + ",\"tipo\":\"" + escapar(d.getTipoDestino()) + "\",\"disponible\":" + d.isDisponible() + "}");
        return arreglo(datos);
    }
    private String hotelesJson(SistemaViajes s) {
        List<String> datos = new ArrayList<>();
        for (Hotel h : s.getHoteles()) datos.add("{\"codigo\":\"" + escapar(h.getCodigoHotel()) + "\",\"nombre\":\"" + escapar(h.getNombre()) + "\",\"destino\":\"" + escapar(h.getDestino().getCodigoDestino()) + "\",\"habitacion\":\"" + escapar(h.getTipoHabitacion()) + "\",\"precio\":" + h.getPrecioNoche() + ",\"disponibles\":" + h.getHabitacionesDisponibles() + "}");
        return arreglo(datos);
    }
    private String actividadesJson(SistemaViajes s) {
        List<String> datos = new ArrayList<>();
        for (Actividad a : s.getActividades()) datos.add("{\"id\":\"" + escapar(a.getIdActividad()) + "\",\"tipo\":\"" + a.getClass().getSimpleName() + "\",\"nombre\":\"" + escapar(a.getNombre()) + "\",\"destino\":\"" + escapar(a.getDestino().getCodigoDestino()) + "\",\"precio\":" + a.getPrecio() + ",\"horario\":\"" + escapar(a.getHorario()) + "\",\"cupos\":" + a.getCuposTotales() + ",\"disponibles\":" + a.getCuposDisponibles() + "}");
        return arreglo(datos);
    }
    private String conexionesJson(SistemaViajes s) {
        List<String> datos = new ArrayList<>();
        for (var entrada : s.getConexiones().entrySet()) for (String destino : entrada.getValue())
            if (entrada.getKey().compareTo(destino) < 0) datos.add(objeto("origen", entrada.getKey(), "destino", destino));
        return arreglo(datos);
    }
    private String reservasJson(SistemaViajes s) {
        List<String> datos = new ArrayList<>();
        for (Reserva r : s.getReservas()) datos.add("{\"codigo\":\"" + escapar(r.getCodigoReserva()) + "\",\"usuario\":\"" + escapar(r.getUsuario().getDocumento()) + "\",\"destino\":\"" + escapar(r.getDestino().getCodigoDestino()) + "\",\"hotel\":\"" + (r.getHotel() == null ? "" : escapar(r.getHotel().getCodigoHotel())) + "\",\"actividad\":\"" + (r.getActividad() == null ? "" : escapar(r.getActividad().getIdActividad())) + "\",\"fecha\":\"" + r.getFechaViaje() + "\",\"estado\":\"" + r.getEstado() + "\"}");
        return arreglo(datos);
    }

    private void escribir(String nombre, String contenido) throws IOException { Files.writeString(CARPETA.resolve(nombre), contenido); }
    private List<String> objetos(String nombre) throws IOException {
        Path archivo = CARPETA.resolve(nombre);
        if (!Files.exists(archivo)) return List.of();
        Matcher matcher = Pattern.compile("\\{([^{}]*)\\}").matcher(Files.readString(archivo));
        List<String> resultado = new ArrayList<>();
        while (matcher.find()) resultado.add(matcher.group(1));
        return resultado;
    }
    private String objeto(String... campos) { StringBuilder b = new StringBuilder("{"); for (int i = 0; i < campos.length; i += 2) { if (i > 0) b.append(','); b.append('"').append(campos[i]).append("\":\"").append(escapar(campos[i + 1])).append('"'); } return b.append('}').toString(); }
    private String arreglo(List<String> objetos) { return "[" + String.join(",", objetos) + "]"; }
    private String escapar(String valor) { return valor.replace("\\", "\\\\").replace("\"", "\\\""); }
    private String cadena(String objeto, String campo) { Matcher m = Pattern.compile("\\\"" + campo + "\\\":\\\"([^\\\"]*)\\\"").matcher(objeto); if (!m.find()) return ""; return m.group(1).replace("\\\"", "\"").replace("\\\\", "\\"); }
    private double numero(String o, String c) { return Double.parseDouble(valor(o, c)); }
    private int entero(String o, String c) { return Integer.parseInt(valor(o, c)); }
    private boolean booleano(String o, String c) { return Boolean.parseBoolean(valor(o, c)); }
    private String valor(String o, String c) { Matcher m = Pattern.compile("\\\"" + c + "\\\":([^,]+)").matcher(o); return m.find() ? m.group(1).replace("\"", "").trim() : "0"; }
    private Destino destino(SistemaViajes s, String codigo) { return s.getDestinos().stream().filter(d -> d.getCodigoDestino().equals(codigo)).findFirst().orElse(null); }
    private Usuario usuario(SistemaViajes s, String documento) { return s.getUsuarios().stream().filter(u -> u.getDocumento().equals(documento)).findFirst().orElse(null); }
    private Hotel hotel(SistemaViajes s, String codigo) { return s.getHoteles().stream().filter(h -> h.getCodigoHotel().equals(codigo)).findFirst().orElse(null); }
    private Actividad actividad(SistemaViajes s, String id) { return s.getActividades().stream().filter(a -> a.getIdActividad().equals(id)).findFirst().orElse(null); }
}