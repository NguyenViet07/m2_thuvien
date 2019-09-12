package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.lang.String;

import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionary {
    static Map<String,String> dic = new HashMap<>();

    static {
        dic.put("hello","xin chào");
        dic.put("cat", "con mèo");
        dic.put("dog","con chó");
    }

   @GetMapping("/translate")
    public String translate(@RequestParam String word, Model model){
        model.addAttribute("word",word);
        if (dic.containsKey(word)){
            model.addAttribute("translate", dic.get(word));

        }else{
            model.addAttribute("translate","not found");
        }
        return "index";
   }

}
