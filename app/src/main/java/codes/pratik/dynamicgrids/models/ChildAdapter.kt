package codes.pratik.dynamicgrids.models

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import codes.pratik.dynamicgrids.R
import codes.pratik.dynamicgrids.gridcompenents.SpannableGridLayoutManager

class ChildAdapter(private var mContext: Context, private var components: List<Component>?) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView

        init {
            title = itemView.findViewById<View>(R.id.childTv) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.child_item, parent, false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
        return components?.size ?: 0
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {

        components?.let {

            val componentGridConfigs = it[position].componentGridConfigs.configs.first().gridConfig

            holder.title.text = it[position].text

            componentGridConfigs?.let {
                val itemView = holder.itemView

                itemView.setBackgroundColor(
                    Color.parseColor(
                        componentGridConfigs.background ?: "#FFFFFF"
                    )
                )

                val lp: SpannableGridLayoutManager.LayoutParams =
                    itemView.layoutParams as SpannableGridLayoutManager.LayoutParams

                val colSpan = componentGridConfigs.toColumn
                val rowSpan = componentGridConfigs.toRow

                if (lp.rowSpan !== rowSpan || lp.colSpan !== colSpan) {
                    lp.rowSpan = rowSpan
                    lp.colSpan = colSpan
                }
            }
        }
    }
}