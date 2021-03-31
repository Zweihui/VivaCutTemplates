package other.board.src.app_package

import other.fileHeader

fun IBoardKt(
  boardClass:String?,
  packageName:String
)="""
package $packageName

${fileHeader()}
interface I${boardClass}Board {

}
"""