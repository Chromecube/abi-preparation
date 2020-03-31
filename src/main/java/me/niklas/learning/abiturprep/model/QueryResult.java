package me.niklas.learning.abiturprep.model;

/**
 * Created by Niklas on 2020/03/31
 */
public class QueryResult {

    private final long start = System.currentTimeMillis();
    private Object result;
    private String duration;

    public Object getResult() {
        return result;
    }

    public QueryResult setResult(Object result) {
        duration = System.currentTimeMillis() - start + "ms";
        this.result = result;
        return this;
    }

    public String getDuration() {
        return duration;
    }
}
