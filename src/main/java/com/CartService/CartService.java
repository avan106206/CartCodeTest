package com.CartService;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.CartModel.Item;
import com.CartModel.Receipt;


public class CartService { //Perform the business logic of the shopping cart
	
	//Parsing the input sentence, output the arrayList of object item
	public ArrayList<Item> sentenceHandler(String inputsentence){
        String[] parts = inputsentence.split(",");
        String[] word = parts[0].split(":");
        String state = (word[1].trim());//get state
        ArrayList<Item> itemlist = new ArrayList<Item>();
        for(int i=1; i< parts.length; i++) {
        	Item item = new Item();
        	String[] object = parts[i].split(" ");
        	String product_name = new String();
			for(int j=2; j<object.length; j++) {
        		if(j == 2)	product_name += object[j];
        		else product_name += " " + object[j];
        		if(object[j+1].equals("at")) {
        			if(product_name.endsWith("s") && !product_name.equals("potato chips")) {
        				StringBuffer sb = new StringBuffer(product_name);
        				product_name = sb.deleteCharAt(sb.length()-1).toString();
        			}
                	item.setPrice(Double.parseDouble(object[j+2]));
        			break;
        		}
        	}
        	item.setQty(Integer.parseInt(object[1]));
        	item.setName(product_name);
        	item.setState(state);
        	itemlist.add(item);
        }		
    	return itemlist;    	
    }
	//Handler the tax calculating logic
	public ArrayList<Item> CartLogicHandler(ArrayList<Item> originalcartlist){
		ArrayList<Item> handledCartlist = new ArrayList<Item>();
		for(Item originalitem: originalcartlist) {
			switch(originalitem.getState()){//TaxHandler
				case "CA": 
					if(originalitem.getName().equals("potato chips")) {originalitem.setTax(0); originalitem.setTax(0);}//exempt
					else {
						originalitem.setTax(Math.ceil((originalitem.getPrice()*originalitem.getQty()*0.0975) * 20) / 20.0); break;
					}
				case "NY": 
					if(originalitem.getName().equals("potato chips") || originalitem.getName().equals("shirt")) {originalitem.setTax(0); originalitem.setTax(0);}//exempt
					else {
						originalitem.setTax(Math.ceil((originalitem.getPrice()*originalitem.getQty()*0.08875) * 20) / 20.0); break;
					}
				default: originalitem.setTax(0);
			}
		}
		handledCartlist = originalcartlist;
		return handledCartlist;
	}
	//input the handled cartlist, the content of input cartlist will be transfered to Receipt
	public Receipt getReceipt(ArrayList<Item> processedCartList){
		Receipt receipt = new Receipt();
		DecimalFormat df = new DecimalFormat("##.00");
		/**Calculate subtotal**/
		double subtotal = 0;
		for(Item item: processedCartList) subtotal += item.getPrice()*item.getQty();
		subtotal = Double.parseDouble(df.format(subtotal));
		receipt.setSubtotal(subtotal);
		/**Calculate totaltax**/
		double totaltax = 0;
		for(Item item: processedCartList) totaltax += item.getTax();
		totaltax = Double.parseDouble(df.format(totaltax));
		receipt.setTotaltax(totaltax);
		/**Calculate total**/
		double total = 0;
		total = Double.parseDouble(df.format(subtotal+totaltax));
		receipt.setTotal(total);
		/**set item list**/
		receipt.setItemlist(processedCartList);
		return receipt;
		
	}
	
}

