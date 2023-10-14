package ddl

import cats.effect.{IO, IOApp}
import doodle.core._
import doodle.java2d._
import doodle.syntax.all._

import scala.concurrent.duration.DurationInt

object X12AnimationMy extends IOApp.Simple {

  val picture = Picture
    .circle(50)
    .strokeColor(Color.yellow)
    .strokeWidth(5)

  val range = fs2.Stream.unfold(0) {
    case x if x < 360 => Some(x -> (x + 360 / 360))
    case _            => None
  }

  val move =
    range
      .map(angle => picture.at(400, angle.degrees))
      .repeat

  val frame = Frame.default
    .withSize(500, 500)
    .withBackground(Color.midnightBlue)

  override def run: IO[Unit] =
    frame.canvas()
      .map { canvas =>
        canvas.setTitle("woo-hoo!")
        canvas
      }
      .flatMap { canvas =>
        move
          .evalTap(_.drawWithCanvasToIO(canvas))
          .meteredStartImmediately(30.millis)
          .compile
          .drain
      }

}
