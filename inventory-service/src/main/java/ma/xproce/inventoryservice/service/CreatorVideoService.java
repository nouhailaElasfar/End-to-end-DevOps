package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CreatorVideoService implements CommandLineRunner {
    @Autowired
    public CreatorRepository creatorRepository;
    @Autowired
    public VideoRepository videoRepository;


    @Override
    public void run(String... args) throws Exception {

    }
}
