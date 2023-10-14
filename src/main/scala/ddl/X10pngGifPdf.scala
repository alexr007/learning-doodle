package ddl

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.java2d._
import doodle.syntax.all._
import doodle.core.format._

object X10pngGifPdf extends App {

  val circle = Picture.circle(100)
    .strokeWidth(10.0)
    .fillColor(Color.crimson)

  circle.write[Png]("circle.png")
  circle.write[Gif]("circle.gif")
  circle.write[Pdf]("circle.pdf")

}
