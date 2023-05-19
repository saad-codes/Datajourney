package com.datagenerator;

import com.connections.Connections;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class Data {
    public void generate() {


        //  Making the variables
        long START_TIME = System.currentTimeMillis();
        long END_TIME = System.currentTimeMillis() + 6000;
        // int count = 0 ;
        Connections conn = new Connections();
        Statement stmt = conn.Mysql();
        int MAX_ORDER_ID = 0;
        int MIN_ORDER_ID = 0;
        ResultSet result = null;


//  getting maximun order ID

        try {

            String sql = "select max(ORDER_ID) from sys.Orders;";

            result = stmt.executeQuery(sql);
            result.next();
            MAX_ORDER_ID = result.getInt(1);
            MIN_ORDER_ID = MAX_ORDER_ID ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Orders Previously inserted  = "+ MAX_ORDER_ID);

//  making random
//  run until loop is completed 


        while (START_TIME < END_TIME) {
            Random random = new Random();

            // count = count+1 ;

            MAX_ORDER_ID = MAX_ORDER_ID + 1;
            String ID = Integer.toString(MAX_ORDER_ID);
            //Country and  branches

            START_TIME = System.currentTimeMillis();
            final int[] country = {1, 2, 3};
            final int[] branchs = {1, 2, 3, 4};


            //Random Selection

            int INDEX = random.nextInt(country.length);
            int ORDER_COUNTRY = country[INDEX];
            INDEX = random.nextInt(branchs.length);
            String BRANCH_ID = String.valueOf(branchs[INDEX]);


            try {

                stmt.executeUpdate("insert into Orders (ORDER_ID, ORDER_COUNTRY,BRANCH_ID , ORDER_TIME ) Values (" + ID + "," + "'" + ORDER_COUNTRY + "'" + "," + BRANCH_ID + ",current_timestamp())");


                for (int i = 1; i <= random.nextInt(4) + 1; i++) {

                    final int[] discount = {1, 2};
                    final int[] items = {1, 2, 3, 4};

                    INDEX = random.nextInt(discount.length);
                    int DISCOUNT_ID = discount[INDEX];

                    INDEX = random.nextInt(items.length);
                    String ITEM_ID = String.valueOf(items[INDEX]);

                    int QUANTITY = random.nextInt(4) + 1;

                    stmt.executeUpdate("insert into Order_details (ORDER_ID,ITEM_ID ,QUANTITY,DISCOUNT_ID,INSERTION_TIME    ) Values (" + ID + "," + ITEM_ID + "," + QUANTITY + "," + DISCOUNT_ID + "," + "current_timestamp())");
                }

//        random
//        final int[] country = {1,2,3};


            } catch (Exception e) {
                e.printStackTrace();

            }


        }
        System.out.println("Order Inserted in this run are " + (MAX_ORDER_ID - MIN_ORDER_ID) );
        System.out.println("So the new Maximum Order id is = " + MAX_ORDER_ID);


    }
}


