package me.niklas.learning.abiturprep.model;

import javax.validation.constraints.NotBlank;

/**
 * Created by Niklas on 2020/03/31
 */
public class CryptInfo {

    @NotBlank
    private final String text;
    private final Integer rotation;
    private final String key;

    public CryptInfo(String text, Integer rotation, String key) {
        this.text = text;
        this.rotation = rotation == null ? 0 : rotation;
        this.key = key;
    }


    public String getText() {
        return text;
    }

    public int getRotation() {
        return rotation;
    }

    public String getKey() {
        return key;
    }
}
