package com.github.fzilic.making.java.groovy.controller;

import com.github.fzilic.making.java.groovy.model.UglyJavaModel;
import com.github.fzilic.making.java.groovy.service.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/java/ugly.html")
public class UglyJavaController {

  private final ThirdPartyService thirdPartyService;

  @Autowired
  public UglyJavaController(final ThirdPartyService thirdPartyService) {
    this.thirdPartyService = thirdPartyService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String showSomething(final Model model) {

    final List<UglyJavaModel> list = thirdPartyService.onlyWayToGetData();

    int countOfThoseWithBooleanTrue = 0;

    // sort by monetary value
    list.sort(new Comparator<UglyJavaModel>() {
      @Override
      public int compare(final UglyJavaModel left, final UglyJavaModel right) {
        return left.getNested().getSomeMonetaryValue().compareTo(right.getNested().getSomeMonetaryValue());
      }
    });

    for (final UglyJavaModel uglyJavaModel : list) {
      if (uglyJavaModel.getNested() != null
          && uglyJavaModel.getNested().getNested() != null
          && uglyJavaModel.getNested().getNested().getNested() != null
          && uglyJavaModel.getNested().getNested().getNested().getTheAllImportantBoolean() == true) {
        countOfThoseWithBooleanTrue++;
      }
    }

    final List<String> topThree = new ArrayList<String>(3);

    for (final UglyJavaModel uglyJavaModel : list.subList(0, 3)) { // old Java 7 way
      topThree.add(uglyJavaModel.getSomeName());
    }

    model.addAttribute("countWithBooleanTrue", countOfThoseWithBooleanTrue);

    model.addAttribute("topThree", topThree);

    return "ugly";
  }
}
