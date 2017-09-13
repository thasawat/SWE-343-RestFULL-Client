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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;



@WebServlet("/book")
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
		
    	PrintWriter out = new PrintWriter( new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
    	
    	// value from web
    	request.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("name");
    	
		// request and response RESTful
		ClientConfig config = new DefaultClientConfig(); 
		Client client = Client.create(config); 
		WebResource service = client.resource(getBaseURI()); 
		
		// request xml
//		WebResource path = service.path("rest").path("bookstore").path("findname");
//		if(name != null) {
//			path = path.path(name);
//		}else{
//			name = "";
//		}
//		ClientResponse clientXmlResponse = path .accept(MediaType.TEXT_XML).get(ClientResponse.class);
//		String outputFromXml =  clientXmlResponse.getEntity(String.class);
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
//	    DocumentBuilder builder;  
//	    Document doc = null;
//	    try  
//	    {  
//	        builder = factory.newDocumentBuilder();  
//	        doc = builder.parse( new InputSource( new StringReader( outputFromXml ) ) );
//	        doc.getDocumentElement().normalize();
//	    } catch (Exception e) {  
//	        e.printStackTrace();  
//	    } 
//	    
////	    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//		NodeList nList  = doc.getElementsByTagName("book");
//		
//		// out put web
//		response.setContentType( "text/html; charset=UTF-8" );
//		out.print("<html>");
//		out.println("<head><base href=\"http://localhost:8080/RESTfulClient/\"></head>");
//		out.print("<body>");
//		
//		out.println("<center>");
//		
//		out.println("<img src=\"picture/2000px-Switch-course-book.svg.png\" width=\"100px\"></img>");
//		out.println("<form action=\"lecturer\">");
//		out.println("<input type=\"text\" name=\"name\" value=\""+name+"\">");
//		out.println("<input type=\"submit\" value=\"เธ�เน�เธ�เธซเธฒ\">");
//		out.println("</form>");
//		
//		out.println("<a href=\"create\">เธชเธฃเน�เธฒเธ�</a>");
//		
//		out.println("<table border=\"0\">");
//		out.println("<tr>");
//		out.println("<th>id_book</th>");
//		out.println("<th>name</th>");
//		out.println("<th>publisher</th>");
//		out.println("<th>book_number</th>");
//		out.println("<th>discovery</th>");
//		out.println("<th>total_book</th>");
//		out.println("</tr>");
//		
//		for (int temp = 0; temp < nList.getLength(); temp++) {
//			Node nNode = nList.item(temp);
//			System.out.println("\nCurrent Element :" + nNode.getNodeName());
//			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//				Element eElement = (Element) nNode;
//				
//				out.println("<tr>");
//				out.println("<td>"+eElement.getElementsByTagName("id_book").item(0).getTextContent()+"</td>");
//				out.println("<td>"+eElement.getElementsByTagName("name").item(0).getTextContent()+"</td>");
//				out.println("<td>"+eElement.getElementsByTagName("publisher").item(0).getTextContent()+"</td>");
////				String id = eElement.getElementsByTagName("id").item(0).getTextContent();
////				out.println("<td><a href=\"update?id="+id+"\">เน�เธ�เน�เน�เธ�</a></td>");
////				out.println("<td><a href=\"delete?id="+id+"\">เธฅเธ�</a></td>");
//				out.println("</tr>");
//			}
//		}
//		out.println("</table");
//		out.println("</center>");
//		out.println("</body>");
//		out.println("</html>");
	}

	private WebResource resource(URI baseURI) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Client create(ClientConfig config) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public URI getBaseURI() {
//		bookstore/findname/xxxx
		return UriBuilder.fromUri( "http://localhost:8080/SWE-343-RestFULL/rest/").build();
		}

}