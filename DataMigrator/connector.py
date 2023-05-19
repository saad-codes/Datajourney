# IMPORT THE SQALCHEMY LIBRARY's CREATE_ENGINE METHOD
from sqlalchemy import create_engine

# DEFINE THE DATABASE CREDENTIALS
user = 'root'
password = 'admin123'
host = '127.0.0.1'
port = 3306
database = 'sys'

# PYTHON FUNCTION TO CONNECT TO THE MYSQL DATABASE AND
# RETURN THE SQLACHEMY ENGINE OBJECT
def get_connection():
	return create_engine(
		url="mysql+pymysql://{0}:{1}@{2}:{3}/{4}".format(
			user, password, host, port, database
		)
	)


class queries():
	
    query = """SELECT 
                order_detail_id
                ,ORDER_COUNTRY
                ,order_details.ORDER_ID
                ,COUNTRY_NAME
                ,BRANCH_ID
                ,BRANCH_NAME
                ,BRANCH_ACTIVE
                ,ITEM_ID
                ,ITEM_NAME
                ,ITEM_PRICE
                ,ITEM_UOM
                ,QUANTITY
                ,DISCOUNT_ID
                ,DISCOUNT_NAME
                ,DISCOUNT_PERCENTAGE
                ,INSERTION_TIME
                ,order_time
            FROM (
                SELECT order_details.order_detail_id
                    ,order_details.ORDER_ID
                    ,order_details.ITEM_ID
                    ,items.ITEM_NAME
                    ,items.ITEM_PRICE
                    ,items.ITEM_UOM
                    ,order_details.QUANTITY
                    ,order_details.DISCOUNT_ID
                    ,discounts.DISCOUNT_NAME
                    ,discounts.DISCOUNT_PERCENTAGE
                    ,order_details.INSERTION_TIME
                FROM sys.order_details
                LEFT JOIN sys.discounts ON discounts.DISCOUNT_ID = order_details.DISCOUNT_ID
                LEFT JOIN sys.items ON items.ITEM_ID = order_details.ITEM_ID
                ) order_details
            LEFT JOIN (
                SELECT Orders.ORDER_ID
                    ,Orders.ORDER_COUNTRY
                    ,countries.COUNTRY_NAME
                    ,Orders.BRANCH_ID
                    ,branches.BRANCH_NAME
                    ,branches.ACTIVE BRANCH_ACTIVE
                    ,Orders.order_time
                FROM sys.Orders
                LEFT JOIN sys.countries ON ORDER_COUNTRY = COUNTRY_ID
                LEFT JOIN sys.branches ON branches.BRANCH_ID = Orders.BRANCH_ID
                ) orders ON orders.ORDER_ID = order_details.ORDER_ID"""
            

