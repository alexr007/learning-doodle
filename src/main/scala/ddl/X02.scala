package ddl

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.image._
import doodle.{algebra, java2d}
import doodle.java2d._
import doodle.syntax.all._

object X02 extends App {

  val left: java2d.Picture.Picture[Unit] = Picture.circle(10)
  val right: java2d.Picture.Picture[Unit] = Picture.circle(20)
  val combined: algebra.Picture[Algebra, Unit] = left.beside(right)

  combined.draw()
}
