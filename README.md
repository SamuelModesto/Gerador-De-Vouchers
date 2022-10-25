<br />
<p align="center">
  <h3 align="center">Gerador de Vouchers</h3>
</p>

<!-- TABLE OF CONTENTS -->

## Conteúdo

- [Conteúdo](#Conteúdo)
- [Sobre o projeto](#Sobre-o-Projeto)
  - [Arquitetura](#Arquitetura)
- [Iniciando](#Iniciando)
  - [Como usar](#Como-usar)
- [Contribuindo](#Contribuindo)
- [Licença](#Licença)
- [Contato](#Contato)

## Sobre o Projeto
O objetivo é criar um micro serviço de pool de vouchers baseado em micro serviço usando Spring Data JPA e MongoDB.
### Arquitetura

<div>
<img src="https://github.com/SamuelModesto/Imagens/blob/master/Gerador%20de%20Vouchers/arquitetura-gerador-de-voucher.jpeg" width="600px" />
</div>

## Iniciando


### Como usar
 1. Baixe o projeto.
 2. Abra os dois projetos na IDE de sua preferência (gateway e getnet).
 3. Inicialize a classe `GatewayApplication`.
 4. Inicialize a classe `GetnetApplication`
 5. Acesse o arquivo `application.yml` para informações de acesso ao banco de dados.
 6. Baixe a collection do postman  `getnet.postman_collection.json` disponibilizada neste repositório para informações de acesso ao banco de dados.
 7. Primeiro um ou mais destinatários `Criar Destinatario` precisam ser criados.
 8. Após isso, basta usar a request `Criar Oferta`.
 9. Para resgatar um voucher use a request de busca `Recuperar destinatarios` copie um codigo de voucher e o email do destinatario para usar na request `Resgatar Voucher`.

## Contribuindo

As contribuições são o que tornam a comunidade de código aberto um lugar incrível para aprender, inspirar e criar. Qualquer contribuição que você fizer será **muito apreciada**.

1. Faça um 'fork' do projeto
2. Cria uma branch para a sua feature(`git checkout -b feature/amazing-feature`)
3. Insira suas alterações (`git add .`)
4. Faça um commit com as suas alterações (`git commit -m 'feat(<project-filename>): Inserindo uma feature!`)
5. Faça um push da sua branch (`git push origin feature/amazing-feature`)
6. Abra um Pull Request

## Licença

Distribuído sob a licença do MIT. Consulte `LICENSE` para obter mais informações.

## Contato

Samuel Modesto 
- [Github](https://github.com/SamuelModesto) 
- [LinkedIn](https://www.linkedin.com/in/samuelmodesto)
- **samuelmodestoes@gmail.com**
