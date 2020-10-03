#language: pt
#utf-8

@Login
Funcionalidade: Login
  Como um usuário eu quero fazer login no site para que eu possa estar identificado

Contexto:
	Dado que o usuário está na página inicial do site

  @LoginEmailSenhaInvalidos
  Cenário: Tentativa de login com email e senha inválidos
    #Dado que o usuário está na página inicial do site
    Quando o usuario preenche email e senha inválidos
    Então será aprensentada a mensagem "Houve um erro, Verifique o Email/Senha"
    
    
  @PesquisaEmpresaExistente
  Cenário: Buscar empresa pelo campo de busca e ver seus elogios
  	Quando o usuário digita no campo de busca "Fast Shop"
  	E clica no botão Ver Elogios
  	Então os dados da empresa devem ser apresentados
  	

		