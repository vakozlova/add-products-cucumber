
# Автоматизация тестирования системы управления товарами QualIT
## Содержание
- [Описание](#описание)
- [Технологии](#технологии)
- [Подключение к стенду](#подключение-к-стенду)
- [Параметры базы данных](#параметры-базы-данных)
- [Установка и запуск](#установка-и-запуск)

## 📄 Описание
Этот проект использует Cucumber для разработки через поведение (BDD) и Allure для создания отчетов о тестах. 
Он автоматизирует проверку функциональности добавления товаров в базу данных и предоставляет подробные отчеты о выполнении тестов.

## 🛠 Технологии
- Java
- JUnit5
- Cucumber
- Allure Reports
- Selenium WebDriver
- Maven

## 🔌Подключение к стенду
1. Создайте папку Working Project на диске C.
2. Скачайте .jar файл по [ссылке](https://drive.google.com/file/d/18bI8rR9uPjVUNbSPIXBs84qViW0_VFpg/view).
3. Скопируйте скачанный файл в созданную папку.
4. Откройте консоль cmd.exe и переключитесь в папку с файлом командой:
```bash
cd C:\Working Project
```
5. Запустите стенд с помощью команды:
```bash
java -jar qualit-sandbox.jar
```
6. Перейдите по адресу: http://localhost:8080.
7. Для работы со стендом используйте вкладку "Песочница" - "Товары".

## 📊Параметры базы данных
1. После запуска стенда откройте консоль базы данных: http://localhost:8080/h2-console/
2. Укажите следующие параметры:
- БД: H2 Embedded
- URL: jdbc:h2:tcp://localhost:9092/mem:testdb
- Login: user
- Password: pass

## 🚀 Установка и запуск
1. Клонируйте проект:
```bash
git clone https://github.com/https://github.com/valeria-kozlova/add-products-cucumber
```
2. Настройте chromedriver.
3. Установите зависимости:
```bash
mvn install
```
4. Запустите тесты через Maven:
```bash
mvn clean test
```
5. Чтобы просмотреть отчеты Allure, используйте:
```bash
mvn allure:serve
```

