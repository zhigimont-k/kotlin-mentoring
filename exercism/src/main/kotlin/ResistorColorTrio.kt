object ResistorColorTrio {

    fun text(vararg input: Color): String {
        return (ResistorColor.colorCode(input[0].toString()).toString()+
                ResistorColor.colorCode(input[1].toString()).toString()+
                "0".repeat(ResistorColor.colorCode(input[2].toString()))+" ")
                    .replace("000000 ", " mega")
                    .replace("000 ", " kilo")+
                "ohms"
    }
}
