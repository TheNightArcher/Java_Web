package bg.softuni.musicdb.web;

import bg.softuni.musicdb.security.CurrentUser;
import bg.softuni.musicdb.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AlbumService albumService;
    private final CurrentUser currentUser;

    public HomeController(AlbumService albumService, CurrentUser currentUser) {
        this.albumService = albumService;
        this.currentUser = currentUser;
    }

    @GetMapping()
    public String homePage(Model model){
        if (currentUser.getId() == null){
            return "index";
        }

        model.addAttribute("totalCopies",albumService.findAllAlbumCopies());
        model.addAttribute("albums",albumService.findAllAlbums());

        return "home";
    }
}
