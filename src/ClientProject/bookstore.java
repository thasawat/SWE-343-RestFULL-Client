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

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.template.Bootstrap;



@WebServlet("/findbook")
public class bookstore extends HttpServlet {
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
		WebResource path = service.path("bookstore").path("findname");
		if(name != null) {
			path = path.path(name);
		}else{
			name = "";
		}
		ClientResponse clientXmlResponse = path .accept(MediaType.TEXT_XML).get(ClientResponse.class);
		String outputFromXml =  clientXmlResponse.getEntity(String.class);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	    DocumentBuilder builder;  
	    Document doc = null;
	    try  
	    {  
	        builder = factory.newDocumentBuilder();  
	        doc = builder.parse( new InputSource( new StringReader( outputFromXml ) ) );
	        doc.getDocumentElement().normalize();
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } 
	    
	    Bootstrap b = new Bootstrap();
	    
//	    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList  = doc.getElementsByTagName("book");
		
		// out put web
		response.setContentType( "text/html; charset=UTF-8" );
		out.print(b.header());
		

		
		
		out.println("<form action=\"findbook\">");
		out.println("<input type=\"text\" name=\"name\" value=\""+name+"\">");
		out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"ค้นหา\">");
		out.println("<a href=\"createbook\" class=\"btn btn-success\">สร้าง</a>");
		out.println("</form>");
		
		
		
		out.println("<table class=\"table\">");
		out.println("<tr>");
			out.println("<th>id_book</th>");
			out.println("<th>name</th>");
			out.println("<th>version</th>");
			out.println("<th>type</th>");
			out.println("<th>price</th>");
			out.println("<th>days</th>");
			out.println("<th>charge</th>");
			out.println("<th>total</th>");
			out.println("<th></th>");
			out.println("<th></th>");
		out.println("</tr>");
		System.out.print(nList.getLength());
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				out.println("<tr>");
					out.println("<td>"+eElement.getElementsByTagName("id").item(0).getTextContent()+"</td>");
					out.println("<td>"+eElement.getElementsByTagName("name").item(0).getTextContent()+"</td>");
					out.println("<td>"+eElement.getElementsByTagName("version").item(0).getTextContent()+"</td>");
					out.println("<td>"+eElement.getElementsByTagName("type").item(0).getTextContent()+"</td>");
					out.println("<td>"+eElement.getElementsByTagName("price").item(0).getTextContent()+"</td>");
					out.println("<td>"+eElement.getElementsByTagName("days").item(0).getTextContent()+"</td>");
					out.println("<td>"+eElement.getElementsByTagName("charge").item(0).getTextContent()+"</td>");
					out.println("<td>"+eElement.getElementsByTagName("total").item(0).getTextContent()+"</td>");
					String id = eElement.getElementsByTagName("id").item(0).getTextContent();
					out.println("<td><a href=\"updatebook?id="+id+"\">แก้ไข</a></td>");
					out.println("<td><a href=\"delete?id="+id+"\">ลบ</a></td>");
				out.println("</tr>");
			}
		}
		out.println("</table");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public URI getBaseURI() {
//		bookstore/findname/xxxx
		return UriBuilder.fromUri( "http://localhost:8080/SWE-343-RestFULL-2/rest/").build();
		}

}