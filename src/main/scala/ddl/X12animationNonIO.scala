package ddl

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.interact.syntax.all._
import doodle.java2d._
import doodle.syntax.all._

object X12animationNonIO extends App {

  val p = Picture
    .circle(15)
    .fillColor(Color.chartreuse)
    .strokeWidth(3.0)

  val range = -100.0 upTo 100.0

  val move =
    range.map(x => p.at(x, 0.0))
      .forSteps(200)
      .repeatForever

  val frame = Frame.default
    .withSize(300, 80)
    .withBackground(Color.midnightBlue)

  move.animate(frame)
}
