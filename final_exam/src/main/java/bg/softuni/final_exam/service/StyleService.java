package bg.softuni.final_exam.service;

import bg.softuni.final_exam.model.entity.StyleEntity;
import bg.softuni.final_exam.model.entity.StyleNameEnum;
import bg.softuni.final_exam.repository.StyleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleService {

    private final StyleRepository styleRepository;
    private final ModelMapper modelMapper;

    public StyleService(StyleRepository styleRepository, ModelMapper modelMapper) {
        this.styleRepository = styleRepository;
        this.modelMapper = modelMapper;
    }


    public void addStyles() {
        if (styleRepository.count() != 0) {
            return;
        }

        Arrays.stream(StyleNameEnum.values())
                .forEach(styleNameEnum -> {

                    StyleEntity style = new StyleEntity();
                    style.setStyleName(styleNameEnum);

                    styleRepository.save(style);
                });
    }

    public StyleEntity findStyle(StyleNameEnum style) {
        return styleRepository.findByStyleName(style)
                .orElse(null);
    }
}
