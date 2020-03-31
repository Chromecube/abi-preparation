package me.niklas.learning.abiturprep.model;

import javax.validation.constraints.NotBlank;

/**
 * Created by Niklas on 2020/03/31
 */
public class CryptInfo {

    @NotBlank
    private final String text;
    private final int rotation;

    public CryptInfo(String text, int rotation) {
        this.text = text;
        this.rotation = rotation;
    }

    public String getText() {
        return text;
    }

    public int getRotation() {
        return rotation;
    }
}
