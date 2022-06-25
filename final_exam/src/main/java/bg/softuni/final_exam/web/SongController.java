package bg.softuni.final_exam.web;

import bg.softuni.final_exam.model.binding.AddSongBindingModel;
import bg.softuni.final_exam.model.service.SongServiceModel;
import bg.softuni.final_exam.security.CurrentUser;
import bg.softuni.final_exam.service.SongService;
import bg.softuni.final_exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {

    private final SongService songService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;

    public SongController(SongService songService, ModelMapper modelMapper, CurrentUser currentUser, UserService userService) {
        this.songService = songService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @GetMapping("/song-add")
    public String addSong() {
        return "song-add";
    }

    @PostMapping("/song-add")
    public String addSongConfirm(@Valid AddSongBindingModel addSongBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addSongBindingModel", addSongBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSongBindingModel"
                    , bindingResult);

            return "redirect:/song-add";
        }

        songService.addSong(modelMapper.map(addSongBindingModel, SongServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/add/my-list{id}")
    public String addToMyList(@PathVariable Long id){
        userService.addToMyList(id);

        return "redirect:/";
    }

    @ModelAttribute
    public AddSongBindingModel addSongBindingModel(){
        return new AddSongBindingModel();
    }
}

