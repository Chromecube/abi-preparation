package me.niklas.learning.abiturprep.controller;

import me.niklas.learning.abiturprep.model.CryptInfo;
import me.niklas.learning.abiturprep.model.QueryResult;
import me.niklas.learning.abiturprep.service.EncryptionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Niklas on 2020/03/31
 */
@RestController
@RequestMapping("/encrypt")
public class EncryptionController {

    @Autowired
    private EncryptionProvider crypt;

    @PostMapping("/caesar")
    public QueryResult applyCaesar(@RequestBody CryptInfo info) {
        return new QueryResult().setResult(crypt.caesar(info.getText(), info.getRotation()));
    }

    @PostMapping("/rot13")
    public QueryResult rot13(@RequestBody CryptInfo info) {
        return new QueryResult().setResult(crypt.caesar(info.getText(), 13));
    }
}
