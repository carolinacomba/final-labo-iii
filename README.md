[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/vOVgRZVd)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=11533703)
# Final LCIII 2023 - 08/Agosto/2023

## Introducción al problema:

Un cliente nos pide una aplicación que sea capaz de guardar los registros periodicos de los sensores de temperatura que posee en su fabrica. Para esto nos pide poder dar de alta los sensores informando el nombre del sensor, una descripción de la ubicación donde esta el sensor (por ejemplo en la entrada a la fabrica) y la unidad de medida en que el sensor mandará la información (grados C° o F°). Por otro lado, el sistema deberá proveer otra api para que los sensores manden las lecturas periodicas donde informarán su identificador, la fecha y hora de la lectura y la medida de su lectura.

Generar un proyecto en SpringBoot desde 0 usando la herramientas Maven, base de datos H2, Junit como framework para Test Unitarios y que cumpla con los siguientes requisitos.

 * CRUD de Sensor (GET all | GET by name | POST | PUT | DELETE)
 * CRUD de Lecturas (GET all | GET by dates (desde/hasta) de lectura | POST | PUT | DELETE)
Test Completos:
 * Api de filtrado por fecha (GET by dates) 
 * Alta de sensor (POST)
 * Incluir automatización de Swagger con la generación del archivo swagger.json
