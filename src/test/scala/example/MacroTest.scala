package example

object MacroTest {
  def a(default: Int = 0, defaultOrNonDefault: Int)(args: Int*) = ???
  def b(num: => Int): Int = ???
  a(defaultOrNonDefault = 0)(b(Macro.myMacro()))
}
