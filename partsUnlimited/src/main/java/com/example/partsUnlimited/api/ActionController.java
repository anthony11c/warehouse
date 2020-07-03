package com.example.partsUnlimited.api;

import com.example.partsUnlimited.model.Action;
import com.example.partsUnlimited.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/salesAction")
@RestController
public class ActionController {

    private final ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping
    public void addAction(@RequestBody Action action){
        actionService.addAction(action);
    }
}
