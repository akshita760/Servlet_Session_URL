package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Product;

public class MyDatabase {

	public static Map<String, List<Product>> products = new HashMap<>();
	
	static
	{
		List<Product> laptopList = new ArrayList<>();
		laptopList.add(new Product("Hp101",2000));
		laptopList.add(new Product("Dell101",3000));
		laptopList.add(new Product("Apple1",20000));
		
		
		List<Product> watchlist = new ArrayList<>();
		watchlist.add(new Product("Fasttrack1",1000));
		watchlist.add(new Product("Fasttrack2",3000));
		watchlist.add(new Product("Fasttrack3",20000));
		
		
		products.put("Laptop",laptopList);
		products.put("Watch",watchlist);
		products.put("Mobile Phones",null);
		
	}
	
}
