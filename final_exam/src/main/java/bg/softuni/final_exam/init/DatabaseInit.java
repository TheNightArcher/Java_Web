package bg.softuni.final_exam.init;

import bg.softuni.final_exam.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final StyleService styleService;

    public DatabaseInit(StyleService styleService) {
        this.styleService = styleService;
    }

    @Override
    public void run(String... args) throws Exception {

        styleService.addStyles();
    }
}
