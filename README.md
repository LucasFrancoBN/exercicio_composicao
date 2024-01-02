# Exercício
Ler os dados de um colaborador com N contratos. Depois, solicitar o mês e mostrar qual foi o salário dele naquele mês. As regras do exercício são:

1. **Seguir o seguinte diagrama de classe:**
   
   ![Diagrama de classe](https://github.com/LucasFrancoBN/exercicio_composicao/blob/master/img/diagrama_classe.png)
    

## Exemplo
```plaintext
Enter department's name: Design
Enter worker data:
Name: Alex
Level: MID_LEVEL
Base salary: 1200.00
How many contracts to this worker? 3
Enter contract #1 data:
Date (DD/MM/YYYY): 20/08/2018
Value per hour: 50.00
Duration (hours): 20
Enter contract #2 data:
Date (DD/MM/YYYY): 13/06/2018
Value per hour: 30.00
Duration (hours): 18
Enter contract #3 data:
Date (DD/MM/YYYY): 25/08/2018
Value per hour: 80.00
Duration (hours): 10

Enter month and year to calculate income (MM/YYYY): 08/2018
Name: Alex
Department: Design
Income for 08/2018: 3000.00
```

## Ferramentas
Desafio desenvolvido utilizando a linguagem Java e a IDE Intellij Community.


## Instruções de Uso
Antes de prosseguir com as instruções de uso, é requerido que você tenha em sua máquina o Java 20 e o git.

### Instalação
Antes de tudo, recomendo que você, pelo terminal, navegue até o diretório Desktop e rode o comando
```bash
# Clone o repositório
git clone https://github.com/LucasFrancoBN/combate-java.git

# Acesse o diretório da classe Program
cd combate-java/src/application
```
Agora basta você digitar no seu terminal
```bash
# Compile o projeto
javac Program.java ../entities/Champion.java
```
Retroceda ao diretório src e compile o programa
```
# Retrocedendo ao diretório src
cd ../

# Execute o programa
java application.Program
```
