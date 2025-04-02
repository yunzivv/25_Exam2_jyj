package org.example.app;

import org.example.container.Container;
import org.example.motivation.controller.MotivationController;
import org.example.motivation.entity.Motivation;

public class App {

    MotivationController motivationController;

    public void run() {

        motivationController = new MotivationController();

        System.out.println("== 명언 앱 실행 ==");

        while (true) {

            System.out.print("명령어 ) ");
            String cmd = Container.getScanner().nextLine();

            if (cmd.equals("목록")) {

                motivationController.showList();

            } else if (cmd.equals("등록")) {

                motivationController.add();

            }  else if (cmd.startsWith("수정")) {

                motivationController.modify(cmd);

            } else if (cmd.startsWith("상세보기")) {

                motivationController.detail(cmd);

            } else if (cmd.startsWith("삭제")) {

                motivationController.delete(cmd);

            } else if (cmd.equals("종료")) {
                break;
            }

        }
    }
}
