# menuapi

## Назначение
REST API сервиса меню в ресторане.

## Развёртывание
1. Установить JDK 17 и прописать его Project Structure.
2. Сгенерировать https сертификат: ```keytool -genkeypair -alias mycert -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650``` и переместить его в `/src/main/resources`.

3. Установить переменные окружения `MENU_PSQL_USERNAME=dev`, `MENU_PSQL_PASSWORD=ps123`, `MENU_CERT_PASSWORD=<пароль от keystore.p12>`, `RABBITMQ_USER=rabbituser`, `RABBITMQ_PASS=rabbitpass`.
4. Запустить сборку проекта с пропуском тестов: `.\gradlew build -x test`.
5. Запустить сборку контейнеров `docker-compose build` (может потребоваться запустить сборку дважды, т.к. инициализируется стартовая БД с некоторыми данными).
6. Запустить контейнеры `docker-compose up`.