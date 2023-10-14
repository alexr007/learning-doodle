package ddl

import cats.effect.{IO, IOApp}
import doodle.core._
import doodle.java2d._
import doodle.java2d.effect.Java2dRenderer
import doodle.syntax.all._

object X09io extends IOApp.Simple {

  val p = Picture.circle(100).strokeColor(Color.yellow).strokeWidth(5)

  val frame: Frame = Frame.default
    .withSize(300, 300)
    .withBackground(Color.midnightBlue)

  override def run: IO[Unit] =
    frame.canvas()
      .map { c =>
        c.setTitle("woo-hoo")
        c
      }
      .flatMap { c =>
        Java2dRenderer.render(c)(p)
        p.drawWithCanvasToIO(c)
      }
}
