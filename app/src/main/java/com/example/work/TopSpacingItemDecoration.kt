package com.example.work

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.core.graphics.convertTo
import androidx.recyclerview.widget.RecyclerView

class TopSpacingItemDecoration(private val paddingInDp: Int) : RecyclerView.ItemDecoration() {
    private val Int.convertPx: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = paddingInDp.convertPx
        outRect.left = paddingInDp.convertPx
        outRect.right = paddingInDp.convertPx
    }
}