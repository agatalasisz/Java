package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.service.HolidayService;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private HolidayService holidayService;

    @GetMapping
    public ModelAndView searchHoliday(@RequestParam("query") String query) {
        System.out.println(query);
        ModelAndView mav = new ModelAndView("holidays/offers");
        mav.addObject("list", holidayService.findByQuery(query));
        mav.addObject("searchQuery", query);
        return mav;
    }
}
