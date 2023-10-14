package ddl

object X03Image extends App {

  import doodle.core._
  import doodle.image._
  import doodle.image.syntax.all._
  // backend to interpret
  import doodle.java2d._
  // effect handle
  import cats.effect.unsafe.implicits.global

  val yellow = Image.rectangle(150, 50).fillColor(Color.yellow)
  val blue = Image.rectangle(150, 50).fillColor(Color.blue)
  val flag = yellow.above(blue)

  flag.draw()
}

object X03Picture extends App {

  import doodle.core._
  import doodle.syntax.all._
  // backend to build
  import doodle.java2d._
  // effect handle
  import cats.effect.unsafe.implicits.global

  val yellow = Picture.rectangle(150, 50).fillColor(Color.yellow)
  val blue = Picture.rectangle(150, 50).fillColor(Color.blue)
  val flag = yellow.above(blue)

  flag.draw()
}
