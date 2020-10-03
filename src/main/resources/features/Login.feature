#language: pt
#utf-8

@Login
Funcionalidade: Login
  Como um usuário eu quero fazer login no site para que eu possa estar identificado

  @LoginEmailSenhaInvalidos
  Cenário: Tentativa de login com email e senha inválidos
    Dado que o usuário está na página inicial do site
    Quando o usuario preenche email e senha inválidos
    Então será aprensentada a mensagem "Houve um erro, Verifique o Email/Senha"

		