package other.board.res.layout

fun BoardViewXml() = """
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/background_root_layout"
    android:layout_width="match_parent"
    android:layout_height="@dimen/editor_board_normal_height"
    android:background="@color/board_container_color"
    android:clickable="true"
    >

</androidx.constraintlayout.widget.ConstraintLayout>
"""