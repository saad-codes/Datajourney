package Demo
import com.github.tototoshi.csv._
import java.sql.DriverManager
import java.sql.Connection


class Demo {

  private val  url = "jdbc:mysql://localhost:3306/sys"
  private val username = "root"
  private val password = "admin123"
  // there's probably a better way to do this
  private var connection: Connection = null
  private val file = "E:\\DataJourney\\sample.csv"

  def dataTransformer(): Unit = {

    val reader = CSVReader.open(file)
    println(reader.readNext())

    val order_item_price = reader.all().map(x =>(x(3),
      x(10).toFloat*x(12).toFloat*(1-(x(15).toFloat/100))
    )
    ).groupMap(_._1)(_._2).map(x => (x._1 ,x._2.sum) )
    Class.forName("com.mysql.jdbc.Driver")
    //.groupBy(_._1).view.mapValues(value => value.map(_._2).sum).toList
    connection = DriverManager.getConnection(url, username, password)

    val statement = connection.createStatement()
    for (i <- order_item_price) {

      var sql = "update sys.Orders" +
                  " set order_price = " +  BigDecimal(i._2).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble  +
                      " where order_id = " +  i._1
      statement.executeQuery(sql).next()
    }
    println("insertion is completed")
  }

}
