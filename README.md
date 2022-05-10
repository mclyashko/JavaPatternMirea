# JavaPatternMirea

## ИКБО-01-20, Виктор Ляшенко, Вариант 18

### Практическая работа №1

Имплементировать интерфейс Function, получающий на вход массив строк и возвращающий массив перевернутых строк.

### Практическая работа №2

Сортировка по весу в обратном порядке, фильтрация по фамилии не Иванов, сортировка по возрасту, произведение всех
возрастов.

### Практическая работа №3

Создать свои thread-safe имплементации интерфейсов. Map с использованием Lock, Set с использованием ключевого слова
synchronized.

### Практическая работа №4

Реализовать собственную имплементацию ExecutorService с единственным параметром конструктора – количеством потоков.

### Практическая работа №5

Реализовать паттерн Singleton как минимум 3-мя способами.

### Практическая работа №6

Написать реализацию паттернов «Фабричный метод», «Абстрактная фабрика», «Строитель», «Прототип».

### Практическая работа №7

Реализовать паттерны «Компоновщик», «Декоратор».

### Практическая работа №8

Реализовать паттерны «Итератор», «Посредник».

## Практические работы 9+ лежат в папке nextTasks

### Практическая работа №9

Создать приложение, которое выводит какое-то сообщение в консоль. Создать Gradle Task,
который создает jar-файл приложения, переносит его в отдельную папку,
в которой хранится Dockerfile для jar, а затем создает Docker контейнер из данного jar-файла и запускает его.

### Практическая работа №10

Создать приложение, в котором создается ApplicationContext и из него берётся бин с названием,
переданным в качестве аргумента к приложению, и вызывается метод интерфейса, который он имплементирует.
Нужно создать по одному бину для каждого класса, определить им название.
Проверить, что вызывается при вводе названия каждого из бинов.
Классы и интерфейс определяются в соответствии с вариантом индивидуального задания.
Интерфейс Programmer с методом doCoding(), его имплементации: Junior, Middle, Senior.

### Практическая работа №11

Создать приложение с использованием [Spring Boot Starter Initializr](https://start.spring.io/) с такими зависимостями:
* Spring Web
* Lombok
* Validation
* Spring boot Actuator

Запустить приложение и удостовериться, что не появилось никаких ошибок. Добавить все эндпоинты в Actuator,
сделать HTTP-запрос на проверку состояния приложения. Собрать jar-файл приложения,
запустить и проверить состояние при помощи REST-запроса.

### Практическая работа №12

Создать приложение, которое при запуске берет данные из одного файла, хеширует,
а при остановке приложения удаляет исходный файл, оставляя только файл с захешированными данными.
Названия первого и второго файла передаются в качестве аргументов при запуске.
При отсутствии первого файла создает второй файл и записывает в него строку null.
Реализовать с использованием аннотаций PostConstruct, PreDestroy.

### Практическая работа №13

Создать файл application.yml в папке resources, добавить в него такие свойства:
* student.name - имя студента
* student.last_name - фамилия студента
* student.group - группа студента

При запуске приложения вывести данные свойства в консоль при помощи интерфейса Environment или аннотации Value.

### Практическая работа №14

Создать отдельный репозиторий Git. Создать простой html-документ,
который будет содержать вашу фамилию, имя, номер группы, номер варианта.
Создать контроллер, который будет возвращать данный статический документ при переходе на url «/home».
Выполнить задание в зависимости с вариантом индивидуального задания.

* Создать класс Book с полями name, creationDate. Создать класс Author с полями 
firstName, lastName, middleName, birthDate. Создать классы- контроллеры для создания,
удаления объектов и получения всех объектов каждого типа. Сами объекты хранить в памяти.

### Практическая работа №15

Изменить программу с предыдущего задания так,
чтобы объекты хранились в базе данных PostgreSQL вместо памяти компьютера.

### Пракическая работа №16

Создать связь Один-ко-многим между сущностями из предыдущего задания и проверить работу lazy loading.

### Практическая работа №17

Добавить возможность фильтрации по всем полям всех классов с использованием Criteria API в Hibernate
для программы из предыдущего задания. Добавить эндпоинты для каждой фильтрации.

### Практическая работа №18

Переписать код предыдущего задания с использованием сервисов и отделения логики контроллера
от логики сервиса и репозитория. В программе всё взаимодействие с базой данных
должно быть реализовано через репозитории Spring Data Jpa.

### Практическая работа №19

Создать файл logback.xml, добавить логирование во все методы классов-сервисов.

### Практическая работа №20

Для приложения из предыдущего задания добавить логирование времени выполнения
каждого метода сервиса с использованием Spring AOP.

### Практическая работа №21

Для приложения из предыдущего задания пометить все классы сервисов, в которых происходит взаимодействие
с базой данных, как Transactional. Добавить отправку информации о сохранении каждого объекта по электронной почте,
создав отдельный класс EmailService с асинхронными методами отправки сообщений.
Для асинхронности методов используйте аннотацию Async.

### Практическая работа №22

Для приложения из предыдущего задания создать класс-сервис с методом,
который будет вызываться каждые 30 минут и очищать определённую директорию,
а затем создавать по файлу для каждой из сущностей и загружать туда все данные из базы данных.
Также добавить возможность вызывать данный метод с использованием Java Management Extensions (JMX).

### Практическая работа №23

В приложении из предыдущего задания добавить возможность регистрации и авторизации пользователей,
хранение cookie сессий в базе данных PostgreSQL,
хеширование паролей алгоритмом Bcrypt,
защиту всех запросов, кроме запросов на авторизацию и регистрацию, от неавторизированных пользователей.