package me.niklas.learning.abiturprep.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Niklas on 2020/03/31
 */
@RestController
@RequestMapping("/generate")
public class GeneratorController {

    @GetMapping("/array/{length}")
    public int[] generateArray(@PathVariable("length") int length) {
        int[] array = new int[length];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    @GetMapping("/string/{length}")
    public String generateString(@PathVariable("length") int length) {
        return RandomStringUtils.random(length, true, false);
    }
}
