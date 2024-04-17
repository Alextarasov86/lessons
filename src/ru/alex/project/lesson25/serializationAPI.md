# Сериализация и десериализация

## Сериализация - объект, как последовательность байт

## Десериализация - последовательность байт в объект (Object)

Для процессов сериализации и десериализации класс должен реализовать
интерфейс java.io.Serializable или
интерфейс java.io.Externalizable

## java.io.Serializable:

1. по умолчанию все поля включаются в процесс сериализации
2. и тоже должны являться java.io.Serializable типом;
2. исключить поля из сериализации можно, если отметить их как transient;
3. если дочерний класс (но не родитель) имплементирует данный интерфейс,
   то полученные от родителя свойства не участвуют в сериализации;
4. если родительский класс имплементирует данный интерфейс,
5. то полученные от родителя свойства участвуют в сериализации.

## java.io.Externalizable

1. по умолчанию все поля исключены из процесса сериализации;
2. только свойства перечисленные в методах (writeExternal / readExternal) участвуют в сериализации;
2. для десериализуемых объектов должен быть задан конструктор без параметров.

## Версия класса `private static final long serialVersionUID` задается, если предполагается менять описание класса (добавлять / удалять свойства) после сериализации.