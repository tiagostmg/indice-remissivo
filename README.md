# 📚 Índice Remissivo em Java

#### Trabalho AV3 - Estrutura de Dados
#### Disciplina: Estrutura de Dados


#### Este projeto implementa um índice remissivo que mapeia palavras-chave de um texto e registra em quais linhas elas aparecem. Foi desenvolvido em Java utilizando estruturas como Tabela Hash e Árvore Binária de Busca e Lista para armazenamento e recuperação eficiente dos dados.

### 📌 Funcionalidades

* ✔ Leitura de palavras-chave (arquivo palavras-chave.txt)
* ✔ Processamento de texto (arquivo texto.txt)
* ✔ Registro de ocorrências (linhas onde cada palavra aparece)
* ✔ Geração de saída (arquivo output.txt)


### ⚙️ Estruturas Utilizadas
Estrutura	| Função no Projeto
-------------- | -----------
Tabela Hash	| Mapeia cada letra inicial para uma árvore de palavras
Árvore Binária	| Armazena palavras-chave em ordem alfabética
Lista	| Guarda os números das linhas de ocorrência
### 📂 Organização do Código

```
src/  
├── ArvoreBinariaBusca.java  # Árvore para armazenar palavras  
├── Fila.java                # Implementação auxiliar (não usada diretamente)  
├── Lista.java               # Lista de ocorrências (linhas)  
├── Main.java                # Ponto de entrada do programa  
├── PalavraChave.java        # Modelo palavra + linhas  
├── Pilha.java               # Implementação auxiliar (não usada diretamente)  
└── TabelaHash.java          # Tabela Hash principal  
```

### 🚀 Como Executar

* Clonar o projeto
* Adicionar as palavras chave e o texto
* Executar

📝 Exemplo de Saída

#### Entrada 

##### (texto.txt)

```
Programação é sobre estruturas de dados.  
Estruturas organizam dados eficientemente.  
```

##### (palavras-chave.txt)

```
dados, estrutura, programação
```

#### Saída (output.txt)
```
dados 1 2 
estruturas 1 2 
programacao 1 
```
