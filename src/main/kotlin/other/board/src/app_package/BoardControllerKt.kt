package other.board.src.app_package

import other.fileHeader

fun BoardControllerKt(
  boardClass:String?,
  packageName:String
)="""
package ${packageName}

${fileHeader()}
class ${boardClass}BoardController(private var mI${boardClass}Board: I${boardClass}Board) {

  fun release() {

  }

}
"""