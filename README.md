# <b>_La Casa Dorada_ 🍝</b>

_Este proyecto esta basado en un software para la automatizacion de gestiones contables y administrativas del restaurante "La Casa Dorada"._<br><br>
_Este es un software totalmente libre, es decir, puede ser utilizado por cualquier persona._

## <b>_Valor de la aplicación_</b> 📹

_Para ver el porque esta aplicación es la mejor opción, dirigete al siguiente enlace [Clic aquí]()_

## <b>_Instalación_</b> 💻

_El programa es portable:_

* 1️⃣ _Descargar el .ZIP del programa en este enlace [Clic aquí](https://www.mediafire.com/file/5cf0g55mwti35nv/CasaDorada.zip/file)._<br>
* 2️⃣ _Extraer el archivo para dejar la carpeta en la cual se encuentra todo lo que necesita._<br>

## <b>_Ejecución_</b> 📦

_Tenemos dos formas para que ejecutes el programa: un ejecutable .exe, archivo java .jar._

* _Para ejecutar el programa desde su ejecutable, deberas abrir el archivo .exe llamado CasaDorada. Una vez hecho esto, el programa se inicializara solo dando inicio a la pantalla de registro. <br><br> Este ejecutable no podra ser copiado o pegado en otra parte, lo que si puedes hacer, es crear un acceso directo en el escritorio para así, tener mayor facilidad a la hora de ingresar al programa. Si te surge algun error al ejecutarlo: Puedes ver este video: [Clic aquí]()._<br><br>
* _Para ejecutar el programa desde su .jar, deberas tener un JRE minimo de: "jre1.8.0_281" en el cual fue desarrollado. Luego, deberas seguir estos pasos: <br><br> 1️⃣ Ejecutar tu consola de comandos. <br><br> 2️⃣ Navegar hasta el directorio en el cual descargaste tu .ZIP o carpeta App si clonaste el directorio.<br><br> 3️⃣ Ejecutar el siguiente comando para ejecutarlo, cualquier error mostrado en consola hacer caso omiso:_<br>
```
java -jar JFX-System-Casa-Dorada
```

## <b>_Construido con_</b> 🛠️

* [Java](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) - Lenguaje de programación en el que se trabajo.
* [Adobe Illustrator](https://www.adobe.com/la/products/illustrator/free-trial-download.html) - Programa donde se editaron todas las imagenes.
* [NetBeans](https://netbeans.apache.org/) - IDE en el cual se trabajo el codigo base
* [Scene Builder](https://gluonhq.com/products/scene-builder/) - Programa donde se realizo el desarrollo de la GUI.
* [JFoenix](https://github.com/sshahine/JFoenix) - Libreria para mejorar aspecto del GUI.

_Todas las librerias usadas se encuentran en la siguiente ruta visible desde el repositorio o clonando el proyecto:_<br>

```
/resources/auxLibs/
```

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)
## <b>_Versionado_</b> 📌

_Usamos [GitHub](https://github.com/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/GabrielSB19/JFX-System-Casa-Dorada)._

## <b>_Autores_ ✒️

* _David Montaño - [cuatrosr](https://github.com/cuatrosr)_
* _Gabriel Suarez - [GabrielSB19](https://github.com/GabrielSB19)_

## <b>_Importar Datos_</b> ⚙️

_Tenemos formatos ya preestablecidos al momento de importar desde el menu bar de la aplicacion los datos alojados en archivos .csv: Clientes, Productos, Pedidos._<br><br>
_Todos los archivos ejemplos que se usaron para las pruebas de importacion se encuentran en la siguiente ruta visible desde el repositorio o clonando el proyecto:_<br>

```
/resources/imports/
```

* Para los clientes: Se usara el separador "," entre valores: nombre,apellido,identificacion,direccion,telefono,observaciones<br><br>
* Para los productos: Se usara el separador "," entre valores: precio,nombre,tipoDeProducto,Ingrediente,Tamaño<br><br>Si el tipo de producto o el ingrediente no esta en la base de datos del programa lo que va a hacer es importarlo. <br><br>Si ya esta en la base de datos, porfavor, asegurarse de poner el nombre exacto al momento de importar<br><br>
* Para los pedidos: Se usara el separador "," entre valores: EstadoOrden,observacionesOrden,nombreCliente,apellidoCliente,identificacionCliente,direccionCliente,telefonoCliente,observacionesCliente,nombreEmpleado,apellidoEmpleado,identificacionEmpleado,nombreProducto,tamañoProducto,precioProducto,ingredienteProducto,tipoProducto<br><br>El EstadoOrden debera ser: "SOLICITADO","EN_PROCESO","ENVIADO","ENTREGADO".<br><br>Si el cliente, empleado, ingrediente, o el tipo de producto no esta en la base de datos del programa lo que va a hacer es importarlo. <br><br>Si ya esta en la base de datos, porfavor, asegurarse de poner el nombre exacto al momento de importar<br><br>

## <b>_Generar Datos_</b> ⚙️

_Para generar reportes se deberan seguir los sigientes pasos:_<br>

* 1️⃣ _Seleccionar desde el menu bar de la aplicacion la opcion de generar reporte._<br>
* 2️⃣ _Se debera de tener un archivo .CSV para que los datos se guarden en este._<br>
* 3️⃣ _Si este archivo .CSV no esta totalmente vacio puede que ocurra un error, en caso de esto, eliminar los elementos de este archivo y volver a generar sobre este._<br>

## <b>_Formateo de datos_</b> ⭐

_Para eliminar todos los datos de la aplicacion para volver a su estado de fabrica debera seguir estos pasos:_<br>

* 1️⃣ _Entrar a la carpeta que se especificara a continuacion, ten encuenta, por ningun motivo la debes de borrar:_<br>
```
/data/
```

* 2️⃣ _Encontraras adentro un archivo .CGD llamado "CasaDorada" el cual deberas borrar_<br><br>La aplicacion entonces se ha formateado correctamente.<br>

## <b>_Documentacion e Imagenes_</b> 💬📷

* _Toda documentacion desde los requerimientos del Software hasta el diagrama de clases se encuentra en un PDF alojado en esta ruta visible desde el repositorio o clonando el proyecto:_<br>

```
/resources/docs/Requirements and Diagram.pdf
```

* _Todas las imagenes utilizadas tanto en el Software como en este Readme se encuentran en esta ruta visible desde el repositorio o clonando el proyecto:_<br>

```
/resources/image/
```

## <b>_Funcionalidades_</b> 📱📹

_Para ver las funcionalidades de la aplicación, por favor, ve las imagenes que estan acontinuacion. Si quieres un poco más de detalle puedes ver el siguiente video: [Clic aquí]()_<br>

* <b>_Iniciar sesion_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Inicio%20Sesion.png)<br><br>
* <b>_Registro_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Registro.png)<br><br>
* <b>_Menu intuitivo_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Menu.png)<br><br>
* <b>_Gestionar empleados_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Empleados.png)<br><br>
* <b>_Gestionar clientes_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Cliente.png)<br><br>
* <b>_Gestionar ingredientes_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Ingredientes.png)<br><br>
* <b>_Gestionar tipo de productos_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Tipo%20de%20Producto.png)<br><br>
* <b>_Gestionar productos_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Productos.png)<br><br>
* <b>_Añadir ingrediente a producto_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/AddIngToP.png)<br><br>
* <b>_Añadir tipo de producto a producto_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/AddTpToP.png)<br><br>
* <b>_Visualizar listas_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/ListarElementos.png)<br><br>
* <b>_Gestionar Pedidos_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Pedidos.png)<br><br>
* <b>_Busqueda de clientes para pedidos_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/BusquedaC.png)<br><br>
* <b>_Añadir productos a pedidos_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/AddPToO.png)<br><br>
* <b>_Importar reportes_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Importar.png)<br><br>
* <b>_Generar reportes_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Reportes%20Short.png)<br><br>
* <b>_Plantilla para los reportes_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/ReportBase.png)<br><br>
* <b>_Calendario para la generación de reportes_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Calendar.png)<br><br>
* <b>_Reloj para la generación de reportes_</b> <br><br>
![ScreenShot](https://github.com/GabrielSB19/JFX-System-Casa-Dorada/blob/master/resources/image/Reloj.png)

## <b>_Expresiones de Gratitud_</b> 🎁

* _Agradecemos a los integrantes del grupo de discord: "Matriculados Papi" por la ayuda durante el desarrollo._ 📢

---
⌨️ con ❤️ por [cuatrosr](https://github.com/cuatrosr) 😊<br>
⌨️ con ❤️ por [GabrielSB19](https://github.com/GabrielSB19) 😊
