# hero-challenge

## Servicio de heroes

### Usage

1. Loguearse usando **credenciales basicas**:

   **URL**: GET http://localhost:8080/
   
   **User**: seba
   
   **pass**: 1234

   Tomar el **XSRF-TOKEN**
2. Luego usar este token como header en **X-XSRF-TOKEN**
   
   Ej:
   
      X-XSRF-TOKEN:9a9bf2dd-a260-473e-ab07-0958cb84ecce

### Filtrar, paginar  y ordenar por name o cualquier campo :

GET http://localhost:8080/v1/hero?page=0&size=1&sort=name,ASC&search=name:*m*

Se uso **spring-search** que usa **Specifications** de Spring-Boot: https://github.com/sipios/spring-search

### Build image

`docker build -t hero:1.0 .`

`docker run -d -p 8080:8080 -t hero:1.0`

### Ver documentacion de la Api

OpenApi Docs: http://localhost:8080/swagger-ui.html

Swagger.yaml: https://github.com/Seba0703/hero-challenge/blob/ea3b4d19ece0efd3760329ee7b3605b2cfd31907/swagger.yaml

