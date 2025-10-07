[![Actions Status](https://github.com/ganiev-dev/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ganiev-dev/java-project-78/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ganiev-dev_java-project-78&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=ganiev-dev_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ganiev-dev_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=ganiev-dev_java-project-78)
 # Валидатор данных #
 Валидатор данных - это библиотека, которая позволяет проверять данные на соответствие заданным условиям. 
 
 Как работает валидатор:
 Создается объект валидатора. Создается и настраивается схема проверки данных. Данные проверяются с использованием ранее созданной схемы. 
 
 ## 1 Создание валидатора ## 
 ```java
 var v = new Validator();
 ```
 ## 2 Создание схемы для конкретного типа данных ##
 ```java
var schema = v.string(); // для строк 
var schema = v.number(); // для чисел 
var schema = v.map();    // для Map
 ```
 ## 3 Настройка схемы валидации ## 
  Схема проверки настраивается с использованием fluent-интерфейса и методов специфичных для каждого типа данных.
  ```java
  var schema = v.string()
    .required()
    .minLength(5)
    .contains("hex");
  ```
  
  **Правила String**  
.required() - запрещает null и пустые строки  
.minLength(n) - минимальная длина строки  
.contains("text") - должна содержать подстроку

**Правила Number**  
required() — не позволяет использовать null в качестве значения  
positive() — ограничение на знак числа. Число должно быть положительным  
range() — допустимый диапазон, в который должно попадать значение числа

**Правила Map**  
required() — не позволяет использовать null в качестве значения. Требуется тип данных Map  
sizeof() — Количество пар ключ-значений в объекте Map должно быть равно заданному

**Метод Shape()**  
Позволяет валидировать внутренние данные объекта Map, назначая каждому ключу свою схему проверки.

## Пример работы ##
```java  import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

var v = new Validator();
var schema = v.string();

// Пока не вызван метод required(), null и пустая строка считаются валидным
schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// Здесь уже false, так как добавлена еще одна проверка contains("whatthe")

// Если один валидатор вызывался несколько раз
// то последний имеет приоритет (перетирает предыдущий)
var schema1 = v.string();
schema1.minLength(10).minLength(4).isValid("Hexlet"); // true
```

**Итого**  
Создаем валидатор → выбираем тип схемы → настраиваем правила → проверяем данные через метод isValid().
  
  Сделано в рамках обучения в школе программирования ["Hexlet"](https://ru.hexlet.io/).




