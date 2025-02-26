package com.nhnacademy.task.controller;

import com.nhnacademy.task.domain.Tag;
import com.nhnacademy.task.dto.TagDTO;
import com.nhnacademy.task.request.TagRequest;
import com.nhnacademy.task.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    //프로젝트에 태그 추가
    @PostMapping("/tag")
    public Tag createTag(@RequestBody TagRequest tagRequest) {
        return tagService.addTagToProject(tagRequest.getProjectId(), tagRequest.getTagName());
    }

    //태그 삭제(태그태스크, comment 도 같이 삭제)
    @DeleteMapping("/tags/{tagId}")
    public void deleteTag(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
    }

    @GetMapping("/tags/{tagId}")
    public Tag getTag(@PathVariable("tagId") Long tagId) {
        return tagService.getTagById(tagId);
    }



    //프로젝트에 있는 모든 태그 보기
    @GetMapping("/project/{projectId}/tags")
    public List<TagDTO> getTags(@PathVariable("projectId") Long projectId) {
        return tagService.getAllTagByProjectId(projectId);
    }
  
    @PutMapping("/tags/{tagId}")
    public Tag updateTag(@PathVariable("tagId") Long tagId, @RequestBody TagRequest tagRequest) {
        return tagService.updateTag(tagId, tagRequest.getTagName());

    }
}
