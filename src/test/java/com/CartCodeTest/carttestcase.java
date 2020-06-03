package com.CartCodeTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.CartModel.Item;
import com.CartModel.Receipt;
import com.CartService.CartService;

public class carttestcase {
	
	@Test
	public void test() {
		CartService cartservice = new CartService();
		Receipt expectreceipt1 = case1();
		Receipt expectreceipt2 = case2();
		Receipt expectreceipt3 = case3();
		Receipt actualreceipt1 = cartservice.getReceipt(cartservice.CartLogicHandler(cartservice.sentenceHandler("Location: CA, 1 book at 17.99, 1 potato chips at 3.99")));
		Receipt actualreceipt2 = cartservice.getReceipt(cartservice.CartLogicHandler(cartservice.sentenceHandler("Location: NY, 1 book at 17.99, 3 pencils at 2.99")));
		Receipt actualreceipt3 = cartservice.getReceipt(cartservice.CartLogicHandler(cartservice.sentenceHandler("Location: NY, 2 pencils at 2.99, 1 shirt at 29.99")));
		assertReceiptEquals(expectreceipt1 , actualreceipt1);
		assertReceiptEquals(expectreceipt2 , actualreceipt2);
		assertReceiptEquals(expectreceipt3 , actualreceipt3);
	}

	private void assertReceiptEquals(Receipt expectreceipt, Receipt actualreceipt) {
		assertEquals(Double.toString(expectreceipt.getTotaltax()), Double.toString((actualreceipt.getTotaltax())));
		assertEquals(Double.toString(expectreceipt.getTotal()), Double.toString((actualreceipt.getTotal())));
		assertEquals(Double.toString(expectreceipt.getSubtotal()), Double.toString((actualreceipt.getSubtotal())));
		for(int i = 0; i< actualreceipt.getItemlist().size(); i++) {
			assertEquals(Double.toString(expectreceipt.getItemlist().get(i).getPrice()), Double.toString((actualreceipt.getItemlist().get(i).getPrice())));
			assertEquals(Double.toString(expectreceipt.getItemlist().get(i).getTax()), Double.toString((actualreceipt.getItemlist().get(i).getTax())));
			assertEquals(Integer.toString(expectreceipt.getItemlist().get(i).getQty()), Integer.toString((actualreceipt.getItemlist().get(i).getQty())));
			assertEquals(expectreceipt.getItemlist().get(i).getName(), actualreceipt.getItemlist().get(i).getName());
			assertEquals(expectreceipt.getItemlist().get(i).getState(), actualreceipt.getItemlist().get(i).getState());
		}		
	}
	
	public Receipt case1(){ //setting expected case for "Location: CA, 1 book at 17.99, 1 potato chips at 3.99"
		ArrayList<Item> case1list = new ArrayList<Item>();
		Item item = new Item();
		Receipt receipt = new Receipt();
		item.setName("book");item.setPrice(17.99);item.setQty(1);item.setState("CA");item.setTax(1.8);case1list.add(item);
		Item item2 = new Item();
		item2.setName("potato chips");item2.setPrice(3.99);item2.setQty(1);item2.setState("CA");item2.setTax(0);case1list.add(item2);
		receipt.setItemlist(case1list);
		receipt.setSubtotal(21.98);
		receipt.setTotaltax(1.8);
		receipt.setTotal(23.78);
		return receipt;
	}
	
	public Receipt case2(){ //setting expected case for "Location: CA, 1 book at 17.99, 1 potato chips at 3.99"
		ArrayList<Item> case2list = new ArrayList<Item>();
		Item item = new Item();
		Receipt receipt = new Receipt();
		item.setName("book");item.setPrice(17.99);item.setQty(1);item.setState("NY");item.setTax(1.6);case2list.add(item);
		Item item2 = new Item();
		item2.setName("pencil");item2.setPrice(2.99);item2.setQty(3);item2.setState("NY");item2.setTax(0.8);case2list.add(item2);
		receipt.setItemlist(case2list);
		receipt.setSubtotal(26.96);
		receipt.setTotaltax(2.4);
		receipt.setTotal(29.36);
		return receipt;
	}
	
	public Receipt case3(){ //setting expected case for "Location: CA, 1 book at 17.99, 1 potato chips at 3.99"
		ArrayList<Item> case3list = new ArrayList<Item>();
		Item item = new Item();
		Receipt receipt = new Receipt();
		item.setName("pencil");item.setPrice(2.99);item.setQty(2);item.setState("NY");item.setTax(0.55);case3list.add(item);
		Item item2 = new Item();
		item2.setName("shirt");item2.setPrice(29.99);item2.setQty(1);item2.setState("NY");item2.setTax(0);case3list.add(item2);
		receipt.setItemlist(case3list);
		receipt.setSubtotal(35.97);
		receipt.setTotaltax(0.55);
		receipt.setTotal(36.52);
		return receipt;
	}
}
