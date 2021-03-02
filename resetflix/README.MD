# RESETFLIX!!!!

O seu objetivo neste projeto é implementar o sistema do RESETFLIX, que definitivamente não é relacionado ao Netflix de maneira alguma.


## Swagger
 A definição do Swagger desejado pode ser encontrada [aqui.](https://pastebin.com/raw/2Aga2tpZ)

 Você deve copiar o conteúdo e colar no [editor.swagger.io.](https://editor.swagger.io/)


## Postman
 A coleção do Postman do RESETFLIX pode ser obtida [aqui.](https://www.getpostman.com/collections/bf5365eed7a1b9a3c547)
 
 Ao importar ela no Postman, você terá acesso a todas as requests, bem como exemplos de todos os retornos
 esperados.
 
 ## Swagger Local
 
 Para acessar o Swagger local, você deve rodar a aplicação e acessar a URL 
 http://localhost:8080/swagger-ui/
 
 Através desta URL, você poderá executar testes no seu código pelo Swagger UI.
 
 ### Implementações
 
* Obs: Se atentar ao padrão de pacotes (Controllers, Services, Repositories) 
e divisão de classes (Requests, Response, Entity, Mapper, Repository)

### Atores
- Os atores devem ter um Id, um Nome e uma lista de filmes dos quais participaram.
- Deve ser possível:
    - Listar atores (apenas Id e Nome)
    - Criar um novo ator (Nome e Ids de Filmes dos quais participou)
    - Obter detalhes de um ator (retorna seu Id, Nome, e Filmes dos quais participou)

### Diretores
- Exatamente as mesmas implementações dos Atores.

### Filmes
- Os filmes devem ter um Id, um Nome, um Genero, um Id de Diretor, e uma lista de Ids de atores.
- Deve ser possível:
    - Listar filmes (filtrando por Gênero, que é opcional). Deve trazer Id, Gênero e Nome.
    - Criar um novo Filme (Nome, Genero, Id de diretor e Ids de atores)
    - Obter detalhes de um filme (retorna seu Id, Nome, Genero, dados básicos do Diretor e dos Atores)
    
### Séries
- As mesmas implementações dos Filmes, mas ao invés de um Diretor, elas terão quantidade de Temporadas e Episódios.

# DESAFIO!

Implementar os endpoints 
> /filmes/{id}/assistir 

>/series/{id}/{temporada}/{episodio}/assistir

Devem registrar que o usuário assistiu ao conteúdo.
Pode-se considerar que essa aplicação está sendo utilizada sempre
pelo mesmo usuário, que poderá ser tratado como uma Entidade.

# DESAFIO 2 - A MISSÃO!
Implementar os endpoints
> /filmes/recomendacoes

> /series/recomendacoes

Devem retornar alguma série ou filme do Gênero 
mais assistido pelo usuário (obtido através do conteudo assistido).

O conteúdo retornado não deve ter sido assistido pelo usuário.

Caso não tenha o que recomendar, deve jogar uma _UsuarioDesocupadoException_.