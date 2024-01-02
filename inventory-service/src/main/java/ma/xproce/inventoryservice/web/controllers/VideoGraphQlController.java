package ma.xproce.inventoryservice.web.controllers;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private VideoRepository videoRepository;

    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }

    @QueryMapping
    public Creator creatorByName(@Argument String name){
        return creatorRepository.findByName(name);
    }
    @QueryMapping
    public List<Video> findVideoByCreator(String name){
        Creator creator=creatorRepository.findByName(name);
        return creator.getVideos();

    }
    @QueryMapping
    public List<Creator> findAll(){
        return creatorRepository.findAll();
    }
    @QueryMapping
    public void deleteCreatorByName(String name){
        creatorRepository.deleteCreatorByName(name);
    }
}
