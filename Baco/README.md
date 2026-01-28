# Baco — Paquetes de vacaciones low‑cost (app + web)

Proyecto académico para mostrar en GitHub: app móvil y página web conectadas a un mismo backend. Enfocado en **paquetes de viajes prefijados** desde Irlanda con precios cerrados (200/300/400€), pensado para viajeros con presupuesto fijo.

## Problema real
Muchas personas quieren viajar con presupuesto limitado y fechas flexibles, pero no saben qué opciones reales existen. La app ofrece paquetes simples, comparables por precio/fecha y con una reserva de interés sin pago.

## MVP (alcance mínimo viable)
- Listado de paquetes
- Filtro por presupuesto (200/300/400€) y fecha
- Detalle de paquete
- Reservar interés (formulario simple)
- Favoritos (guardar paquete)

## Usuarios
- Viajeros low‑cost (usuarios finales)
- (Opcional) Admin interno para gestionar paquetes

## Flujo principal
Buscar → filtrar → ver detalle → reservar interés → confirmación

## Arquitectura propuesta (alto nivel)
- **Backend único** (API REST)
- **App móvil** (cliente)
- **Web** (cliente)
- Base de datos con paquetes y reservas

## Próximos pasos
1. Definir modelo de datos
2. Diseñar endpoints básicos
3. Bocetar pantallas app/web
4. Crear datos semilla
