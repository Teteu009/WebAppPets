

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Animal"%>
<%@page import="model.dao.AnimalDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        //Entrada/Receber
        String nome = request.getParameter("nome");
            
        // Instância e atrib de valor
        Consuntar consu = new Consultar();
        consu.setID(id);
        
         //Select
        AnimalDAO animDAO = new AnimlDAO();
        if(pesqDAO.consPesqReg(pesq) != null){
                out.println("<br> <b>Consultar Animal</b> <br>");
                out.println("<br> Id: " + consu.getId());
                out.println("<br> Nome: " + consu.getNome());
                out.println("<br> Especie: " + consu.getEspecie());
                out.println("<br> Raça: " + consu.getRaca());
                out.println("<br> Tamanho : " + consu.Tamanho());
                out.println("<br> Idade: " + consu.getIdade());
                out.println("<br> Peso: " + consu.getPeso());                             
        }else{
               out.println("Registro não encontrado!!!");
        }

        
        %>
    </body>
</html>
