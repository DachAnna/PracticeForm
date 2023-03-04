### Реализован локальный запуск тестов на форму регистрации на странице https://demoqa.com/automation-practice-form с использованием рандомных данных 
![Страница регистрации](https://user-images.githubusercontent.com/118796374/222902208-2973cfb7-c0f4-416c-bec4-c947b7532765.png)

#### Автотесты запускаются локально на http://localhost:8080/

![запуск тестов локально](https://user-images.githubusercontent.com/118796374/222902450-313d8da6-77b3-4083-a495-9a7332c84a3f.jpg)


#### <a target="_blank" href="http://10.73.100.15:55185/index.html#suites/5284c78a4f27e04d33f9e1c33682c59f/4da6504dfc6cc11c/">Отчет Allure Report</a> с результатами прохождения тестов.

![изображение](https://user-images.githubusercontent.com/118796374/222902392-32ee028e-e4ee-467a-b8f5-6f80ca739231.png)

#### Контейнеры образов для Selenoid и Selenoid-ui развернуты в Docker

![контейнеры в докере](https://user-images.githubusercontent.com/118796374/222902996-83abd878-6d7e-4f0a-b9eb-cf75ad0dcf5f.jpg)

Run tests with filled remote.properties:
```bash
gradle clean test
```
Serve report:
```bash
allure serve build/allure-results
```
