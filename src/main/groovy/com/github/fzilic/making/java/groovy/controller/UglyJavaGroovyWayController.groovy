package com.github.fzilic.making.java.groovy.controller

import com.github.fzilic.making.java.groovy.model.UglyJavaModel
import com.github.fzilic.making.java.groovy.service.ThirdPartyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/groovy/ugly.html")
class UglyJavaGroovyWayController {

  @Autowired
  ThirdPartyService thirdPartyService

  @RequestMapping(method = RequestMethod.GET)
  String showSomething(Model model) {

    def list = thirdPartyService.onlyWayToGetData()

    model.addAttribute("countWithBooleanTrue", list.count { UglyJavaModel ugly ->
      ugly?.nested?.nested?.nested?.theAllImportantBoolean
    })

    model.addAttribute("topThree", list.sort { a, b ->
      a.nested.someMonetaryValue <=> b.nested.someMonetaryValue
    }[0..2]*.someName)

    return "ugly"
  }
}
