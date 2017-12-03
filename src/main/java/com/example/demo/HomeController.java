package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    MovieRepository movieRepository;
    @RequestMapping("/")
    public String loadData(){
        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealname("Sandra Mae Bullowski");
        actorRepository.save(a);



        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        movie.addActor(a);
        movieRepository.save(movie);

        movie= new Movie();
        movie.setTitle("Valerian and the City of a Thousand Planets");
        movie.setYear(2017);
        movie.setDescription("About Space...");

        movie.addActor(a);
        movieRepository.save(movie);

        movie = new Movie();
        movie.setTitle("Wonder Woman");
        movie.setYear(2017);
        movie.setDescription("About a Super Hero...");

        movie.addActor(a);
        movieRepository.save(movie);

        return "redirect:/view";

    }

    @RequestMapping("/view")
    public String showData(Model model) {
        model.addAttribute( "actors", actorRepository.findAll());
        return "index";
    }
}
