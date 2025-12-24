# Zoo ERP

ERP-система Московского зоопарка.

## Запуск

```bash
mvn compile exec:java -Dexec.mainClass="com.zoo.Main"
```

## Тесты

```bash
mvn test
```

## SOLID

### S - Single Responsibility
- `Zoo` - управление животными и вещами
- `VetClinic` - только проверка здоровья

### O - Open/Closed
- Новые животные через наследование от `Herbo`/`Predator`
- Новые вещи через наследование от `Thing`

### L - Liskov Substitution
- `Monkey`, `Rabbit` работают как `Herbo`
- `Tiger`, `Wolf` работают как `Predator`

### I - Interface Segregation
- `IAlive` - только еда
- `IInventory` - только инвентарный номер

### D - Dependency Inversion
- `Zoo` зависит от интерфейса `VetClinic`, а не от `VetClinicImpl`
- DI через Spring

## Структура

```
src/main/java/com/zoo/
├── model/     # Animal, Herbo, Predator, Monkey, Rabbit, Tiger, Wolf
│              # Thing, Table, Computer, IAlive, IInventory
├── service/   # Zoo, VetClinic, VetClinicImpl
└── Main.java
```
