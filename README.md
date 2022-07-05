### Hexlet tests and linter status:
[![Actions Status](https://github.com/Oleg995/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/Oleg995/java-project-lvl3/actions)
[![Java CI](https://github.com/Oleg995/java-project-lvl3/workflows/Java%20CI/badge.svg)](https://github.com/Oleg995/java-project-lvl3/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/852f4ad606f169238f62/maintainability)](https://codeclimate.com/github/Oleg995/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/852f4ad606f169238f62/test_coverage)](https://codeclimate.com/github/Oleg995/java-project-lvl3/test_coverage)

# description
### Data validator - a library with which you can check the correctness of data of the String type, Numeric type and map type

### Usage example:
````
// create object class Validator
Validator v = new Validator();

// in application have three scemas, having parrent abstract class - BaseSchemas. 
// Method isValid() check object on correct. 
StringSchema schema = v.string();
schema.isValid(""); // true
schema.isValid(null); //true

// the scheme can set the test condition
schema.required() // любая не пустая строка
schema.isValid(""); // false
schema.isValid("true") // true

// string contains a specific substring
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false


// numbers
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Object Map with structure check support
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
````
