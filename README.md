# Disseminação de Fake News



Este projeto em Java simula a disseminação de fake news entre pessoas em uma grade, onde um conjunto de  células representa uma casa. As regras de disseminação são baseadas na proximidade e no tipo de casa em que a pessoa entra. A simulação é mostrada no terminal e permite observar como as fake news se espalham ou são contidas através de diferentes interações.



#### Regras da Simulação
1)Troca de Contato:
Quando há pessoas em casas adjacentes, elas trocam contatos.

2)Gerador de Fake News:
Quando uma pessoa entra em uma casa geradora de fake news, ela se infecta.
Todos os contatos salvos por essa pessoa também são infectados.

3)Destruidor de Fake News:
Quando uma pessoa entra em uma casa destruidora de fake news, ela se cura.
Todos os contatos salvos por essa pessoa também são curados.

4)Casa Segura:
Quando uma pessoa entra em uma casa segura, ela fica temporariamente imune a receber fake news.
