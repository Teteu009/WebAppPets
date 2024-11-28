
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Animal"%>
<%@page import="model.dao.AnimalDAO"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario de Cadastro</h1>
        <%
            //Entrada
            int id = Integer.parseInt( request.getParameter("id") );
            String nome = request.getParameter("nome");            
            String especie = request.getParameter("epecie");
            String raca = request.getParameter("raca");
            String tamanho = request.getParameter("tamanho");
            int idade = Integer.parseInt( request.getParameter("idade") );
            double peso = Double.parseDouble( request.getParameter("peso") );
            

            // Instância do objeto e atrib. de dados
            Animal anim = new Animal();
            anim.setId(id);
            anim.setNome(nome);
            anim.setEspecie(especie);
            anim.setRaca(raca);
            anim.setTamanho(tamanho);
            anim.setIdade(idade);
            anim.setPeso(peso);            

            
            AnimalDAO animDAO = new AnimalDAO();
            
            if (animDAO.insAnim(anim)){    
                
                out.println("Cadastro com sucesso com sucesso!!!");
            }else{
                //Erro no cadastro
                out.println("Não de cadastro!!!");
            }          
        %>
    </body>
</html>
