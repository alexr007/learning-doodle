package ddl

import cats.effect.unsafe.implicits.global
import doodle.{algebra, java2d}
import doodle.core._
import doodle.image._
import doodle.image.syntax.all._
import doodle.java2d._
import doodle.language.Basic
import doodle.syntax.all._

import java.io.File

object X01 extends App {

  val size               = 30
  val blackSquare: Image = Image.rectangle(size, size) // .fillColor(Color.black)
  val redSquare: Image   = Image.rectangle(size, size).fillColor(Color.red)
  val twoByTwo: Image    =
    redSquare
      .beside(blackSquare)
      .above(blackSquare.beside(redSquare))
  val x4x4: Image        =
    twoByTwo
      .beside(twoByTwo)
      .above(twoByTwo.beside(twoByTwo))
  val s8: Image          =
    x4x4
      .beside(x4x4)
      .above(x4x4.beside(x4x4))

//  val compiled: algebra.Picture[Basic, Unit] = s8.compile
//  compiled.draw()
//
//  s8.draw()
//
//  Image.rightArrow()

  val cir: java2d.Picture.Picture[Unit] = Picture.circle(30)
  cir.draw()

}
