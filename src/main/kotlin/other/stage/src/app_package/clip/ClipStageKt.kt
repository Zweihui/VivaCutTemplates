package other.stage.src.app_package.clip

import other.fileHeader

fun ClipStageKt(
  stageClass:String?,
  generateToolProvider:Boolean,
  packageName:String
)="""
package ${packageName}

import android.annotation.SuppressLint
import androidx.fragment.app.FragmentActivity
import com.quvideo.vivacut.editor.common.Stage
import com.quvideo.vivacut.editor.stage.clipedit.base.BaseClipStageView
${if (generateToolProvider) 
"""import com.quvideo.vivacut.editor.stage.common.CommonToolAdapter
   import androidx.recyclerview.widget.LinearLayoutManager
   import androidx.recyclerview.widget.RecyclerView
   import com.quvideo.vivacut.editor.stage.common.ToolCallback
   import com.quvideo.vivacut.editor.stage.common.ToolItemModel
   """
else
  ""
}
import com.quvideo.vivacut.editor.R

${fileHeader()}
@SuppressLint("ViewConstructor")
class Clip${stageClass}StageView(
  activity: FragmentActivity,
  stage: Stage
)  : BaseClipStageView<Clip${stageClass}Controller>(activity, stage), IClip${stageClass}Stage {

    ${if (generateToolProvider) 
"""private lateinit var mRecyclerView: RecyclerView
   private lateinit var mAdapter: CommonToolAdapter"""
    else
    ""
    }

  override fun handleViewCreate() {
    initController()
    initView()
  }

   override fun getLayoutId(): Int {
   ${if (generateToolProvider)
  """return R.layout.editor_common_stage_view_layout"""
    else
    "return R.layout.editor_empty_stage_layout"
    }
   }
    
   private fun initController() {
     val index = emitter?.clipIndex ?: -1
     mController = Clip${stageClass}Controller(index, this)
   }

   private fun initView() {
     ${if (generateToolProvider)
  """mRecyclerView = this.findViewById(R.id.rc_view)
     mAdapter = CommonToolAdapter(context, false)
     mAdapter.setToolList(${stageClass}ToolProvider.getToolList())
     mAdapter.setListener(object : ToolCallback{
       override fun onToolSelected(
         position: Int,
         model: ToolItemModel?
       ) {
         
       }

       override fun onToolLongPress(
         position: Int,
         model: ToolItemModel?
       ) {
         
       }

     })
     //mAdapter.updateFocus(CollageMode.KEY_FRAME_ANIMATOR_LOCATION, true) //初始化选中项
     mRecyclerView.layoutManager =
     LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
     mRecyclerView.adapter = mAdapter
     """
    else
      ""
    }   
   
   }

   override fun getInitParams(force: Boolean) {
     mController?.getInitParams(force)
   }


   override fun handleRelease() {
     mController.release()
   }
   
   ${if (generateToolProvider)
  """override fun getContentRecyclerView(): RecyclerView {
        return mRecyclerView
     }"""
    else 
      ""
   }

   override fun getIndex(): Int {
    return emitter?.clipIndex ?: -1
   }

}

"""
