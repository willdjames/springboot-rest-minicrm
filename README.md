# springboot-rest-minicrm

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

Restful de empresa e seus funcionários para estudos.
Este componente rest também pode ser empacotado em um container docker com auxilio do plugin do Spotify.

* Para executar o componente com ajuda do maven, execute:
   > mvnw spring-boot:run -Dspring-boot.run.profiles=des

* Para gerar o container docker:
1. Altere o valor da tag <docker.image.prefix> no pom.xml com seu usuário do docker hub;
2. Certifique-se que o docker em sua máquina está em execução;
3. Rode o seguinte comando para gerar a imagem docker com o componente empacotado:
   > mvnw clean package dockerfile:build
4. Para criar um container com a imgem docker gerada, execute:
   > docker run -e "SPRING_PROFILES_ACTIVE=des" -p8080:8080 -t willdjames/springboot-rest-minicrm
