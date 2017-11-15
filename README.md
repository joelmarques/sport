# Microservices
Arquitetura de Microservices para cadastros de campanhas de esporte e socio torcedor utilizando Spring Boot, Spring AMQP, Spring Cloud, Spring Data JPA, Base de dados H2 em memória, Tomcat, REST.

# Deadlock

Deadlock é a situação indesejada em que duas ou mais threads ficam bloqueadas mutuamente indefinidamente, devido uma desejar o lock de um recurso da outra que ja o possui.
Por exemplo, se a thread 1 bloquear o recurso A, e tentar bloquear o recurso B, e a thread 2 já bloqueou B, e tentar bloquear A, surge um deadlock. 
Thread 1 nunca pode obter B, e thread 2 nunca pode obter A.

Solucoes de lock como Thread.join() e Object.wait() pode ser usadas.
