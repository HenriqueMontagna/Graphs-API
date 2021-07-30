# Graphs-API

## Rotas desenvolvidas

|Rotas|Funcionalidades|
|:---:|:---:|
| POST - /graph| Grava um grafo|
| GET - /graph/{graphId}| Retorna um grafo dado o seu id(graphId) por Path Param|

OBS: Este projeto usa a lib do lombok para evitar POJOs verbosos, entreatando algumas IDEs não estão prontas para o lombok, acusando erros falsos-positivos.
Para resolver este erro, siga os passos neste link, item 3: https://www.baeldung.com/lombok-ide#eclipse