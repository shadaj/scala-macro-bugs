# scala-macro-bugs
A reproduction of a Scala compiler bug (affecting 2.12 and 2.13) where using macros results in "Error while emitting" crashes.

This is minimized as far as possible while keeping the compiler crashing. The conditions that cause this issue are:
- Have a macro that includes and uses a `val` as part of the code it emits
- Call the macro when supplying a by-name parameter to some method `b`
- Call method `b` while providing varargs to method `a`
- Method `a` is called with a parameter (default or non-default) that is not the first parameter supplied as a named parameter

While super specific, this actually came up with testing a new Slinky feature (https://github.com/shadaj/slinky/pull/263) with a production code base!
