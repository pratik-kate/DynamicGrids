package codes.pratik.dynamicgrids

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import codes.pratik.dynamicgrids.gridcompenents.SpannableGridLayoutManager
import codes.pratik.dynamicgrids.gridcompenents.StaggeredGridLayoutManager
import codes.pratik.dynamicgrids.gridcompenents.TwoWayLayoutManager.Orientation
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        val jsonData =
            "{ \"name\": \"dashboard-view\", \"id\": \"dashboardReports\", \"description\": \"This is dashboard count report page\", \"version\": \"v1\", \"components\": [ { \"text\": \"Total Leads: 10\", \"alignment\": \"left\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 1, \"toRow\": 1, \"fromColumn\": 1, \"toColumn\": 12, \"background\": \"#641E16\", \"position\": \"1\" } } ] } }, { \"border\": 1, \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 2, \"toRow\": 3, \"fromColumn\": 1, \"toColumn\": 4, \"background\": \"#512E5F\", \"position\": \"2\" } } ] }, \"components\": [ { \"text\": \"Unactioned\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 1, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 4 } } ] } }, { \"text\": \"10\", \"alignment\": \"right\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 2 } } ] } }, { \"text\": \"(100%)\", \"alignment\": \"left\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 3, \"toColumn\": 2 } } ] } } ] }, { \"componentGridConfigs\": { \"configs\": [ { \"description\": \"empty view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 3, \"fromColumn\": 1, \"toColumn\": 4, \"background\": \"#FFFFFF\" } } ] } }, { \"border\": 1, \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 5, \"fromColumn\": 5, \"toColumn\": 9, \"background\": \"#512E5F\", \"position\": \"3\" } } ] }, \"components\": [ { \"text\": \"Actioned\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 1, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 4 } } ] } }, { \"text\": \"10\", \"alignment\": \"right\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 2 } } ] } }, { \"text\": \"(0%)\", \"alignment\": \"left\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 3, \"toColumn\": 2 } } ] } } ] }, { \"border\": 1, \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 2, \"toRow\": 3, \"fromColumn\": 10, \"toColumn\": 12, \"background\": \"#512E5F\", \"position\": \"4\" } } ] }, \"components\": [ { \"text\": \"A/C Opened\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 1, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 4 } } ] } }, { \"text\": \"10\", \"alignment\": \"right\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 2 } } ] } }, { \"text\": \"(0%)\", \"alignment\": \"left\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 3, \"toColumn\": 2 } } ] } } ] }, { \"componentGridConfigs\": { \"configs\": [ { \"description\": \"empty view\", \"gridConfig\": { \"fromRow\": 4, \"toRow\": 5, \"fromColumn\": 10, \"toColumn\": 12, \"background\": \"#FFFFFF\" } } ] } }, { \"border\": 1, \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 5, \"toRow\": 7, \"fromColumn\": 1, \"toColumn\": 6, \"background\": \"#512E5F\", \"position\": \"5\" } } ] }, \"components\": [ { \"text\": \"Actn with cont\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 1, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 4 } } ] } }, { \"text\": \"10\", \"alignment\": \"right\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 2 } } ] } }, { \"text\": \"(0%)\", \"alignment\": \"left\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 3, \"toColumn\": 2 } } ] } } ] }, { \"border\": 1, \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 5, \"toRow\": 7, \"fromColumn\": 8, \"toColumn\": 12, \"background\": \"#512E5F\", \"position\": \"6\" } } ] }, \"components\": [ { \"text\": \"A/C Opened\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 1, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 4 } } ] } }, { \"text\": \"10\", \"alignment\": \"right\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 2 } } ] } }, { \"text\": \"(0%)\", \"alignment\": \"left\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 3, \"toColumn\": 2 } } ] } } ] }, { \"border\": 1, \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 8, \"toRow\": 12, \"fromColumn\": 1, \"toColumn\": 12, \"background\": \"#512E5F\", \"position\": \"7\" } } ] }, \"components\": [ { \"text\": \"Actn with cont\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 1, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 4 } } ] } }, { \"text\": \"10\", \"alignment\": \"right\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 1, \"toColumn\": 2 } } ] } }, { \"text\": \"(0%)\", \"alignment\": \"left\", \"componentGridConfigs\": { \"configs\": [ { \"description\": \"grid chip view\", \"gridConfig\": { \"fromRow\": 3, \"toRow\": 2, \"fromColumn\": 3, \"toColumn\": 2 } } ] } } ] } ] }"
        val dashboard = decodeJson(jsonData)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)

        val data: List<Component> = dashboard.components
        val adapter = RVAdapter(data, this)

        val lm = SpannableGridLayoutManager(Orientation.VERTICAL, 12, 12)
//        val lm = StaggeredGridLayoutManager(Orientation.VERTICAL, 12,12)

        rv.adapter = adapter
        rv.layoutManager = lm
    }

    data class GridConfig(
        val fromRow: Int,
        val toRow: Int,
        val fromColumn: Int,
        val toColumn: Int,
        val background: String,
        val position: String
    )

    data class Component(
        val text: String,
        val alignment: String,
        val componentGridConfigs: ComponentGridConfigs
    )

    data class ComponentGridConfigs(
        val configs: List<GridConfig>
    )

    data class Dashboard(
        val name: String,
        val id: String,
        val description: String,
        val version: String,
        val components: List<Component>
    )

    private fun decodeJson(jsonData: String): Dashboard {

        val data = JSONObject(jsonData)
        val name = data.getString("name")
        val id = data.getString("id")
        val description = data.getString("description")
        val version = data.getString("version")
        val componentsJsonArray = data.getJSONArray("components")
        val components = mutableListOf<Component>()

        for (i in 0 until componentsJsonArray.length()) {
            val componentData = componentsJsonArray.getJSONObject(i)
            val text = componentData.optString("text")
            val alignment = componentData.optString("alignment")
            val componentGridConfigsData = componentData.optJSONObject("componentGridConfigs")
            val configsJsonArray = componentGridConfigsData?.optJSONArray("configs")

            val gridConfigs = mutableListOf<GridConfig>()

            configsJsonArray?.let {
                for (j in 0 until configsJsonArray.length()) {
                    val itemData = configsJsonArray.getJSONObject(j)
                    val gridConfigData = itemData.getJSONObject("gridConfig")
                    val gridConfig = GridConfig(
                        fromRow = gridConfigData.optInt("fromRow"),
                        toRow = gridConfigData.optInt("toRow"),
                        fromColumn = gridConfigData.optInt("fromColumn"),
                        toColumn = gridConfigData.optInt("toColumn"),
                        background = gridConfigData.optString("background"),
                        position = gridConfigData.optString("position")
                    )

                    gridConfigs.add(gridConfig)
                }
            }

            val componentGridConfigs = ComponentGridConfigs(configs = gridConfigs)
            val component = Component(
                text = text,
                alignment = alignment,
                componentGridConfigs = componentGridConfigs
            )
            components.add(component)
        }

        return Dashboard(
            name = name,
            id = id,
            description = description,
            version = version,
            components = components
        )
    }
}


