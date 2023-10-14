package ddl

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.core.format._
import doodle.svg._
import doodle.syntax.all._

object X11svg extends App {

  val circle = Picture.circle(100)
    .strokeWidth(10.0)
    .fillColor(Color.crimson)

  circle.write[Svg]("circle.svg")

}
