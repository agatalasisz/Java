package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.model.Client;
import pl.akademiakodu.model.Holiday;
import pl.akademiakodu.service.ClientService;
import pl.akademiakodu.service.HolidayService;
import javax.validation.Valid;


@Controller
@RequestMapping("/holiday")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ModelAndView showOffers() {
        ModelAndView mav = new ModelAndView("holidays/offers");
        mav.addObject("list", holidayService.getList());
        return mav;
    }

    @GetMapping("/management")
    public ModelAndView manage() {
        ModelAndView mav = new ModelAndView("holidays/list");
        mav.addObject("list", holidayService.getList());
        return mav;
    }


    @GetMapping("/add")
    public ModelAndView addHolidayForm() {
        ModelAndView mav = new ModelAndView("holidays/form");
        mav.addObject("holiday", new Holiday());
        return mav;
    }

    @PostMapping("/add")
    public ModelAndView saveHoliday(@Valid @ModelAttribute("holiday") Holiday holiday,
                                    BindingResult bindingResult) {
        System.out.println(holiday);
        ModelAndView mav = new ModelAndView();

        if (bindingResult.hasErrors()) {
            mav.addObject("holiday", holiday);
            mav.setViewName("holidays/form");
        } else {
            Holiday savedHoliday = holidayService.save(holiday);
            mav.setViewName("redirect:/holiday");
        }

        return mav;
    }


    @GetMapping("/remove/{id}")
    public String deleteHoliday(@PathVariable("id") int holidayId) {
        holidayService.remove(holidayId);
        return "redirect:/holiday";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editHolidayForm(@PathVariable("id") int holidayId) {
        ModelAndView mav = new ModelAndView("holidays/form");
        mav.addObject("holiday", holidayService.read(holidayId));
        return mav;
    }

    @GetMapping("/clients")
    public ModelAndView getClients() {
        ModelAndView mav = new ModelAndView("clients/list");
        mav.addObject("list", clientService.getList());
        return mav;
    }


    @GetMapping("/reserve/{holidayId}")
    public ModelAndView addClientFormForHoliday(@PathVariable("holidayId") int holidayId) {
        Holiday holiday = holidayService.read(holidayId);
        Client client = new Client();
        client.setHoliday(holiday);
        ModelAndView mav = new ModelAndView("clients/form");
        mav.addObject("client", client);
        return mav;
    }

    @PostMapping("/reserve")
    public ModelAndView saveClient(@Valid @ModelAttribute("client") Client client,
                                   BindingResult bindingResult) {

        int holidayId = client.getHoliday().getId();
        Holiday holiday = holidayService.read(holidayId);
        client.setHoliday(holiday);

        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("clients/form");
            mav.addObject("client", client);
            return mav;
        } else {

            System.out.println("client ::" + client);
            clientService.save(client);
            holidayService.reserve(holidayId);

            return new ModelAndView("redirect:/holiday/clients");
        }
    }

    @GetMapping("/{id}")
    public ModelAndView getdetails(@PathVariable("id") int holidayId) {
        return new ModelAndView("holidays/details", "holiday", holidayService.read(holidayId));
    }

}
