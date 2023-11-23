# Proyecto Examen Marvel API

## Descripción
Bienvenidos al repositorio del Proyecto Examen Marvel API. Este proyecto es un desafío de desarrollo de aplicaciones Android, enfocado en el uso de la API de Marvel para crear una aplicación interactiva y atractiva. 
El objetivo es demostrar habilidades en construir aplicaciones robustas y escalables, siguiendo las mejores prácticas de la industria.

## Características
- **Consumo de Servicios con Retrofit**: Se realiza el acceso a la API de Marvel utilizando Retrofit para una integración eficiente y efectiva.
- **Activities y Fragments**: La interfaz de usuario se estructura utilizando Activities y Fragments, asegurando una experiencia de usuario fluida.
- **Componentes Visuales XML**: La interfaz de usuario se diseña con XML, para un aspecto atractivo y funcional.
- **Arquitectura MVVM**: Se implementa el patrón MVVM para separar la lógica de la interfaz de usuario y facilitar la mantenibilidad.
- **Clean Architecture**: Se sigue los principios de Clean Architecture para una estructura de proyecto escalable y mantenible.
- **Funcionalidad Offline**: Se garantiza que la aplicación funcione incluso sin conexión a internet.

## Notas Finales

Encontré que la API de Marvel tarda mucho en cargar las imagenes, entonces hice una petición y cambie el tiempo de respuesta de Picasso para que sea mÁs largo, pero las imagenes se ven, en caso de contar con un error 504, mandarán un Toast. Un poco de paciencia.
Muchas gracias por la oportunidad de presentar este examen, me faltaron algunas cosas que ya no pude terminar por darle prioridad a otras y unas fallas en mis tiempos
Espero que les guste el Clean Architecture y el MVVM.
En caso de que un personaje no tenga descripción de la API la app dice: "Descripción Clasificada"
Perdón por que se ve fea
Pueden revisar todo el repo para ver como hago los commits y MR.
