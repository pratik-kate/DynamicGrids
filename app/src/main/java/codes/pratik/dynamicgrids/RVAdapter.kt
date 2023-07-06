package codes.pratik.dynamicgrids

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import codes.pratik.dynamicgrids.gridcompenents.SpannableGridLayoutManager
import codes.pratik.dynamicgrids.gridcompenents.StaggeredGridLayoutManager

class RVAdapter(private var list: List<MainActivity.Component>, private var mContext: Context): RecyclerView.Adapter<RVAdapter.RVViewHolder>() {



    class RVViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView

        init {
            title = view.findViewById<View>(R.id.textView) as TextView
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

//        setupStaggeredGridHolder(holder, position)
        setupSpannableHolder(holder, position)
    }

    private fun setupSpannableHolder(holder: RVViewHolder, position: Int) {
        // TODO: Add Iterator
        val data = list[position].componentGridConfigs.configs.first()

        holder.title.text = data.position

        val itemView = holder.itemView

        itemView.setBackgroundColor(Color.parseColor(data.background))

        val lp: SpannableGridLayoutManager.LayoutParams =
            itemView.layoutParams as SpannableGridLayoutManager.LayoutParams

        val colSpan = data.toColumn - data.fromColumn + 1
        val rowSpan = data.toRow - data.fromRow + 1

        if (lp.rowSpan !== rowSpan || lp.colSpan !== colSpan) {
            lp.rowSpan = rowSpan
            lp.colSpan = colSpan
        }
    }

    private fun setupStaggeredGridHolder(holder: RVViewHolder, position: Int) {
        // TODO: Add Iterator
        val data = list[position].componentGridConfigs.configs.first()

        holder.title.text = data.position

        val itemView = holder.itemView

        val lp: StaggeredGridLayoutManager.LayoutParams =
            itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams

        val colSpan = data.toColumn - data.fromColumn + 1
        val rowSpan = data.toRow - data.fromRow + 1

        lp.span = colSpan

    }

}