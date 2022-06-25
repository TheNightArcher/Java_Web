package bg.softuni.final_exam.service;

import bg.softuni.final_exam.model.entity.SongEntity;
import bg.softuni.final_exam.model.service.SongServiceModel;
import bg.softuni.final_exam.model.view.SongViewModel;
import bg.softuni.final_exam.repository.SongRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final StyleService styleService;
    private final ModelMapper modelMapper;

    public SongService(SongRepository songRepository, StyleService styleService, ModelMapper modelMapper) {
        this.songRepository = songRepository;
        this.styleService = styleService;
        this.modelMapper = modelMapper;
    }


    public void addSong(SongServiceModel songServiceModel) {
        SongEntity song = modelMapper.map(songServiceModel, SongEntity.class);
        song.setStyle(styleService.findStyle(songServiceModel.getStyle()));

        songRepository.save(song);
    }

    public List<SongViewModel> finStyleSongs(String style) {
        return songRepository.findAll()
                .stream()
                .filter(s -> s.getStyle().getStyleName().name().equals(style))
                .map(s -> {
                    SongViewModel songViewModel = modelMapper.map(s, SongViewModel.class);
                    songViewModel.setStyle(s.getStyle().getStyleName());

                    return songViewModel;
                })
                .collect(Collectors.toList());
    }

    public SongEntity findSong(Long id) {
        return songRepository.findById(id)
                .orElse(null);
    }
}
