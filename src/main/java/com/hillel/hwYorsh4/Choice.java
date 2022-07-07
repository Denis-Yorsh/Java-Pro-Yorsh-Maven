package com.hillel.hwYorsh4;

public enum Choice {
    YES("Y"),
    NO("N");

    String yesOrNo;

    Choice(String yesOrNo) {
        this.yesOrNo = yesOrNo;
    }

    public static Choice convert(String yesOrNo) {
        for (Choice choice : values()) {
            if (choice.yesOrNo.equals(yesOrNo)) {
                return choice;
            }
        }
        return null;
    }
}
