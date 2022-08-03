# projeto-alma-backend

API desenvolvida para ser utilizada no projeto AngularTourOfHeroes, que se encontra no repositório "projeto-alma-front" (https://github.com/rachel-araujo/projeto-alma-front)

### Criar uma imagem Docker

Após as alterações feitas no código-fonte é necessário compilar o backend para a geração do jar utilizado na imagem.
Para isso execute o seguinte comando:

```shell
mvn clean install -DskipTests
```

Após a compilação será necessário criar a imagem Docker:

```shell
docker build -t heroes .
```
