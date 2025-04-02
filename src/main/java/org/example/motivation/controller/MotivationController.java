package org.example.motivation.controller;

import org.example.container.Container;
import org.example.motivation.entity.Motivation;
import org.example.motivation.service.MotivationService;

public class MotivationController {
    
    int lastId;
    MotivationService motivationService;
    
    public MotivationController() {
        lastId = 1;
        motivationService = new MotivationService();
    }
    
    public void showList() {

        System.out.println("번호  /  작가  /  명언");
        System.out.println("==============================");
        
        if(motivationService.moivationIsExist()) {
            motivationService.showList();
        }
    }

    public void add() {
        
        System.out.print("명언 : ");
        String body = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();
        
        motivationService.doAdd(lastId, body, author);

        System.out.println(lastId + "번 명언이 등록되었습니다.");
        lastId++;
    }

    public void modify(String cmd) {

        int modifyId = Integer.parseInt(cmd.substring(6));
        Motivation motivation = motivationService.getMotivation(modifyId);

        if(motivation == null) {
            System.out.println(modifyId + "번 명언은 존재하지 않습니다.");
            return;
        }

        motivationService.doModify(modifyId);
        System.out.println(modifyId + "번 명언이 수정되었습니다.");
    }

    public void delete(String cmd) {

        int deleteId = Integer.parseInt(cmd.substring(6));
        Motivation motivation = motivationService.getMotivation(deleteId);

        if(motivation == null) {
            System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
            return;
        }

        motivationService.doDelete(deleteId);
        System.out.println(deleteId + "번 명언이 삭제되었습니다.");
    }

    public void detail(String cmd) {

        int detailId = Integer.parseInt(cmd.substring(8));
        Motivation motivation = motivationService.getMotivation(detailId);

        if(motivation == null) {
            System.out.println(detailId + "번 명언은 존재하지 않습니다.");
            return;
        }

        motivationService.showDetail(detailId);
    }
}
