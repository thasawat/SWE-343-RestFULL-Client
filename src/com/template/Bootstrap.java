package com.template;

public class Bootstrap {
	public String header()
	{
		String s = "";
		s += "<html>";
			s += "<head><base href=\"http://localhost:8080/SWE-343-RestFULL-Client/\">";
		s += "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">";
		s += "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>";
		s += "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\" integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\" crossorigin=\"anonymous\"></script>";
		s += "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\" integrity=\"sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1\" crossorigin=\"anonymous\"></script>";
		
		s += "</head>";
		s += "<body>";
		
		
		s += navbar();
		s += "<div class=\"container text-center mt-4\">";
		return s;
	}
	public String navbar()
	{
		String s;
		s = "<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n" + 
				"  <a class=\"navbar-brand\" href=\"#\">ArMa</a>\n" + 
				"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" + 
				"    <span class=\"navbar-toggler-icon\"></span>\n" + 
				"  </button>\n" + 
				"\n" + 
				"  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" + 
				"    <ul class=\"navbar-nav mr-auto\">\n" + 
				"      <li class=\"nav-item active\">\n" + 
				"        <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n" + 
				"      </li>\n" + 
				"      <li class=\"nav-item\">\n" + 
				"        <a class=\"nav-link\" href=\"#\">Link</a>\n" + 
				"      </li>\n" + 
				"      <li class=\"nav-item\">\n" + 
				"        <a class=\"nav-link disabled\" href=\"#\">Disabled</a>\n" + 
				"      </li>\n" + 
				"    </ul>\n" + 
				"  </div>\n" + 
				"</nav>";
		return s;
	}
}
