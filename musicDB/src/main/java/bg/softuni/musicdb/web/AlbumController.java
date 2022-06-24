package bg.softuni.musicdb.web;

import bg.softuni.musicdb.model.binding.AddAlbumBindingModel;
import bg.softuni.musicdb.model.service.AlbumServiceModel;
import bg.softuni.musicdb.service.AlbumService;
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
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add-album")
    public String addAlbum() {

        return "add-album";
    }

    @PostMapping("/add-album")
    public String addAlbumConfirm(@Valid AddAlbumBindingModel addAlbumBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addAlbumBindingModel", addAlbumBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addAlbumBindingModel"
                    , bindingResult);

            return "redirect:/add-album";
        }

        albumService
                .addAlbum(modelMapper.map(addAlbumBindingModel, AlbumServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/album/delete{id}")
    public String deleteAlbum(@PathVariable Long id){

        albumService.deleteAlbum(id);

        return "redirect:/";
    }

    @ModelAttribute
    public AddAlbumBindingModel addAlbumBindingModel() {
        return new AddAlbumBindingModel();
    }
}
