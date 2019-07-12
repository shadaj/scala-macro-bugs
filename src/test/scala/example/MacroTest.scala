package example

object MacroTest {
  def a(default: Int = 0, notDefault: Int)(args: Int*) = ???
  def b(str: => Int): Int = ???
  a(notDefault = 0)(b(Macro.myMacro()))
}
