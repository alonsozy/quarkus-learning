# getting-started

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

The app uses a parameter to valid the range, for example to run the app, we could run this command:
```bash
mvn quarkus:dev "-Dquarkus.args='33'"
```

With the previous command we are sending the value 33

**Expected result:**

```
Range - High: 1000
Range - Low: 250
Invalid amount: 33
```

We can press the key 'e' to update the parameter 
Write 260 and press enter to restart the app

**Expected result:**

```
Range - High: 1000
Range - Low: 250
Valid amount: 260
```

The app uses a interface configuration to get the configurations from the property file

- ExpenseConfiguration

Property file
```properties
expense.range-high = 1024
expense.range-low = 64
expense.debug-enabled = true
```

Besides, we can create some profile to run the app in different envs.
To achieve that, we can use only one property file and add the prefix
```properties
%dev.
```

example:
```properties
%dev.expense.range-low=10

%qa.expense.range-low=321
%qa2.expense.range-low=322
```

To run the app with specific env, we can use this command
```bash
mvn quarkus:dev -Dquarkus.args='330' -Dquarkus.profile=dev
```

We can override those properties using an env file
We can create the file .env and add some properties
```env
EXPENSE_RANGE_LOW = 600
```

To run the app using the env variables 
```bash
mvn clean package \
&& EXPENSE_RANGE_LOW=700 \
java -jar -Dquarkus.profile=dev \
target/quarkus-app/quarkus-run.jar 255
```