package codes.pratik.dynamicgrids.models

data class GridConfig(
    val background: String?,
    val fromColumn: Int,
    val fromRow: Int,
    val position: String,
    val toColumn: Int,
    val toRow: Int
)