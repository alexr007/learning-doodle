package ddl

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.java2d._
import doodle.syntax.all._

object X07 extends App {

  val basicStyle =
    Picture
      .circle(100)
      .beside(
        Picture
          .circle(100)
          .strokeColor(Color.purple)
          .strokeWidth(5.0)
          .fillColor(Color.lavender)
      )

  val strokeStyle =
    Picture
      .star(5, 50, 25)
      .strokeWidth(5.0)
      .strokeColor(Color.limeGreen)
      .strokeJoin(Join.bevel)
      .strokeCap(Cap.round)
      .strokeDash(Array(9.0, 7.0))
      .beside(
        Picture
          .star(5, 50, 25)
          .strokeWidth(5.0)
          .strokeColor(Color.greenYellow)
          .strokeJoin(Join.miter)
          .strokeCap(Cap.square)
          .strokeDash(Array(12.0, 9.0))
      )

  val fillStyle =
    Picture
      .square(100)
      .fillGradient(
        Gradient.linear(
          Point(-50, 0),
          Point(50, 0),
          List((Color.red, 0.0), (Color.yellow, 1.0)),
          Gradient.CycleMethod.repeat
        )
      )
      .strokeWidth(5.0)
      .margin(0.0, 5.0, 0.0, 0.0)
      .beside(
        Picture
          .circle(100)
          .fillGradient(
            Gradient.dichromaticRadial(Color.limeGreen, Color.darkBlue, 50)
          )
          .strokeWidth(5.0)
      )

  basicStyle.draw()
  strokeStyle.draw()
  fillStyle.draw()

}
