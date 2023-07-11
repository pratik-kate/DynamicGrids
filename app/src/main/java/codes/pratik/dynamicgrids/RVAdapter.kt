package codes.pratik.dynamicgrids

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import codes.pratik.dynamicgrids.gridcompenents.SpannableGridLayoutManager
import codes.pratik.dynamicgrids.gridcompenents.TwoWayLayoutManager
import codes.pratik.dynamicgrids.models.ChildAdapter
import codes.pratik.dynamicgrids.models.Component

class RVAdapter(private var list: List<Component>, private var mContext: Context) :
    RecyclerView.Adapter<RVAdapter.RVViewHolder>() {

    class RVViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val childRV: RecyclerView

        init {
            title = view.findViewById<View>(R.id.textView) as TextView
            childRV = view.findViewById(R.id.childRV) as RecyclerView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false)
        return RVViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        setupSpannableHolder(holder, position)
    }

    private fun setupSpannableHolder(holder: RVViewHolder, position: Int) {

        val component = list[position]

        val data = component.componentGridConfigs.configs.first().gridConfig

        holder.title.text = component.text

        val itemView = holder.itemView

        data?.let {
            itemView.setBackgroundColor(Color.parseColor(data.background ?: "#FFFFFF"))

            val lp: SpannableGridLayoutManager.LayoutParams =
                itemView.layoutParams as SpannableGridLayoutManager.LayoutParams

            val colSpan = data.toColumn
            val rowSpan = data.toRow

            if (lp.rowSpan !== rowSpan || lp.colSpan !== colSpan) {
                lp.rowSpan = rowSpan
                lp.colSpan = colSpan
            }

            setupChildRecyclerView(holder.childRV, component.components, lp.colSpan, lp.rowSpan)
        }
    }

    private fun setupChildRecyclerView(
        rv: RecyclerView,
        component: List<Component>?,
        colSpan: Int,
        rowSpan: Int
    ) {

        val adapter = ChildAdapter(mContext, component)

        val lm =
            SpannableGridLayoutManager(TwoWayLayoutManager.Orientation.VERTICAL, colSpan, rowSpan)

        rv.adapter = adapter
        rv.layoutManager = lm
    }
}