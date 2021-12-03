package com.example.demo.module2;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class DashBoard {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;


    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("test", "Random text");
        ParkingSlot parkingSlot = new ParkingSlot("One", true, "Arjun", "none", "6/12/2021", "3.5");
        parkingSpotRepository.save(parkingSlot);
        ParkingSlot parkingSlot1 = new ParkingSlot("One", true, "Ravi", "none", "6/12/2021", "4.2");
        parkingSpotRepository.save(parkingSlot1);
        ParkingSlot parkingSlot2 = new ParkingSlot("Two", true, "Pranav", "none", "9/12/2021", "4.5");
        parkingSpotRepository.save(parkingSlot2);
        ParkingSlot parkingSlot3 = new ParkingSlot("Three", true, "Jason", "none", "10/12/2021", "3.4");
        parkingSpotRepository.save(parkingSlot3);
        ParkingSlot parkingSlot4 = new ParkingSlot("Four", true, "Monkey", "none", "19/12/2021", "3.9");
        parkingSpotRepository.save(parkingSlot4);
        ParkingSlot parkingSlot5 = new ParkingSlot("Three", true, "Anita", "none", "23/12/2021", "4.1");
        parkingSpotRepository.save(parkingSlot5);
        ParkingSlot parkingSlot6 = new ParkingSlot("Two", true, "Aniket", "none", "17/12/2021", "3.8");
        parkingSpotRepository.save(parkingSlot6);
        ParkingSlot parkingSlot7 = new ParkingSlot("Four", true, "Kaif", "none", "11/12/2021", "4.3");
        parkingSpotRepository.save(parkingSlot7);
        ParkingSlot parkingSlot8 = new ParkingSlot("Three", true, "Sarim", "none", "21/12/2021", "3.9");
        parkingSpotRepository.save(parkingSlot8);
        ParkingSlot parkingSlot9 = new ParkingSlot("Two", true, "Rahul", "none", "14/12/2021", "4.8");
        parkingSpotRepository.save(parkingSlot9);
        ParkingSlot parkingSlot10 = new ParkingSlot("One", true, "Karan", "none", "10/12/2021", "3.7");
        parkingSpotRepository.save(parkingSlot10);
        ParkingSlot parkingSlot11 = new ParkingSlot("Two", true, "Sridhar", "none", "27/12/2021", "2.9");
        parkingSpotRepository.save(parkingSlot11);
        ParkingSlot parkingSlot12 = new ParkingSlot("Four", true, "Animesh", "none", "26/12/2021", "1");
        parkingSpotRepository.save(parkingSlot12);
        ParkingSlot parkingSlot13 = new ParkingSlot("One", true, "Anish", "none", "03/12/2021", "5");
        parkingSpotRepository.save(parkingSlot13);
        ParkingSlot parkingSlot14 = new ParkingSlot("Three", true, "Abhi", "none", "06/12/2021", "4.7");
        parkingSpotRepository.save(parkingSlot14);
        ParkingSlot parkingSlot15 = new ParkingSlot("Two", true, "Dheeraj", "none", "16/12/2021", "3.6");
        parkingSpotRepository.save(parkingSlot15);
        ParkingSlot parkingSlot16 = new ParkingSlot("Four", true, "Raj", "none", "19/12/2021", "4.9");
        parkingSpotRepository.save(parkingSlot16);
        ParkingSlot parkingSlot17 = new ParkingSlot("Two", true, "Sri", "none", "24/12/2021", "2.3");
        parkingSpotRepository.save(parkingSlot17);
        ParkingSlot parkingSlot18 = new ParkingSlot("Three", true, "Ajay", "none", "21/12/2021", "2.9");
        parkingSpotRepository.save(parkingSlot18);
        ParkingSlot parkingSlot19 = new ParkingSlot("Four", true, "Nath", "none", "01/12/2021", "3.8");
        parkingSpotRepository.save(parkingSlot19);
        ParkingSlot parkingSlot20 = new ParkingSlot("One", true, "Tayson", "none", "07/12/2021", "4.6");
        parkingSpotRepository.save(parkingSlot20);
        System.out.println(parkingSpotRepository);
        System.out.println(parkingSpotRepository);
        return "dsb";
    }

    @PostMapping("/parkingsearchresult")
    public String Searchresult(Model model, @RequestBody String request, String location, String hrs, String date, String numberOfWheels, String cartype){
        System.out.println(location);
        System.out.println(hrs);
        List parkingSpots = parkingSpotRepository.findByLocation(location);
        List<ParkingSlot> newEmpty = Collections.<ParkingSlot>emptyList();
        Iterator<ParkingSlot> setIterator = parkingSpots.iterator();
        while(setIterator.hasNext()) {
            ParkingSlot temp = (ParkingSlot)setIterator.next();
            if(temp.getAvailability()){
                //newEmpty.add(temp);
            }
        }
        System.out.println(newEmpty);
        model.addAttribute("parkingSpots", parkingSpots);
        model.addAttribute("hrs", hrs);
        model.addAttribute("numberOfWheels", numberOfWheels);
        model.addAttribute("cartype", cartype);

        return "AvailableSpots";
    }
}
