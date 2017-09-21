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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.template.Bootstrap;

/**
 * Servlet implementation class Create
 */
@WebServlet("/save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html;charset-UTF-8");
    	PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
    	
    	// value from web
    	String id = request.getParameter("id");
    	String name = request.getParameter("name");
    	String type = request.getParameter("type");
    	String version = request.getParameter("version");
    	String price = request.getParameter("price");
    	String charge = request.getParameter("charge");
    	String days = request.getParameter("days");
    	String total = request.getParameter("total");
    	
    	
    	System.out.println(id+" "+name+" "+version+" "+price);
    	
    	MultivaluedMap queryParams = new MultivaluedMapImpl();
    		queryParams.add("name", name);
		queryParams.add("version", version);
		queryParams.add("type", type);
		queryParams.add("price", price);
		queryParams.add("charge", charge);
		queryParams.add("days", days);
		queryParams.add("total", total);
		
	 	
	 	
		
		// request and response RESTful
		ClientConfig config = new DefaultClientConfig(); 
		Client client = Client.create(config); 
		WebResource service = client.resource(getBaseURI()); 
		
		WebResource path = service.path("rest").path("bookstore");
		if(id == null) {
			path = path.path("create");
		}else {
			queryParams.add("id", id);
			path = path.path("update");
		}
				
		ClientResponse clientResponsePost = path .accept(MediaType.TEXT_PLAIN).post(ClientResponse.class, queryParams);
		
		String result = "";
		if (clientResponsePost.getStatus() != 200) {
			result = "บันทึกไม่สำเร็จ";
		}else {
			result = "บันทึกสำเร็จ";
		}

//		String outputFromPost = clientResponsePost.getEntity(String.class);
//		out.print(outputFromPost);
		
		Bootstrap b = new Bootstrap();
		// out put web
    	 	response.setContentType( "text/html; charset=UTF-8" );
    	 	out.print(b.header());
    	 	
		out.println("<center>");
		out.println("<h2>ผลลัพทธ์</h2>");
		out.println(result+"<br><br>");
		out.println("<a href=\"findbook\">กลับสู่หน้าหลัก</a>");
		out.println("</center>");
		
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
		return UriBuilder.fromUri( "http://localhost:8080/SWE-343-RestFULL-2/").build(); 
	}
}
