# Java_School_Challenge_web
Repositorio para el Java School Challenge

Este ejercicio se decidió implementar en JAVA usando el framework de Spring Boot,
esta implementación tiene dos endpoints un post el cual recibe la url original y nos
regresa el Shortener url y el segundo endpoint es un get el cual recibe el Shortener url como
parámetro y nos regresa la url original. Se cuenta con una capa de controladores la cual manda a
llamar la capa de servicio que usa un enfoque de fábrica abstracta ya que dependiendo del tipo de url el 
servicio manda a llamar a la capa de repositorio la cual ocupa una instancia en específico de una clase dependiendo el tipo de url encontrada.


Pruebas realizadas para la validación del código:

http://localhost:8080/shortenerURL/

POST
{
    "url" : "www.goasdf123ogle.comooooooo.com"
}

Response:
Alias : rlwwwgsdfglcmcm


POST
{
     "url" : "www.google.comooooooo.com"
}

Response:
Alias : ZQnvu


POST
{
    "url" : "www.yahoo.comooooooo.com"
}

Response:
Alias : 6136600

Para  validar la respuesta de los métodos GET solo es necesario poner:

http://localhost:8080/shortenerURL/(Alias regresado).



