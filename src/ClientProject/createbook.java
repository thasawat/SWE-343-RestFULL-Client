package ClientProject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.template.Bootstrap;



@WebServlet("/createbook")
public class createbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html;charset-UTF-8");
    	PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
    	
    	// value from web
    	String id = request.getParameter("id");
		
    	 	Bootstrap b = new Bootstrap();
		// out put web
    	 	response.setContentType( "text/html; charset=UTF-8" );
    	 	out.print(b.header());
    	 	
		out.println("<form action=\"save\">");
		out.println("name : <input type=\"text\" name=\"name\" value=\"\"><br>");
		out.println("version: <input type=\"text\" name=\"version\" value=\"\"><br>");
		out.println("<select name=\"type\">\n" + 
				"  			<option value=\"การ์ตูน\">การ์ตูน</option>\n" + 
				" 		 	<option value=\"นิตยสาร\">นิตยสาร </option>\n" + 
				" 		 	<option value=\"วารสาร\">วารสาร</option>\n" + 
				" 		 	<option value=\"นวนิยาย\">นวนิยาย</option>\n" + 
				" 		 	<option value=\"บันเทิงคดี\">บันเทิงคดี</option>\n" + 
				" 		 	<option value=\"สารคดี\">สารคดี</option>\n" + 
				"\n" + 
				" 		</select><br>");
		out.println("price : <input type=\"text\" name=\"price\" value=\"\"><br>");
		out.println("charge : <input type=\"text\" name=\"charge\" value=\"\"><br>");
		out.println("days : <input type=\"text\" name=\"days\" value=\"\"><br>");
		out.println("total : <input type=\"text\" name=\"total\" value=\"\"><br>");
		out.println("<input class=\"btn btn-success\" type=\"submit\" value=\"สร้าง\">");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private static URI getBaseURI() { 
		return UriBuilder.fromUri( "http://localhost:8080/SWE-343-RestFULL-Client/").build(); 
	}
	

}
