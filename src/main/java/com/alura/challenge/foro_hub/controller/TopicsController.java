package com.alura.challenge.foro_hub.controller;

import com.alura.challenge.foro_hub.domain.topic.Topic;
import com.alura.challenge.foro_hub.domain.topic.TopicsRepository;
import com.alura.challenge.foro_hub.domain.DataResponseJson;
import com.alura.challenge.foro_hub.domain.topic.dto.DataResponseTopic;
import com.alura.challenge.foro_hub.domain.topic.dto.TopicDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;

@RequestMapping("/topics")
@RestController
public class TopicsController {

    @Autowired
    private TopicsRepository topicsRepository;

    @PostMapping
    public ResponseEntity<DataResponseJson> createNewTopic(@RequestBody @Valid TopicDTO dataTopics, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicsRepository.save(new Topic(dataTopics));
        DataResponseTopic dataResponseTopic = new DataResponseTopic(topic.getTopicID(), topic.getTopicTitle(), topic.getTopicMessage(), topic.getTopicDate());
        DataResponseJson dataResponseJson = new DataResponseJson("Topic created succesfully", dataResponseTopic);
        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getTopicID()).toUri();
        return ResponseEntity.created(url).body(dataResponseJson);
    }

    @DeleteMapping("/{idTopic}")
    @Transactional
    public ResponseEntity<DataResponseJson> deleteTopic(@PathVariable Long idTopic){
        Topic topic = topicsRepository.getReferenceById(idTopic);
        topicsRepository.delete(topic);
        return  ResponseEntity.noContent().build();
    }
}
