### Como rodar o projeto

* O stub já foi gerado
* Os arquivos `policy` estão na pasta classes e garatem acesso total
* Acesse a pasta anterior onde estão os arquivos `.class`: `target/classes`
* Nessa pasta rode o comando `rmiregistry` (no linux pode usar o `&` no fim da linha para que rode em background caso queira rodar em background)
* Rode o servidor `java trabthree.Server` (pode-se adicionar o parametro `-D java.security.policy=trabthree/security.policy trabthree.Server`)
* Rode o cliente, pode-se usar as duas formas anteriores mudando apenas o final para `Cliente`
* Pronto, basta testar. :)

