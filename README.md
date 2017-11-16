# Arquitetura de Microservices

Arquitetura de Microservices para cadastros de campanhas de esporte e socio torcedor utilizando Spring Boot, Spring AMQP, Spring Cloud, Spring Data JPA, Base de dados H2 em memória, Tomcat, REST.

Foi escolhido Spring Boot pela vantagem de facilitar o processo de configuração e publicação de aplicações. Com base na convenção sobre a configuração. Com ele foi possivel utilizar por exemplo um tomcat embarcado e um banco de dados H2 em memoria, agilizando o desenvolvimento.

# Deadlock

Deadlock é a situação indesejada em que duas ou mais threads ficam bloqueadas mutuamente indefinidamente, devido uma desejar o lock de um recurso da outra que ja o possui.
Por exemplo, se a thread 1 bloquear o recurso A, e tentar bloquear o recurso B, e a thread 2 já bloqueou B, e tentar bloquear A, surge um deadlock. 
Thread 1 nunca pode obter B, e thread 2 nunca pode obter A.

Solucoes de lock como Thread.join() e Object.wait() podem ser usadas.

# Stream e ParallelStream

O Java 8 introduziu o conceito de Streams como uma maneira eficiente de realizar operações em massa em dados de forma declarativa.
E com o ParallelStreams vantagens podem ser obtidas em ambientes que oferecem suporte à concorrência como as arquiteturas de núcleos múltiplos.
Com o stream o processamento e executado em uma unica thread, enquanto que com o parallelstream varias thread sao criadas e processadas em diferentes núcleos da CPU.

Um exemplo, supondo que queiramos filtrar os produtos com estoque disponiveis para a venda, poderia ser assim:

```
List<Produto> produtos = buscarProdutos();
        
List<Produto> produtosDisponiveisParaVenda = produtos.parallelStream().filter(produto -> getEstoqueDisponivel(produto) > 0).collect(Collectors.toList());
```
