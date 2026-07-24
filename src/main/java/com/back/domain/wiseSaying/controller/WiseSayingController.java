package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.dto.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;
import com.back.global.AppContext;
import com.back.global.Rq;

import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController() {
        this.sc = AppContext.sc;
        this.wiseSayingService = AppContext.wiseSayingService;
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(saying, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList(Rq rq) {

        String keywordType = rq.getParam("keywordType", "");
        String keyword = rq.getParam("keyword", "");
        int pageSize = rq.getParamAsInt("pageSize", 5);
        int page = rq.getParamAsInt("page", 1);



        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        PageDto pageDto = wiseSayingService.findListDesc(keywordType, keyword, pageSize, page);

        pageDto.getContent()
                .stream()
                .forEach(wiseSaying -> System.out.printf("%d / %s / %s%n",
                        wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));

    }

    public void actionDelete(Rq rq) {

        int id = rq.getParamAsInt("id", -1);
        boolean deleted = wiseSayingService.delete(id);

        if(!deleted) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));

    }

    public void actionModify(Rq rq) {

        int id = rq.getParamAsInt("id", -1);

        WiseSaying wiseSaying = wiseSayingService.findByIdOrNull(id); //못 찾으면 null 반환할 수도 있으니까 함수명에 표시

        if(wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("명언(기존) : %s".formatted(wiseSaying.getContent()));
        String newSaying = sc.nextLine();
        System.out.println("작가(기존) : %s".formatted(wiseSaying.getAuthor()));
        String newAuthor = sc.nextLine();

        wiseSayingService.modify(wiseSaying, newSaying, newAuthor);

    }

}