package easy

object ResistorColorDuo {
    fun value(vararg colors: Color): Int {
        return (ResistorColor.colorCode(colors[0].toString()).toString()
                + ResistorColor.colorCode(colors[1].toString()).toString())
            .toInt()
    }
}
