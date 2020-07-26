# MiTiempoApp-MVI-Hilt

------------

Sencilla aplicación para android que da la previsión de temperaturas en localidades de todo el mundo (en español como lenguaje de entrada/presentación), cuyo nombre es ingresado en el cuadro texto ([1](#nota)). Arranca la aplicación mostrando la predicción térmica de la ciudad de Sevilla, ES.


### Ejemplo de patrón MVI / Repository

------------


Esta app sirve de plantilla para el aprendizaje de la **arquitectura MVI** con **Repository**, **Livedata**, **Dagger/Hilt** (recientemente incorporado a Android), **Coroutines/Flow** y **Fragment** con **Navigation component**, siendo util para principiantes en Kotlin/Android que se adentran en la [Clean Architecture](https://devexperto.com/clean-architecture-android/ "Clean Architecture").

La aplicación recupera de la red los datos necesarios desde una **API REST** (https://api.tutiempo.net/; es trivial cambiar el patrón de búsqueda para recuperar los datos de poblaciones con entrada/salida en otras lenguas), los guarda en la base de datos y los vuelve a recuperar seguidamente de la misma (fuente única de confianza), mostrando durante el proceso una barra de progreso; al terminar muestra los datos en la UI, quedando lista para una nueva búsqueda.

### Referencias (Clean Architecture, MVI, Hilt, Navigation component):

------------


***Esquema de una Clean Architecuture***:
![Clean Architecture / MVI](https://camo.githubusercontent.com/684982fb8b636b4ce55d981ba97a0309cee42eca/68747470733a2f2f636f64696e67776974686d697463682e73332e616d617a6f6e6177732e636f6d2f7374617469632f636f75727365732f32312f636c65616e5f6172636869746563747572655f6469616772616d732e706e67 "Clean Architecture / MVI")

***Esquema del MVI pattern***:
![MVI pattern](https://miro.medium.com/max/1282/1*q2oRSMrKQbHeEViPBNkavQ.png "MVI pattern")

- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android "Hilt")
- [MVI pattern](https://proandroiddev.com/android-unidirectional-state-flow-without-rx-596f2f7637bb "MVI pattern")
- [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started "Navigation component")
- [Clean Architecture](https://devexperto.com/clean-architecture-android/ "Clean Architecture")

#### Notas:

------------

Esta muestra/plantilla es fácilmente moficable en relación a una mejora de su UI (que es minimalista), una presentación de un mayor número de datos procedente de la **API** o un mejor modelado de los mensajes de error, por ejemplo.


------------


(<a name="nota">1</a>) El método getFromLocationName del objeto Geocoder de Android da la latitud y la longitud dado el nombre de una población. En este caso, la API dará la información de la localidad más cercana de la que se disponga de datos. Hay que tener en cuenta que, si no se tienen datos a menos de 30 km del punto referenciado con las coordenadas proporcionadas por getFromLocationName, la salida dará un error.
