package me.niklas.learning.abiturprep.controller;

import me.niklas.learning.abiturprep.model.QueryResult;
import me.niklas.learning.abiturprep.service.SortProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Niklas on 2020/03/31
 */
@RestController
@RequestMapping("/sort")
public class SortController {

    @Autowired
    private SortProvider provider;

    @PostMapping("/all")
    public QueryResult testAll(@RequestBody int[] array) {
        QueryResult result = new QueryResult();
        Map<String, String> algorithms = new HashMap<>();
        algorithms.put("Selection Sort", selectionSort(array).getDuration());
        algorithms.put("Insertion Sort", insertionSort(array).getDuration());
        algorithms.put("Bubble Sort", bubbleSort(array).getDuration());
        algorithms.put("Quick Sort", quickSort(array).getDuration());
        algorithms.put("Merge Sort", mergeSort(array).getDuration());
        result.setResult(algorithms);
        return result;
    }

    @PostMapping("/select")
    public QueryResult selectionSort(@RequestBody int[] array) {
        QueryResult result = new QueryResult();
        return result.setResult(provider.selectionSort(array));
    }

    @PostMapping("/insert")
    public QueryResult insertionSort(@RequestBody int[] array) {
        QueryResult result = new QueryResult();
        return result.setResult(provider.insertionSort(array));
    }

    @PostMapping("/bubble")
    public QueryResult bubbleSort(@RequestBody int[] array) {
        QueryResult result = new QueryResult();
        return result.setResult(provider.bubbleSort(array));
    }

    @PostMapping("/quick")
    public QueryResult quickSort(@RequestBody int[] array) {
        QueryResult result = new QueryResult();
        return result.setResult(provider.quickSort(array));
    }

    @PostMapping("/merge")
    public QueryResult mergeSort(@RequestBody int[] array) {
        QueryResult result = new QueryResult();
        return result.setResult(provider.mergeSort(array));
    }
}
