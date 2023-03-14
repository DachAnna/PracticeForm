### Реализован запуск тестов на <a target="_blank" href="https://demoqa.com/automation-practice-form">форму регистрации</a> на сайте demoqa.com с использованием рандомных данных 
![Страница регистрации](https://user-images.githubusercontent.com/118796374/222902208-2973cfb7-c0f4-416c-bec4-c947b7532765.png)
Для запуска тестов на удаленном репозитории используем команду:
```bash
.\gradlew clean test -Denvironment=remote
```

Для локального запуска тестов используем команду:
```bash
.\gradlew clean test -Denvironment=local
```

Формируем отчет:
```bash
allure serve build/allure-results
```
