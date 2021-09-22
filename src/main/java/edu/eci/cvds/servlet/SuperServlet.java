package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import edu.eci.cvds.servlet.model.Todo;

@WebServlet(urlPatterns = "/julianServlet")
public class SuperServlet extends HttpServlet {
    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
            if(optName.isPresent()){
                int id = Integer.parseInt(optName.get());
                resp.setStatus(HttpServletResponse.SC_OK);
                ArrayList<Todo> todos = new ArrayList<>();
                Todo todo = Service.getTodo(id);
                todos.add(todo);
                responseWriter.write(Service.todosToHTMLTable(todos));
            }
        }
        catch (FileNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("No se encontro un item con el identificador dado");
        }
        catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseWriter.write("El parametro dado no es un numero");
        }
        catch (MalformedURLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseWriter.write("Error interno en el servidor");
        }
        catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseWriter.write("Requerimiento Invalido");
        }
        responseWriter.flush();
    }
    
}
