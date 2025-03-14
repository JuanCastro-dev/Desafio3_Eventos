----------- Para uso em cloud ----------

- Faça as requisições pelo endereço http://18.218.207.201:8080 (TicketManager)
- Faça as requisições pelo endereço http://18.218.207.201:8081 (EventManager)

- É nescessário subir uma instância do Banco de Dados MongoDB com o nome do banco: Desafio3
      1. Crie uma instância EC2 (Garantindo que no security group esteja liberado o tráfego na porta 27017, que é a padrão do mongo)
      2. Conecte-se a ela via SSH
      3. Instale o MongoDB na instância com o comando : sudo apt-get install -y mongodb
      4. Configure o banco para permitir o acesso remoto com: sudo nano /etc/mongodb.conf, depois procure o bindIp e altere-o para 0.0.0.0
      5. Reinicie o mongoDb: sudo systemctl restart mongodb
      6. Abra o mongo shell com o comando: mongo --host <Ip da instância> --port 27017
      7. Execute o comando a seguir para criar o banco: use Desafio3


----------- Para uso local ----------

1. Clone o repositório
2. Execute os dois microsserviços
3. Pelo postman ou aplicação de preferência execute as requisições

- Faça as requisições pelo endereço http://localhost:8080 (TicketManager)
- Faça as requisições pelo endereço http://localhost:8081 (EventManager)

- É nescessário criar um Banco de Dados MongoDB com o nome do banco: Desafio3


----------- Requisições ----------

- Criar Evento: /events/create-event
- Deletar Evento: /events/delete-event/{id}
- Buscar Evento pelo id: /events/get-event/{id}
- Buscar todos os Eventos: /events/get-all-events
- Atualizar Evento: /events/update-event/{id}

- Criar Ticket: /tickets/create-ticket
- Deletar Ticket: /tickets/cancel-ticket/{id}
- Buscar Ticket pelo id: /tickets/get-ticket/{id}
- Buscar Tickets pelo id do Evento: /tickets/check-tickets-by-event/{eventId}
- Atualizar Ticket: /tickets/update-ticket/{id}

- Parametros para o corpo da requisição para atualizar ou criar um evento:
  {
  "eventName": "string",
  "dateTime": "DateTime",
  "cep": "string"
  }

- Parametros para o corpo da requisição para atualizar ou criar um ticket:
  {
  "cpf": "string",
  "customerName": "string",
  "customerMail": "string",
  "eventId": "string",
  "eventName": "string",
  "BRLamount": double,
  "USDamount": double
}
