# Desafio Itaú Backend ## 📌 Descrição Este projeto foi desenvolvido como solução para o **Desafio de Programação Backend do Itaú Unibanco**. O objetivo é construir uma **API REST** capaz de: * Receber transações financeiras * Armazenar os dados **em memória** * Calcular estatísticas das transações ocorridas nos **últimos 60 segundos** O projeto foi desenvolvido utilizando **Java + Spring Boot**, seguindo rigorosamente os requisitos propostos no desafio. --- ## 🛠️ Tecnologias Utilizadas * Java 21 * Spring Boot * Spring Web * Spring Validation * Maven --- ## 📂 Estrutura do Projeto
src/main/java/com/itau/desafio
 ├── controller
 │   ├── TransacaoController.java
 │   └── EstatisticaController.java
 ├── service
 │   ├── TransacaoService.java
 │   └── EstatisticaService.java
 ├── model
 │   ├── Transacao.java
 │   └── Estatistica.java
 └── DesafioItauApplication.java
--- ## ▶️ Como Executar o Projeto ### Pré-requisitos * Java 21 instalado * Maven instalado ### Executando a aplicação
bash
mvn spring-boot:run
A aplicação estará disponível em:
http://localhost:8080
--- ## 🔗 Endpoints Disponíveis ### ➕ 
POST /transacao Recebe uma transação financeira. **Request Body**
json
{
  "valor": 100.0,
  "dataHora": "2025-12-18T11:51:20Z"
}
**Regras de Validação** * valor deve ser maior ou igual a 0 * dataHora não pode estar no futuro * Campos obrigatórios devem estar preenchidos **Respostas** * 201 Created → Transação aceita * 400 Bad Request → Requisição inválida * 422 Unprocessable Entity → Regra de negócio violada --- ### 🗑️ DELETE /transacao Remove todas as transações armazenadas em memória. **Resposta** * 200 OK --- 
### 📊 GET /estatistica Retorna estatísticas das transações ocorridas nos **últimos 60 segundos**. **Response Body**
json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
**Observação** * Caso não existam transações no período, todos os valores retornam 0. --- ## ⚠️ Regras Importantes do Desafio * Não utiliza banco de dados * Dados armazenados exclusivamente em memória * API aceita e retorna apenas JSON * Endpoints seguem exatamente o padrão solicitado --- ## 🚀 Considerações Finais Este projeto foi desenvolvido com foco em: * Clareza de código * Organização da aplicação * Boas práticas REST * Conformidade total com o desafio proposto Sinta-se à vontade para avaliar, testar e sugerir melhorias. --- 👤 **Autor** Projeto desenvolvido para fins de avaliação técnica.
