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

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/update-array")
  public String updateArrayList(@RequestParam String s) {
    stringList.add(s);
    return "Value '" + s + "' added to the ArrayList.";
  }

  @GetMapping("/show-array")
  public List<String> showArrayList() {
    return stringList;
  }

  @GetMapping("/update-map")
  public String updateHashMap(@RequestParam String s) {
    integerStringMap.put(integerStringMap.size() + 1, s);
    return "Value '" + s + "' added to the HashMap.";
  }

  @GetMapping("/show-map")
  public Map<Integer, String> showHashMap() {
    return integerStringMap;
  }

  @GetMapping("/show-all-length")
  public String showAllLength() {
    int arrayListSize = stringList.size();
    int hashMapSize = integerStringMap.size();
    return "ArrayList size: " + arrayListSize + ", HashMap size: " + hashMapSize;
  }
}
