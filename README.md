# Proyecto Java Web (Ampliar modelo Repository)

Es un codigo funcional en el cual se gestiono la conexion de bases de datos con SQL y Java, de importaron dependencias, se crearon diferentes clases JAVA con el codigo de la conexion (ConnectionPool, interfaz de repository entre otras) <br>
Se hace una encriptacion de contraseñas atravez de SQL y JAVA <br>
Se crean e insertan datos en la base de datos ya creada y llamda "my_app" <br>
Se crea 4 vistas, una de login, registro, categorias y productos , cada una con su formulario y patrones de validacion en cada input.

## Estructura del Proyecto

### Creacion de formularios "login" , "registrar" , "categorias" y "productos":
Creamos 4 formularios en html5 con sus respectivos campos y patrones en cada input para que el usuario digite lo que dice estrictamente el programa, aplicamos estilos con boostrap y unas lineas de css.
### Conexión a DB:
Creamos una clase llamada "BasicConnection" para comprobar la conectividad local con variables establecidas del localhost de SQL, seguidamente creamos un archivo llamado "pool de conexiones" donde alli implementamos las dependencias en el pom.xml con la version del Apache. <br>
Incluimo el RepositoryImpl para cada nuevo objeto en este caso el de "categorias y productos".
###  Encriptacion y desencriptacion:
Creamos la base de datos llamada "My_app" craemos unos campos para insertar datos, especificamente cambiamos el valor del campo de "password_tbl" y lo ponemos en varbinary(256) y con el "AES_ENCRYPT" para encryptar la contraseña.
###  Incluimos los beans para las tablas nuevas (categorias y productos) .


## Dependencias

### Dependencias de Sistema
- IntelliJ IDEA version 2023.1 <br>
- Jakarta EE <br>
- MySql

## Contacto
Jhoann Sebastian Zamudio <br>
jszamudio35@soy.sena.edu.co <br>
https://github.com/JoanZamudio/JAVA_AVANZADO_07-06-3.git
