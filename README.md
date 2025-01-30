# Algoritmo de Diffie-Hellman

Este repositório contém a implementação do algoritmo de troca de chaves Diffie-Hellman, utilizado para criar um segredo compartilhado entre duas partes, mesmo que elas se comuniquem por um canal inseguro. O projeto foi desenvolvido para fins de estudo e prática de criptografia e segurança.

## 💻 Pré-requisitos

Para executar este projeto, certifique-se de ter as seguintes ferramentas configuradas no seu ambiente:

- **Java 21** ou superior;
- **Apache Maven** para gerenciamento de dependências e build do projeto;
- Editor ou IDE de sua escolha (IntelliJ IDEA, Eclipse, VS Code, etc.).

## 🚀 Sobre o projeto

O algoritmo Diffie-Hellman permite que duas partes, sem jamais se encontrarem diretamente, compartilhem uma chave secreta. Isso é feito trocando valores públicos e realizando cálculos usando esses valores. O segredo gerado pode ser usado para criptografar e descriptografar mensagens.

### ✨ Funcionalidades

- Estabelecer uma chave secreta compartilhada entre duas partes.
- Baseado em operações matemáticas com grandes números primos e módulos.
- Implementação simples e clara para fins educacionais.

### 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto;
- **Apache Maven**: Ferramenta de build e gerenciamento de dependências;
- **Java BigInteger**: Usado para manipulação de números grandes necessários no algoritmo.

## 📚 Como Funciona o Algoritmo

O algoritmo de Diffie-Hellman é baseado na troca de chaves públicas entre duas partes, com cada parte gerando uma chave secreta privada e, a partir dessa chave, calculando uma chave pública que será compartilhada. O segredo final é calculado por ambas as partes usando a chave pública recebida e sua chave secreta privada.

1. As duas partes escolhem um número primo grande `p` e uma base `g`, ambos conhecidos por ambas as partes.
2. Cada parte escolhe um número secreto privado:
   - Parte A escolhe `a` e calcula a chave pública `A = g^a mod p`.
   - Parte B escolhe `b` e calcula a chave pública `B = g^b mod p`.
3. As chaves públicas `A` e `B` são trocadas entre as duas partes.
4. Cada parte calcula a chave secreta compartilhada:
   - Parte A calcula `s = B^a mod p`.
   - Parte B calcula `s = A^b mod p`.
5. A chave secreta calculada por ambas as partes será a mesma, mesmo que as chaves privadas sejam mantidas secretas.

### Exemplo

**Entrada:**  
- Número primo `p = 23`
- Base `g = 5`
- Parte A escolhe `a = 6`
- Parte B escolhe `b = 15`

**Saída:**  
- Chave pública de A: `A = 5^6 mod 23 = 8`
- Chave pública de B: `B = 5^15 mod 23 = 19`
- A troca das chaves públicas leva a um segredo compartilhado `s = 19^6 mod 23 = 2` para A e `s = 8^15 mod 23 = 2` para B.

A complexidade do algoritmo é:
- **Tempo:** O logaritmo da chave, O(log n), onde *n* é o tamanho do número primo `p`.
- **Espaço:** O(1), já que o algoritmo utiliza apenas valores temporários.

## 🛠️ Configuração e Execução

1. Clone este repositório:
   
   ```bash
   git clone https://github.com/enzokaua/algorith-keys-of-diffie-hellman
