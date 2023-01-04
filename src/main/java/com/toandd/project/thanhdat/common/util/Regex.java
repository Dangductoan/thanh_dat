package com.toandd.project.thanhdat.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Regex {
    public static final String CODE_REGEX = "^[A-Z0-9_]*$";

    public static final String VIETNAM_PHONE_REGEX = "((0|84)(9|3|7|8|5)+([0-9]{8})\\b)";
    public static final String LINK_REGEX ="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
}
