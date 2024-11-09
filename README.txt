-- Procesamiento de Pedidos -- 



- Para compilar el proyecto se debe de tener Maven instalado. Si no se lo tiene se puede instalar mediante pip con el siguiente comando:

pip install maven

- Una vez instalado, compilamos el proyecto con el siguiente comando:

mvn clean compile

- Para correr el main, correr el siguiente comando:

mvn exec:java -Dexec.mainClass="com.empresa.Main"

- Para correr los tests:

mvn test
