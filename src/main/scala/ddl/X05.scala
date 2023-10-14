package ddl

import cats.effect.unsafe.implicits.global
import doodle.algebra
import doodle.algebra.Path
import doodle.core._
import doodle.java2d._
import doodle.syntax.all._
//import cats.implicits._

object X05 extends App {

  val feather: algebra.Picture[Path, Unit] =
    ClosedPath.empty
      .lineTo(100, 100)
      .curveTo(90, 75, 90, 25, 10, 10)
      .moveTo(100, 100)
      .curveTo(75, 90, 25, 90, 10, 10)
      .path

  val open =
    OpenPath.empty.curveTo(90, 0, 100, 10, 50, 50).path.strokeColor(Color.red)

  val closed =
    ClosedPath.empty.curveTo(90, 0, 100, 10, 50, 50).path.strokeColor(Color.blue)

  val curves = open.beside(closed)

  val points: Seq[Point] =
    (0 to 360)
      .map(x => Point(x, x.degrees.sin * 100))

  val curve = Picture.interpolatingSpline(points.toList)

  curves.draw()
  feather.draw()
  curve.draw()
}
