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