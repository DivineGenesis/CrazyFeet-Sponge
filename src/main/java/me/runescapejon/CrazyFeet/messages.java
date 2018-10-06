package me.runescapejon.CrazyFeet;

import me.runescapejon.CrazyFeet.Commands.commandUtil;

public class messages {

    private static final String generalError = "Invalid Choice! Available colors are\n";
    public static final String colorError = generalError + commandUtil.getColors().toString();
    public static final String bodyError = generalError + commandUtil.getBodyTypes().toString();
    public static final String colorCommandKey = "color";
    public static final String bodyCommandKey = "bodyType";

}
