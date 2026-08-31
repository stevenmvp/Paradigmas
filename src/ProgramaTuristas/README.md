# Programa Turistas

`MainProgramaTuristas` es la interfaz de consola del simulador. No utiliza API
ni servidor externo: la carpeta `datos/` funciona como una base de datos local
compuesta por archivos JSON separados por entidad.

Ejecutar desde la carpeta del proyecto:

```text
javac -d bin src/Viajes/*.java src/ProgramaTuristas/*.java
java -cp bin ProgramaTuristas.MainProgramaTuristas
```

Al iniciar por primera vez se crea un catalogo y estas cuentas:

- Administrador: documento `admin`, contrasena `admin123`.
- Cliente demo: documento `1001`, contrasena `cliente123`.

El administrador puede crear y eliminar elementos del catalogo, revisar todas
las reservas, conectar ciudades y atender la cola de espera. El cliente puede
consultar el catalogo y solo ver, crear o cancelar sus propias reservas.
Las clases del dominio y sus estructuras se reutilizan desde `Viajes`.