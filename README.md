Proyecto de API Testing Atomation con RestAssured y TestNG.Se usa un framework en el que se separan los endpoints, el payload, y los tests en los cuales sólo se hacen las validaciones.
Usando la API Petstore (https://petstore.swagger.io/) he creado Tests Automatizados para hacer un CRUD que envía peticiones a distintos endpoints.
También se usa la técnica de API Chaining usando datos obtenidos en una respuesta como datos de entrada, se generan reportes con ExtentsReports, logs con Log4j y se obtienen los endpoints de un archivo .properties.
Se hace Data Driven Testing obteniendo datos de un archivo Excel.
