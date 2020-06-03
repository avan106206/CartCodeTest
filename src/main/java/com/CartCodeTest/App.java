package com.CartCodeTest;

import java.util.ArrayList;
import java.util.Scanner;

import com.CartModel.Item;
import com.CartModel.Receipt;
import com.CartService.CartService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CartService cartLogic = new CartService();
        Scanner input = new Scanner(System.in);
        System.out.println("enter the product with the format: Example: Location: CA, 1 book at 17.99, 1 potato chips at 3.99");
        String inputsentence = input.nextLine();
        /**call service method**/
        ArrayList<Item> inputItemlist = cartLogic.sentenceHandler(inputsentence);
        ArrayList<Item> handledItemlist = cartLogic.CartLogicHandler(inputItemlist);
        Receipt receipt = cartLogic.getReceipt(handledItemlist);
        /**print receipt**/
        System.out.format("%2s%15s%12s", "item", "price", "qty");
        for(Item item: receipt.getItemlist()){
            System.out.println();
            System.out.format("%2s%15s%12s", item.getName(), Double.toString(item.getPrice()), Integer.toString(item.getQty()));
        }
        System.out.println();
        System.out.format("%2s%30s", "tax", Double.toString(receipt.getTotaltax()));
        System.out.println();
        System.out.format("%2s%30s", "total", Double.toString(receipt.getPrice()));
    }
}
