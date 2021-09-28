[![Codacy Badge](https://app.codacy.com/project/badge/Grade/e469b4a0f5a340d1a7f26a86e25ed172)](https://www.codacy.com/gh/JulianP-24/Lab-06/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=JulianP-24/Lab-06&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/JulianP-24/Lab-06.svg?style=svg)](https://circleci.com/gh/JulianP-24/Lab-06)

# PARTE UNO
3. Antes de que el servidor cierre la conexión por falta de comunicación:
Revise la página 36 del RFC del protocolo HTTP, sobre cómo realizar una petición GET. Con esto, solicite al servidor el recurso ‘sssss/abc.html’, usando la versión 1.0 de HTTP.
Asegúrese de presionar ENTER dos veces después de ingresar el comando.
Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.

**Error 301: Se refiere a un error de tipo REDIRECCIONAMIENTO utilizando la version HTTP 1.0** 
**Resultado**
~~~
HTTP/1.1 301 Moved Permanently
Connection: Close 
Date: Thu, 16 Sep 2021 13:54:11 GMT
Server: gunicorn
Location: https://www.escuelaing.edu.co/sssss/abc.html
Content-Type: text/html; charset=utf-8
~~~
¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?

4. Realice una nueva conexión con telnet, esta vez a:
* Host: www.httpbin.org
* Puerto: 80
* Versión HTTP: 1.1
Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?

**RESULTADO**
~~~
HTTP/1.1 200 ok 
Date: Tue, 21 Sep 2021 20:24:04 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 3741
Connection: keep-alive
Server: gunicorn/19.9.0
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true
~~~
De igual forma se obtiene como resultado un html, el cual tiene un body, un titulo y un parrafo.

5.  ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?
![](imagenes/imagen10.png)
Otros tipos de peticiones son:
* Head
* Put
* Delete
* Connect
* Options
* Trace
* Patch
# PARTE DOS
5. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá como host ‘localhost’, como puerto, el configurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo.
![](imagenes/imagen1.png)

6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando un parámetro GET (si no sabe como hacerlo, revise la documentación en http://www.w3schools.com/tags/ref_httpmethods.asp).
![](imagenes/imagen2.png)

8. En el navegador revise la dirección https://jsonplaceholder.typicode.com/todos/1. Intente cambiando diferentes números al final del path de la url.
![](imagenes/imagen3.png)
![](imagenes/imagen4.png)

15. Intente hacer diferentes consultas desde un navegador Web para probar las diferentes funcionalidades.
![](imagenes/imagen5.png)
![](imagenes/imagen6.png)
![](imagenes/imagen7.png)

# PARTE TRES
20. Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada. Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?
### Usando GET
![](imagenes/imagen8.png)
### Usando POST
![](imagenes/imagen9.png)
La diferencia entre POST y GET se encuentra en las urls, donde el GET lleva los datos de forma visible al cliente, lo cual cualquiera que vea la url puede saber esa informacion, mientras que el POST oculta los datos y los muestra a travez de un formulario y no en la url.

# PARTE CUATRO
3. Revise cada una de las configuraciones agregadas anteriormente para saber qué hacen y por qué se necesitan. Elimine las que no se necesiten.
* La etiqueta servlet no se puede borrar debido a que es necesaria para llamar a dicho servlet con la informacion necesaria
* La etiqueta servlet-mapping no se puede borrar ya que se utiliza para que se pueda acceder a dicho servlet, publicandolo en el exterior.
* La etiqueta welcome-file-list no se puede borrar ya que se utiliza como una pagina de bienvenida, la cual salta directamente a la pagina cuando el usuario ingresa el nombre del proyecto en la url o ingresa la url del contenedor web.
