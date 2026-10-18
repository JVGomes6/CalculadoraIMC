#  Calculadora de IMC (Índice de Massa Corporal)

Aplicativo desenvolvido em **Kotlin** utilizando o **Android Studio** para o cálculo e classificação do Índice de Massa Corporal (IMC), criado como parte das atividades práticas da disciplina de Desenvolvimento de Aplicativos.

---

##  Funcionalidades

* **Cálculo Preciso do IMC**: Utiliza a fórmula padrão baseada no peso e na altura informados (`Peso / (Altura * Altura)`).
* **Tratamento de Locale (`Locale.US`)**: Garante que o separador decimal seja interpretado corretamente pelo sistema, evitando erros de cálculo independentemente da região do dispositivo.
* **Validação Robusta de Dados**:
  * Verificação de campos vazios com avisos interativos via `Toast`.
  * Validação de limites reais para o corpo humano (Altura entre `0.5m` e `2.5m`; Peso entre `2kg` e `500kg`).
  * Tratamento de exceções (`try-catch`) para evitar falhas caso o usuário insira caracteres inválidos.
* **Navegação entre Telas (`Intent`)**: Envio dos dados processados da tela principal (`MainActivity`) para a tela de resultados (`ResultadoActivity`).
* **Classificação Dinâmica**: Categorização automática do resultado (Desnutrição, Normalidade, Sobrepeso, Obesidade e Obesidade Mórbida) utilizando estruturas condicionais (`if-else`).
* **Botão de Limpeza**: Limpa os campos de entrada e redefine o foco para a altura com um único toque.

---

##  Tecnologias e Conceitos Utilizados

* **Linguagem**: Kotlin
* **Ambiente de Desenvolvimento**: Android Studio
* **Componentes de UI**: `LinearLayout`, `EditText`, `TextView`, `Button`, `ImageView`
* **Controle de Versão**: Git e GitHub

---

##  Estrutura do Projeto

* `MainActivity.kt`: Tela inicial responsável pela entrada dos dados, tratamento de erros, validações e disparo do cálculo.
* `ResultadoActivity.kt`: Tela secundária que recebe os dados via `Intent` e exibe o IMC formatado com a respectiva classificação.
* `activity_main.xml` & `activity_resultado.xml`: Layouts estruturados com componentes nativos do Android.

---

## Autor

Desenvolvido por **João Vitor de Oliveira Gomes** (UFPR).
