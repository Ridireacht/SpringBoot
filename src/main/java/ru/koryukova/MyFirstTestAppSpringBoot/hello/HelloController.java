package ru.koryukova.MyFirstTestAppSpringBoot.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

  private List<String> stringList = new ArrayList<>();
  private Map<Integer, String> integerStringMap = new HashMap<>();


  @GetMapping("/update-array")
  public String updateArrayList(@RequestParam String s) {
    if (stringList.isEmpty()) {
      stringList = new ArrayList<>();
    }

    stringList.add(s);

    return "Значение '" + s + "' добавлено в список.";
  }

  @GetMapping("/show-array")
  public List<String> showArrayList() {
    return stringList;
  }

  @GetMapping("/update-map")
  public String updateHashMap(@RequestParam String s) {
    if (integerStringMap.isEmpty()) {
      integerStringMap = new HashMap<>();
    }

    integerStringMap.put(integerStringMap.size() + 1, s);
    return "Значение '" + s + "' добавлено в хэш-мап.";
  }

  @GetMapping("/show-map")
  public Map<Integer, String> showHashMap() {
    return integerStringMap;
  }

  @GetMapping("/show-all-length")
  public String showAllLength() {
    int arrayListSize = stringList.size();
    int hashMapSize = integerStringMap.size();

    return "Размер списка: " + arrayListSize + ", размер хэш-мапа: " + hashMapSize;
  }
}
