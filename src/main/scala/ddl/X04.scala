package ddl

import doodle.core._
import doodle.syntax.all._
import doodle.java2d._
import cats.effect.unsafe.implicits.global
//import cats.implicits._
import doodle.image.Image.Elements.Font

object X04 extends App {

  val zeroTo360 = fs2.Stream.unfold(0) {
    case x if x < 360 => Some(x -> (x + 10))
    case _            => None
  }.to(List)
  val circle = Picture.circle(240).strokeColor(Color.blue).strokeWidth(5)
  val square = Picture.square(145).strokeColor(Color.darkBlue)
  val squares = zeroTo360.foldLeft(Picture.empty) { case (p, angle) => p on square.rotate(Angle.degrees(angle)) }
  val triangle = Picture.equilateralTriangle(100).strokeColor(Color.crimson).strokeWidth(2)
  val triangles = triangle.on(triangle.rotate(Angle.one / 2))
  val text = Picture.text("hello")
  val spline = Picture.interpolatingSpline(List(Point(0,0), Point(100,100), Point(200, 0), Point(300,-100), Point(400, 0), Point(500, 100), Point(600, 0)))
  val combined = List(circle, squares, triangles, text).fold(Picture.empty)((a, p) => a on p)

  combined.draw()
//  spline.draw()
}
