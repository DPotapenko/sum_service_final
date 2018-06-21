package com.example.sum_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    Repo userRepo;

    //вывод списка
    @GetMapping("/all")
    public List<Model> all() {
        return userRepo.findAll();
    }

    //добавление
    @PostMapping("/add")
    public Response add(@RequestBody Model model) {
        if (userRepo.userCount(model.getName()) > 0) {
            return new Response(2, "Добавление невозможно! Запись с таким именем уж существует");
        } else {
            String name = model.getName();
            int val = model.getValue();
            userRepo.save(new Model(name, val));
            return new Response(0, "OK");
        }
    }

    //удаление
    @PostMapping("/remove")
    public Response remove(@RequestBody Model model) {
        Model m1 = userRepo.findByName(model.getName());
        if (m1 != null) {
            userRepo.delete(m1);
            return new Response(0, "OK");
        } else {
            return new Response(1, "Ошибка! Запись с таким именем не существует");
        }
    }

    //суммирование
    @PostMapping("/sum")
    public Response sum(@RequestBody Map<String, String> json) {

        int first_val = userRepo.userCount(json.get("first"));
        int second_val = userRepo.userCount(json.get("second"));
        int sum;

        if ((first_val == 0) && (second_val == 0)) {
            return new Response(3, "Записи с именами '" + json.get("first") + "' и '" + json.get("second") + " не существуют");
        } else if (first_val == 0) {
            return new Response(3, "Запись с именем '" + json.get("first") + "' не существует");
        } else if (second_val == 0) {
            return new Response(3, "Запись с именем '" + json.get("second") + "' не существует");
        } else
            sum = userRepo.getVal(json.get("first")) + userRepo.getVal(json.get("second"));
        return new Response(sum, 0, "OK");
    }

}


