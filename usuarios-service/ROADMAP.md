# Instrucciones para Agentes

## Proyecto

Sistema de Gestión de Cine basado en Microservicios.

## Arquitectura

Arquitectura Hexagonal (Ports & Adapters).

## Regla principal

Nunca escribir código sin revisar primero la documentación del proyecto.

## Metodología

1. Diseñar
2. Documentar
3. Implementar
4. Probar
5. Actualizar documentación

## Dominio

El dominio nunca depende de Spring.

No usar @Entity dentro del dominio.

No usar @Service dentro del dominio.

## Persistencia

Siempre mediante Adaptadores.

Nunca acceder directamente a JpaRepository desde un UseCase.

## API

Todas las respuestas deben utilizar ApiResponse<T>.

Los errores deben utilizar ErrorResponse.

## Convenciones

UUID.

Eliminación lógica.

DTO para entrada y salida.

Swagger obligatorio.

## Documentación

Toda decisión importante debe registrarse antes de implementarse.