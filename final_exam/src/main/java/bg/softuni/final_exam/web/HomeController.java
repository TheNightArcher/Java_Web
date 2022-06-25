package bg.softuni.final_exam.web;

import bg.softuni.final_exam.security.CurrentUser;
import bg.softuni.final_exam.service.SongService;
import bg.softuni.final_exam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final String POP_SONGS = "POP";
    private static final String ROCK_SONGS = "ROCK";
    private static final String JAZZ_SONGS = "JAZZ";

    private final SongService songService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public HomeController(SongService songService, CurrentUser currentUser, UserService userService) {
        this.songService = songService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @GetMapping()
    public String homePage(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("userSongs", userService.findUserSongs(currentUser.getId()));
        model.addAttribute("popSongs", songService.finStyleSongs(POP_SONGS));
        model.addAttribute("rockSongs", songService.finStyleSongs(ROCK_SONGS));
        model.addAttribute("jazzSongs", songService.finStyleSongs(JAZZ_SONGS));

        return "home";
    }



}
