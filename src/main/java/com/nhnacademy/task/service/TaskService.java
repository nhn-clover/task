package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.Task;

import java.util.List;

public interface TaskService {

    //새 task 등록
    Task createTask(long projectId, long milestoneId, String content);

    //task 수정
    Task updateTask(Long taskId, String updatedContent, Long milestoneId); // 태스크 수정


    //task 삭제
    void deleteTask(long taskId);

    //특정 프로젝트의 task 목록 조회
    List<Task> getTasksByProjectId(long projectId);
}
