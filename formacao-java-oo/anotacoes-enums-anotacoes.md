# Curso complementar (De 23/02/2021 a 23/02/2021)

## Enums

Caracteristicas enum: 

+ Nâo é possível instanciar um enum
+ O construtor é tipo privado (entender melhor isso depois)
+ Pode ter atributos, métodos e construtores

## Anotações

+ As anotações são como configurações, que indicam o que queremos fazer com a classe. Ex.: gravar no banco de dados da tabela x
+ Exemplo de anotação: Override. Então as anotações fazem uma verificação se o seu código está de acordo com a anotação que vc colocou. Verifica regras
+ Existem anotações para o compilador e para máquina virtual
+ Anotação não possui implementação. Parecido com interface
+ Quando criar uma anotação, definir onde ela é valida: é valida para um atributo ou método? 
+ Podemos definir se a anotação vai permanecer no código ou não. Exemplo: no caso do Override, a anotação não fica no bytecode, pois a validação dela é feita na compilação.
    + Usamos o RETENTION para definir isso

Escrevendo uma anotação: 

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DoublePositivo {

}
```

Eu preciso dar uma olhadinha mais a fundo sobre como Enums e Anotações funcionam