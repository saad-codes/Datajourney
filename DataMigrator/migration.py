from connector import get_connection
from connector import queries
import pandas as pd



if __name__ == '__main__':

	try:
		engine = get_connection()
		flat_data = pd.read_sql(queries.query, engine.connect())
		flat_data.to_csv("sample.csv")
		flat_data.to_parquet('df.parquet',compression='gzip')


	except Exception as ex:
		print("Connection error: \n", ex)
	
    
	try:
		engine = get_connection()
		orders = pd.read_sql("select * from sys.orders", engine.connect())
	except Exception as ex:
		print("Connection error: \n", ex)