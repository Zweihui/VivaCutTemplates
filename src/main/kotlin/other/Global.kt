package other

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**@Author neil
 * @Description TODO
 * @Date 2021/3/30 14:33
 */

fun fileHeader() : String {
  val current = LocalDateTime.now()

  val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")
  val formatted = current.format(formatter)
  return """ 
/**
 * ================================================
 * Description:
 * <p>
 * Created by VivaCutTemplate on $formatted
 * ================================================
 */"""

}