package ddl

import cats.effect._
import doodle.core._
import doodle.interact.syntax.all._
import doodle.java2d._
import doodle.syntax.all._

import scala.concurrent.duration.DurationInt

object X12animationIO extends IOApp.Simple {

  val picture = Picture
    .circle(15)
    .fillColor(Color.chartreuse)
    .strokeWidth(3.0)

  val range = -150.0 upTo 150.0

  val move =
    range
      .map(x => picture.at(x, 0.0))
      .forSteps(100)
      .repeatForever

  val frame = Frame.default
    .withSize(300, 80)
    .withBackground(Color.midnightBlue)

  override def run: IO[Unit] =
    frame.canvas()
      .flatMap { canvas =>
        move.toStream
          .evalTap(_.drawWithCanvasToIO(canvas))
          .meteredStartImmediately(20.millis)
          .compile
          .drain
      }

}
