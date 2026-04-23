# SIVEBO - Sistema de Ventas y Bodega
**PROPUESTA DE PROYECTO**

Sistema POS Integral para Operadores Polifuncionales

**RapidinBombin**

Fecha: Abril 2025

# **1\. Problemática**

## **1.1 Contexto de la Empresa**

RapidinBombin es una empresa de logística con presencia en múltiples sucursales, cuya operación diaria depende de operadores polifuncionales. Estos trabajadores son responsables de ejecutar una amplia variedad de tareas críticas para el funcionamiento del negocio.

## **1.2 Funciones del Operador Polifuncional**

Actualmente, cada operador debe gestionar de forma simultánea las siguientes responsabilidades:

- Admisión y recepción de paquetería entrante
- Manejo del inventario de paquetes recepcionados y despachados
- Control del inventario de materiales de embalaje
- Venta de embalaje y servicios adicionales a los clientes
- Gestión de las finanzas de la sucursal (caja, cierre, reportes)

## **1.3 Descripción del Problema**

La empresa enfrenta una serie de problemas operacionales derivados de la fragmentación de sus sistemas actuales:

**Fragmentación de herramientas:**

El operador debe alternar entre múltiples sistemas o herramientas para completar sus tareas diarias. Esto provoca pérdida de tiempo, errores de ingreso y una experiencia de trabajo ineficiente.

**Alto volumen de atención a clientes:**

Las sucursales de RapidinBombin atienden un gran volumen de clientes diariamente. La lentitud en los procesos operacionales genera colas de espera, insatisfacción del cliente y pérdida de productividad.

**Curva de aprendizaje elevada:**

Al utilizar sistemas separados y sin una interfaz unificada, la capacitación de nuevos operadores es lenta y costosa. Cada nuevo ingreso requiere aprender múltiples plataformas.

**Falta de trazabilidad integral:**

Sin un sistema centralizado, es difícil realizar seguimiento completo a un paquete desde su admisión hasta su entrega, ni cruzar información entre inventario, ventas y finanzas de forma confiable.

**Riesgo de errores financieros:**

La gestión manual o desconectada de la caja y los reportes financieros aumenta el riesgo de descuadres, pérdidas no detectadas y falta de transparencia en la operación de cada sucursal.

## **1.4 Impacto del Problema**

Los problemas descritos generan un impacto directo en tres dimensiones clave del negocio:

- Operacional: Mayor tiempo por atención, errores frecuentes y reprocesos
- Económico: Pérdidas por descuadres, mermas de inventario no detectadas y ventas mal registradas
- Experiencia del cliente: Tiempos de espera elevados y falta de información en tiempo real sobre sus envíos

# **2\. Soluciones Propuestas**

A continuación se presentan tres alternativas de solución para abordar la problemática descrita. Se evalúan en función de su viabilidad técnica, escalabilidad y alineación con los requerimientos de RapidinBombin.

| **Solución**                                                          | **Descripción**                                                                                                                                                                                                                                                 | **Ventajas**                                                                                                                       | **Desventajas**                                                                                   |
| --------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| **Solución A (Recomendada): Sistema POS Integral con Microservicios** | Desarrollo de un sistema web unificado basado en arquitectura de microservicios. Cada funcionalidad (admisión, tracking, inventario, ventas, finanzas) opera como un servicio independiente con su propia base de datos MariaDB, comunicados mediante API REST. | Alta escalabilidad. Fácil mantenimiento por módulos. Permite agregar sucursales sin rediseñar el sistema. Portal cliente incluido. | Mayor complejidad inicial de desarrollo. Requiere buena coordinación entre servicios.             |
| ---                                                                   | ---                                                                                                                                                                                                                                                             | ---                                                                                                                                | ---                                                                                               |
| **Solución B: Sistema Monolítico con Módulos**                        | Desarrollo de una aplicación única que integra todas las funcionalidades en un solo proyecto con una base de datos centralizada y módulos separados por funcionalidad.                                                                                          | Desarrollo más rápido. Menor complejidad inicial. Fácil de desplegar.                                                              | Difícil de escalar. Un fallo puede afectar todo el sistema. Poco flexible ante nuevas sucursales. |
| ---                                                                   | ---                                                                                                                                                                                                                                                             | ---                                                                                                                                | ---                                                                                               |
| **Solución C: Software ERP Comercial Adaptado**                       | Adquisición y configuración de un ERP comercial existente (como Odoo o similar) adaptado a los procesos de RapidinBombin.                                                                                                                                       | Implementación rápida. Soporte técnico incluido. Funcionalidades probadas.                                                         | Costo de licenciamiento. Poca personalización. Dependencia del proveedor externo.                 |
| ---                                                                   | ---                                                                                                                                                                                                                                                             | ---                                                                                                                                | ---                                                                                               |

## **2.1 Solución Recomendada: Sistema POS Integral con Microservicios**

Se recomienda la Solución A debido a su capacidad de escalar con el crecimiento de RapidinBombin y su alineación con las mejores prácticas de desarrollo de software moderno.

El sistema estará compuesto por 10 microservicios independientes:

- MS-01 Auth & Usuarios: Gestión de login y roles (admin, operador, supervisor)
- MS-02 Sucursales: Configuración y administración de una unica sucursal
- MS-03 Admisión de Paquetes: Registro de ingreso y generación de número de tracking
- MS-04 Tracking & Logística: Control de estados (recibido, en tránsito, entregado)
- MS-05 Inventario de Paquetes: Stock de paquetes recepcionados y despachados
- MS-06 Inventario de Embalaje: Control de materiales de embalaje por sucursal
- MS-07 Ventas / POS: Venta de embalaje y servicios, generación de boletas
- MS-08 Finanzas: Apertura y cierre de caja, reportes de ventas y gastos
- MS-09 Clientes: Registro de remitentes y destinatarios
- MS-10 Portal Cliente: Consulta pública de tracking sin necesidad de login

## **2.2 Principios Técnicos de la Solución**

La solución propuesta se basa en los siguientes principios técnicos:

- Comunicación entre servicios mediante API REST (HTTP/JSON)
- Principio Database per Service: cada microservicio tiene su propia base de datos MariaDB independiente
- Implementación del Patrón CSR (Controller-Service-Repository) en cada servicio
- Uso de DTOs (Data Transfer Objects) para el intercambio de datos entre capas
- Persistencia de datos con MariaDB gestionada mediante XAMPP en entorno de desarrollo
- Interfaz web unificada para el operador, diseñada para ser rápida y fácil de aprender

## **2.3 Criterios de Selección**

La Solución A fue seleccionada por cumplir con los siguientes criterios prioritarios del proyecto:

- Interfaz única para el operador que centraliza todas las funciones
- Soporte para múltiples sucursales sin necesidad de rediseño
- Portal web para que los clientes consulten el estado de sus paquetes
- Sistema de roles diferenciados (admin, operador, supervisor)
- Escalabilidad para incorporar nuevos servicios o sucursales en el futuro

_Documento preparado para revisión y aprobación - RapidinBombin 2025_


