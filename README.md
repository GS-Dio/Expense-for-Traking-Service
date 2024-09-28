# Expense for Tracking Service

## Описание

Expense for Tracking Service — это микросервис для ведения расходов. Он позволяет пользователям управлять своими транзакциями, ограничениями расходов и курсами валют.

## Установка и запуск

### Шаги для запуска

1. Клонируйте репозиторий:

   ```bash
   git clone <https://github.com/GS-Dio/Expense-for-Traking-Service>
   cd Expense-for-Tracking-Service
Соберите и запустите сервис с помощью Docker Compose:

bash
Копировать код
docker-compose up --build
После успешного запуска сервиса, H2 консоль будет доступна по адресу:

bash
Копировать код
http://localhost:8080/h2-console
Для подключения используйте следующие параметры:

JDBC URL: jdbc:h2:mem:testdb
User Name: admin
Password: оставьте пустым
Использование API
Сервис предоставляет следующие конечные точки:

Создать транзакцию

POST /api/transactions
Тело запроса:
json
Копировать код
{
  "accountFrom": "string",
  "accountTo": "string",
  "amount": 100,
  "currency": "USD"
}

Получить все транзакции
GET /api/transactions

## Зависимости:
Spring Boot: Основной фреймворк для создания веб-приложений.
Spring Data JPA: Для работы с базами данных и реализации репозиториев.
H2 Database: Временная база данных для разработки и тестирования.
Flyway: Для управления миграциями базы данных.
Spring Web: Для создания RESTful API.
