# DAO Product App

Небольшое приложение на Java Spring Boot для поиска товаров, которые заказывали пользователи.

Приложение получает имя пользователя, ищет его заказы в базе PostgreSQL и возвращает название товара.

### Что использовалось

- Java 21
- Spring Boot
- PostgreSQL
- Spring JDBC
- Maven

### Как устроен проект

- `ProductController` — принимает запросы.
- `ProductRepository` — ищет товары в базе данных.
- `schema.sql` — создаёт таблицы.
- `myScript.sql` — содержит SQL-запрос для поиска товаров.
- `application.properties` — настройки приложения и базы данных.

### Как запустить

1. Создать базу данных `dao_db` в PostgreSQL.
2. Указать логин и пароль PostgreSQL в переменных окружения `DB_USERNAME` и `DB_PASSWORD`.
3. Запустить приложение командой:

```bash
mvn spring-boot:run
```

### Проверка

Открыть в браузере:

`http://localhost:8080/products/fetch-product?name=Alexey`

В ответ приложение вернёт название товара, например:

`Keyboard`

Если пользователь или его заказ не найдены, появится сообщение:

`Продукт не найден`
