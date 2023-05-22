object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    var num1 = 5
    val name = "saad"
    println(num1 + " "+name)
  var person1 = tutorial(12,"saad" , 13)
  person1.age_category()
  var person2 = tutorial()
  person2.age_category()
  }
  case class tutorial(var id:Int  = 1, var name:String = "Saad", var age:Int = 25)
  {
    println(id + name + age)
    def age_category() = {
      if (age > 20) {
        println("Older person")
      }
      else{
        println("Teen ager")
      }
    }

  }
}