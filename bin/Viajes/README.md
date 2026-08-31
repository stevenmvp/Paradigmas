# Sistema de gestion de viajes

Este paquete contiene el modelado inicial del sistema de viajes y turismo.

## Entidades

- `Usuario`: datos del viajero y pila de historial de busquedas.
- `Destino`: ciudad, pais, precio, tipo y disponibilidad.
- `Hotel`: alojamiento asociado a un destino y control de habitaciones.
- `Actividad`: clase abstracta para servicios con cupos y cola de espera.
- `Tour`, `Restaurante`, `Museo`, `Parque` y `Excursion`: especializaciones de `Actividad`.
- `Reserva`: relaciona usuario, destino, hotel, actividad, fecha y estado.
- `EstadoReserva`: estados pendiente, confirmada y cancelada.

## Abstracciones POO

- `IReservable` define las operaciones de disponibilidad y cupos.
- `Actividad` implementa la interfaz y deja `mostrarDetalles()` para las clases hijas.
- Las clases concretas de actividad aplican herencia y polimorfismo.
- Los atributos son privados y se accede a ellos mediante metodos publicos.

## Estructuras de datos preparadas

`SistemaViajes` centraliza listas de catalogos, una cola general de usuarios,
una pila de reservas recientes, una tabla hash de reservas por codigo, un arbol
ordenado de destinos por precio y un grafo de conexiones entre ciudades.

`MainViajes` contiene una ejecucion minima para comprobar el modelo.