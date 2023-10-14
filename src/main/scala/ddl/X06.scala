package ddl

import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.java2d._
import doodle.syntax.all._

object X06 extends App {

  val basicLayout =
    Picture
      .circle(100)
      .strokeColor(Color.blue).debug
      .beside(Picture.square(100).strokeColor(Color.darkBlue).debug)
      .above(Picture.triangle(100, 100).strokeColor(Color.crimson).debug)
      .strokeWidth(5.0)
      .debug

  val atAndOriginAt =
    Picture
      .circle(100)
      .at(25, 25) // moves local center
      .debug
      .beside(Picture.circle(100)
        // .originAt(25, 25)
        .debug)

  val c = Picture.circle(10)

  val deltas = LazyList.unfold(0) {
    case x if x < 360 => Some(x -> (x + 360 / 36))
    case _            => None
  }.to(List)

  val figure =
    deltas.foldLeft(Picture.empty) { case (p, angle) => p on c.at(200, angle.degrees) }

  val c100 = Picture
    .circle(100)

  val overlappingCircles =
    Picture.empty
      .on(c100.originAt(Landmark(Coordinate.percent(50), Coordinate.percent(-50))))
      .on(c100.originAt(Landmark(Coordinate.percent(-50), Coordinate.percent(-50))))
      .on(c100.originAt(Landmark(Coordinate.percent(-50), Coordinate.percent(50))))
      .on(c100.originAt(Landmark(Coordinate.percent(50), Coordinate.percent(50))))

  val circle = Picture.circle(50)
  val rollingCircles =
    circle
      .margin(25)
      .debug
      .beside(circle.margin(15).debug)
      .beside(circle.debug)
      .beside(circle.margin(-15).debug)
      .beside(circle.margin(-25).debug)


  //  basicLayout.draw()
//  atAndOriginAt.draw()
  figure.draw()
//  overlappingCircles.draw()
//  rollingCircles.draw()

}
