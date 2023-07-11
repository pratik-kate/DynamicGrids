package codes.pratik.dynamicgrids.models

data class Component(
    val alignment: String,
    val border: Int,
    val componentGridConfigs: ComponentGridConfigs,
    val components: List<Component>,
    val text: String
)