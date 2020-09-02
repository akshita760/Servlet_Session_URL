package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import db.MyDatabase;


public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("---->> 1inside doGet");
		String requestedkeyword = request.getParameter("products_keyword");
		System.out.println(" --->> 2 "+requestedkeyword);
		// call DAO
		Map<String,List<Product>> products =  MyDatabase.products;
		System.out.println(" ---->> 3 "+products);
		Iterator<String> itr = products.keySet().iterator();
		
		while(itr.hasNext())
		{
			String keyword = itr.next(); // key
			System.out.println(" --->> 3.1 inside while itr of map "+keyword);
			if(keyword.equals(requestedkeyword))
			{
				System.out.println(" ---->> 4 inside while - if Keyword match "+keyword);	
				List<Product> listOfProducts = products.get(keyword);
				
				System.out.println(" ---->> 4.1 "+listOfProducts);
				Iterator<Product> availableProductsItr = listOfProducts.iterator();
				
				out.print("<ul>");
				while(availableProductsItr.hasNext())
				{
					System.out.println(" ---->> 5 inside while for list itr");
					Product p = availableProductsItr.next();
					String productName = p.getProductName();
					
					out.print("<li><a href='DisplayProductServlet?keyword="+keyword+"&name="+productName+"'>"+productName+"</a></li>");
				}
				out.print("</ul>");
				
				
				break;
				
			}
			
		}
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("doPost");
	}

}//end class
