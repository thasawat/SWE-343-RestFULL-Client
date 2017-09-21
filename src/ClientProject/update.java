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

	/**
	 * Servlet implementation class Create
	 */
	@WebServlet("/findupdate")
	public class update extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
	    	response.setContentType("text/html;charset-UTF-8");
	    	PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
	    	
	    	// value from web
	    	String id = request.getParameter("id");
	    	
	    	// request and response RESTful
	    	ClientConfig config = new DefaultClientConfig(); 
	    	Client client = Client.create(config); 
	    	WebResource service = client.resource(getBaseURI()); 
	    			
	    	// request xml
	    	ClientResponse clientXmlResponse = service.path("update").path("updatefind").path("getUpdate").path(id) .accept(MediaType.TEXT_XML).get(ClientResponse.class);
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
	    	
	    	NodeList nList  = doc.getElementsByTagName("course");
			
			// out put web
	    	out.print("<html>");
	    	out.println("<head><base href=\"http://localhost:8080/RESTfulClient/\"></head>");
			out.println("<body>");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					out.println("<form action=\"save\">");
					out.println("<input type=\"hidden\" name=\"id\" value=\""+id+"\"><br>");
					out.println("เธฃเธซเธฑเธชเธงเธดเธ�เธฒ : <input type=\"text\" name=\"name\" value=\""+eElement.getElementsByTagName("name").item(0).getTextContent()+"\"><br>");
					out.println("เธ�เธทเน�เธญเธงเธดเธ�เธฒ: <input type=\"text\" name=\"version\" value=\""+eElement.getElementsByTagName("version").item(0).getTextContent()+"\"><br>");
					out.println("เธฃเธฒเธขเธฅเธฐเน€เธญเธตเธขเธ” : <input type=\"text\" name=\"type\" value=\""+eElement.getElementsByTagName("type").item(0).getTextContent()+"\"><br>");
					out.println("เธฃเธฒเธขเธฅเธฐเน€เธญเธตเธขเธ” : <input type=\"text\" name=\"price\" value=\""+eElement.getElementsByTagName("price").item(0).getTextContent()+"\"><br>");
					out.println("เธฃเธฒเธขเธฅเธฐเน€เธญเธตเธขเธ” : <input type=\"text\" name=\"day\" value=\""+eElement.getElementsByTagName("day").item(0).getTextContent()+"\"><br>");
					out.println("เธฃเธฒเธขเธฅเธฐเน€เธญเธตเธขเธ” : <input type=\"text\" name=\"charge\" value=\""+eElement.getElementsByTagName("charge").item(0).getTextContent()+"\"><br>");
					out.println("เธฃเธฒเธขเธฅเธฐเน€เธญเธตเธขเธ” : <input type=\"text\" name=\"total\" value=\""+eElement.getElementsByTagName("total").item(0).getTextContent()+"\"><br>");
					out.println("<input type=\"submit\" value=\"เน�เธ�เน�เน�เธ�\">");
					out.println("</form>");
					
				}
			}
			
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
			return UriBuilder.fromUri( "http://localhost:8080/RESTfulService/").build(); 
		}
	}
