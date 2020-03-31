package me.niklas.learning.abiturprep.controller;

import me.niklas.learning.abiturprep.model.QueryResult;
import me.niklas.learning.abiturprep.service.SearchProvider;
import me.niklas.learning.abiturprep.service.SortProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Niklas on 2020/03/31
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchProvider provider;
    @Autowired
    private SortProvider sorting;

    @PostMapping("/testall/{search}")
    public QueryResult testAll(@RequestBody int[] array, @PathVariable("search") int search) {

        QueryResult result = new QueryResult();
        Map<String, String> data = new HashMap<>();
        data.put("Linear Search", linearSearch(array, search).getDuration());
        data.put("Reverse Linear Search", reverseLinearSearch(array, search).getDuration());

        //Zuerst müssen die Daten sortiert werden, nutze temporäres QueryResult zum messen der Sortierzeit
        QueryResult temp = new QueryResult();
        int[] sorted = sorting.mergeSort(array);
        data.put("Sorting duration (merge sort)", temp.setResult(sorted).getDuration());
        data.put("Binary Search", binarySearch(sorted, search).getDuration());

        return result.setResult(data);
    }

    @PostMapping("/linear/{search}")
    public QueryResult linearSearch(@RequestBody int[] array, @PathVariable("search") int search) {
        QueryResult res = new QueryResult();
        res.setResult(provider.linearSearch(array, search));
        return res;
    }

    @PostMapping("/reverse-linear/{search}")
    public QueryResult reverseLinearSearch(@RequestBody int[] array, @PathVariable("search") int search) {
        QueryResult res = new QueryResult();
        res.setResult(provider.reverseLinearSearch(array, search));
        return res;
    }

    @PostMapping("/binary/{search}")
    public QueryResult binarySearch(@RequestBody int[] array, @PathVariable("search") int search) {
        QueryResult res = new QueryResult();
        res.setResult(provider.binarySearch(array, search));
        return res;
    }
}
