package ddl

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.java2d._
import doodle.syntax.all._

object X09 extends App {

  val picture = Picture.circle(100).strokeColor(Color.crimson)

  val frame: Frame = Frame.default.withSize(300, 300).withBackground(Color.midnightBlue)
  picture.drawWithFrame(frame)

  frame.canvas()
    .map { c =>
      c.setTitle("woo-hoo")
      c
    }
    .map(c => picture.drawWithCanvas(c))
    .unsafeRunSync()

  val x: IO[Unit] = frame.canvas().flatMap(c => picture.drawWithCanvasToIO(c))
  val y: IO[Unit] = picture.drawToIO()

}
