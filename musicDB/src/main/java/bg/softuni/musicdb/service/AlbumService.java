package bg.softuni.musicdb.service;

import bg.softuni.musicdb.model.entity.AlbumEntity;
import bg.softuni.musicdb.model.service.AlbumServiceModel;
import bg.softuni.musicdb.model.view.HomeViewModel;
import bg.softuni.musicdb.repository.AlbumRepository;
import bg.softuni.musicdb.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public AlbumService(AlbumRepository albumRepository, ArtistService artistService, UserService userService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.userService = userService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    public void addAlbum(AlbumServiceModel albumServiceModel) {
        AlbumEntity album = modelMapper.map(albumServiceModel, AlbumEntity.class);
        album.setArtist(artistService.findArtist(albumServiceModel.getArtist()));
        album.setAddedFrom(userService.findFrom(currentUser.getId()));

        albumRepository.save(album);
    }

    public Integer findAllAlbumCopies() {
        return albumRepository.findAlbumsCopies();
    }


    public List<HomeViewModel> findAllAlbums() {
        return albumRepository.findAll()
                .stream().map(a -> {
                    HomeViewModel album = modelMapper.map(a, HomeViewModel.class);
                    album.setArtist(a.getArtist().getName());

                    return album;
                })
                .collect(Collectors.toList());
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
